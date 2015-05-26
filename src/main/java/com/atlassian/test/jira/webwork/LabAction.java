package com.atlassian.test.jira.webwork;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.config.properties.APKeys;
import com.atlassian.jira.project.Project;
import com.atlassian.jira.web.action.JiraWebActionSupport;
import com.atlassian.test.testplugin.DAO.DAOFactory;
import com.atlassian.test.testplugin.entity.TeamEntity;
import com.atlassian.test.testplugin.pojo.Team;
import com.atlassian.test.testplugin.pojo.impl.TeamImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webwork.action.ServletActionContext;

public class LabAction extends JiraWebActionSupport {

    private static final Logger log = LoggerFactory.getLogger(LabAction.class);
    private Project project;
    private TeamEntity[] teams;

    @Override
    public String execute() throws Exception {
        project = getSelectedProjectObject();
        getHttpRequest().setAttribute("com.atlassian.jira.projectconfig.util.ServletRequestProjectConfigRequestCache:project", project);
        teams = DAOFactory.getInstance().getTeamDAO().getTeams();
        return super.execute();
    }

    public String doAdd() throws Exception {
        String name = getHttpRequest().getParameterValues("name")[0];
        Team team = new TeamImpl(name);
        DAOFactory.getInstance().getTeamDAO().addTeam(team);
        ServletActionContext.getResponse().sendRedirect("/secure/LabAction.jspa");
        System.out.println("==========");
        return NONE;
    }

    public TeamEntity[] getTeams() {
        return teams;
    }
}
