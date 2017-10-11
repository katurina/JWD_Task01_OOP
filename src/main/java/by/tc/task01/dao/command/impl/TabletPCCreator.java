package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceCreator;
import by.tc.task01.dao.command.ApplianceValidator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

import static by.tc.task01.dao.command.impl.constants.RegularConstants.INT;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.STRING;

public class TabletPCCreator implements ApplianceCreator, ApplianceValidator {
	@Override
	public Appliance createAppliance(String line) {
		TabletPC tabletPC = new TabletPC();
		tabletPC.setBatteryCapacity(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		tabletPC.setDisplayInches(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		tabletPC.setMemoryROM(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		tabletPC.setFlashMemoryCapacity(Integer.decode(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2, line.length() - 1);
		tabletPC.setColor(line.substring(line.indexOf('=') + 1));
		return tabletPC;
	}

	@Override
	public <E> boolean criteriaValidator(Criteria<E> criteria) {
		for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
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
