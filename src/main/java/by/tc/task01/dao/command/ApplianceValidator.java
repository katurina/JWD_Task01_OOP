package by.tc.task01.dao.command;

import by.tc.task01.entity.criteria.Criteria;

public interface ApplianceValidator {
	<E> boolean criteriaValidator(Criteria<E> criteria);
}
