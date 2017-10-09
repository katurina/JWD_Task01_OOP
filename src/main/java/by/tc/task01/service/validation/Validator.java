package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;
import java.util.regex.Pattern;

public class Validator {

	private static final Pattern DOUBLE_OR_INT = Pattern.compile("(\\d+\\.\\d+)|(\\d+)");
	private static final Pattern INT = Pattern.compile("^[0-9]+");
	private static final Pattern STRING = Pattern.compile("[a-zA-Z]+");
	private static final Pattern STRING_SPECIFIC_SYMBOL = Pattern.compile("[a-zA-Z0-9-]+");
	private static final Pattern RANGE = Pattern.compile("((\\d+\\.\\d+)|(\\d+))-((\\d+\\.\\d+)|(\\d+))");

	public static <E> boolean criteriaValidator(Criteria<E> criteria) {
		switch (criteria.getParamClassName()) {
			case "TabletPC": {
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
			case "Laptop": {
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
			case "Oven": {
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
			case "Refrigerator": {
				for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
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
			case "VacuumCleaner": {
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
			case "Speakers": {
				for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
					String nameKey = entry.getKey().toString();
					if (nameKey.equals("POWER_CONSUMPTION") || nameKey.equals("NUMBER_OF_SPEAKERS") || nameKey.equals("CORD_LENGTH")) {
						if (!INT.matcher(entry.getValue().toString()).matches()) {
							return false;
						}
					} else if (nameKey.equals("FREQUENCY_RANGE")) {
						if (!RANGE.matcher(entry.getValue().toString()).matches()) {
							return false;
						}
					}
				}
				return true;
			}
		}
		return true;
	}
}