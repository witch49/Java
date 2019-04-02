package basic02;

public class SongTest {
	public static void main(String[] args) {
		SongDAO sDao = new SongDAO();

		/* 1) 삽입 예제 */
		// same as
		// sDao.insertSong(new SongDTO("빨간맛", "빠빠빨간맛 궁금해 허니"));
//		SongDTO sDto = new SongDTO("빨간맛", "빠빠빨간맛 궁금해 허니");
//		sDao.insertSong(sDto);
//		sDao.close();
		
		/* 2) 선택 예제 */
//		SongDTO sDto = sDao.selectOne(120);
//		System.out.println(sDto.toString());
//		sDao.close();
		
		/* 3) 업데이트 예제 */
		//SongDTO sDto = sDao.selectOne(117);
//		SongDTO sDto = new SongDTO();
//		System.out.println(sDto.toString());
//		sDto.setTitle("넌 이즈 뭔들");
//		sDto.setLyrics("나 지금 너 땜에 혼란스러 제발 누가 나 좀 말려줘");
//		sDao.updateSong(sDto);
//		sDto = sDao.selectOne(117);
//		System.out.println(sDto.toString());
//		
//		sDao.close();
		
		/* 4) 삭제 예제 */
		SongDTO sDto = sDao.selectOne(121);
		sDto.setTitle("넌 이즈 뭔들");
		sDto.setLyrics("나 지금 너 땜에 혼란스러 제발 누가 나 좀 말려줘");
		System.out.println(sDto.toString());
		sDao.deleteSong(sDto);
		sDto = sDao.selectOne(121);
		System.out.println(sDto.toString());
		sDao.close();
	}
}
