/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.room;

/**
 *
 * @author mical
 */
public class RoomDTO {
    private int RoID;
    private int CID;
    private int RID;
    private int OID;
    private int status;

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

    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
    }

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public RoomDTO() {
    }

    public RoomDTO(int RoID, int CID, int RID, int OID, int status) {
        this.RoID = RoID;
        this.CID = CID;
        this.RID = RID;
        this.OID = OID;
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoomDTO{" + "RoID=" + RoID + ", CID=" + CID + ", RID=" + RID + ", OID=" + OID + ", status=" + status + '}';
    }
    
    
}
