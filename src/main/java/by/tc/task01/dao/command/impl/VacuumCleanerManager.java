package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceManager;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;
import java.util.regex.Matcher;

import static by.tc.task01.dao.command.impl.constants.RegularConstants.FINDER;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.INT;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.STRING;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.STRING_SPECIFIC_SYMBOL;

public class VacuumCleanerManager implements ApplianceManager {
	@Override
	public Appliance createAppliance(String line) {
		Matcher matcher = FINDER.matcher(line);
		VacuumCleaner vacuumCleaner = new VacuumCleaner();
		matcher.find();
		vacuumCleaner.setPowerConsumption(Integer.decode(matcher.group(2)));
		matcher.find();
		vacuumCleaner.setFilterType(matcher.group(2));
		matcher.find();
		vacuumCleaner.setBagType(matcher.group(2));
		matcher.find();
		vacuumCleaner.setWandType(matcher.group(2));
		matcher.find();
		vacuumCleaner.setMotorSpeedRegulation(Integer.decode(matcher.group(2)));
		matcher.find();
		vacuumCleaner.setCleaningWidth(Integer.decode(matcher.group(2)));
		return vacuumCleaner;
	}

	@Override
	public <E> boolean criteriaValidator(Criteria<E> criteria) {
		for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
			if (entry.getValue() == null) {
				return false;
			}
			String nameKey = entry.getKey().toString();
			if (nameKey.equals("POWER_CONSUMPTION") || nameKey.equals("MOTOR_SPEED_REGULATION") || nameKey.equals("CLEANING_WIDTH")) {
				if (!INT.matcher(entry.getValue().toString()).matches()) {
					return false;
				}
			} else if (nameKey.equals("FILTER_TYPE")) {
				if (!STRING.matcher(entry.getValue().toString()).matches()) {
					return false;
				}
			} else if (nameKey.equals("BAG_TYPE") || nameKey.equals("WAND_TYPE")) {
				if (!STRING_SPECIFIC_SYMBOL.matcher(entry.getValue().toString()).matches()) {
					return false;
				}
			}
		}
		return true;
	}
}
