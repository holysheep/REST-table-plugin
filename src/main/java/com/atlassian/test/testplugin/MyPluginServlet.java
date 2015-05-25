package com.atlassian.test.testplugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyPluginServlet extends HttpServlet
{

    private static final Logger log = LoggerFactory.getLogger(MyPluginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException

    {
		resp.setContentType("text/html");
		resp.getWriter().write("<html><body>Hello! You did it.</body></html>");

    }

}