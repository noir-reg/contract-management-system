/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.contract;

import java.sql.Date;

/**
 *
 * @author mical
 */
public class ContractDTO {

    private int CoID;
    private int RoID;
    private int CID;
    private String CName;
    private int RID;
    private String RName;
    private int OID;
    private String OName;
    private int SaID;
    private String Sname;
    private int check;
    private int fee;
    private int total;
    private Date createDate;
    private Date endDate;
    private int status;

    public ContractDTO() {
    }

    public ContractDTO(int CoID, int RoID, int CID, String CName, int RID, String RName, int OID, String OName, int SaID, String Sname, int check, int fee, int total, Date createDate, Date endDate, int status) {
        this.CoID = CoID;
        this.RoID = RoID;
        this.CID = CID;
        this.CName = CName;
        this.RID = RID;
        this.RName = RName;
        this.OID = OID;
        this.OName = OName;
        this.SaID = SaID;
        this.Sname = Sname;
        this.check = check;
        this.fee = fee;
        this.total = total;
        this.createDate = createDate;
        this.endDate = endDate;
        this.status = status;
    }

    
    public ContractDTO(int CoID, int RoID, int CID, String CName, int RID, String RName, int OID, String OName, int SaID, String Sname, int check, int fee, int total, Date createDate, Date endDate) {
        this.CoID = CoID;
        this.RoID = RoID;
        this.CID = CID;
        this.CName = CName;
        this.RID = RID;
        this.RName = RName;
        this.OID = OID;
        this.OName = OName;
        this.SaID = SaID;
        this.Sname = Sname;
        this.check = check;
        this.fee = fee;
        this.total = total;
        this.createDate = createDate;
        this.endDate = endDate;
    }
    ContractDTO(int CoID, String CName, String RName, String OName, String SName, int check, int fee, int total, Date createDate, Date endDate) {
         this.CoID=CoID;
         this.CName=CName;
         this.RName=RName;
         this.OName=OName;
         this.Sname=SName;
         this.check=check;
         this.fee=fee;
         this.total=total;
         this.createDate=createDate;
         this.endDate=endDate;
    }

    public int getCoID() {
        return CoID;
    }

    public void setCoID(int CoID) {
        this.CoID = CoID;
    }

    public int getRoID() {
        return RoID;
    }

    public void setRoID(int RoID) {
        this.RoID = RoID;
    }

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
    }

    public String getRName() {
        return RName;
    }

    public void setRName(String RName) {
        this.RName = RName;
    }

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    public String getOName() {
        return OName;
    }

    public void setOName(String OName) {
        this.OName = OName;
    }

    public int getSaID() {
        return SaID;
    }

    public void setSaID(int SaID) {
        this.SaID = SaID;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String Sname) {
        this.Sname = Sname;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ContractDTO{" + "CoID=" + CoID + ", RoID=" + RoID + ", CID=" + CID + ", CName=" + CName + ", RID=" + RID + ", RName=" + RName + ", OID=" + OID + ", OName=" + OName + ", SaID=" + SaID + ", Sname=" + Sname + ", check=" + check + ", fee=" + fee + ", total=" + total + ", createDate=" + createDate + ", endDate=" + endDate + ", status=" + status + '}';
    }
}