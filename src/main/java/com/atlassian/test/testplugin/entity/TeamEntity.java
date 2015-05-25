package com.atlassian.test.testplugin.entity;


import com.atlassian.test.testplugin.pojo.Team;
import net.java.ao.Entity;

import java.util.Date;

public interface TeamEntity extends Entity, Team {

    Date getCreated();
    void setCreated(Date created);
}

