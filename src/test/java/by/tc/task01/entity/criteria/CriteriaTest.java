package by.tc.task01.entity.criteria;

import org.junit.Assert;
import org.junit.Test;

public class CriteriaTest {
	@Test
	public void getParamClassName() throws Exception {
		Criteria<SearchCriteria.Oven> ovenCriteria = new Criteria<>();
		ovenCriteria.add(SearchCriteria.Oven.POWER_CONSUMPTION, 1000);
		Assert.assertEquals("Oven", ovenCriteria.getParamClassName());
	}

}