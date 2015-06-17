package com.atlassian.test.resource;

import com.atlassian.test.testplugin.entity.TeamEntity;

public class Mapper {

    public static XmlTeam toXmlTeam(TeamEntity entity) {
        XmlTeam team = new XmlTeam();
        team.id = entity.getID();
        team.name = entity.getName();
        team.created = entity.getCreated();
        return team;
    }
}
