package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceCreator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;

public class VacuumCleanerCreator implements ApplianceCreator {
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
}
