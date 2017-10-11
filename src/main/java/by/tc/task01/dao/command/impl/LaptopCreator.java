package by.tc.task01.dao.command.impl;

import by.tc.task01.dao.command.ApplianceCreator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;

public class LaptopCreator implements ApplianceCreator {
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
}
