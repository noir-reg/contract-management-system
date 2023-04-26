/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.controllers;

import com.abc.contractmanager.dao.AdminDAO;
import com.abc.contractmanager.dao.BoardManagerDAO;
import com.abc.contractmanager.dao.OwnerDAO;
import com.abc.contractmanager.dao.UserDAO;
import com.abc.contractmanager.dto.AdminDTO;
import com.abc.contractmanager.dto.BoardManagerDTO;
import com.abc.contractmanager.dto.OwnerDTO;
import com.abc.contractmanager.dto.UserDTO;
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
public class LoginServlet extends HttpServlet {

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
            String password = request.getParameter("passwordtxt");
            HttpSession s = request.getSession();
            String url = "";
//            out.print("email: "+email);
//            out.print("<br/>password: "+ password);
//            CustomerDTO user = CustomerDAO.getAccount("khachhanga@gmail.com", "123");
//            out.print(user.toString());
            Object user = null;
            user = UserDAO.getUserByEmailAndPassword(email, password);
            if (user != null) {
                s.setAttribute("user", (UserDTO) user);
                s.setAttribute("userType", "U");
                url = "FindTwoContractsServlet";
            } else {
                user = OwnerDAO.getOwnerByEmailAndPassword(email, password);
                if (user != null) {
                    s.setAttribute("user", (OwnerDTO) user);
                    s.setAttribute("userType", "O");
                    url = "FindTwoContractsServlet";
                } else {
                    user = AdminDAO.getAccount(email, password);
                    if (user != null) {
                        s.setAttribute("user", (AdminDTO) user);
                        s.setAttribute("userType", "A");
                        url = "GetInfoServlet";
                    } else {
                        user = BoardManagerDAO.getAccount(email, password);
                        if (user != null) {
                            s.setAttribute("user", (BoardManagerDTO) user);
                            s.setAttribute("userType", "B");
                            url = "GetInfoServlet";
                        } else{
                            request.setAttribute("notification", "Account is not found");
                            url = "LoginIndex.jsp";
                        }
                    }
                }
            }
//            out.print("<br/> URL: "+ url);
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
