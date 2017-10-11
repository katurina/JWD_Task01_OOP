package by.tc.task01.service.validation;

import by.tc.task01.dao.command.ApplianceDirector;
import by.tc.task01.dao.command.ApplianceValidator;
import by.tc.task01.entity.criteria.Criteria;

public class Validator {


	public static <E> boolean criteriaValidator(Criteria<E> criteria) {
		if (criteria.getCriteriaList().isEmpty()) {
			return false;
		}
		ApplianceDirector applianceDirector = new ApplianceDirector();
		ApplianceValidator appliance = applianceDirector.getApplianceManager(criteria.getParamClassName());
		return appliance.criteriaValidator(criteria);
	}
}