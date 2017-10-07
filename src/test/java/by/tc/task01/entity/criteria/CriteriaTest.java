package by.tc.task01.entity.criteria;

import org.junit.Test;

public class CriteriaTest {
	@Test
	public void getParametsClassName() throws Exception {
		Criteria<SearchCriteria.Oven> ovenCriteria = new Criteria<>();
		ovenCriteria.add(SearchCriteria.Oven.POWER_CONSUMPTION, 1000);
		System.out.println(ovenCriteria.getParamClassName());
	}

}