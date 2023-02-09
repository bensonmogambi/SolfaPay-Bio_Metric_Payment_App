/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDT.FingerPrint.cmu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
@WebServlet(name = "ProcessPaymentServlet", urlPatterns = {"/ProcessPaymentServlet"})
public class ProcessPaymentServlet extends HttpServlet {

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
            out.println("<title>Servlet ProcessPaymentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessPaymentServlet at " + request.getContextPath() + "</h1>");
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
        String tranNumber = request.getParameter("transactionNumber");
        String tranDate = request.getParameter("transactionDate");
        String vendorName = request.getParameter("vendorName");
        String content = request.getParameter("content");
        String total = request.getParameter("total");
        HashMap<String, String> map = new HashMap<String, String>();

        if (total.length() > 0) {
            total = total.trim().replaceAll("$", "");
        }
        String contents[]=null;
        if (content.length() > 0) {
            content = content.trim().replaceAll("<li>", "");
            contents = content.trim().split("</li>");
        }

        for (int i = 0; i < contents.length; i++) {
            String values[] = contents[i].trim().split(" x ");
            if (values.length >= 2) {
                map.put(values[0], values[1]);
            }
        }

        Order o = new Order(tranNumber, tranDate, vendorName, total, map);
        request.setAttribute("order", o);

        String nextView = "confirmOrder.jsp";
        RequestDispatcher view = request.getRequestDispatcher(nextView);
        view.forward(request, response);
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

//        String tranNumber = request.getParameter("transactionNumber");
//        String tranDate = request.getParameter("transactionDate");
//        String vendorName = request.getParameter("vendorName");
//        String content = request.getParameter("content");
//        String total = request.getParameter("total");
//        HashMap<String, String> map = new HashMap<String, String>();
//
//        total = total.trim().replaceAll("$", "");
//        content = content.trim().replaceAll("<li>", "");
//        String contents[] = content.trim().split("</li>");
//
//        for (int i = 0; i < contents.length; i++) {
//            String values[] = contents[i].trim().split(" x ");
//            if (values.length >= 2) {
//                map.put(values[0], values[1]);
//            }
//        }
//
//        Order o = new Order(tranNumber, tranDate, vendorName, total, map);
//        request.setAttribute("order", o);
//
//        String nextView = "confirmOrder.jsp";
//        RequestDispatcher view = request.getRequestDispatcher(nextView);
//        view.forward(request, response);
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
