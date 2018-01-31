/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EE;

import SE.Sys;
import SE.User;
import Validation.Validation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author emad_
 */
@WebServlet(name = "Regist", urlPatterns = {"/Regist"})
public class Regist extends HttpServlet {

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
            String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
            System.out.println(gRecaptchaResponse);
            boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
            System.out.println("goooooooooogle " + verify);
            String Fname = request.getParameter("FN");
            String Lname = request.getParameter("LN");
            String Email = request.getParameter("EM");
            String Pass = request.getParameter("PA");
            System.out.println(Fname + "   " + Lname + "  " + Email + "  " + Pass);
            Validation V = Validation.Get_Validations();
            if (verify && V.Is_alpha(Fname) && V.Is_alpha(Lname) && V.Is_email(Email)) {
                HttpSession session = request.getSession();
                session.setAttribute("flag", 1);
                Sys S=Sys.GetSystem();
                User U=new User();
                U.setEmail(Email);
                U.setPassword(Pass);
                U.setFname(Fname);
                U.setLname(Lname);
                U.setType(2);
                U.setPhone("000");
                int ID=S.AddUser(U);
                session.setAttribute("Person_ID", ID);
                session.setAttribute("Person_Type", 2);
                session.setAttribute("Person", U);
                response.sendRedirect("home.jsp");
            }
            else
                                response.sendRedirect("index.jsp");

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
