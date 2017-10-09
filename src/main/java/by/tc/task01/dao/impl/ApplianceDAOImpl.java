package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class ApplianceDAOImpl implements ApplianceDAO {

	private final static String PATH = "src\\main\\resources\\appliances_db.txt";

	@Override
	public <E> Appliance find(Criteria<E> criteria) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
			if (criteria == null) {
				return null;
			}
			String tmp = "";
			while ((tmp = bufferedReader.readLine()) != null) {
				if (tmp.isEmpty()) {
					continue;
				}
				String applianceNameStr = tmp.substring(0, tmp.indexOf(' ')).trim();
				String applianceNameActual = criteria.getParamClassName();
				if (applianceNameStr.equals(applianceNameActual)) {
					boolean containsCriteria = true;
					List<String> criteriaList = criteria.getCriteriaList();
					for (String criteriaStr : criteriaList) {
						if (!tmp.toLowerCase().contains(criteriaStr.toLowerCase())) {
							containsCriteria = false;
							break;
						}
					}
					if (containsCriteria) {
						switch (applianceNameStr) {
							case "Oven":
								Oven oven = new Oven();
								oven.setPowerConsumption(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								oven.setWeight(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								oven.setCapacity(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								oven.setDepth(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								oven.setHeight(Double.valueOf(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length() - 1);
								oven.setWidth(Double.valueOf(tmp.substring(tmp.indexOf('=') + 1)));
								return oven;
							case "Laptop":
								Laptop laptop = new Laptop();
								laptop.setBatteryCapacity(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								laptop.setOs(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(',')));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								laptop.setMemoryROM(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								laptop.setSystemMemory(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								laptop.setCpu(Double.valueOf(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length() - 1);
								laptop.setDisplayInchs(Integer.valueOf(tmp.substring(tmp.indexOf('=') + 1)));
								return laptop;
							case "Refrigerator":
								Refrigerator refrigerator = new Refrigerator();
								refrigerator.setPowerConsumption(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								refrigerator.setWeight(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								refrigerator.setFreezerCapacity(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								refrigerator.setOverallCapacity(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								refrigerator.setHeight(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length() - 1);
								refrigerator.setWidth(Integer.decode(tmp.substring(tmp.indexOf('=') + 1)));
								return refrigerator;
							case "Speakers":
								Speakers speakers = new Speakers();
								speakers.setPowerConsumption(Integer.valueOf(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								speakers.setNumberSpeakers(Integer.valueOf(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								speakers.setFrequencyRange(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(',')));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length() - 1);
								speakers.setCordLength(Integer.decode(tmp.substring(tmp.indexOf('=') + 1)));
								return speakers;
							case "TabletPC":
								TabletPC tabletPC = new TabletPC();
								tabletPC.setBatteryCapacity(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								tabletPC.setDisplayInches(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								tabletPC.setMemoryRom(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								tabletPC.setFlashMemoryCapacity(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length() - 1);
								tabletPC.setColor(tmp.substring(tmp.indexOf('=') + 1));
								return tabletPC;
							case "VacuumCleaner":
								VacuumCleaner vacuumCleaner = new VacuumCleaner();
								vacuumCleaner.setPowerConsumption(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								vacuumCleaner.setFilterType(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(',')));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								vacuumCleaner.setBagType(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(',')));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								vacuumCleaner.setWandType(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(',')));
								tmp = tmp.substring(tmp.indexOf(',') + 2);
								vacuumCleaner.setMotorSpeedRegulation(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length() - 1);
								vacuumCleaner.setCleaningWidth(Integer.decode(tmp.substring(tmp.indexOf('=') + 1)));
								return vacuumCleaner;
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}