/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EE;

import SE.Sys;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 *
 * @author emad
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
@MultipartConfig(maxFileSize = 16999999)
public class NewServlet extends HttpServlet {

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

            Part filepart = request.getPart("photo");
            InputStream inputStream = null;
            if (filepart != null) {
                inputStream = filepart.getInputStream();
                File F = new File("");
                OutputStream os = new FileOutputStream(F);
                byte[] buf = new byte[1024];
                int len;

                while ((len = inputStream.read(buf)) > 0) {
                    os.write(buf, 0, len);
                }

                os.close();
                inputStream.close();

            }
            /*       boolean IsMultiPart=ServletFileUpload.isMultipartContent(request);
            if(IsMultiPart)
            {
                ServletFileUpload upload=new ServletFileUpload();
                try
                {
                    FileItemIterator itr=upload.getItemIterator(request);
                    while(itr.hasNext())
                    {
                        FileItemStream item=itr.next();
                        if(item.isFormField())
                        {
                            String fieldName=item.getFieldName();
                            InputStream is=item.openStream();
                            byte[]b=new byte[is.available()];
                            is.read(b);
                            String value=new String(b);
                        }
                        else
                        {
                            String path=getServletContext().getRealPath("/");
                            Sys S=new Sys();
                            if(S.FileUpload(path, item))
                                System.out.println("DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
                            else
                                System.out.println("BLALAAAAAAAAAAAAAAAAAAAAAAAAA");
                        }
                    }
                }
                catch(Exception E)
                {
                    
                }*/

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
