package memberDB;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/memberDB/bbsProcServlet")
public class BbsProc extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(BbsProc.class);
	
    public BbsProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String message = "", title = "", context = "", mWritterName = "";
		String page = "";
		int mId = 0, bId = 0, mWritterId = 0;
		int pageNo = 0;
		int curPageNo = 1; // 현재 페이지 번호
		int countAllPosts = 0;	// 게시글 총 개수
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		BbsDTO bbs = null;
		BbsDAO bDao = new BbsDAO();
		RequestDispatcher rd = null;
		List<String> pageList = new ArrayList<String>();
		List<BbsDTO> bbslist = null;
		
		
		// 세션이 만료되면 재로그인
		try {
			mId = (int) session.getAttribute("memberId");
		} catch (NullPointerException e) {
			System.out.println("세션이 만료되었습니다.");
		}
		if (mId == 0) {
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

		switch (action) {
			///////////////////////////////////////////////////////////////////////////////
		// 회원 명단 목록 화면 등등에서 -> 게시판 글 목록 화면 전환/돌아오는 부분
		case "gotoBbsList": 
			LOG.info("gotoBbsList start");
			if (!request.getParameter("page").equals("")) {
				curPageNo = Integer.parseInt(request.getParameter("page"));
			}
			bDao = new BbsDAO();
			countAllPosts = bDao.getListCount();
			if (countAllPosts == 0)			// 데이터가 없을 때 대비
				countAllPosts = 1;
			pageNo = (int)Math.ceil(countAllPosts/10.0);
			if (countAllPosts > pageNo)	// 경계선에 걸렸을 때 대비
				countAllPosts--;
			session.setAttribute("currentBbsPage", curPageNo);
			
			// 리스트 페이지의 하단 페이지 데이터 만들어 주기
			page = null;
			page = "<a href=#>&laquo;</a>&nbsp;";
			pageList.add(page);
			for (int i = 1; i <= pageNo; i++) {
				if (curPageNo == i)
					page = "&nbsp;" + i + "&nbsp;";
				else
					page = "&nbsp;<a href=bbsProcServlet?action=gotoBbsList&page=" + i + ">" + i + "</a>&nbsp;";
				pageList.add(page);
			}
			page = "&nbsp;<a href=#>&raquo;</a>";
			pageList.add(page);		
			
			bbslist = bDao.getList(curPageNo);
			request.setAttribute("bbsPostList", bbslist);
			request.setAttribute("pageList", pageList);

			rd = request.getRequestDispatcher("bbs_list.jsp");
			rd.forward(request, response);
			LOG.info("gotoBbsList success");
			break;
		
			///////////////////////////////////////////////////////////////////////////////
		case "update":	// 게시글 수정 화면으로 넘어가기
			LOG.debug("bbs update start");
			if (!request.getParameter("mId").equals(""))
				mId = Integer.parseInt(request.getParameter("mId").trim());
			if (!request.getParameter("bId").equals(""))
				bId = Integer.parseInt(request.getParameter("bId").trim());
			
//			if(mId != (Integer) session.getAttribute("memberId")) {
//				message = "본인이 작성한 글이 아닙니다.";
//				request.setAttribute("message", message);
//				request.setAttribute("url", "bbs_list.jsp");
//				rd = request.getRequestDispatcher("alertMsg.jsp");
//				rd.forward(request, response);
//				break;
//			}
			
			bbs = bDao.selectOne(bId);
			bDao.close();	
			
			bbs.setBbsContent(br2Lf(bbs.getBbsContent()));
			request.setAttribute("bbs", bbs);
			rd = request.getRequestDispatcher("updateBbs.jsp");
			rd.forward(request, response);
			LOG.debug("bbs update success - goto update page");
			break;
			
			///////////////////////////////////////////////////////////////////////////////
		case "delete":	// 게시글 삭제 버튼 클릭
			LOG.debug("bbs delete start");
			if (!request.getParameter("mId").equals(""))
				mId = Integer.parseInt(request.getParameter("mId").trim());
			if (!request.getParameter("bId").equals(""))
				bId = Integer.parseInt(request.getParameter("bId").trim());
			
			if(mId != (Integer) session.getAttribute("memberId")) {
				message = "본인이 작성한 글이 아닙니다.";
				request.setAttribute("message", message);
				request.setAttribute("url", "bbs_list.jsp");
				rd = request.getRequestDispatcher("alertMsg.jsp");
				rd.forward(request, response);
				LOG.debug("bbs delete fail - not your post");
				break;
			}
			
			bDao.deleteBbs(bId, mId);
			bDao.close();
			
			curPageNo = (int)session.getAttribute("currentBbsPage");
			
			message = "글 삭제 완료";
			request.setAttribute("message", message);
			request.setAttribute("url", "bbsProcServlet?action=gotoBbsList&page=" + curPageNo);
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			
			LOG.debug("bbs delete success");

			break;
			
			///////////////////////////////////////////////////////////////////////////////
		case "execute":	// 게시글 수정 완료 버튼 클릭
			LOG.debug("bbs update execute start");
			if (!request.getParameter("mId").equals(""))
				mId = Integer.parseInt(request.getParameter("mId").trim());
			if (!request.getParameter("bId").equals(""))
				bId = Integer.parseInt(request.getParameter("bId").trim());

			title = request.getParameter("title");
			context = lf2Br(request.getParameter("context"));
			
			bbs = new BbsDTO(bId, title, context);
			bDao.updateBbs(bbs, mId, bId);

			bbslist = bDao.getList(curPageNo);
			request.setAttribute("bbsPostList", bbslist);
			
			curPageNo = (int)session.getAttribute("currentBbsPage");
			
			message = "글 수정 완료";
			request.setAttribute("message", message);
			request.setAttribute("url", "bbsProcServlet?action=gotoBbsList&page=" + curPageNo);
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			
			LOG.debug("bbs update execute success");
			
			break;
			
			///////////////////////////////////////////////////////////////////////////////
		case "register":	// 새로운 글 작성
			LOG.debug("bbs write start");
			if (!request.getParameter("mId").equals(""))
				mId = Integer.parseInt(request.getParameter("mId").trim());
			session.setAttribute("memberId", mId);
			response.sendRedirect("bbs_register.jsp");
			LOG.debug("bbs write success - goto write page");
			break;
			
			///////////////////////////////////////////////////////////////////////////////
		case "registerBtn":	// 새로운 글 작성 완료 버튼 클릭
			LOG.debug("bbs write registerBtn start");
			if (!request.getParameter("mId").equals(""))
				mId = Integer.parseInt(request.getParameter("mId").trim());
			
			title = request.getParameter("bbsTitle");
			context = lf2Br(request.getParameter("bbsContext"));
			
			bDao.insertBbs(new BbsDTO(mId, title, context), mId);	

			curPageNo = (int)session.getAttribute("currentBbsPage");

			bbslist = bDao.getList(curPageNo);
			request.setAttribute("bbsPostList", bbslist);
			request.setAttribute("pageList", pageList);
			
			message = "글 작성 완료";
			request.setAttribute("message", message);
			request.setAttribute("url", "bbsProcServlet?action=gotoBbsList&page=" + curPageNo);
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			LOG.debug("bbs write registerBtn success");
			break;
			
			///////////////////////////////////////////////////////////////////////////////
		case "detail": // 글 제목 클릭 - 상세보기 화면으로 전환
			LOG.info("show bbs detail start");
			if (!request.getParameter("mId").equals(""))
				mWritterId = Integer.parseInt(request.getParameter("mId").trim());
			if (!request.getParameter("bId").equals(""))
				bId = Integer.parseInt(request.getParameter("bId").trim());

			mWritterName = bDao.selectMemberName(mWritterId, bId);

			bDao = new BbsDAO();
			bbslist = bDao.selectPostsAll();

			request.setAttribute("bbslist", bbslist);
			request.setAttribute("bId", bId);
			request.setAttribute("mWritterId", mWritterId);
			request.setAttribute("mWritterName", mWritterName);
			rd = request.getRequestDispatcher("bbs_list_content.jsp");
			rd.forward(request, response);
			LOG.info("show bbs detail success");
			break;

		default:
			LOG.info("action value ERROR!!");
		}
		
	}

	protected String lf2Br(String content) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < content.length(); i++) {
			if (content.charAt(i) == '\r') {
				sb.append("<br>");
				sb.append(content.charAt(i));
			} else
				sb.append(content.charAt(i));
		}
		return sb.toString();
	}

	protected String br2Lf(String content) {
		StringBuffer sb = new StringBuffer(content);
		int count = 0;
		while (true) {
			int index = sb.indexOf("<br>", count);
			if (index < 0)
				break;
			sb.delete(index, index + 4);
			count += 4;
		}
		return sb.toString();
	}
	
}
