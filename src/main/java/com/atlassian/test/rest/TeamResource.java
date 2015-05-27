package com.atlassian.test.rest;

import com.atlassian.jira.util.json.JSONException;
import com.atlassian.jira.util.json.JSONObject;
import com.atlassian.plugins.rest.common.security.AnonymousAllowed;
import com.atlassian.test.resource.Mapper;
import com.atlassian.test.resource.XmlTeam;
import com.atlassian.test.resource.XmlTeams;
import com.atlassian.test.testplugin.DAO.DAOFactory;
import com.atlassian.test.testplugin.entity.TeamEntity;
import com.atlassian.test.testplugin.pojo.Team;
import com.atlassian.test.testplugin.pojo.impl.TeamImpl;
import com.google.common.collect.Lists;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teams")
public class TeamResource {

    @GET
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    @Path("/")
    public Response getTeams() throws Exception {
        List<XmlTeam> xmlTeams = Lists.newArrayList();
        return Response.ok(new XmlTeams(xmlTeams.size(), xmlTeams)).build();
    }

    @POST
    public Response addTeam(String request) throws Exception {

        JSONObject jsonObject = new JSONObject(request);
        String name = jsonObject.getString("name");
        Team team = new TeamImpl(name);
        TeamEntity teamEntity = DAOFactory.getInstance().getTeamDAO().addTeam(team);
        return Response.ok(Mapper.toXmlTeam(teamEntity)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRow(@PathParam("id") String idString) throws Exception {

        long id = Long.parseLong(idString);
        TeamEntity teamEntity = DAOFactory.getInstance().getTeamDAO().deleteTeam(id);
        return Response.ok(Mapper.toXmlTeam(teamEntity)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateRow(@PathParam("id") String idString, String request) throws Exception {

        String name;
        long id = Long.parseLong(idString);
        JSONObject jsonObject = new JSONObject(request);
        try {
            name = jsonObject.getString("name");
        } catch (JSONException ex) {
            name = null;
        }

        Team team = new TeamImpl(name);
        TeamEntity teamEntity = DAOFactory.getInstance().getTeamDAO().updateTeam(id, team);
        return Response.ok(Mapper.toXmlTeam(teamEntity)).build();
    }
}
