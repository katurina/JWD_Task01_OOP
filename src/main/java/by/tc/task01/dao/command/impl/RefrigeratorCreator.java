package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceCreator;
import by.tc.task01.dao.command.ApplianceValidator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

import static by.tc.task01.dao.command.impl.constants.RegularConstants.DOUBLE_OR_INT;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.INT;

public class RefrigeratorCreator implements ApplianceCreator, ApplianceValidator {
	@Override
	public Appliance createAppliance(String line) {
		Refrigerator refrigerator = new Refrigerator();
		refrigerator.setPowerConsumption(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		refrigerator.setWeight(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		refrigerator.setFreezerCapacity(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		refrigerator.setOverallCapacity(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		refrigerator.setHeight(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2, line.length() - 1);
		refrigerator.setWidth(Integer.decode(line.substring(line.indexOf('=') + 1)));
		return refrigerator;
	}

	@Override
	public <E> boolean criteriaValidator(Criteria<E> criteria) {
		for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
			String nameKey = entry.getKey().toString();
			if (nameKey.equals("POWER_CONSUMPTION") || nameKey.equals("WEIGHT") || nameKey.equals("FREEZER_CAPACITY") || nameKey.equals("HEIGHT") || nameKey.equals("WIDTH")) {
				if (!INT.matcher(entry.getValue().toString()).matches()) {
					return false;
				}
			} else if (nameKey.equals("OVERALL_CAPACITY")) {
				if (!DOUBLE_OR_INT.matcher(entry.getValue().toString()).matches()) {
					return false;
				}
			}
		}

		return true;
	}
}
