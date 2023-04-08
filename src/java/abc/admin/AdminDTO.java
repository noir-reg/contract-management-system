/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.admin;

/**
 *
 * @author mical
 */
public class AdminDTO {
    private int AID;
    private String email;   
    private String ACID;   
    private String password;
    private String fullName;
    private String phoneNumber;      
    private String avatar;      
    private String address;
    private int status;

    public AdminDTO() {
    }

    public AdminDTO(int AID) {
        this.AID = AID;
    }

    public AdminDTO(int AID, String fullName, int status) {
        this.AID = AID;
        this.fullName = fullName;
        this.status = status;
    }

    public AdminDTO(int AID, String email, String password, String fullName, String phoneNumber, String address, int status) {
        this.AID = AID;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
    }

    public AdminDTO(int AID, String email, String ACID, String password, String fullName, String phoneNumber, String avatar, String address, int status) {
        this.AID = AID;
        this.email = email;
        this.ACID = ACID;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.address = address;
        this.status = status;
    }

    public String getACID() {
        return ACID;
    }

    public void setACID(String ACID) {
        this.ACID = ACID;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "AdminDTO{" + "AID=" + AID + ", email=" + email + ", password=" + password + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", address=" + address + ", status=" + status + '}';
    }


    
}
