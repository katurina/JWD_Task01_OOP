package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.command.ApplianceDirector;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class ApplianceDAOImpl implements ApplianceDAO {

	@Override
	public <E> Appliance find(Criteria<E> criteria) {
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(getClass().getClassLoader()
						.getResourceAsStream("appliances_db.txt"), "UTF-8"));) {
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
						ApplianceDirector applianceDirector = new ApplianceDirector();
						return applianceDirector.getApplianceManager(applianceNameActual).createAppliance(tmp);
					}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}