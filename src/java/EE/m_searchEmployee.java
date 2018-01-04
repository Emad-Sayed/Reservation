/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EE;

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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author emad
 */
@WebServlet(name = "m_searchEmployee", urlPatterns = {"/m_searchEmployee"})
public class m_searchEmployee extends HttpServlet {

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
            String BranchName = request.getParameter("BranchName");
            HttpSession session = request.getSession();
            Manager M = (Manager) session.getAttribute("Person");
            Sys S = Sys.GetSystem();  
            Employee E = M.SearchEmployee(S.GetEmployeeID(BranchName));
            JSONArray A = new JSONArray();
            JSONObject Ob = new JSONObject();
            if (E == null) {
                Ob.put("Flag", "false");
            } else {
                Ob.put("Flag", "true");
                Ob.put("Fname", E.getFname());
                Ob.put("Lname", E.getLname());
                Ob.put("Email", E.getEmail());
                Ob.put("Phone", E.getPhone());                
                Ob.put("Password", E.getPassword());
                Ob.put("Branch", S.GetBranchName(E.getBranchID()));

            }
            A.add(Ob);
            response.getWriter().write(A.toString());
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
