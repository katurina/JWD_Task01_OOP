package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.entity.criteria.SearchCriteria.TabletPC;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {
	@Test
	public void criteriaValidatorNULL() {
		Criteria<Object> objectCriteria = new Criteria<>();
		Assert.assertEquals(false, Validator.criteriaValidator(objectCriteria));
	}

	@Test
	public void criteriaValidatorTablePC() {
		Criteria<TabletPC> tabletPCCriteria = new Criteria<>();
		tabletPCCriteria.add(TabletPC.COLOR, "RED");
		tabletPCCriteria.add(TabletPC.DISPLAY_INCHES, 1);
		tabletPCCriteria.add(TabletPC.MEMORY_ROM, 1);
		tabletPCCriteria.add(TabletPC.BATTERY_CAPACITY, 1);
		tabletPCCriteria.add(TabletPC.FLASH_MEMORY_CAPACITY, 1);
		boolean b = Validator.criteriaValidator(tabletPCCriteria);
		Assert.assertEquals(true, b);
	}

	@Test
	public void criteriaTablePCColoc() {
		Criteria<TabletPC> tabletPCCriteria = new Criteria<TabletPC>();
		tabletPCCriteria.add(TabletPC.COLOR, "545");
		Assert.assertEquals(false, Validator.criteriaValidator(tabletPCCriteria));
	}

	@Test
	public void criteriaTablePCDouble() {
		Criteria<TabletPC> tabletPCCriteria = new Criteria<TabletPC>();
		tabletPCCriteria.add(TabletPC.DISPLAY_INCHES, 5.5);
		Assert.assertEquals(false, Validator.criteriaValidator(tabletPCCriteria));
	}

	@Test
	public void criteriaValidatorLaptop() {
		Criteria<SearchCriteria.Laptop> laptopCriteria = new Criteria<SearchCriteria.Laptop>();
		laptopCriteria.add(SearchCriteria.Laptop.OS, "Linux");
		laptopCriteria.add(SearchCriteria.Laptop.MEMORY_ROM, 8000);
		laptopCriteria.add(SearchCriteria.Laptop.CPU, 2.2);
		laptopCriteria.add(SearchCriteria.Laptop.BATTERY_CAPACITY, 1.5);
		laptopCriteria.add(SearchCriteria.Laptop.DISPLAY_INCHS, 19);
		laptopCriteria.add(SearchCriteria.Laptop.SYSTEM_MEMORY, 1000);
		boolean b = Validator.criteriaValidator(laptopCriteria);
		Assert.assertEquals(true, b);

	}

	@Test
	public void criteriaValidatorOven() {
		Criteria<SearchCriteria.Oven> ovenCriteria = new Criteria<>();
		ovenCriteria.add(SearchCriteria.Oven.POWER_CONSUMPTION, 1000);
		ovenCriteria.add(SearchCriteria.Oven.WEIGHT, 10);
		ovenCriteria.add(SearchCriteria.Oven.CAPACITY, 32);
		ovenCriteria.add(SearchCriteria.Oven.DEPTH, 60);
		ovenCriteria.add(SearchCriteria.Oven.HEIGHT, 45.5);
		ovenCriteria.add(SearchCriteria.Oven.WIDTH, 59.5);
		boolean b = Validator.criteriaValidator(ovenCriteria);
		Assert.assertEquals(true, b);
	}

	@Test
	public void criteriaValidatorRefrigerator() {
		Criteria<SearchCriteria.Refrigerator> refrigeratorCriteria = new Criteria<>();
		refrigeratorCriteria.add(SearchCriteria.Refrigerator.POWER_CONSUMPTION, 150);
		refrigeratorCriteria.add(SearchCriteria.Refrigerator.WEIGHT, 35);
		refrigeratorCriteria.add(SearchCriteria.Refrigerator.FREEZER_CAPACITY, 20);
		refrigeratorCriteria.add(SearchCriteria.Refrigerator.OVERALL_CAPACITY, 350.5);
		refrigeratorCriteria.add(SearchCriteria.Refrigerator.WIDTH, 75);
		refrigeratorCriteria.add(SearchCriteria.Refrigerator.HEIGHT, 250);
		boolean b = Validator.criteriaValidator(refrigeratorCriteria);
		Assert.assertEquals(true, b);
	}

	@Test
	public void criteriaValidatorSpeakers() {
		Criteria<SearchCriteria.Speakers> speakersCriteria = new Criteria<>();
		speakersCriteria.add(SearchCriteria.Speakers.POWER_CONSUMPTION, 17);
		speakersCriteria.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS, 4);
		speakersCriteria.add(SearchCriteria.Speakers.FREQUENCY_RANGE, "2-3.5");
		speakersCriteria.add(SearchCriteria.Speakers.CORD_LENGTH, 4);
		boolean b = Validator.criteriaValidator(speakersCriteria);
		Assert.assertEquals(true, b);
	}

	@Test
	public void criteriaValidatorVacuumCleaner() {
		Criteria<SearchCriteria.VacuumCleaner> vacuumCleanerCriteria = new Criteria<>();
		vacuumCleanerCriteria.add(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION, 110);
		vacuumCleanerCriteria.add(SearchCriteria.VacuumCleaner.FILTER_TYPE, "B");
		vacuumCleanerCriteria.add(SearchCriteria.VacuumCleaner.BAG_TYPE, "AA-89");
		vacuumCleanerCriteria.add(SearchCriteria.VacuumCleaner.WAND_TYPE, "all-in-one");
		vacuumCleanerCriteria.add(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION, 2900);
		vacuumCleanerCriteria.add(SearchCriteria.VacuumCleaner.CLEANING_WIDTH, 25);
		boolean b = Validator.criteriaValidator(vacuumCleanerCriteria);
		Assert.assertEquals(true, b);
	}


}