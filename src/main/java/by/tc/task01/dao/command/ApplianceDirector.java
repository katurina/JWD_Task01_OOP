package by.tc.task01.dao.command;

import by.tc.task01.dao.command.impl.LaptopManager;
import by.tc.task01.dao.command.impl.OvenManager;
import by.tc.task01.dao.command.impl.RefrigeratorManager;
import by.tc.task01.dao.command.impl.SpeakersManager;
import by.tc.task01.dao.command.impl.TabletPCManager;
import by.tc.task01.dao.command.impl.VacuumCleanerManager;

import java.util.HashMap;
import java.util.Map;

public class ApplianceDirector {
	private Map<String, ApplianceManager> map = new HashMap<>();

	public ApplianceDirector() {
		map.put("Oven", new OvenManager());
		map.put("Laptop", new LaptopManager());
		map.put("Refrigerator", new RefrigeratorManager());
		map.put("Speakers", new SpeakersManager());
		map.put("TabletPC", new TabletPCManager());
		map.put("VacuumCleaner", new VacuumCleanerManager());
	}

	public ApplianceManager getApplianceManager(String typeName) {
		return map.get(typeName);
	}
}