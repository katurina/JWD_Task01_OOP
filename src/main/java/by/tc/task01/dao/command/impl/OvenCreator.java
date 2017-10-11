package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceCreator;
import by.tc.task01.dao.command.ApplianceValidator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

import static by.tc.task01.dao.command.impl.constants.RegularConstants.DOUBLE_OR_INT;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.INT;

public class OvenCreator implements ApplianceCreator, ApplianceValidator {
	@Override
	public Appliance createAppliance(String line) {
		Oven oven = new Oven();
		oven.setPowerConsumption(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		oven.setWeight(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		oven.setCapacity(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		oven.setDepth(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		oven.setHeight(Double.valueOf(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2, line.length() - 1);
		oven.setWidth(Double.valueOf(line.substring(line.indexOf('=') + 1)));
		return oven;
	}

	@Override
	public <E> boolean criteriaValidator(Criteria<E> criteria) {
		for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
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
