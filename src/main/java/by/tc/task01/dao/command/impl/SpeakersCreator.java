package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceCreator;
import by.tc.task01.dao.command.ApplianceValidator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

import static by.tc.task01.dao.command.impl.constants.RegularConstants.INT;
import static by.tc.task01.dao.command.impl.constants.RegularConstants.RANGE;

public class SpeakersCreator implements ApplianceCreator, ApplianceValidator {
	@Override
	public Appliance createAppliance(String line) {
		Speakers speakers = new Speakers();
		speakers.setPowerConsumption(Integer.valueOf(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		speakers.setNumberSpeakers(Integer.valueOf(line.substring(line.indexOf('=') + 1, line.indexOf(','))));
		line = line.substring(line.indexOf(',') + 2);
		speakers.setFrequencyRange(line.substring(line.indexOf('=') + 1, line.indexOf(',')));
		line = line.substring(line.indexOf(',') + 2, line.length() - 1);
		speakers.setCordLength(Integer.decode(line.substring(line.indexOf('=') + 1)));
		return speakers;
	}

	@Override
	public <E> boolean criteriaValidator(Criteria<E> criteria) {
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
