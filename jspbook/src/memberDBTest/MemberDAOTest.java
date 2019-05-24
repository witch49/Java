package memberDBTest;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import memberDB.MemberDAO;

public class MemberDAOTest {
	private MemberDAO mDao = null;

	@Before
	public void beforeTest() {
		mDao = new MemberDAO();
	}

	@Test
	public void verifyLoginTest() {
		int result = mDao.verifyLogin(100001, "asdf");
		assertEquals(MemberDAO.ID_PASSWORD_MATCH, result);

	}

}
