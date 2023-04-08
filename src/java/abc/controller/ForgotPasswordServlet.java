/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.controller;

import abc.admin.AdminDAO;
import abc.admin.AdminDTO;
import abc.boardmanager.BoardManagerDAO;
import abc.boardmanager.BoardManagerDTO;
import abc.customer.CustomerDAO;
import abc.customer.CustomerDTO;
import abc.owner.OwnerDAO;
import abc.owner.OwnerDTO;
import abc.resident.ResidentDAO;
import abc.resident.ResidentDTO;
import abc.seller.SellerDAO;
import abc.seller.SellerDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class ForgotPasswordServlet extends HttpServlet {

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
            String password = "";

             
            String url = "ForgotPassWord.jsp";
//            out.print("hi");
//            out.print("email: "+email);
//            out.print("password: "+ password);
//            CustomerDTO user = CustomerDAO.getAccount("khachhanga@gmail.com", "123");
//            out.print(user.toString());

            CustomerDTO customer = CustomerDAO.getAccount(email );
            OwnerDTO owner = OwnerDAO.getAccount(email );
            ResidentDTO resident = ResidentDAO.getAccount(email );
            SellerDTO seller = SellerDAO.getAccount(email );
            AdminDTO admin = AdminDAO.getAccount(email );
            BoardManagerDTO boardManager = BoardManagerDAO.getAccount(email);

            if (customer != null) {

                password = customer.getPassword();

            } else if (owner != null) {
                password = owner.getPassword();
            } else if (resident != null) {
                password = resident.getPassword();
            } else if (seller != null) {
                password = seller.getPassword();
            } else if (admin != null) {
                password = admin.getPassword();
            } else if (boardManager != null) {
                password = boardManager.getPassword();
            } else {
                request.setAttribute("notification", "Account is not found");
                request.getRequestDispatcher(url).forward(request, response);
            }
            //Get the session object
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");

            props.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("phuhungpham297@gmail.com", "aqlbpnrzkdygigov");//Put your email id and password here
                }
            });

//compose message
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress("phuhungpham297@gmail.com"));//change accordingly
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                message.setSubject("Forgot password");
                message.setText("Your password: " + password);

                //send message
                Transport.send(message);
                request.setAttribute("notification", "Please check your email");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
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
