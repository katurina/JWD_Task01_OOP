package by.tc.task01.dao.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.junit.Assert;
import org.junit.Test;

public class ApplianceDAOImplTest {
	@Test
	public void findOven() throws Exception {
		ApplianceDAOImpl applianceDAO = new ApplianceDAOImpl();
		Criteria<SearchCriteria.Oven> ovenCriteria = new Criteria<>();
		ovenCriteria.add(SearchCriteria.Oven.CAPACITY, 32);
		ovenCriteria.add(SearchCriteria.Oven.DEPTH, 60);
		Appliance actual = applianceDAO.find(ovenCriteria);
		Oven expected = new Oven(1000, 10, 32, 60, 45.5, 59.5);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void findLaptop() {
		ApplianceDAOImpl applianceDAO = new ApplianceDAOImpl();
		Criteria<SearchCriteria.Laptop> laptopCriteria = new Criteria<>();
		laptopCriteria.add(SearchCriteria.Laptop.CPU, 1.2);
		laptopCriteria.add(SearchCriteria.Laptop.MEMORY_ROM, 4000);
		laptopCriteria.add(SearchCriteria.Laptop.OS, "Windows");
//		Laptop : BATTERY_CAPACITY=1, OS=Windows, MEMORY_ROM=4000, SYSTEM_MEMORY=1000, CPU=1.2, DISPLAY_INCHS=18;
		Appliance actual = applianceDAO.find(laptopCriteria);
		Laptop expected = new Laptop(1, "Windows", 4000, 1000, 1.2, 18);
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void findRefrigirator() {
		ApplianceDAOImpl applianceDAO = new ApplianceDAOImpl();
		Criteria<SearchCriteria.Refrigerator> refrigeratorCriteria = new Criteria<>();
//		Refrigerator : POWER_CONSUMPTION=100, WEIGHT=20, FREEZER_CAPACITY=10, OVERALL_CAPACITY=300, HEIGHT=200, WIDTH=70;
		refrigeratorCriteria.add(SearchCriteria.Refrigerator.HEIGHT, 200);
		refrigeratorCriteria.add(SearchCriteria.Refrigerator.WEIGHT, 20);
		Appliance actual = applianceDAO.find(refrigeratorCriteria);
		Refrigerator expected = new Refrigerator(100, 20, 10, 300, 200, 70);
		Assert.assertEquals(expected, actual);
	}


}