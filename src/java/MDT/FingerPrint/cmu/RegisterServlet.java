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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
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

        if (request.getParameter("username").equals("")
                || request.getParameter("username") == null
                || request.getParameter("password").equals("")
                || request.getParameter("password") == null) {

            request.setAttribute("ErrorMessage", "Both UserName and Password are mandatory!");
            String nextView = "error.jsp";
            RequestDispatcher view = request.getRequestDispatcher(nextView);
            view.forward(request, response);
        } else {
            try {

                Class.forName("oracle.jdbc.OracleDriver");
                String url = "jdbc:oracle:thin:@localhost:1521:xe";
                Connection conn = DriverManager.getConnection(url, "CASTEEL", "tiger");

                Statement statement = conn.createStatement();
                String queryString = "select count(*) from Customer where UserName ='" + request.getParameter("username") + "'";

                ResultSet rs = statement.executeQuery(queryString);

                rs.next();
                if (rs.getInt(1) > 0) {
                    request.setAttribute("ErrorMessage", "UserName already exist! Please choose different UserName");
                    String nextView = "error.jsp";
                    RequestDispatcher view = request.getRequestDispatcher(nextView);
                    view.forward(request, response);
                } else {
                    try {
                        String username = request.getParameter("username");
                        String password = request.getParameter("password");
                        String address = request.getParameter("address1");
                        String firstName = request.getParameter("firstname");
                        String lastName = request.getParameter("lastname");
                        String pin = request.getParameter("pin");
                        String address2 = request.getParameter("address2");
                        String address3 = request.getParameter("address3");
                        String city = request.getParameter("city");
                        String dob = request.getParameter("dob");
                        String state = request.getParameter("state");
                        String phoneNumber = request.getParameter("phonenumber");
                        
                        PreparedStatement insertStatment = conn.prepareStatement("insert into Customer "
                                + "(FirstName, LastName, UserName, Password, Address, Address2, Address3, State, City, Pin, DOB, Phonenumber) values "
                                + "(?,?,?,?,?,?,?,?,?,?,?,?)");

                        insertStatment.setString(1, firstName);
                        insertStatment.setString(2, lastName);
                        insertStatment.setString(3, username);
                        insertStatment.setString(4, password);
                        insertStatment.setString(5, address);
                        insertStatment.setString(6, address2);
                        insertStatment.setString(7, address3);
                        insertStatment.setString(8, state);
                        insertStatment.setString(9, city);
                        insertStatment.setString(10, pin);
                        insertStatment.setString(11, dob);
                        insertStatment.setString(12, phoneNumber);
                        insertStatment.execute();

                        request.setAttribute("SuccessMessage", "Registeration Sucessful.Click on continue to Login");
                        String nextView = "success.jsp";
                        RequestDispatcher view = request.getRequestDispatcher(nextView);
                        view.forward(request, response);

                    } catch (SQLException ex) {
                        request.setAttribute("ErrorMessage", "Error In Server Connection! Please try later");
                        System.out.println(ex.getMessage());
                        String nextView = "error.jsp";
                        RequestDispatcher view = request.getRequestDispatcher(nextView);
                        view.forward(request, response);
                    } finally {
                        conn.close();
                    }
                }
            } catch (SQLException ex) {
                request.setAttribute("ErrorMessage", "Error In Server Connection! Please try later");
                System.out.println(ex.getMessage());
                String nextView = "error.jsp";
                RequestDispatcher view = request.getRequestDispatcher(nextView);
                view.forward(request, response);
            } catch (ClassNotFoundException ex) {
                request.setAttribute("ErrorMessage", "Error In Server Connection! Please try later");
                System.out.println(ex.getMessage());
                String nextView = "error.jsp";
                RequestDispatcher view = request.getRequestDispatcher(nextView);
                view.forward(request, response);
            }
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
