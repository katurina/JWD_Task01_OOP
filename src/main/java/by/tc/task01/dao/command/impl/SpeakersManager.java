package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceManager;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;
import java.util.regex.Matcher;

import static by.tc.task01.dao.command.impl.constants.RegularConstants.FINDER;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.INT;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.RANGE;

public class SpeakersManager implements ApplianceManager {
	@Override
	public Appliance createAppliance(String line) {
		Matcher matcher = FINDER.matcher(line);
		Speakers speakers = new Speakers();
		matcher.find();
		speakers.setPowerConsumption(Integer.valueOf(matcher.group(2)));
		matcher.find();
		speakers.setNumberSpeakers(Integer.valueOf(matcher.group(2)));
		matcher.find();
		speakers.setFrequencyRange(matcher.group(2));
		matcher.find();
		speakers.setCordLength(Integer.decode(matcher.group(2)));
		return speakers;
	}

	@Override
	public <E> boolean criteriaValidator(Criteria<E> criteria) {
		for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
			if (entry.getValue() == null) {
				return false;
			}
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
