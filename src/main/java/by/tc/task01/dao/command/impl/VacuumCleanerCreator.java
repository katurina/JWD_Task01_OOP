package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceCreator;
import by.tc.task01.dao.command.ApplianceValidator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

import static by.tc.task01.dao.command.impl.constants.RegularConstants.INT;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.STRING;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.STRING_SPECIFIC_SYMBOL;

public class VacuumCleanerCreator implements ApplianceCreator, ApplianceValidator {
	@Override
	public Appliance createAppliance(String line) {
		VacuumCleaner vacuumCleaner = new VacuumCleaner();
		vacuumCleaner.setPowerConsumption(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		vacuumCleaner.setFilterType(line.substring(line.indexOf('=') + 1, line.indexOf(',')));
		line = line.substring(line.indexOf(',') + 2);
		vacuumCleaner.setBagType(line.substring(line.indexOf('=') + 1, line.indexOf(',')));
		line = line.substring(line.indexOf(',') + 2);
		vacuumCleaner.setWandType(line.substring(line.indexOf('=') + 1, line.indexOf(',')));
		line = line.substring(line.indexOf(',') + 2);
		vacuumCleaner.setMotorSpeedRegulation(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2, line.length() - 1);
		vacuumCleaner.setCleaningWidth(Integer.decode(line.substring(line.indexOf('=') + 1)));
		return vacuumCleaner;
	}

	@Override
	public <E> boolean criteriaValidator(Criteria<E> criteria) {
		for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
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
