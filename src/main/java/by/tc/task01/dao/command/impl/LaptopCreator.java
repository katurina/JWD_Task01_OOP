package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceCreator;
import by.tc.task01.dao.command.ApplianceValidator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

import static by.tc.task01.dao.command.impl.constants.RegularConstants.DOUBLE_OR_INT;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.INT;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.STRING;

public class LaptopCreator implements ApplianceCreator, ApplianceValidator {
	@Override
	public Appliance createAppliance(String line) {
		Laptop laptop = new Laptop();
		laptop.setBatteryCapacity(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		laptop.setOs(line.substring(line.indexOf('=') + 1, line.indexOf(',')));
		line = line.substring(line.indexOf(',') + 2);
		laptop.setMemoryROM(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		laptop.setSystemMemory(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		laptop.setCpu(Double.valueOf(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2, line.length() - 1);
		laptop.setDisplayInchs(Integer.valueOf(line.substring(line.indexOf('=') + 1)));
		return laptop;
	}

	@Override
	public <E> boolean criteriaValidator(Criteria<E> criteria) {
		for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
			String nameKey = entry.getKey().toString();
			if (nameKey.equals("SYSTEM_MEMORY") || nameKey.equals("MEMORY_ROM") || nameKey.equals("DISPLAY_INCHS")) {
				if (!INT.matcher(entry.getValue().toString()).matches()) {
					return false;
				}
			} else if (nameKey.equals("OS")) {
				if (!STRING.matcher(entry.getValue().toString()).matches()) {
					return false;
				}
			} else if (nameKey.equals("CPU") || nameKey.equals("BATTERY_CAPACITY")) {
				if (!DOUBLE_OR_INT.matcher(entry.getValue().toString()).matches()) {
					return false;
				}
			}
		}
		return true;
	}
}
