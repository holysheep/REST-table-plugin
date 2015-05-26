package com.atlassian.test.testplugin.pojo.impl;


import com.atlassian.test.testplugin.pojo.Team;

public class TeamImpl implements Team {

    private String name;

    public TeamImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
