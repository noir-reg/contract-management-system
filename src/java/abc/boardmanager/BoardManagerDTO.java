/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.boardmanager;

/**
 *
 * @author mical
 */
public class BoardManagerDTO {

    private int BID;
    private String email;
    private String password;
    private String fullName;

    public BoardManagerDTO(int BID, String email, String password) {
        this.BID = BID;
        this.email = email;
        this.password = password;
    }

    public BoardManagerDTO() {
    }

    public BoardManagerDTO(int BID, String email, String password, String fullName) {
        this.BID = BID;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBID() {
        return BID;
    }

    public void setBID(int BID) {
        this.BID = BID;
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

    @Override
    public String toString() {
        return "BoardManagerDTO{" + "BID=" + BID + ", email=" + email + ", password=" + password + '}';
    }

}
