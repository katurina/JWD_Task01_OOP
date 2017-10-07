package by.tc.task01.main;

import by.tc.task01.dao.impl.ApplianceDAOImpl;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;

public class JustTestDeleteAfter {
	public static void main(String[] args) {
		ApplianceDAOImpl applianceDAO = new ApplianceDAOImpl();
		applianceDAO.find(new Criteria<Oven>());
	}
}
