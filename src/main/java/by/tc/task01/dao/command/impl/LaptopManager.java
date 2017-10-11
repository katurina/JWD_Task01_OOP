package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceManager;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;
import java.util.regex.Matcher;

import static by.tc.task01.dao.command.impl.constants.RegularConstants.DOUBLE_OR_INT;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.FINDER;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.INT;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.STRING;

public class LaptopManager implements ApplianceManager {
	@Override
	public Appliance createAppliance(String line) {
		Matcher matcher = FINDER.matcher(line);
		Laptop laptop = new Laptop();
		matcher.find();
		laptop.setBatteryCapacity(Integer.decode(matcher.group(2)));
		matcher.find();
		laptop.setOs(matcher.group(2));
		matcher.find();
		laptop.setMemoryROM(Integer.decode(matcher.group(2)));
		matcher.find();
		laptop.setSystemMemory(Integer.decode(matcher.group(2)));
		matcher.find();
		laptop.setCpu(Double.valueOf(matcher.group(2)));
		matcher.find();
		laptop.setDisplayInchs(Integer.valueOf(matcher.group(2)));
		return laptop;
	}

	@Override
	public <E> boolean criteriaValidator(Criteria<E> criteria) {
		for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
			if (entry.getValue() == null) {
				return false;
			}
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
