package com.atlassian.test.resource;


import javax.xml.bind.annotation.XmlElement;

public class XmlTeam {

    @XmlElement
    public long id;

    @XmlElement
    public String name;

    @XmlElement
    public String created;

}
