package model.DAO;

import org.junit.Test;

/**
 * @author Laetitia
 *
 */
public class DAOMapTest {


	DAOMap dao ;

	/**
	 * Test for level 0
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testApplyToMap() throws Exception {
		this.dao.loadlevel(0);
	}

}
