/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDT.FingerPrint.cmu;

import com.neurotechnology.Nffv.NffvStatus;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
@WebServlet(name = "ValidateTransaction", urlPatterns = {"/ValidateTransaction"})
public class ValidateTransaction extends HttpServlet {

    static final int TIMEOUT = 10000;

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
            out.println("<title>Servlet ValidateTransaction</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidateTransaction at " + request.getContextPath() + "</h1>");
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
            //        try {
            String pin = request.getParameter("pin");
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            Connection conn = DriverManager.getConnection(url, "CASTEEL", "tiger");
            Statement statement = conn.createStatement();
            String queryString = "Select * from customer where pin='" + pin + "'";
            ResultSet rs = statement.executeQuery(queryString);
            if (rs.next() == true) {
                FingerCode fc = FingerCode.getInstace();
                String username = rs.getString("USERNAME");
                queryString = "Select * from creditcard where username='" + username + "' and isprimary='Y'";
                rs = statement.executeQuery(queryString);
                if (rs.next() == true) {
                    String cardNum = rs.getString("creditcardnumber");
                    String venName = request.getParameter("vendorName");
                    String tranNum = request.getParameter("transactionNumber");
                    String tranDate = request.getParameter("transactionDate");
                    String total = request.getParameter("total");
                    for (int i = 0; i < fc.getUsers().size(); i++) {
                        int score = fc.getEngine().verify(fc.getUsers().get(i), TIMEOUT);
                        if (fc.getEngine().getEngineStatus() == NffvStatus.TemplateCreated) {
                            if (score > 0) {
                                try {

                                    queryString = "Insert into transaction (creditcardnumber,transactionnumber,vendorname,transactiondate,transactionamount) values('" + cardNum + "','" + tranNum + "','" + venName + "','" + tranDate + "','" + total + "')";

                                    int flag = statement.executeUpdate(queryString);

                                    request.setAttribute("SuccessMessage", "Payment Successful");
                                    String nextView = "success.jsp";
                                    RequestDispatcher view = request.getRequestDispatcher(nextView);
                                    view.forward(request, response);
                                } catch (Exception ex) {
                                    Logger.getLogger(Register2Servlet.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else {

                            }
                        }
                    }
                } else {
                    request.setAttribute("ErrorMessage", "Invalid pin");
                    String nextView = "error.jsp";
                    RequestDispatcher view = request.getRequestDispatcher(nextView);
                    view.forward(request, response);
                }

                request.setAttribute("ErrorMessage", "Invalid Biometrics");
                String nextView = "error.jsp";
                RequestDispatcher view = request.getRequestDispatcher(nextView);
                view.forward(request, response);
            } else {
                request.setAttribute("ErrorMessage", "Invalid Pin");
                String nextView = "error.jsp";
                RequestDispatcher view = request.getRequestDispatcher(nextView);
                view.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ValidateTransaction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidateTransaction.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
