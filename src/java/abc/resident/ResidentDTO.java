 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.resident;

import java.sql.Date;

/**
 *
 * @author mical
 */
public class ResidentDTO {
    private int RID;
    private String email;
    private String RCID;
    private String password;
    private Date dateOfBirth;
    private String fullName;
    private String phoneNumber;
    private String avatar;
    
    private String address;
    private int status;

    public ResidentDTO(int RID, String email, String RCID, String password, Date dateOfBirth, String fullName, String phoneNumber, String avatar, String address, int status) {
        this.RID = RID;
        this.email = email;
        this.RCID = RCID;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.address = address;
        this.status = status;
    }

    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRCID() {
        return RCID;
    }

    public void setRCID(String RCID) {
        this.RCID = RCID;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public ResidentDTO() {
    }

    public ResidentDTO(int RID, String email, String RCID, String password, Date dateOfBirth, String fullName, String phoneNumber, String address, int status) {
        this.RID = RID;
        this.email = email;
        this.RCID = RCID;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
    }

    public ResidentDTO(int RID, String fullName, int status) {
        this.RID = RID;
        this.fullName = fullName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResidentDTO{" + "RID=" + RID + ", email=" + email + ", RCID=" + RCID + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", address=" + address + ", status=" + status + '}';
    }
}
 
