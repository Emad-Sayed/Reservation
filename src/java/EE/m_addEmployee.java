/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EE;

import SE.Branch;
import SE.Employee;
import SE.Manager;
import SE.Sys;
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
 * @author emad
 */
@WebServlet(name = "m_addEmployee", urlPatterns = {"/m_addEmployee"})
public class m_addEmployee extends HttpServlet {

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
            String Fname=request.getParameter("Fname");
            String Lname=request.getParameter("Lname");
            String Email=request.getParameter("Email");
            String Password=request.getParameter("Password");
            String SecretWord=request.getParameter("SecretWord");
            String Branch=request.getParameter("Branch");  
            String Phone=request.getParameter("Phone"); 
            System.out.println("111111111111"+Phone);
        Sys S=Sys.GetSystem();
            Employee E=new Employee();
            E.setBranchID(S.GetBranchID(Branch));
            E.setEmail(Email);
            E.setFname(Fname);
            E.setLname(Lname);
            E.setPhone(Phone);
            E.setPassword(Password);
            E.setSecretWord(SecretWord);
            HttpSession session = request.getSession();
            Manager M = (Manager) session.getAttribute("Person");
            int flag=M.AddEmploye(E);
            if(flag==-1)
            response.getWriter().write("Branch Already have Employee"); 
            else
            response.getWriter().write("Employee Added"); 
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
