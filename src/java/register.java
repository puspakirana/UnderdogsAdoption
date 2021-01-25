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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author puspakirana
 */
public class register extends HttpServlet
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
        String address = request.getParameter("address");
        String country = request.getParameter("country");
        String idNum = request.getParameter("idNum");
        String gender = request.getParameter("gender");
        if(gender.equals("male"))
        {
            gender = "Male";
        }
        else if(gender.equals("female"))
        {
            gender = "Female";
        }
        String underdogs = request.getParameter("dogs");
        String[] temp = request.getParameterValues("stuff");
        String stuff = "";
        
        for(int i=0; i < temp.length; i++)
        {
            stuff += temp[i];
            if (i < temp.length - 1)
            {
                stuff += ", ";
            }
        }
        
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adoption", "root", "");
           PreparedStatement ps = con.prepareStatement("insert into registationform (firstName, lastName, email, phone, address, country, idNum, gender, underdogs, stuff) values(?,?,?,?,?,?,?,?,?,?)");
           ps.setString(1, fname);
           ps.setString(2, lname);
           ps.setString(3, email);
           ps.setString(4, phNum);
           ps.setString(5, address);
           ps.setString(6, country);
           ps.setString(7, idNum);
           ps.setString(8, gender);
           ps.setString(9, underdogs);
           ps.setString(10, stuff);
           
           ps.executeUpdate();
           
           //out.println("Data is input succesfully");
           out.println("<html>");
           //head
           out.println("<head>");
           out.println("<meta charset='utf-8'>");
           out.println("<title>Registration Success</title>");
           out.println("<link rel='stylesheet' href='confirmation.css'>");
           out.println("</head>");
           //body
           out.println("<body>");
           
           out.println("<div class='header'>");
           out.println("<h2>Registration Success !!</h2>");
           out.println("<h1>Your profile will be reviewed in 5 days</h1>");
           out.println("<h3>We will contact you soon</h3>");
           out.println("</div>");
           
           out.println("<div class='body2'>");
           
           out.println("<div class='timeline'>");
           out.println("<div class='timeline-body'>");
           
           //basic info
           out.println("<div class='timeline-item'>");
           out.println("<p class='time'>Basic Info</p>");
           out.println("<div class='content'>");
           out.println("<h2 class='title'>Adopter Name</h2>");
           out.println("<p>First name: "+fname+"<br>Last name: "+lname+"</p>");
           out.println("</div>");
           out.println("</div>");
           
           //contact info
           out.println("<div class='timeline-item'>");
           out.println("<p class='time'>Contact Info</p>");
           out.println("<div class='content'>");
           out.println("<h2 class='title'>Adopter Contact</h2>");
           out.println("<p>E-mail: "+email+"<br>Phone Number: "+phNum+"</p>");
           out.println("</div>");
           out.println("</div>");
           
           //address
           out.println("<div class='timeline-item'>");
           out.println("<p class='time'>Address Info</p>");
           out.println("<div class='content'>");
           out.println("<h2 class='title'>Adopter Address</h2>");
           out.println("<p>Address: "+address+"<br>Country: "+country+"</p>");
           out.println("</div>");
           out.println("</div>");
           
           //additional
           out.println("<div class='timeline-item'>");
           out.println("<p class='time'>Additional Info</p>");
           out.println("<div class='content'>");
           out.println("<h2 class='title'>Adopter Additional Info</h2>");
           out.println("<p>ID Number: "+idNum+"<br>Gender: "+gender+"</p>");
           out.println("</div>");
           out.println("</div>");
           
           //dogs
           out.println("<div class='timeline-item'>");
           out.println("<p class='time'>The Underdog</p>");
           out.println("<div class='content'>");
           out.println("<h2 class='title'>Dog's Profile</h2>");
           out.println("<p>Name: "+underdogs+"<br>Additional Stuff: "+stuff+"</p>");
           out.println("</div>");
           out.println("</div>");
           
           out.println("</div>");
           out.println("</div>");
           
           out.println("<div class='okay-body'>");
           out.println("<a class='okay' href='index.html'>OKAY!</a>");
           out.println("</div>");
           
           out.println("</div>");
           
           out.println("</body>");
           out.println("</html>");
           
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
