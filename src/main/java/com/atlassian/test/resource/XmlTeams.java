package com.atlassian.test.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class XmlTeams {

    public XmlTeams (long count, List<XmlTeam> teams) {
        this.count = count;
        this.teams = teams;
    }

    @XmlElement
    public long count;
    @XmlElement
    public List<XmlTeam> teams;

}
