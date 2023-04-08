/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.seller;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class SellerDTO {
    private int SaID;
    private String email;
    private String SCID;   
    private String password;
    private Date dateOfBirth;
    private String fullName;
    private String phoneNumber;
    private String avatar;
    private String address;
    private int status;

    public SellerDTO() {
    }

    public SellerDTO(int SaID, String email, String SCID, String password, Date dateOfBirth, String fullName, String phoneNumber, String avatar, String address, int status) {
        this.SaID = SaID;
        this.email = email;
        this.SCID = SCID;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.address = address;
        this.status = status;
    }

    public SellerDTO(int SaID, String fullName, int status) {
        this.SaID = SaID;
        this.fullName = fullName;
        this.status = status;
    }

    public SellerDTO(int SaID, String email, String SCID, String password, Date dateOfBirth, String fullName, String phoneNumber, String address, int status) {
        this.SaID = SaID;
        this.email = email;
        this.SCID = SCID;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getSaID() {
        return SaID;
    }

    public void setSaID(int SaID) {
        this.SaID = SaID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSCID() {
        return SCID;
    }

    public void setSCID(String SCID) {
        this.SCID = SCID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SellerDTO{" + "SaID=" + SaID + ", email=" + email + ", SCID=" + SCID + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", address=" + address + ", status=" + status + '}';
    }
    
}
