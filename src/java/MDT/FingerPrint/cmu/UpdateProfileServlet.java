/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDT.FingerPrint.cmu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arjunmehrotra
 */
@WebServlet(name = "UpdateProfileServlet", urlPatterns = {"/UpdateProfileServlet"})
public class UpdateProfileServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateProfileServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProfileServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //String user = request.getParameter("username");
            Class.forName("oracle.jdbc.OracleDriver");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String address1 = request.getParameter("address1");
            String address2 = request.getParameter("address2");
            String address3 = request.getParameter("address3");
            String dob = request.getParameter("dob");
            String phone = request.getParameter("phonenumber");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String pin = request.getParameter("pin");

            Connection conn = DriverManager.getConnection(url, "CASTEEL", "tiger");
            Statement statement = conn.createStatement();

            Customer cust = new Customer();
            cust.setAddress(address1);
            cust.setFirstName(firstname);
            cust.setLastName(lastname);
            cust.setPassword(password);
            cust.setPhoneNumber(phone);
            cust.setUsername(username);
            cust.setAddress2(address2);
            cust.setAddress3(address3);
            cust.setDOB(dob);
            cust.setCity(city);
            cust.setState(state);
            String queryString = "UPDATE customer SET firstname='"+firstname+"',lastname='"+lastname+"',phonenumber='"+phone+"',address='"+address1+"',address2='" +address2+ "',address3='" +address3+"',state='"+state+"',city='" +city+ "',dob='" +dob+ "',pin='"+pin+"',password='" +password+ "'  WHERE username = '"+username +"'";

           int flag = statement.executeUpdate(queryString);

            String nextView = "";
 
            request.removeAttribute("username");
            request.removeAttribute("password");
            request.removeAttribute("customer");
            
            request.setAttribute("customer", cust);
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            nextView = "welcome.jsp";
            conn.close();
            RequestDispatcher view = request.getRequestDispatcher(nextView);
            view.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
