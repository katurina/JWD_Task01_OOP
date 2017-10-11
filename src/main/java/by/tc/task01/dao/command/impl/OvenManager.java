package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceManager;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;
import java.util.regex.Matcher;

import static by.tc.task01.dao.command.impl.constants.RegularConstants.DOUBLE_OR_INT;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.FINDER;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.INT;

public class OvenManager implements ApplianceManager {
	@Override
	public Appliance createAppliance(String line) {
		Matcher matcher = FINDER.matcher(line);
		Oven oven = new Oven();
		matcher.find();
		oven.setPowerConsumption(Integer.decode(matcher.group(2)));
		matcher.find();
		oven.setWeight(Integer.decode(matcher.group(2)));
		matcher.find();
		oven.setCapacity(Integer.decode(matcher.group(2)));
		matcher.find();
		oven.setDepth(Integer.decode(matcher.group(2)));
		matcher.find();
		oven.setHeight(Double.valueOf(matcher.group(2)));
		matcher.find();
		oven.setWidth(Double.valueOf(matcher.group(2)));
		return oven;
	}

	@Override
	public <E> boolean criteriaValidator(Criteria<E> criteria) {
		for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
			if (entry.getValue() == null) {
				return false;
			}
			String nameKey = entry.getKey().toString();
			if (nameKey.equals("HEIGHT") || nameKey.equals("WIDTH")) {
				if (!DOUBLE_OR_INT.matcher(entry.getValue().toString()).matches()) {
					return false;
				}
			} else if (nameKey.equals("POWER_CONSUMPTION") || nameKey.equals("WEIGHT") || nameKey.equals("CAPACITY") || nameKey.equals("DEPTH")) {
				if (!INT.matcher(entry.getValue().toString()).matches()) {
					return false;
				}
			}
		}
		return true;
	}
}
