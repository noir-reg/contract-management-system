/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.admin;

import abc.admin.AdminDTO;
 
import abc.utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AdminDAO {

    public static AdminDTO getAccount(String email, String password) {
        AdminDTO admin = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Admin where email=? and password=? COLLATE SQL_Latin1_General_CP1_CS_AS and status=1";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                admin = new AdminDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
public static AdminDTO getAccount(String email) {
        AdminDTO admin = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Admin where email=? and status=1";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);
            
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                admin = new AdminDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
    public static ArrayList getAdminList() {
        ArrayList<AdminDTO> list = new ArrayList();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Admin order by AID desc";
            PreparedStatement pr = cn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {

                AdminDTO admin = new AdminDTO(rs.getInt(1), rs.getString(5), rs.getInt(9));
                list.add(admin);
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static ArrayList getAdminList(String keyWord) {
        ArrayList<AdminDTO> list = new ArrayList();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Admin where fullname like ?";

            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, "%" + keyWord + "%");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {

                AdminDTO admin = new AdminDTO(rs.getInt(1), rs.getString(5), rs.getInt(9));
                list.add(admin);
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

//    public static void main(String[] args) {
//        System.out.println(getAdminList());
//    }

    public static AdminDTO getAdminDetail(String id) {
        AdminDTO admin = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Admin where AID=?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {

                admin = new AdminDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));

            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }

    public static int updateAdmin(String id, String email, String cid, String password, String name, String phone, String address, int status) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "update Admin set email=?,ACID=?,password=?,fullname=?,phone=?,address1=?,status=? where AID=?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, cid);
            pr.setString(3, password);
            pr.setString(4, name);
            pr.setString(5, phone);
            pr.setString(6, address);
            pr.setInt(7, status);
            pr.setString(8, id);
            result = pr.executeUpdate();

            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int insertAdmin(String email, String password,String name, String cid) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "insert into  Admin(email,ACID,password,fullname,status) values(?,?,?,?,1)";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, cid);
            pr.setString(3, password);
            pr.setString(4, name);
             
            result = pr.executeUpdate();

            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
