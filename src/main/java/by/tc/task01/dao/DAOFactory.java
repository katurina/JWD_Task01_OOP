package by.tc.task01.dao;

import by.tc.task01.dao.impll.ApplianceDAOImpl;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	}
}
