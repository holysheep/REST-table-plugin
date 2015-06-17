package com.atlassian.test.testplugin.DAO;

import com.atlassian.test.testplugin.entity.TeamEntity;
import com.atlassian.test.testplugin.pojo.Team;

public interface TeamDAO {

    TeamEntity addTeam(Team team) throws Exception;
    TeamEntity[] getTeams() throws Exception;

    TeamEntity deleteTeam(long id) throws Exception;
    TeamEntity updateTeam(long id, Team team) throws Exception;
}
