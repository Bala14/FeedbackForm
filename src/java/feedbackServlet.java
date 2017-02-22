/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BALA
 */
@WebServlet(urlPatterns = {"/feedbackServlet"})
public class feedbackServlet extends HttpServlet {

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
            out.println("<title>Servlet feedbackServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet feedbackServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        try{
            String name = request.getParameter("name");
            String reg = request.getParameter("regno");
            String course = request.getParameter("course");
            String dept = request.getParameter("dept");
            String year = request.getParameter("year");
            String email = request.getParameter("email");
            String date = request.getParameter("date");
            String topic = request.getParameter("topic");
            String teach = request.getParameter("teaching");
            String under = request.getParameter("understand");
            String feed = request.getParameter("feedback");
            String star = request.getParameter("star");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback?zeroDateTimeBehavior=convertToNull", "root", "1234");
            Statement stmt = con.createStatement();
            String sql = "insert into feedback (name,regno,course,department,yea,mail,dat,topic,standard,understand,feedback,ratings) values ('"+name+"','"+reg+"','"+course+"','"+dept+"','"+year+"','"+email+"','"+date+"','"+topic+"','"+teach+"','"+under+"','"+feed+"','"+star+"')";
            int row = stmt.executeUpdate(sql);
            RequestDispatcher rd = request.getRequestDispatcher("success.html");
            rd.forward(request, response);
            
        }catch(Exception e){
            e.printStackTrace();
        }
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
