/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.controller;

import abc.customer.CustomerDTO;
import abc.owner.OwnerDTO;
import abc.resident.ResidentDTO;
import abc.seller.SellerDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mical
 */
public class ViewSelfProfileServlet extends HttpServlet {

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
            Object viewProfile = new Object();
            char userType = ((String) session.getAttribute("userType")).charAt(0);

//            viewProfile = (OwnerDTO) session.getAttribute("user");
            switch (userType) {
                case 'C':
                    viewProfile = (CustomerDTO) session.getAttribute("user");
                    if(null == request.getAttribute("txtFullName"))
                    request.setAttribute("txtFullName", ((CustomerDTO) viewProfile).getFullName());
                    if(null == request.getAttribute("txtcid"))
                    request.setAttribute("txtcid", ((CustomerDTO) viewProfile).getCCID());
                    if(null == request.getAttribute("txtDate"))
                    request.setAttribute("txtDate", ((CustomerDTO) viewProfile).getDateOfBirth());
                    if(null == request.getAttribute("address"))
                    request.setAttribute("address", ((CustomerDTO) viewProfile).getAddress());
                    request.setAttribute("profileType", "C");
                    break;
                case 'O':
                    viewProfile = (OwnerDTO) session.getAttribute("user");
                    if(null == request.getAttribute("txtFullName"))
                    request.setAttribute("txtFullName", ((OwnerDTO) viewProfile).getFullName());
                    if(null == request.getAttribute("txtcid"))
                    request.setAttribute("txtcid", ((OwnerDTO) viewProfile).getOCID());
                    if(null == request.getAttribute("txtDate"))
                    request.setAttribute("txtDate", ((OwnerDTO) viewProfile).getDateOfBirth());
                    if(null == request.getAttribute("address"))
                    request.setAttribute("address", ((OwnerDTO) viewProfile).getAddress());
                    request.setAttribute("profileType", "O");
                    break;
                case 'S':
                    viewProfile = (SellerDTO) session.getAttribute("user");
                    if(null == request.getAttribute("txtFullName"))
                    request.setAttribute("txtFullName", ((SellerDTO) viewProfile).getFullName());
                    if(null == request.getAttribute("txtcid"))
                    request.setAttribute("txtcid", ((SellerDTO) viewProfile).getSCID());
                    if(null == request.getAttribute("txtDate"))
                    request.setAttribute("txtDate", ((SellerDTO) viewProfile).getDateOfBirth());
                    if(null == request.getAttribute("address"))
                    request.setAttribute("address", ((SellerDTO) viewProfile).getAddress());
                    request.setAttribute("profileType", "S");
                    break;
                case 'R':
                    viewProfile = (ResidentDTO) session.getAttribute("user");
                    if(null == request.getAttribute("txtFullName"))
                    request.setAttribute("txtFullName", ((ResidentDTO) viewProfile).getFullName());
                    if(null == request.getAttribute("txtcid"))
                    request.setAttribute("txtcid", ((ResidentDTO) viewProfile).getRCID());
                    if(null == request.getAttribute("txtDate"))
                    request.setAttribute("txtDate", ((ResidentDTO) viewProfile).getDateOfBirth());
                    if(null == request.getAttribute("address"))
                    request.setAttribute("address", ((ResidentDTO) viewProfile).getAddress());
                    request.setAttribute("profileType", "R");
                    break;
                default:
                    out.print("Failed to get user type");
            }
            request.setAttribute("viewProfile", viewProfile);
            String edit = "true";
            request.setAttribute("edit", edit);
            request.getRequestDispatcher("ViewProfile.jsp").forward(request, response);
//            out.print(viewProfile.toString());

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
