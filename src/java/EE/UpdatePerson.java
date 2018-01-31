/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EE;

import SE.Manager;
import SE.Person;
import SE.Sys;
import Validation.Validation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
@WebServlet(name = "UpdatePerson", urlPatterns = {"/UpdatePerson"})
public class UpdatePerson extends HttpServlet {

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
            String FNAME=request.getParameter("FNAME");
            String LNAME=request.getParameter("LNAME");
            String PHONE=request.getParameter("PHONE");
            Validation V=Validation.Get_Validations();
            if(V.Is_alpha(FNAME)&&V.Is_alpha(LNAME)&&V.Is_digit(PHONE))
            {
            HttpSession session = request.getSession();
            Person P = (Person) session.getAttribute("Person");
            int PersonID=(int) session.getAttribute("Person_ID");
            HashMap<String,String>Data=new HashMap<>();
            Data.put("ID",PersonID+"");
            Data.put("FNAME", FNAME);
            Data.put("LNAME", LNAME);
            Data.put("PHONE", PHONE);
            P.setFname(FNAME);
            P.setLname(LNAME);
            P.setPhone(PHONE);
            P.UpdateProfile(Data);
            session.setAttribute("Person",P);
            response.getWriter().write("Information Modified");               
            }
            else
                            response.getWriter().write("Invalid information");               


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
