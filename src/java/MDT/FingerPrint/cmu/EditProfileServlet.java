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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
@WebServlet(name = "EditProfileServlet", urlPatterns = {"/EditProfileServlet"})
public class EditProfileServlet extends HttpServlet {

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
            out.println("<title>Servlet EditProfileServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditProfileServlet at " + request.getContextPath() + "</h1>");
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
            String user = request.getParameter("username");

            Connection conn = DriverManager.getConnection(url, "CASTEEL", "tiger");
            Statement statement = conn.createStatement();

            Customer cust = new Customer();

            String queryString = "select * from Customer where UserName ='" + user + "'";
            ResultSet rs = statement.executeQuery(queryString);
            rs.next();
//            cust.setUsername(rs.getString("USERNAME"));
//            cust.setPassword(rs.getString("PASSWORD"));
//            cust.setFirstName(rs.getString("FIRSTNAME"));
//            cust.setLastName(rs.getString("LASTNAME"));
//            cust.setAddress(rs.getString("ADDRESS"));
//            cust.setPhoneNumber(rs.getString("PHONENUMBER"));

            cust.setUsername(rs.getString("USERNAME"));
            cust.setPassword(rs.getString("PASSWORD"));
            cust.setFirstName(rs.getString("FIRSTNAME"));
            cust.setLastName(rs.getString("LASTNAME"));
            cust.setAddress(rs.getString("ADDRESS"));
            cust.setPhoneNumber(rs.getString("PHONENUMBER"));
            cust.setAddress2(rs.getString("ADDRESS2"));
            cust.setAddress3(rs.getString("ADDRESS3"));
            cust.setCity(rs.getString("CITY"));
            cust.setDOB(rs.getString("DOB"));
            cust.setPin(rs.getString("PIN"));
            cust.setState(rs.getString("STATE"));

            request.removeAttribute("customer");
            request.setAttribute("customer", cust);
            String nextView = "";

            nextView = "editProfile.jsp";
            conn.close();
            RequestDispatcher view = request.getRequestDispatcher(nextView);
            try {
                view.forward(request, response);
            } catch (ServletException e) {
            }
        } catch (SQLException | ClassNotFoundException ex) {
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
