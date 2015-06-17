package com.atlassian.test.jira.webwork;

import com.atlassian.jira.project.Project;
import com.atlassian.jira.web.action.JiraWebActionSupport;
import com.atlassian.test.testplugin.DAO.DAOFactory;
import com.atlassian.test.testplugin.entity.TeamEntity;
import com.atlassian.test.testplugin.pojo.Team;
import com.atlassian.test.testplugin.pojo.impl.TeamImpl;
import webwork.action.ServletActionContext;

public class MainAction extends JiraWebActionSupport {

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
        String created = getHttpRequest().getParameterValues("created")[0];
        Team team = new TeamImpl(name, created);
        DAOFactory.getInstance().getTeamDAO().addTeam(team);
        ServletActionContext.getResponse().sendRedirect("/secure/MainAction.jspa");
        return NONE;
    }

    public TeamEntity[] getTeams() {
        return teams;
    }
}