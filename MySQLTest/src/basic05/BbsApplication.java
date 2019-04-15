package basic05;

import java.util.Scanner;

public class BbsApplication {
	int iId = 0;
	String iPwd = "";
	
	/* 0 - 로그인 기능 */
	public String login() {
		BbsDAO bDao = new BbsDAO();
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 입력> ");
		int inputId = Integer.parseInt(sc.nextLine());
		iId = inputId;
		System.out.print("비밀번호 입력> ");
		String inputPwd = sc.nextLine();
		iPwd = inputPwd;
		
		if (bDao.verifyLogin(inputId, inputPwd) == 1) {
			return "로그인 성공!";
		}
		if (bDao.verifyLogin(inputId, inputPwd) == -1) {
			return null;
		}

		bDao.close();
		return null;
	}

	/* 1 - 쓰기 (현재 로그인한 아이디로 글 작성) */
	public void write() {
		BbsDAO bDao = new BbsDAO();
		Scanner sc = new Scanner(System.in);
		System.out.print("제목> ");
		String title = sc.nextLine();
		System.out.print("내용> ");
		String content = sc.nextLine();
		
		bDao.insertBbs(new BbsDTO(iId, title, content), iId);
		bDao.close();
	}
	
	/* 2 - 조회 (가장 최근에 작성한 순서대로 글 목록 출력) */
	public void lookUp() {
		BbsDAO bDao = new BbsDAO();
		bDao.showBbs();
		bDao.close();
	}
	
	/* 3 - 변경 (글 수정, 본인이 작성한 것만 가능) */
	public void modify() {
		BbsDAO bDao = new BbsDAO();
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" * 본인이 작성한 글만 수정 가능");
		System.out.print("수정할 글 번호 입력> ");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.print("수정할 글 제목 입력> ");
		String title = sc.nextLine();
		
		System.out.print("수정할 글 내용 입력> ");
		String content = sc.nextLine();
		
		BbsDTO bbs = bDao.selectOne(iId);
		
		bbs.setBbsId(num);
		bbs.setBbsTitle(title);
		bbs.setBbsContent(content);
		
		bDao.updateBbs(bbs, iId);
		bDao.close();
	}
	
	/* 4 - 삭제 (id를 입력받아 본인이 작성한 글이라면 삭제) */
	public void delete() {
		BbsDAO bDao = new BbsDAO();

		System.out.print("삭제할 글 번호> ");
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		
		bDao.deleteBbs(num, iId);
		bDao.close();
	}
	
	/* 5 - 상세 조회 (bbs.id를 입력받아 제목, 글쓴이, 최종수정일, 내용 표기) */
	public void lookUpDetail() {
		BbsDAO bDao = new BbsDAO();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("id(글 번호)를 입력하세요> ");
		int input = Integer.parseInt(sc.nextLine());

		bDao.selectBbsById(input);
		bDao.close();
	}
	
}
