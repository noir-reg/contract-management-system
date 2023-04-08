/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.seller;

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
public class SellerDAO {
    public static SellerDTO getAccount(String email, String password) {
        SellerDTO seller=null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Seller where email=? and password=? COLLATE SQL_Latin1_General_CP1_CS_AS and status=1";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                seller = new SellerDTO( rs.getInt(1),  rs.getString(2),  rs.getString(3),  rs.getString(4),  rs.getDate(5), rs.getString(6),  rs.getString(7), rs.getString(8), rs.getString(9),  rs.getInt(10));
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return seller;
    }
    public static SellerDTO getAccount(String email ) {
        SellerDTO seller=null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Seller where email=? and   status=1";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);
             
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                seller = new SellerDTO( rs.getInt(1),  rs.getString(2),  rs.getString(3),  rs.getString(4),  rs.getDate(5), rs.getString(6),  rs.getString(7),   rs.getString(9),  rs.getInt(10));
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return seller;
    }
    public static SellerDTO searchSeller(int SID) {
        SellerDTO seller=null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Seller where SID = ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, SID);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                seller = new SellerDTO(rs.getInt(1),  rs.getString(2),  rs.getString(3),  rs.getString(4),  rs.getDate(5), rs.getString(6),  rs.getString(7), rs.getString(8),   rs.getString(9),  rs.getInt(10));
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return seller;
    }
    
    public static int changePass(String newPass,String email) {
        int result = 0;

        try {
            Connection cn = DBUtils.getConnection();
            String sql = "update Seller set password=? where email=?";
            PreparedStatement pr = cn.prepareStatement(sql);
             
            pr.setString(1, newPass);
            pr.setString(2, email);
            result = pr.executeUpdate();

            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static int updateProfile(String name, Date dob, String address, String CID, int ID) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "update Seller set fullname=?, dateOfBirth=?, address1=?, SCID=? where SID=?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, name);
            pr.setDate(2, dob);
            pr.setString(3, address);
            pr.setString(4, CID);
            pr.setInt(5, ID);
            result = pr.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static void main(String[] args) {
        SellerDTO test = getAccount("moigioib@gmail.com", "123");
        System.out.println(test.toString());
    }
    public static ArrayList getSellerList() {
        ArrayList<SellerDTO> list = new ArrayList();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Seller";
            PreparedStatement pr = cn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {

                SellerDTO sel = new SellerDTO(rs.getInt(1),rs.getString(6),rs.getInt(10));
                list.add(sel);
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public static ArrayList getSellerList(String keyWord) {
        ArrayList<SellerDTO> list = new ArrayList();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Seller where fullname like ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1,"%"+keyWord+"%");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {

                SellerDTO sel = new SellerDTO(rs.getInt(1),rs.getString(6),rs.getInt(10));
                list.add(sel);
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public static SellerDTO getSellerDetail(String id) {
        SellerDTO sel = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Seller where SID=?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {

                sel = new SellerDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7),rs.getString(8), rs.getString(9), rs.getInt(10));

            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return sel;
    }

    public static int updateSeller(String id, String email, String cid, String password, String dob, String name, String phone,String avatar, String address, int status) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "update Seller set email=?,SCID=?,password=?,dateOfBirth=?,fullname=?,phone=?,avartar=?,address1=?,status=? where SID=?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, cid);
            pr.setString(3, password);
            pr.setString(4, dob);
            pr.setString(5, name);
            pr.setString(6, phone);
            pr.setString(7, avatar);
            pr.setString(8, address);
            pr.setInt(9, status);
            pr.setString(10, id);
            result = pr.executeUpdate();

            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static int insertSeller(String email, String password,String id, String phone,String avatar,String fullName,String dob, String address ) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "insert into  Seller(email,SCID,password,fullname,phone,dateOfBirth,avartar,address1,status) values(?,?,?,?,?,?,?,?,1)";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, id);
            pr.setString(3, password);
            pr.setString(4, fullName);
            pr.setString(5, phone);
            pr.setString(6, dob);
            pr.setString(7, avatar);
            pr.setString(8, address);
             
            result = pr.executeUpdate();

            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
