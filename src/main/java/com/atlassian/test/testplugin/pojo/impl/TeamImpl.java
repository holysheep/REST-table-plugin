package com.atlassian.test.testplugin.pojo.impl;


import com.atlassian.test.testplugin.pojo.Team;

import java.util.Date;

public class TeamImpl implements Team {

    private String name;
    private String created;

    public TeamImpl(String name, String created) {
        this.name = name;
        this.created = created;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String getCreated() {
        return created;
    }
}
