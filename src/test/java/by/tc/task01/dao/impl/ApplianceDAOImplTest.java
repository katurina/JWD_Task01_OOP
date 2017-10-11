package by.tc.task01.dao.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;
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
		Appliance actual = applianceDAO.find(laptopCriteria);
		Laptop expected = new Laptop(1, "Windows", 4000, 1000, 1.2, 18);
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void findRefrigirator() {
		ApplianceDAOImpl applianceDAO = new ApplianceDAOImpl();
		Criteria<SearchCriteria.Refrigerator> refrigeratorCriteria = new Criteria<>();
		refrigeratorCriteria.add(SearchCriteria.Refrigerator.HEIGHT, 200);
		refrigeratorCriteria.add(SearchCriteria.Refrigerator.WEIGHT, 20);
		Appliance actual = applianceDAO.find(refrigeratorCriteria);
		Refrigerator expected = new Refrigerator(100, 20, 10, 300, 200, 70);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void findVacuumCleaner() {
		ApplianceDAOImpl applianceDAO = new ApplianceDAOImpl();
		Criteria<SearchCriteria.VacuumCleaner> vacuumCleanerCriteria = new Criteria<>();
		vacuumCleanerCriteria.add(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION, 90);
		vacuumCleanerCriteria.add(SearchCriteria.VacuumCleaner.CLEANING_WIDTH, 30);
		Appliance actual = applianceDAO.find(vacuumCleanerCriteria);
		VacuumCleaner expected = new VacuumCleaner(90, "C", "XX00", "all-in-one", 2950, 30);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void findTabletPC() {
		ApplianceDAOImpl applianceDAO = new ApplianceDAOImpl();
		Criteria<SearchCriteria.TabletPC> tabletPCCriteria = new Criteria<>();
		tabletPCCriteria.add(SearchCriteria.TabletPC.DISPLAY_INCHES, 14);
		tabletPCCriteria.add(SearchCriteria.TabletPC.COLOR, "blue");
		Appliance actual = applianceDAO.find(tabletPCCriteria);
		TabletPC expected = new TabletPC(3, 14, 8000, 2, "blue");
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void findSpeakers() {
		ApplianceDAOImpl applianceDAO = new ApplianceDAOImpl();
		Criteria<SearchCriteria.Speakers> speakersCriteria = new Criteria<>();
		speakersCriteria.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS, 3);
		speakersCriteria.add(SearchCriteria.Speakers.CORD_LENGTH, 3);
		Appliance actual = applianceDAO.find(speakersCriteria);
		Speakers expected = new Speakers(20, 3, "3-4", 3);
		Assert.assertEquals(expected, actual);
	}
}