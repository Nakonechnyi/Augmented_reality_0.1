package com.controller;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @autor A_Nakonechnyi
 * @date 27.04.2016.
 */
public class LoginTest extends TestCase{

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession session;

    @Mock
    RequestDispatcher requestDispatcher;

    @Before
    protected void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() throws IOException, ServletException {
        /*HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher rd=mock(RequestDispatcher.class);
        */

        when(request.getParameter("user")).thenReturn("Anton");
        when(request.getParameter("password")).thenReturn("passw0rd");
        when(request.getParameter("rememberMe")).thenReturn("Y");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/HelloWorld.do")).thenReturn(requestDispatcher);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        when(response.getWriter()).thenReturn(pw);

        new Login().doPost(request, response);

        //Verify the session attribute value
        verify(session).setAttribute("user", "Anton");

        verify(requestDispatcher).forward(request, response);

        String result = sw.getBuffer().toString().trim();

        System.out.println("Result: "+result);

        assertEquals("Login successfull...", result);

    }

}