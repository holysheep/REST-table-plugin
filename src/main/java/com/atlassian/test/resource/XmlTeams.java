package com.atlassian.test.resource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class XmlTeams {

    @XmlElement
    public long count;
    @XmlElement
    public List<XmlTeam> teams;

    public XmlTeams (long count, List<XmlTeam> teams) {
        this.count = count;
        this.teams = teams;
    }
}
