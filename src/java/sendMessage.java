/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author puspakirana
 */
public class sendMessage extends HttpServlet
{
     public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException
     {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection con = null;
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String phNum = request.getParameter("phNum");
        String message = request.getParameter("message");
        
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adoption", "root", "");
           PreparedStatement ps = con.prepareStatement("insert into clientmessage (firstName, lastName, email, phone, message) values(?,?,?,?,?)");
           ps.setString(1, fname);
           ps.setString(2, lname);
           ps.setString(3, email);
           ps.setString(4, phNum);
           ps.setString(5, message);
           ps.executeUpdate();
           
           RequestDispatcher rd = request.getRequestDispatcher("thanks.html");
           rd.forward(request, response);
           
           response.sendRedirect("thanks.html");
       }
        catch (Exception e)
        {
           e.printStackTrace();
        }
       
        finally 
        {
           try 
           {
               con.close();
           }
           catch (Exception e)
           {
               e.printStackTrace();
           }
       }
     }
}
