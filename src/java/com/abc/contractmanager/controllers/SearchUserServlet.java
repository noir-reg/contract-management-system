/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.controllers;

import com.abc.contractmanager.dao.AdminDAO;
import com.abc.contractmanager.dao.ContractDAO;
import com.abc.contractmanager.dao.OwnerDAO;
import com.abc.contractmanager.dao.UserDAO;
import com.abc.contractmanager.dto.AdminDTO;
import com.abc.contractmanager.dto.OwnerDTO;
import com.abc.contractmanager.dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mical
 */
public class SearchUserServlet extends HttpServlet {

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
            char role = request.getParameter("role").charAt(0);
            String keyWord = request.getParameter("keyWord");
            request.setAttribute("role", role);
            request.setAttribute("keyWord", keyWord);
            ArrayList<Integer> countContractList = new ArrayList<>();
            switch (role) {
                case 'C':
                    ArrayList<UserDTO> customerList = UserDAO.getCustomerListByName(keyWord);
                    request.setAttribute("viewUserType", "C");
                    request.setAttribute("list", customerList);
                    break;
                case 'R':
                    ArrayList<UserDTO> residentList = UserDAO.getResidentListByName(keyWord);
                    for (UserDTO resident : residentList) {
                        countContractList.add(ContractDAO.countContract('R', resident.getUID()));
                    }
                    request.setAttribute("countContract", countContractList);
                    request.setAttribute("viewUserType", "R");
                    request.setAttribute("list", residentList);
                    break;
                case 'O':
                    ArrayList<OwnerDTO> ownerList = OwnerDAO.getOwnerListByName(keyWord);
                    for (OwnerDTO owner : ownerList) {
                        countContractList.add(ContractDAO.countContract('O', owner.getOID()));
                    }
                    request.setAttribute("countContract", countContractList);
                    request.setAttribute("viewUserType", "O");
                    request.setAttribute("list", ownerList);
                    break;
                case 'A':
                    ArrayList<AdminDTO> adminList = AdminDAO.getAdminListByName(keyWord);
                    request.setAttribute("list", adminList);
                    request.setAttribute("viewUserType", "A");
                    break;
            }
            
            
            request.getRequestDispatcher("ViewAllUser.jsp").forward(request, response);
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
