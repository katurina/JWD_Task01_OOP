package by.tc.task01.dao.command;

import by.tc.task01.dao.command.impl.LaptopCreator;
import by.tc.task01.dao.command.impl.OvenCreator;
import by.tc.task01.dao.command.impl.RefrigeratorCreator;
import by.tc.task01.dao.command.impl.SpeakersCreator;
import by.tc.task01.dao.command.impl.TabletPCCreator;
import by.tc.task01.dao.command.impl.VacuumCleanerCreator;

import java.util.HashMap;
import java.util.Map;

public class ApplianceDirector {
	private Map<String, ApplianceCreator> map = new HashMap<>();

	public ApplianceDirector() {
		map.put("Oven", new OvenCreator());
		map.put("Laptop", new LaptopCreator());
		map.put("Refrigerator", new RefrigeratorCreator());
		map.put("Speakers", new SpeakersCreator());
		map.put("TabletPC", new TabletPCCreator());
		map.put("VacuumCleaner", new VacuumCleanerCreator());
	}

	public ApplianceCreator getApplianceCreator(String typeName) {
		return map.get(typeName); // return value according key(typeName)
	}
}