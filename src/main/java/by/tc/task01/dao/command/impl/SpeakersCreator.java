package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceCreator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;

public class SpeakersCreator implements ApplianceCreator {
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
}
