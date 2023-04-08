/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.controller;

import abc.customer.CustomerDAO;
import abc.customer.CustomerDTO;
import abc.owner.OwnerDAO;
import abc.owner.OwnerDTO;
import abc.resident.ResidentDAO;
import abc.resident.ResidentDTO;
import abc.seller.SellerDAO;
import abc.seller.SellerDTO;
import abc.utils.validation;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mical
 */
public class SaveProfileServlet extends HttpServlet {

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
            boolean ready = true;
            //date compare: 1 - lon hon; 0 - bang; -1 - nho hon

            String emailRegex = "[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+.+[a-zA-Z0-9.-]$";
            String fullName = request.getParameter("txtFullName");
            String CID = request.getParameter("txtcid");
            Date dateOfBirth = Date.valueOf(request.getParameter("txtDate"));
            String address = request.getParameter("txtAddress");

            request.setAttribute("txtFullName", fullName);
            request.setAttribute("txtcid", CID);
            request.setAttribute("txtDate", dateOfBirth);
            request.setAttribute("address", address);
            Object user = new Object();
            out.print((new Date(System.currentTimeMillis())).toString() + "<p>new</p>");
            out.print(dateOfBirth.toString() + ":" + (new Date(System.currentTimeMillis()).toString()) + "=> " + (new Date(System.currentTimeMillis())).compareTo(dateOfBirth));
            char userType = ((String) request.getSession().getAttribute("userType")).charAt(0);
            if (fullName.equals("")) {
                out.print("Name cannnot be null");
                request.setAttribute("nameError", "Name cannnot be null!");
                ready = false;
            }
            if (CID.equals("")) {
                out.print("CID cannot be null");
                request.setAttribute("CIDError", "CID cannot be null!");
                ready = false;
            }
            if (!validation.onlyNumber(CID)) {
                out.print("CID must be all number");
                request.setAttribute("CIDError", "CID must be all number");
                ready = false;
            }
            if (CID.length() != 12) {
                out.print("CID must be 12 length number");
                request.setAttribute("CIDError", "CID must be 12 length number");
                ready = false;
            }
            if (address.equals("")) {
                out.print("Addresscan not be null");
                request.setAttribute("addressError", "Addresscan not be null!");
                ready = false;
            }
            if ((new Date(System.currentTimeMillis())).compareTo(dateOfBirth) < 0) {
                out.print("Invalid date");
                request.setAttribute("DoBError", "Invalid date!");
                ready = false;
            }
            out.print(ready);
            if (ready) {
                switch (userType) {
                    case ('C'):
                        user = (CustomerDTO) request.getSession().getAttribute("user");
                        CustomerDAO.updateProfile(fullName, dateOfBirth, address, CID, ((CustomerDTO) user).getCID());
                        user = CustomerDAO.searchAccount(((CustomerDTO) request.getSession().getAttribute("user")).getCID());
                        break;
                    case ('S'):
                        user = (SellerDTO) request.getSession().getAttribute("user");
                        SellerDAO.updateProfile(fullName, dateOfBirth, address, CID, ((SellerDTO) user).getSaID());
                        user = SellerDAO.searchSeller(((SellerDTO) request.getSession().getAttribute("user")).getSaID());
                        break;
                    case ('R'):
                        user = (ResidentDTO) request.getSession().getAttribute("user");
                        ResidentDAO.updateProfile(fullName, dateOfBirth, address, CID, ((ResidentDTO) user).getRID());
                        user = ResidentDAO.searchResident(((ResidentDTO) request.getSession().getAttribute("user")).getRID());
                        break;
                    default:
                        user = (OwnerDTO) request.getSession().getAttribute("user");
                        OwnerDAO.updateProfile(fullName, dateOfBirth, address, CID, ((OwnerDTO) user).getOID());
                        user = OwnerDAO.searchOwner(((OwnerDTO) request.getSession().getAttribute("user")).getOID());
                        break;
                }
                request.setAttribute("noti", "Update profile success!");
                request.getSession().setAttribute("user", user);
            }
//            out.print("<p>"+user.toString()+"</p>");
//            CustomerDTO newuser = CustomerDAO.searchAccount(1);
//            out.print("<p>"+newuser.toString()+"</p>");
            request.getRequestDispatcher("ViewSelfProfileServlet").forward(request, response);
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
