package basic03;

import java.util.List;

public class EaglesTest {
	public static void main(String[] args) {
		
		/* 1) 단일 선택 예제 - selectOne() */
//		EaglesDAO eDao = new EaglesDAO();
//		EaglesDTO player = eDao.selectOne(1);
//		System.out.println(player.toString());
//		eDao.close();
		
		
		/* 2) 삽입 예제 - insertPlayer() */
//		EaglesDAO eDao = new EaglesDAO();
//		eDao.insertPlayer(new EaglesDTO(27, "김범수", "투수", "대한민국 충청남도 아산시", "좌투", "좌타", "3,600만원", "19951003"));
//		eDao.close();
		
		
		/* 3) 수정 예제 - updatePlayer() */
//		EaglesDAO eDao = new EaglesDAO();
//		EaglesDTO player = eDao.selectOne(6);
//		System.out.println(player.toString());
//		
//		player.setPlayerName("오선진");
//		player.setPlayerPosition("내야수");
//		player.setPlayerHometown("대한민국 서울특별시");
//		player.setPlayerThrowingHand("우투");
//		player.setPlayerHitHand("우타");
//		player.setPlayerSalary("7,500만원");
//		player.setPlayerBirth("19890707");
//		eDao.updatePlayer(player);
//		
//		player = eDao.selectOne(6);
//		System.out.println(player.toString());
//		eDao.close();
		
		
		/* 4) 삭제 예제 - deletePlayer() */
//		EaglesDAO eDao = new EaglesDAO();
//		eDao.deletePlayer(60);
//		eDao.close();
		
		
		/* 5) 전체 선택 예제 - selectPlayersAll() */	
//		EaglesDAO eDao = new EaglesDAO();
//		List<EaglesDTO> playerlist = eDao.selectPlayersAll();
//		for (EaglesDTO player : playerlist)
//			System.out.println(player.toString());
//		eDao.close();
		
		
		/* 6) 검색 예제 - searchPlayer() */
		EaglesDAO eDao = new EaglesDAO();
		String[] positions = {"유격수", "내야수", "외야수", "1루수", "2루수", "포수", "투수", "좌익수"};
		for(String position : positions) {
			List<EaglesDTO> playerlist = eDao.selectPlayersByPosition(position);
			System.out.println("===========================================  포지션 : " + position
					+ "인 선수 명단  ===========================================");
			for (EaglesDTO player : playerlist)
				System.out.println(player.toString());
			System.out.println();
		}
//		List<EaglesDTO> playerlist = eDao.selectPlayersByBackNo(20);
//		System.out.println("선수 번호 20번 이상인 사람 명단");
//		for (EaglesDTO player : playerlist)
//			System.out.println(player.toString());
		eDao.close();
		
	}
}
