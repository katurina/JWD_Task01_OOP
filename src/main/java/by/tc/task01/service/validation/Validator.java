package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;
import java.util.regex.Pattern;

public class Validator {

	public static <E> boolean criteriaValidator(Criteria<E> criteria) {

		switch (criteria.getParamClassName()) {
			case "TabletPC": {
				for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
					String nameKey = entry.getKey().toString();
					if (nameKey.equals("COLOR")) {
						if (!Pattern.compile("^[a-zA-Z]+").matcher(entry.getValue().toString()).matches()) {
							return false;
						}
						entry.setValue(entry.getValue().toString().toLowerCase());
					} else if (nameKey.equals("BATTERY_CAPACITY") || nameKey.equals("DISPLAY_INCHES")
							|| nameKey.equals("MEMORY_ROM") || nameKey.equals("FLASH_MEMORY_CAPACITY")) {
						if (!Pattern.compile("^[0-9]+").matcher(entry.getValue().toString()).matches()) {
							return false;
						}
					}
				}
				return true;
			}
			case "Laptop": {
//				Laptop : BATTERY_CAPACITY=1, OS=Windows, MEMORY_ROM=4000, SYSTEM_MEMORY=1000, CPU=1.2, DISPLAY_INCHS=18;
				for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
					String nameKey = entry.getKey().toString();
					if (nameKey.equals("BATTERY_CAPACITY") || nameKey.equals("MEMORY_ROM") || nameKey.equals("DISPLAY_INCHS")) {
						if (!Pattern.compile("^[0-9]+").matcher(entry.getValue().toString()).matches()) {
							return false;
						}
					} else if (nameKey.equals("OS")) {
						if (!Pattern.compile("^[a-zA-Z]+").matcher(entry.getValue().toString()).matches()) {
							return false;
						}
					}
				}
				return true;
			}
			case "Oven":
			case "Refrigerator":
			case "VacuumCleaner":
			case "Speakers":
		}

		return true;
	}

}


//you may add your own new classes