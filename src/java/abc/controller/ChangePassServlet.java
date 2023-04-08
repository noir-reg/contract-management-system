/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.controller;

import abc.admin.AdminDAO;
import abc.admin.AdminDTO;
import abc.boardmanager.BoardManagerDAO;
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
 * @author Admin
 */
public class ChangePassServlet extends HttpServlet {

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
            String email = request.getParameter("emailtxt");
            String password = request.getParameter("oldPasstxt");
            String newPass = request.getParameter("newPasstxt");
            String confirm = request.getParameter("confirmPasstxt");
            String role = request.getParameter("role");
            String url = "ChangePassword.jsp";

            ErrorDTO err = new ErrorDTO();
            boolean fault = false;

            switch (role) {
                case "Customer":

                    CustomerDTO customer = CustomerDAO.getAccount(email, password);

                    if (customer != null) {

                        if (newPass.trim().length() < 6 || newPass.trim().length() > 30) {
                            fault = true;
                            err.setPasswordErr("Requires 6-30 chars");
                        }
                        if (!newPass.equals(confirm)) {
                            fault = true;
                            err.setConfirmErr("New password is not matched");
                        }
                        if (!fault) {
                            CustomerDAO.changePass(newPass, email);
                            request.setAttribute("successfully", "Successfully, click here to forward to login page");
                            request.getRequestDispatcher(url).forward(request, response);

                        } else {
                            request.setAttribute("err", err);
                            request.getRequestDispatcher(url).forward(request, response);
                        }

                    } else {
                        request.setAttribute("noti", "Account is not found");
                        request.getRequestDispatcher(url).forward(request, response);
                    }
                    break;
                case "Owner":
                    OwnerDTO owner = OwnerDAO.getAccount(email, password);

                    if (owner != null) {

                        if (newPass.trim().length() < 6 || newPass.trim().length() > 30) {
                            fault = true;
                            err.setPasswordErr("Requires 6-30 chars");
                        }
                        if (!newPass.equals(confirm)) {
                            fault = true;
                            err.setConfirmErr("New password is not matched");
                        }
                        if (!fault) {
                            OwnerDAO.changePass(newPass, email);
                            request.setAttribute("successfully", "Successfully, click here to forward to login page");
                            request.getRequestDispatcher(url).forward(request, response);

                        } else {
                            request.setAttribute("err", err);
                            request.getRequestDispatcher(url).forward(request, response);
                        }

                    } else {
                        request.setAttribute("noti", "Account is not found");
                        request.getRequestDispatcher(url).forward(request, response);
                    }
                    break;
                case "Resident":
                    ResidentDTO resident = ResidentDAO.getAccount(email, password);

                    if (resident != null) {

                        if (newPass.trim().length() < 6 || newPass.trim().length() > 30) {
                            fault = true;
                            err.setPasswordErr("Requires 6-30 chars");
                        }
                        if (!newPass.equals(confirm)) {
                            fault = true;
                            err.setConfirmErr("New password is not matched");
                        }
                        if (!fault) {
                            ResidentDAO.changePass(newPass, email);
                            request.setAttribute("successfully", "Successfully, click here to forward to login page");
                            request.getRequestDispatcher(url).forward(request, response);

                        } else {
                            request.setAttribute("err", err);
                            request.getRequestDispatcher(url).forward(request, response);
                        }

                    } else {
                        request.setAttribute("noti", "Account is not found");
                        request.getRequestDispatcher(url).forward(request, response);
                    }
                    break;
                case "Seller":
                    SellerDTO seller = SellerDAO.getAccount(email, password);

                    if (seller != null) {

                        if (newPass.trim().length() < 6 || newPass.trim().length() > 30) {
                            fault = true;
                            err.setPasswordErr("Requires 6-30 chars");
                        }
                        if (!newPass.equals(confirm)) {
                            fault = true;
                            err.setConfirmErr("New password is not matched");
                        }
                        if (!fault) {
                            SellerDAO.changePass(newPass, email);
                            request.setAttribute("successfully", "Successfully, click here to forward to login page");
                            request.getRequestDispatcher(url).forward(request, response);

                        } else {
                            request.setAttribute("err", err);
                            request.getRequestDispatcher(url).forward(request, response);
                        }

                    } else {
                        request.setAttribute("noti", "Account is not found");
                        request.getRequestDispatcher(url).forward(request, response);
                    }
                    break;

            }
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
