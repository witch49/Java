package basic04;

import java.util.List;
import java.util.Scanner;

public class MemberApplication {
	
	/* 1 - 회원 가입 */
	public void signUp() {
		MemberDAO mDao = new MemberDAO();
		
		System.out.print("패스워드> ");
		Scanner sc = new Scanner(System.in);
		String pass = sc.nextLine();
		
		System.out.print("이름> ");
		String name = sc.nextLine();
		
		System.out.print("생년월일> ");
		int birth = Integer.parseInt(sc.nextLine());
		
		System.out.print("주소> ");
		String address = sc.nextLine();
		
		mDao.insertMember(new MemberDTO(pass, name, birth, address));	
		mDao.close();
	}
	
	/* 2 - 회원 조회(가장 최근에 가입한 순서대로) */
	public void lookUp() {
		MemberDAO mDao = new MemberDAO();
		
		List<MemberDTO> memberlist = mDao.selectMembersAll();
		for (MemberDTO member : memberlist)
			System.out.println(member.toString());

		mDao.close();
	}
	
	/* 3 - 회원 정보 변경(수정) */
	public void modify() {
		MemberDAO mDao = new MemberDAO();
		
		System.out.print("수정할 회원 아이디> ");
		Scanner sc = new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());
		MemberDTO member = mDao.selectOne(id);
		
		System.out.print("패스워드> ");
		String pass = sc.nextLine();
		
		System.out.print("이름> ");
		String name = sc.nextLine();
		
		System.out.print("생년월일> ");
		int birth = Integer.parseInt(sc.nextLine());
		
		System.out.print("주소> ");
		String address = sc.nextLine();
		
		member.setMemberPassword(pass);
		member.setMemberName(name);
		member.setMemberBirth(birth);
		member.setMemberAddress(address);
		
		mDao.updateMember(member);
		member = mDao.selectOne(id);
		System.out.println("수정 완료\n" + member.toString());
		mDao.close();
	}
	
	/* 4 - 회원 삭제 */
	public void delete() {
		MemberDAO mDao = new MemberDAO();
		System.out.print("삭제할 회원 아이디> ");
		Scanner sc = new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());
		mDao.deleteMember(id);
		mDao.close();
	}
	
	/* 5 - 회원 검색 (이름으로) */
	public void search() {
		MemberDAO mDao = new MemberDAO();
		System.out.print("검색하고자 하는 회원의 이름 입력> ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		List<MemberDTO> memberlist = mDao.selectMemberByName(name);
		for (MemberDTO member : memberlist)
			System.out.println(member.toString());
		if (memberlist.isEmpty())
			System.out.println("해당 이름이 없습니다.");
		mDao.close();
	}
	
	/* 6 - 회원 로그인 (id, password 검증) */
	public void login() {
		MemberDAO mDao = new MemberDAO();
		
		System.out.print("아이디> ");
		Scanner sc = new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());
		
		System.out.print("비밀번호> ");
		String pass = sc.nextLine();

		if (mDao.verifyLogin(id, pass) == 1) {
			System.out.println("로그인 성공!");
		}
		if (mDao.verifyLogin(id, pass) == -1) {
			System.out.println("로그인 실패!");
		}

		mDao.close();
	}
	
}
