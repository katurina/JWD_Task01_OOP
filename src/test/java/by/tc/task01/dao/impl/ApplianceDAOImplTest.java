package by.tc.task01.dao.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.junit.Assert;
import org.junit.Test;

public class ApplianceDAOImplTest {
	@Test
	public void find() throws Exception {
		ApplianceDAOImpl applianceDAO = new ApplianceDAOImpl();
		Criteria<SearchCriteria.Oven> ovenCriteria = new Criteria<>();
		ovenCriteria.add(SearchCriteria.Oven.CAPACITY,32);
		ovenCriteria.add(SearchCriteria.Oven.DEPTH,60);
		Appliance actual = applianceDAO.find(ovenCriteria);
		Oven expected = new Oven(1000,10,32,60,45.5,59.5);
		Assert.assertEquals(expected,actual);
	}



}