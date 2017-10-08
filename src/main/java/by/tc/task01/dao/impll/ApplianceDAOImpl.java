package by.tc.task01.dao.impll;

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
				String help = tmp.substring(0, tmp.indexOf(' '));
				if (help.equals(criteria.getParamClassName())) {
					boolean containsCriteria = true;
					List<String> listCriteria = criteria.getListCriteria();
					for (String listCriterion : listCriteria) {
						if (!tmp.contains(listCriterion)) {
							containsCriteria = false;
						}
					}
					if (containsCriteria) {
						String entity = tmp.substring(0, tmp.indexOf(' ')).trim();
						switch (entity) {
							case "Oven":
								Oven oven = new Oven();
								oven.setPowerConsumption(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								oven.setWeight(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								oven.setCapacity(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								oven.setDepth(Double.valueOf(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								oven.setHeight(Double.valueOf(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length() - 1);
								oven.setWidth(Double.valueOf(tmp.substring(tmp.indexOf('=') + 1, tmp.length())));
								return oven;
							case "Laptop":
								Laptop laptop = new Laptop();
								laptop.setBatteryCapacity(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								laptop.setOs(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(',')));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								laptop.setMemoryROM(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								laptop.setSystemMemory(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								laptop.setCpu(Double.valueOf(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length() - 1);
								laptop.setDisplayInchs(Integer.valueOf(tmp.substring(tmp.indexOf('=') + 1, tmp.length())));
								return laptop;
							case "Refrigerator":
								Refrigerator refrigerator = new Refrigerator();
								refrigerator.setPowerConsumption(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								refrigerator.setWeight(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								refrigerator.setFreezerCapacity(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								refrigerator.setOverallCapacity(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								refrigerator.setHeight(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length() - 1);
								refrigerator.setWidth(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.length())));
								return refrigerator;
							case "Speakers":
								Speakers speakers = new Speakers();
								speakers.setPowerConsumption(Integer.valueOf(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								speakers.setNumberSpeakers(Integer.valueOf(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								speakers.setFrequencyRange(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(',')));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length() - 1);
								speakers.setCordLength(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.length())));
								return speakers;
							case "TabletPC":
								TabletPC tabletPC = new TabletPC();
								tabletPC.setBatteryCapacity(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								tabletPC.setDisplayInches(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								tabletPC.setMemoryRom(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								tabletPC.setFlashMemoryCapacity(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length() - 1);
								tabletPC.setColor(tmp.substring(tmp.indexOf('=') + 1, tmp.length()));
								return tabletPC;
							case "VacuumCleaner":
								VacuumCleaner vacuumCleaner = new VacuumCleaner();
								vacuumCleaner.setPowerConsumption(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								vacuumCleaner.setFilterType(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(',')));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								vacuumCleaner.setBagType(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(',')));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								vacuumCleaner.setWandType(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(',')));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length());
								vacuumCleaner.setMotorSpeedRegulation(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.indexOf(','))));
								tmp = tmp.substring(tmp.indexOf(',') + 2, tmp.length() - 1);
								vacuumCleaner.setCleaningWidth(Integer.decode(tmp.substring(tmp.indexOf('=') + 1, tmp.length())));
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

	// you may add your own code here

}


//you may add your own new classes