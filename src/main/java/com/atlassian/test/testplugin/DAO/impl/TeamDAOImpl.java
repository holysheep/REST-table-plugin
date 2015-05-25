package com.atlassian.test.testplugin.DAO.impl;


import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.sal.api.transaction.TransactionCallback;
import com.atlassian.test.testplugin.DAO.TeamDAO;
import com.atlassian.test.testplugin.entity.TeamEntity;
import com.atlassian.test.testplugin.pojo.Team;
import net.java.ao.Query;

import java.util.Date;

public class TeamDAOImpl implements TeamDAO {

    private final ActiveObjects ao;

    public TeamDAOImpl(ActiveObjects ao) {
        this.ao = ao;
    }

    @Override
    public TeamEntity addTeam(final Team team) throws Exception {

        return ao.executeInTransaction(new TransactionCallback<TeamEntity>() {
            @Override
            public TeamEntity doInTransaction() {
                TeamEntity entity = ao.create(TeamEntity.class);
                entity.setName(team.getName());
                entity.setCreated(new Date(System.currentTimeMillis()));
                entity.save();
                return entity;
            }
        });
    }

    @Override
    public TeamEntity[] getTeams() throws Exception {
        return ao.executeInTransaction(new TransactionCallback<TeamEntity[]>() {
            @Override
            public TeamEntity[] doInTransaction() {
                return ao.find(TeamEntity.class);
            }
        });
    }

    @Override
    public TeamEntity deleteTeam(final long id) throws Exception {
        return ao.executeInTransaction(new TransactionCallback<TeamEntity>(){

            @Override
            public TeamEntity doInTransaction() {
                TeamEntity entity = ao.find(TeamEntity.class, Query.select().where("ID=?", id))[0];
                ao.delete(entity);
                return entity;
            }
        });
    }

    @Override
    public TeamEntity updateTeam(final long id, final Team team) throws Exception {
        return ao.executeInTransaction(new TransactionCallback<TeamEntity>() {

            @Override
            public TeamEntity doInTransaction() {
                TeamEntity entity = ao.find(TeamEntity.class, Query.select().where("ID=?", id))[0];

                if (team.getName() != null) {
                    entity.setName(team.getName());
                }
                entity.save();
                return entity;

            }
        });
    }
}
