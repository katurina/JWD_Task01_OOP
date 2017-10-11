package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceManager;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;
import java.util.regex.Matcher;

import static by.tc.task01.dao.command.impl.constants.RegularConstants.DOUBLE_OR_INT;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.FINDER;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.INT;

public class RefrigeratorManager implements ApplianceManager {
	@Override
	public Appliance createAppliance(String line) {
		Matcher matcher = FINDER.matcher(line);
		Refrigerator refrigerator = new Refrigerator();
		matcher.find();
		refrigerator.setPowerConsumption(Integer.decode(matcher.group(2)));
		matcher.find();
		refrigerator.setWeight(Integer.decode(matcher.group(2)));
		matcher.find();
		refrigerator.setFreezerCapacity(Integer.decode(matcher.group(2)));
		matcher.find();
		refrigerator.setOverallCapacity(Integer.decode(matcher.group(2)));
		matcher.find();
		refrigerator.setHeight(Integer.decode(matcher.group(2)));
		matcher.find();
		refrigerator.setWidth(Integer.decode(matcher.group(2)));
		return refrigerator;
	}

	@Override
	public <E> boolean criteriaValidator(Criteria<E> criteria) {
		for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
			if (entry.getValue() == null) {
				return false;
			}
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
