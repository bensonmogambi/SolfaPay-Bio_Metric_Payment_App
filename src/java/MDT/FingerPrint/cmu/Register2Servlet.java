package MDT.FingerPrint.cmu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.neurotechnology.Library.NativeManager;
import static com.neurotechnology.Library.NativeManager.getWrapperLibraryInfo;
import com.neurotechnology.Nffv.Nffv;
import com.neurotechnology.Nffv.NffvStatus;
import com.neurotechnology.Nffv.NffvUser;
import com.neurotechnology.Nffv.ScannerModule;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import scanimagetest.ScanImageTest;

/**
 *
 * @author arjunmehrotra
 */
@WebServlet(urlPatterns = {"/Register2Servlet"})
public class Register2Servlet extends HttpServlet {

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
            out.println("<title>Servlet Register2Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register2Servlet at " + request.getContextPath() + "</h1>");
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
//        Scan s = new Scan();
//        s.scanSave();
//        String[] arr = new String[1];
//        try {
//            ScanImageTest.main(arr);
//        } catch (Exception ex) {
//            Logger.getLogger(Register2Servlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
        FingerCode fc = FingerCode.getInstace();
        String userName = request.getParameter("username");
        Connection conn = null;

//        Nffv engine;
        NffvUser curruser;
//        ScannerModule[] scanners = Nffv.getAvailableScannerModules();
//        ScannerModule[] scan = new ScannerModule[1];
//        for (int i = 0; i < scanners.length; i++) {
//            if (scanners[i].getName().equals("Futronic")) {
//                scan[0] = scanners[i];
//                break;
//            }
//        }
//        engine = new Nffv("Test", "test", scan);
        String pathToWeb = getServletContext().getRealPath(File.separator);
//        curruser = engine.enroll(TIMEOUT);
        curruser = fc.getEngine().enroll(TIMEOUT);
        String path;
        fc.getUsers().add(curruser);
        BufferedImage im;
        try {
            im = curruser.getNffvImage().getBufferedImage();
            path = pathToWeb + userName + ".png";
            File outputfile = new File(path);
            ImageIO.write(im, "png", outputfile);
        } catch (Exception ex) {
            Logger.getLogger(Register2Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";

            conn = DriverManager.getConnection(url, "CASTEEL", "tiger");

            Statement statement = conn.createStatement();

            String queryString = "select * from Customer where UserName ='" + userName + "'";
            ResultSet rs = statement.executeQuery(queryString);
            rs.next();
            Customer cust = new Customer();
            cust.setUsername(rs.getString("USERNAME"));
            cust.setPassword(rs.getString("PASSWORD"));
            cust.setFirstName(rs.getString("FIRSTNAME"));
            cust.setLastName(rs.getString("LASTNAME"));
            cust.setAddress(rs.getString("ADDRESS"));
            cust.setPhoneNumber(rs.getString("PHONENUMBER"));

            request.removeAttribute("customer");

            request.setAttribute("customer", cust);
            request.setAttribute("username", userName);
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0);
            
            String nextView = "fingerScan1.jsp";
            RequestDispatcher view = request.getRequestDispatcher(nextView);
            view.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register1Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Register1Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Register2Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Register1Servlet.class.getName()).log(Level.SEVERE, null, ex);
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
