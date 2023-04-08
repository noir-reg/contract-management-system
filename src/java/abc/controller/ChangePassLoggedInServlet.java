/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.controller;

import abc.customer.CustomerDAO;
import abc.customer.CustomerDTO;
import abc.error.ErrorDTO;
import abc.owner.OwnerDAO;
import abc.owner.OwnerDTO;
import abc.resident.ResidentDAO;
import abc.resident.ResidentDTO;
import abc.seller.SellerDAO;
import abc.seller.SellerDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mical
 */
public class ChangePassLoggedInServlet extends HttpServlet {

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
            String email = "";
            String txtpass = request.getParameter("txtPassword");
            String password = request.getParameter("oldPasstxt");
            String newPass = request.getParameter("newPasstxt");
            String confirm = request.getParameter("confirmPasstxt");
            char role = ((String) request.getSession().getAttribute("userType")).charAt(0);
            Object user = request.getSession().getAttribute("user");
            String url = "UserChangePassword.jsp";
            boolean fault = false;
            
//            out.print("<p>user.pass: "+txtpass+"</p>");
//            out.print("<p>input old pass: "+password+"</p>");
            
            if (!txtpass.equals(password)) {
                fault = true;
                request.setAttribute("noti", "Input old password is wrong!");
            } else if (newPass.trim().length() < 6 || newPass.trim().length() > 30) {
                fault = true;
                request.setAttribute("noti", "Requires 6-30 chars");
            } else if (!newPass.equals(confirm)) {
                fault = true;
                request.setAttribute("noti", "New password is not matched");
            }
            if (!fault) {
                switch (role) {
                    case 'C':
                        email = ((CustomerDTO) user).getEmail();
                        CustomerDAO.changePass(newPass, email);
                        request.setAttribute("noti", "Change password successfully!");
                        user = (CustomerDTO) request.getSession().getAttribute("user");
                        user = CustomerDAO.searchAccount(((CustomerDTO) request.getSession().getAttribute("user")).getCID());
                        break;
                    case 'O':
                        email = ((OwnerDTO) user).getEmail();
                        OwnerDAO.changePass(newPass, email);
                        request.setAttribute("noti", "Change password successfully!");
                        user = (OwnerDTO) request.getSession().getAttribute("user");
                        user = OwnerDAO.searchOwner(((OwnerDTO) request.getSession().getAttribute("user")).getOID());
                        break;
                    case 'R':
                        email = ((ResidentDTO) user).getEmail();
                        ResidentDAO.changePass(newPass, email);
                        request.setAttribute("noti", "Change password successfully!");
                        user = (ResidentDTO) request.getSession().getAttribute("user");
                        user = ResidentDAO.searchResident(((ResidentDTO) request.getSession().getAttribute("user")).getRID());
                        break;
                    case 'S':
                        email = ((SellerDTO) user).getEmail();
                        SellerDAO.changePass(newPass, email);
                        request.setAttribute("noti", "Change password successfully!");
                        user = (SellerDTO) request.getSession().getAttribute("user");
                        user = SellerDAO.searchSeller(((SellerDTO) request.getSession().getAttribute("user")).getSaID());
                        break;
                }
            }
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher(url).forward(request, response);
            
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
