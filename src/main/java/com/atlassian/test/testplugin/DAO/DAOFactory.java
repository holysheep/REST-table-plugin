package com.atlassian.test.testplugin.DAO;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.test.testplugin.DAO.impl.TeamDAOImpl;

public class DAOFactory {

    private static TeamDAO teamDAO = null;
    private static DAOFactory instance = null;
    private static ActiveObjects ao;

    public DAOFactory(ActiveObjects ao) {
        DAOFactory.ao = ao;
    }

    public static synchronized DAOFactory getInstance(){
        if(instance == null) {
            instance = new DAOFactory(ao);
        }
        return instance;
    }

    public TeamDAO getTeamDAO() {
        if (teamDAO == null) {
            teamDAO = new TeamDAOImpl(ao);
        }
        return teamDAO;
    }
}
