package MDT.FingerPrint.cmu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/ViewTransactionServlet"})
public class ViewTransactionServlet extends HttpServlet {

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
            out.println("<title>Servlet ViewTransactionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewTransactionServlet at " + request.getContextPath() + "</h1>");
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

        String userName = request.getParameter("username");
        Connection conn = null;
        ArrayList<Transaction> tran = new ArrayList<Transaction>();
        Customer cust = new Customer();
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "CASTEEL", "tiger");
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String queryString = "select * from Customer where UserName ='" + userName + "'";

            ResultSet rs = statement.executeQuery(queryString);

            // Point to the last row in resultset.
            rs.last();
            // Get the row position which is also the number of rows in the ResultSet.
            int rowcount = rs.getRow();

            if (rowcount == 1) {
                rs.beforeFirst();
                rs.next();
                cust.setUsername(rs.getString("USERNAME"));
                cust.setPassword(rs.getString("PASSWORD"));
                cust.setFirstName(rs.getString("FIRSTNAME"));
                cust.setLastName(rs.getString("LASTNAME"));
                cust.setAddress(rs.getString("ADDRESS"));
                cust.setPhoneNumber(rs.getString("PHONENUMBER"));
                rs.close();
                queryString = "SELECT * FROM transaction WHERE creditcardnumber IN (SELECT creditcardnumber FROM creditcard WHERE username='" + userName + "') ORDER BY transactiondate DESC";
                rs = statement.executeQuery(queryString);
                while (rs.next()) {
                    Transaction t = new Transaction();
                    t.setCreditCardNumber(rs.getString("CREDITCARDNUMBER"));
                    t.setTransactionNumber(rs.getString("TRANSACTIONNUMBER"));
                    t.setVendor(rs.getString("VENDORNAME"));
                    t.setTransactionDate(rs.getString("TRANSACTIONDATE"));
                    t.setTransactionAmount(rs.getString("TRANSACTIONAMOUNT"));
                    tran.add(t);
                }

                request.removeAttribute("customer");
                request.removeAttribute("transaction");

                request.setAttribute("transaction", tran);
                request.setAttribute("customer", cust);
                String nextView = "viewTransaction.jsp";
                RequestDispatcher view = request.getRequestDispatcher(nextView);
                view.forward(request, response);
            } else {
                request.setAttribute("transaction", tran);
                String nextView = "viewTransaction.jsp";
                RequestDispatcher view = request.getRequestDispatcher(nextView);
                view.forward(request, response);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewTransactionServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewTransactionServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ViewTransactionServlet.class.getName()).log(Level.SEVERE, null, ex);
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
