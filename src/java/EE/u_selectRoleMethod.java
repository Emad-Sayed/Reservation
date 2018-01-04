/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EE;

import SE.Branch;
import SE.Manager;
import SE.Sys;
import SE.User;
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
@WebServlet(name = "u_selectRoleMethod", urlPatterns = {"/u_selectRoleMethod"})
public class u_selectRoleMethod extends HttpServlet {

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
            HttpSession session = request.getSession();
            String Number = request.getParameter("Special");
            User U = (User) session.getAttribute("Person");
            Sys S = Sys.GetSystem();
            JSONArray A = new JSONArray();
            JSONObject Ob = new JSONObject();
            String My_Selection = (String) session.getAttribute("My_Selection");
            int CurrentNum = U.GetCurrentNumber(My_Selection); 
            System.out.println("aaaaaaaa"+Number);
            if (Number == null||Number.isEmpty()) 
            {
                int MyNumber = U.GetNumber(My_Selection);
                if (MyNumber != -1)
                {
                    Ob.put("Flag", "true");
                    Ob.put("My_Number", MyNumber);
                    Ob.put("Curr_Number", CurrentNum);
                    Ob.put("Fname", U.getFname());
                    Ob.put("Lname", U.getLname());
                    Ob.put("branch", My_Selection);
                } 
                else
                {
                    Ob.put("Flag", "false");
                    Ob.put("My_Number", "Branch Closed Now");
                    Ob.put("Curr_Number", "No One");
                    Ob.put("Fname", U.getFname());
                    Ob.put("Lname", U.getLname());
                    Ob.put("branch", My_Selection);
                }
            }
            else 
            {
                int Num=Integer.parseInt(Number);
                int Back=U.GetSpecificNumber(My_Selection, Num);
                if(Back!=-1&&Back!=-2)
                {
                    Ob.put("Flag", "true");
                    Ob.put("My_Number", Back);
                    Ob.put("Curr_Number", CurrentNum);
                    Ob.put("Fname", U.getFname());
                    Ob.put("Lname", U.getLname());
                    Ob.put("branch", My_Selection);
                }
                else if(Back==-1)
                {
                    Ob.put("Flag", "true");
                    Ob.put("My_Number", "Branch Closed Now");
                    Ob.put("Curr_Number", "No One");
                    Ob.put("Fname", U.getFname());
                    Ob.put("Lname", U.getLname());
                    Ob.put("branch", My_Selection);
                }
                else if(Back==-2)//Number Not Available
                {
                    Ob.put("Flag", "false");
                    Ob.put("My_Number", "Number Not Available");
                    Ob.put("Curr_Number", CurrentNum);
                    Ob.put("Fname", U.getFname());
                    Ob.put("Lname", U.getLname());
                    Ob.put("branch", My_Selection);
                }
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
