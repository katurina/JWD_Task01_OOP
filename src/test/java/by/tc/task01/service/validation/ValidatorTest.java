package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
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
	public void criteriaValidatorTablePC() throws Exception {
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


}