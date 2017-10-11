package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceManager;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;
import java.util.regex.Matcher;

import static by.tc.task01.dao.command.impl.constants.RegularConstants.FINDER;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.INT;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.STRING;

public class TabletPCManager implements ApplianceManager {
	@Override
	public Appliance createAppliance(String line) {
		Matcher matcher = FINDER.matcher(line);
		TabletPC tabletPC = new TabletPC();
		matcher.find();
		tabletPC.setBatteryCapacity(Integer.decode(matcher.group(2)));
		matcher.find();
		tabletPC.setDisplayInches(Integer.decode(matcher.group(2)));
		matcher.find();
		tabletPC.setMemoryROM(Integer.decode(matcher.group(2)));
		matcher.find();
		tabletPC.setFlashMemoryCapacity(Integer.decode(matcher.group(2)));
		matcher.find();
		tabletPC.setColor(matcher.group(2));
		return tabletPC;
	}

	@Override
	public <E> boolean criteriaValidator(Criteria<E> criteria) {
		for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
			if (entry.getValue() == null) {
				return false;
			}
			String nameKey = entry.getKey().toString();
			if (nameKey.equals("COLOR")) {
				if (!STRING.matcher(entry.getValue().toString()).matches()) {
					return false;
				}
			} else if (nameKey.equals("BATTERY_CAPACITY") || nameKey.equals("DISPLAY_INCHES")
					|| nameKey.equals("MEMORY_ROM") || nameKey.equals("FLASH_MEMORY_CAPACITY")) {
				if (!INT.matcher(entry.getValue().toString()).matches()) {
					return false;
				}
			}
		}
		return true;
	}
}
