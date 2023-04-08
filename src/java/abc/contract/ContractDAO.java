/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.contract;

import abc.utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mical
 */
public class ContractDAO {

    public static ArrayList<ContractDTO> getContracts(char userType, int id) {
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = abc.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "select Contract.[CoID],[RoID],Contract.[CID],[dbo].[Contract].[RID],[dbo].[Owner].[OID],[dbo].[Contract].[SID],[dbo].[Contract].[status],[fee],[total],[createDate],[endDate],\n"
                        + "[dbo].[Customer].[fullname] AS [CName], [dbo].[Owner].[fullname] AS [OName], [dbo].[Seller].[fullname] AS [SName], [dbo].[Resident].[fullname] AS [RName],[dbo].[Contract].[status]\n"
                        + "from Contract \n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[Customer] on [dbo].[Contract].CID = [dbo].[Customer].CID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n"
                        + "left join [dbo].[Seller] on [dbo].[Contract].[SID] = [dbo].[Seller].[SID]\n"
                        + "left join [dbo].[Resident] on [dbo].[Contract].[RID] = [dbo].[Resident].[RID]\n";

                if (userType == 'C') {
                    sql = sql + "where Contract.[CID]=?";
                }
                if (userType == 'O') {
                    sql = sql + "where Contract.[OID]=?";
                }
                if (userType == 'R') {
                    sql = sql + "where Contract.[RID]=?";
                }
                if (userType == 'S') {
                    sql = sql + "where Contract.[SID]=?";
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int CoID = rs.getInt("CoID");
                        int RoID = rs.getInt("RoID");
                        int CID = rs.getInt("CID");
                        String CName = "";
                        if (rs.wasNull()) {
                            CID = 0;
                        } else {
                            CName = rs.getString("CName");
                        }
                        int RID = rs.getInt("RID");
                        String RName = "";
                        if (rs.wasNull()) {
                            RID = 0;
                        } else {
                            RName = rs.getString("RName");
                        }
                        int OID = rs.getInt("OID");
                        String OName = rs.getString("OName");
                        int SID = rs.getInt("SID");
                        String SName = "";
                        if (rs.wasNull()) {
                            SID = 0;
                        } else {
                            SName = rs.getString("SName");
                        }
                        int check = rs.getInt("status");
                        int fee = rs.getInt("fee");
                        int total = rs.getInt("total");
                        Date createDate = rs.getDate("createDate");
                        Date endDate = rs.getDate("endDate");
                        int status = rs.getInt("status");
                        ContractDTO nw = new ContractDTO(CoID, RoID, CID, CName, RID, RName, OID, OName, SID, SName, check, fee, total, createDate, endDate, status);
                        result.add(nw);
                    }
                }
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }

        }
        return result;
    }

    public static ArrayList<ContractDTO> get2Contracts(char userType, int id) {
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = abc.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "select top 2 Contract.[CoID],[RoID],Contract.[CID],[dbo].[Contract].[RID],[dbo].[Owner].[OID],[dbo].[Contract].[SID],[dbo].[Contract].[status],[fee],[total],[createDate],[endDate],\n"
                        + "[dbo].[Customer].[fullname] AS [CName], [dbo].[Owner].[fullname] AS [OName], [dbo].[Seller].[fullname] AS [SName], [dbo].[Resident].[fullname] AS [RName]\n"
                        + "from Contract \n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[Customer] on [dbo].[Contract].CID = [dbo].[Customer].CID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n"
                        + "left join [dbo].[Seller] on [dbo].[Contract].[SID] = [dbo].[Seller].[SID]\n"
                        + "left join [dbo].[Resident] on [dbo].[Contract].[RID] = [dbo].[Resident].[RID]\n";

                if (userType == 'C') {
                    sql = sql + "where Contract.[CID]=?";
                }
                if (userType == 'O') {
                    sql = sql + "where Contract.[OID]=?";
                }
                if (userType == 'R') {
                    sql = sql + "where Contract.[RID]=?";
                }
                if (userType == 'S') {
                    sql = sql + "where Contract.[SID]=?";
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int CoID = rs.getInt("CoID");
                        int RoID = rs.getInt("RoID");
                        int CID = rs.getInt("CID");
                        String CName = "";
                        if (rs.wasNull()) {
                            CID = 0;
                        } else {
                            CName = rs.getString("CName");
                        }
                        int RID = rs.getInt("RID");
                        String RName = "";
                        if (rs.wasNull()) {
                            RID = 0;
                        } else {
                            RName = rs.getString("RName");
                        }
                        int OID = rs.getInt("OID");
                        String OName = rs.getString("OName");
                        int SID = rs.getInt("SID");
                        String SName = "";
                        if (rs.wasNull()) {
                            SID = 0;
                        } else {
                            SName = rs.getString("SName");
                        }
                        int check = rs.getInt("status");
                        int fee = rs.getInt("fee");
                        int total = rs.getInt("total");
                        Date createDate = rs.getDate("createDate");
                        Date endDate = rs.getDate("endDate");
                        ContractDTO nw = new ContractDTO(CoID, RoID, CID, CName, RID, RName, OID, OName, SID, SName, check, fee, total, createDate, endDate);
                        result.add(nw);
                    }
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getCause();
        }
        return result;
    }

    public static ArrayList<ContractDTO> getContracts() {
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = abc.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "select Contract.[CoID],[RoID],Contract.[CID],[dbo].[Contract].[RID],[dbo].[Owner].[OID],[dbo].[Contract].[SID],[dbo].[Contract].[status],[fee],[total],[createDate],[endDate],\n"
                        + "[dbo].[Customer].[fullname] AS [CName], [dbo].[Owner].[fullname] AS [OName], [dbo].[Seller].[fullname] AS [SName], [dbo].[Resident].[fullname] AS [RName]\n"
                        + "from Contract \n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[Customer] on [dbo].[Contract].CID = [dbo].[Customer].CID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n"
                        + "left join [dbo].[Seller] on [dbo].[Contract].[SID] = [dbo].[Seller].[SID]\n"
                        + "left join [dbo].[Resident] on [dbo].[Contract].[RID] = [dbo].[Resident].[RID]\n";

                PreparedStatement pst = cn.prepareStatement(sql);

                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int CoID = rs.getInt("CoID");
                        String CName = rs.getString("CName");
                        String RName = rs.getString("RName");
                        String OName = rs.getString("OName");
                        String SName = rs.getString("SName");
                        int check = rs.getInt("status");
                        int fee = rs.getInt("fee");
                        int total = rs.getInt("total");
                        Date createDate = rs.getDate("createDate");
                        Date endDate = rs.getDate("endDate");
                        ContractDTO nw = new ContractDTO(CoID, CName, RName, OName, SName, check, fee, total, createDate, endDate);
                        result.add(nw);
                    }
                }
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }

        }
        return result;
    }

    public static ContractDTO getContractDetail(String id) {
        ContractDTO contract = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "select Contract.[CoID],[RoID],Contract.[CID],[dbo].[Contract].[RID],[dbo].[Owner].[OID],[dbo].[Contract].[SID],[dbo].[Contract].[status],[fee],[total],[createDate],[endDate],\n"
                    + "[dbo].[Customer].[fullname] AS [CName], [dbo].[Owner].[fullname] AS [OName], [dbo].[Seller].[fullname] AS [SName], [dbo].[Resident].[fullname] AS [RName]\n"
                    + "from Contract \n"
                    + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                    + "left join [dbo].[Customer] on [dbo].[Contract].CID = [dbo].[Customer].CID\n"
                    + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n"
                    + "left join [dbo].[Seller] on [dbo].[Contract].[SID] = [dbo].[Seller].[SID]\n"
                    + "left join [dbo].[Resident] on [dbo].[Contract].[RID] = [dbo].[Resident].[RID]\n where Contract.[CoID] = ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {

                int CoID = rs.getInt("CoID");
                String CName = rs.getString("CName");
                String RName = rs.getString("RName");
                String OName = rs.getString("OName");
                String SName = rs.getString("SName");
                int check = rs.getInt("status");
                int fee = rs.getInt("fee");
                int total = rs.getInt("total");
                Date createDate = rs.getDate("createDate");
                Date endDate = rs.getDate("endDate");
                contract = new ContractDTO(CoID, CName, RName, OName, SName, check, fee, total, createDate, endDate);

            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return contract;
    }

    public static int updateFee(int fee, int total, String id) {
        Connection cn = null;
        int rs = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update ContractInformation set fee=?,total=? where CoID=?";
                PreparedStatement pr = cn.prepareStatement(sql);
                pr.setInt(1, fee);
                pr.setInt(2, total);
                pr.setString(3, id);
                rs = pr.executeUpdate();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ArrayList<ContractDTO> searchContractByName(String name, char userType, int userID) {
        if (name == null) {
            name = "";
        }
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = abc.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "select Contract.[CoID],[RoID],Contract.[CID],[dbo].[Contract].[RID],[dbo].[Owner].[OID],[dbo].[Contract].[SID],[dbo].[Contract].[status],[fee],[total],[createDate],[endDate],\n"
                        + "[dbo].[Customer].[fullname] AS [CName], [dbo].[Owner].[fullname] AS [OName], [dbo].[Seller].[fullname] AS [SName], [dbo].[Resident].[fullname] AS [RName]\n"
                        + "from Contract \n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[Customer] on [dbo].[Contract].CID = [dbo].[Customer].CID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n"
                        + "left join [dbo].[Seller] on [dbo].[Contract].[SID] = [dbo].[Seller].[SID]\n"
                        + "left join [dbo].[Resident] on [dbo].[Contract].[RID] = [dbo].[Resident].[RID]\n";
                switch (userType) {
                    case 'C':
                        sql = sql + "where Contract.[CID]=? and \n"
                                + "(\n"
                                + "	dbo.Seller.fullname like ? or\n"
                                + "	dbo.Resident.fullname like ? or\n"
                                + "	dbo.Owner.fullname like ? \n"
                                + ")";
                        break;
                    case 'O':
                        sql = sql + "where Contract.[OID]=? and \n"
                                + "(\n"
                                + "	dbo.Seller.fullname like ? or\n"
                                + "	dbo.Resident.fullname like ? or\n"
                                + "	dbo.Customer.fullname like ?\n"
                                + ")";
                        break;
                    case 'R':
                        sql = sql + "where Contract.[RID]=? and \n"
                                + "(\n"
                                + "	dbo.Seller.fullname like ? or\n"
                                + "	dbo.Owner.fullname like ? or\n"
                                + "	dbo.Customer.fullname like ?\n"
                                + ")";
                        break;
                    case 'S':
                        sql = sql + "where Contract.[SID]=? and \n"
                                + "(\n"
                                + "	dbo.Resident.fullname like ? or\n"
                                + "	dbo.Owner.fullname like ? or\n"
                                + "	dbo.Customer.fullname like ?\n"
                                + ")";
                        break;
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                pst.setString(2, "%" + name + "%");
                pst.setString(3, "%" + name + "%");
                pst.setString(4, "%" + name + "%");
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int CoID = rs.getInt("CoID");
                        String CName = rs.getString("CName");
                        String RName = rs.getString("RName");
                        String OName = rs.getString("OName");
                        String SName = rs.getString("SName");
                        int check = rs.getInt("status");
                        int fee = rs.getInt("fee");
                        int total = rs.getInt("total");
                        Date createDate = rs.getDate("createDate");
                        Date endDate = rs.getDate("endDate");
                        ContractDTO nw = new ContractDTO(CoID, CName, RName, OName, SName, check, fee, total, createDate, endDate);
                        result.add(nw);
                    }
                }
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }
        }
        return result;
    }

    public static ArrayList<ContractDTO> searchContractByName(String name) {
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = abc.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "select Contract.[CoID],[RoID],Contract.[CID],[dbo].[Contract].[RID],[dbo].[Owner].[OID],[dbo].[Contract].[SID],[dbo].[Contract].[status],[fee],[total],[createDate],[endDate],\n"
                        + "[dbo].[Customer].[fullname] AS [CName], [dbo].[Owner].[fullname] AS [OName], [dbo].[Seller].[fullname] AS [SName], [dbo].[Resident].[fullname] AS [RName]\n"
                        + "from Contract \n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[Customer] on [dbo].[Contract].CID = [dbo].[Customer].CID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n"
                        + "left join [dbo].[Seller] on [dbo].[Contract].[SID] = [dbo].[Seller].[SID]\n"
                        + "left join [dbo].[Resident] on [dbo].[Contract].[RID] = [dbo].[Resident].[RID]\n"
                        + "where [dbo].[Customer].[fullname] like ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + name + "%");
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int CoID = rs.getInt("CoID");
                        String CName = rs.getString("CName");
                        String RName = rs.getString("RName");
                        String OName = rs.getString("OName");
                        String SName = rs.getString("SName");
                        int check = rs.getInt("status");
                        int fee = rs.getInt("fee");
                        int total = rs.getInt("total");
                        Date createDate = rs.getDate("createDate");
                        Date endDate = rs.getDate("endDate");
                        ContractDTO nw = new ContractDTO(CoID, CName, RName, OName, SName, check, fee, total, createDate, endDate);
                        result.add(nw);
                    }
                }
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }

        }
        return result;
    }

    public static ArrayList<ContractDTO> searchContract(Date from, Date to, String name, int userID, char userType) {
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        int type = 0;
        try {
            cn = abc.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "select Contract.[CoID],[RoID],Contract.[CID],[dbo].[Contract].[RID],[dbo].[Owner].[OID],[dbo].[Contract].[SID],[dbo].[Contract].[status],[fee],[total],[createDate],[endDate],\n"
                        + "[dbo].[Customer].[fullname] AS [CName], [dbo].[Owner].[fullname] AS [OName], [dbo].[Seller].[fullname] AS [SName], [dbo].[Resident].[fullname] AS [RName]\n"
                        + "from Contract \n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[Customer] on [dbo].[Contract].CID = [dbo].[Customer].CID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n"
                        + "left join [dbo].[Seller] on [dbo].[Contract].[SID] = [dbo].[Seller].[SID]\n"
                        + "left join [dbo].[Resident] on [dbo].[Contract].[RID] = [dbo].[Resident].[RID]\n";
                switch (userType) {
                    case 'C':
                        sql = sql + "where Contract.[CID]=?";
                        break;
                    case 'O':
                        sql = sql + "where Contract.[OID]=?";
                        break;
                    case 'R':
                        sql = sql + "where Contract.[RID]=?";
                        break;
                    case 'S':
                        sql = sql + "where Contract.[SID]=?";
                        break;
                }
                if (from != null) {
                    if (to != null) {
                        sql = sql + " and ([createDate]>=? or [endDate] <=?)";
                        type = 3;
                    } else {
                        sql = sql + " and ([createDate]>=?)";
                        type = 2;
                    }
                } else {
                    if (to != null) {
                        sql = sql + " and ([endDate] <=?)";
                        type = 1;
                    }
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                switch (type) {
                    case 3:
                        pst.setDate(2, from);
                        pst.setDate(3, to);
                        break;
                    case 2:
                        pst.setDate(2, from);
                        break;
                    case 1:
                        pst.setDate(2, to);
                        break;

                }
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int CoID = rs.getInt("CoID");
                        String CName = rs.getString("CName");
                        String RName = rs.getString("RName");
                        String OName = rs.getString("OName");
                        String SName = rs.getString("SName");
                        int check = rs.getInt("status");
                        int fee = rs.getInt("fee");
                        int total = rs.getInt("total");
                        Date createDate = rs.getDate("createDate");
                        Date endDate = rs.getDate("endDate");
                        ContractDTO nw = new ContractDTO(CoID, CName, RName, OName, SName, check, fee, total, createDate, endDate);
                        result.add(nw);
                    }
                }
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }

        }
        return result;
    }

    public static ArrayList<ContractDTO> searchContractFromDateToDate(Date from, Date to, int userID, char userType) {
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        int type = 0;
        try {
            cn = abc.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "select Contract.[CoID],[RoID],Contract.[CID],[dbo].[Contract].[RID],[dbo].[Owner].[OID],[dbo].[Contract].[SID],[dbo].[Contract].[status],[fee],[total],[createDate],[endDate],\n"
                        + "[dbo].[Customer].[fullname] AS [CName], [dbo].[Owner].[fullname] AS [OName], [dbo].[Seller].[fullname] AS [SName], [dbo].[Resident].[fullname] AS [RName]\n"
                        + "from Contract \n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[Customer] on [dbo].[Contract].CID = [dbo].[Customer].CID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n"
                        + "left join [dbo].[Seller] on [dbo].[Contract].[SID] = [dbo].[Seller].[SID]\n"
                        + "left join [dbo].[Resident] on [dbo].[Contract].[RID] = [dbo].[Resident].[RID]\n";
                switch (userType) {
                    case 'C':
                        sql = sql + "where Contract.[CID]=?";
                        break;
                    case 'O':
                        sql = sql + "where Contract.[OID]=?";
                        break;
                    case 'R':
                        sql = sql + "where Contract.[RID]=?";
                        break;
                    case 'S':
                        sql = sql + "where Contract.[SID]=?";
                        break;
                }
                if (from != null) {
                    if (to != null) {
                        sql = sql + " and ([createDate]>=? or [endDate] <=?)";
                        type = 3;
                    } else {
                        sql = sql + " and ([createDate]>=?)";
                        type = 2;
                    }
                } else {
                    if (to != null) {
                        sql = sql + " and ([endDate] <=?)";
                        type = 1;
                    }
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                switch (type) {
                    case 3:
                        pst.setDate(2, from);
                        pst.setDate(3, to);
                        break;
                    case 2:
                        pst.setDate(2, from);
                        break;
                    case 1:
                        pst.setDate(2, to);
                        break;

                }
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int CoID = rs.getInt("CoID");
                        String CName = rs.getString("CName");
                        String RName = rs.getString("RName");
                        String OName = rs.getString("OName");
                        String SName = rs.getString("SName");
                        int check = rs.getInt("status");
                        int fee = rs.getInt("fee");
                        int total = rs.getInt("total");
                        Date createDate = rs.getDate("createDate");
                        Date endDate = rs.getDate("endDate");
                        ContractDTO nw = new ContractDTO(CoID, CName, RName, OName, SName, check, fee, total, createDate, endDate);
                        result.add(nw);
                    }
                }
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }

        }
        return result;
    }

    public static ArrayList<ContractDTO> searchContractFromDate(Date from, char userType, int userID) {
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        int type = 0;
        try {
            cn = abc.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "select Contract.[CoID],[RoID],Contract.[CID],[dbo].[Contract].[RID],[dbo].[Owner].[OID],[dbo].[Contract].[SID],[dbo].[Contract].[status],[fee],[total],[createDate],[endDate],\n"
                        + "[dbo].[Customer].[fullname] AS [CName], [dbo].[Owner].[fullname] AS [OName], [dbo].[Seller].[fullname] AS [SName], [dbo].[Resident].[fullname] AS [RName]\n"
                        + "from Contract \n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[Customer] on [dbo].[Contract].CID = [dbo].[Customer].CID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n"
                        + "left join [dbo].[Seller] on [dbo].[Contract].[SID] = [dbo].[Seller].[SID]\n"
                        + "left join [dbo].[Resident] on [dbo].[Contract].[RID] = [dbo].[Resident].[RID]\n";
                switch (userType) {
                    case 'C':
                        sql = sql + "where Contract.[CID]=? ";
                        break;
                    case 'O':
                        sql = sql + "where Contract.[OID]=?";
                        break;
                    case 'R':
                        sql = sql + "where Contract.[RID]=?";
                        break;
                    case 'S':
                        sql = sql + "where Contract.[SID]=?";
                        break;
                }
                sql = sql + " and createDate <= ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, 1);
                pst.setDate(2, from);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int CoID = rs.getInt("CoID");
                        String CName = rs.getString("CName");
                        String RName = rs.getString("RName");
                        String OName = rs.getString("OName");
                        String SName = rs.getString("SName");
                        int check = rs.getInt("status");
                        int fee = rs.getInt("fee");
                        int total = rs.getInt("total");
                        Date createDate = rs.getDate("createDate");
                        Date endDate = rs.getDate("endDate");
                        ContractDTO nw = new ContractDTO(CoID, CName, RName, OName, SName, check, fee, total, createDate, endDate);
                        result.add(nw);
                    }
                }
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }

        }
        return result;
    }

    public static ArrayList<ContractDTO> searchContractToDate(Date to, char userType, int userID) {
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        int type = 0;
        try {
            cn = abc.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "select Contract.[CoID],[RoID],Contract.[CID],[dbo].[Contract].[RID],[dbo].[Owner].[OID],[dbo].[Contract].[SID],[dbo].[Contract].[status],[fee],[total],[createDate],[endDate],\n"
                        + "[dbo].[Customer].[fullname] AS [CName], [dbo].[Owner].[fullname] AS [OName], [dbo].[Seller].[fullname] AS [SName], [dbo].[Resident].[fullname] AS [RName]\n"
                        + "from Contract \n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[Customer] on [dbo].[Contract].CID = [dbo].[Customer].CID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n"
                        + "left join [dbo].[Seller] on [dbo].[Contract].[SID] = [dbo].[Seller].[SID]\n"
                        + "left join [dbo].[Resident] on [dbo].[Contract].[RID] = [dbo].[Resident].[RID]\n";
                switch (userType) {
                    case 'C':
                        sql = sql + "where Contract.[CID]=? ";
                        break;
                    case 'O':
                        sql = sql + "where Contract.[OID]=?";
                        break;
                    case 'R':
                        sql = sql + "where Contract.[RID]=?";
                        break;
                    case 'S':
                        sql = sql + "where Contract.[SID]=?";
                        break;
                }
                sql = sql + " and endDate >= ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, 1);
                pst.setDate(2, to);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int CoID = rs.getInt("CoID");
                        String CName = rs.getString("CName");
                        String RName = rs.getString("RName");
                        String OName = rs.getString("OName");
                        String SName = rs.getString("SName");
                        int check = rs.getInt("status");
                        int fee = rs.getInt("fee");
                        int total = rs.getInt("total");
                        Date createDate = rs.getDate("createDate");
                        Date endDate = rs.getDate("endDate");
                        ContractDTO nw = new ContractDTO(CoID, CName, RName, OName, SName, check, fee, total, createDate, endDate);
                        result.add(nw);
                    }
                }
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }

        }
        return result;
    }

    public static ArrayList<ContractDTO> searchContract(String name, Date from, Date to, int userID, char userType) {
        if (name == null) {
            name = "";
        }
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        int type = 0;
        try {
            cn = abc.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "select Contract.[CoID],[RoID],Contract.[CID],[dbo].[Contract].[RID],[dbo].[Owner].[OID],[dbo].[Contract].[SID],[dbo].[Contract].[status],[fee],[total],[createDate],[endDate],\n"
                        + "[dbo].[Customer].[fullname] AS [CName], [dbo].[Owner].[fullname] AS [OName], [dbo].[Seller].[fullname] AS [SName], [dbo].[Resident].[fullname] AS [RName]\n"
                        + "from Contract \n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[Customer] on [dbo].[Contract].CID = [dbo].[Customer].CID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n"
                        + "left join [dbo].[Seller] on [dbo].[Contract].[SID] = [dbo].[Seller].[SID]\n"
                        + "left join [dbo].[Resident] on [dbo].[Contract].[RID] = [dbo].[Resident].[RID]\n";
                switch (userType) {
                    case 'C':
                        sql = sql + "where Contract.[CID]=? and \n"
                                + "(\n"
                                + "	dbo.Seller.fullname like ? or\n"
                                + "	dbo.Resident.fullname like ? or\n"
                                + "	dbo.Owner.fullname like ? \n"
                                + ")";
                        break;
                    case 'O':
                        sql = sql + "where Contract.[OID]=? and \n"
                                + "(\n"
                                + "	dbo.Seller.fullname like ? or\n"
                                + "	dbo.Resident.fullname like ? or\n"
                                + "	dbo.Customer.fullname like ?\n"
                                + ")";
                        break;
                    case 'R':
                        sql = sql + "where Contract.[RID]=? and \n"
                                + "(\n"
                                + "	dbo.Seller.fullname like ? or\n"
                                + "	dbo.Owner.fullname like ? or\n"
                                + "	dbo.Customer.fullname like ?\n"
                                + ")";
                        break;
                    case 'S':
                        sql = sql + "where Contract.[SID]=? and \n"
                                + "(\n"
                                + "	dbo.Resident.fullname like ? or\n"
                                + "	dbo.Owner.fullname like ? or\n"
                                + "	dbo.Customer.fullname like ?\n"
                                + ")";
                        break;
                }
                if (from != null) {
                    if (to != null) {
                        sql = sql + " and ([createDate]>=? or [endDate] <=?)";
                        type = 3;
                    } else {
                        sql = sql + " and ([createDate]>=?)";
                        type = 2;
                    }
                } else {
                    if (to != null) {
                        sql = sql + " and ([endDate] <=?)";
                        type = 1;
                    }
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                pst.setString(2, "%" + name + "%");
                pst.setString(3, "%" + name + "%");
                pst.setString(4, "%" + name + "%");
                switch (type) {
                    case 3:
                        pst.setDate(5, from);
                        pst.setDate(6, to);
                        break;
                    case 2:
                        pst.setDate(5, from);
                        break;
                    case 1:
                        pst.setDate(5, to);
                        break;

                }
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int CoID = rs.getInt("CoID");
                        String CName = rs.getString("CName");
                        String RName = rs.getString("RName");
                        String OName = rs.getString("OName");
                        String SName = rs.getString("SName");
                        int check = rs.getInt("status");
                        int fee = rs.getInt("fee");
                        int total = rs.getInt("total");
                        Date createDate = rs.getDate("createDate");
                        Date endDate = rs.getDate("endDate");
                        ContractDTO nw = new ContractDTO(CoID, CName, RName, OName, SName, check, fee, total, createDate, endDate);
                        result.add(nw);
                    }
                }
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }

        }
        return result;
    }

    public static ArrayList<ContractDTO> searchContractByStatus(int status, int userID, char userType) {
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = abc.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "select Contract.[CoID],[RoID],Contract.[CID],[dbo].[Contract].[RID],[dbo].[Owner].[OID],[dbo].[Contract].[SID],[dbo].[Contract].[status],[fee],[total],[createDate],[endDate],\n"
                        + "[dbo].[Customer].[fullname] AS [CName], [dbo].[Owner].[fullname] AS [OName], [dbo].[Seller].[fullname] AS [SName], [dbo].[Resident].[fullname] AS [RName]\n"
                        + "from Contract \n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID]\n"
                        + "left join [dbo].[Customer] on [dbo].[Contract].CID = [dbo].[Customer].CID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n"
                        + "left join [dbo].[Seller] on [dbo].[Contract].[SID] = [dbo].[Seller].[SID]\n"
                        + "left join [dbo].[Resident] on [dbo].[Contract].[RID] = [dbo].[Resident].[RID]\n"
                        + "where [Contract].[status] = ? ";
                switch (userType) {
                    case 'C':
                        sql = sql + "and Contract.[CID]=?";
                        break;
                    case 'O':
                        sql = sql + "and Contract.[OID]=?";
                        break;
                    case 'R':
                        sql = sql + "and Contract.[RID]=?";
                        break;
                    case 'S':
                        sql = sql + "and Contract.[SID]=?";
                        break;
                }

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, status);
                pst.setInt(2, userID);

                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int CoID = rs.getInt("CoID");
                        String CName = rs.getString("CName");
                        String RName = rs.getString("RName");
                        String OName = rs.getString("OName");
                        String SName = rs.getString("SName");
                        int check = rs.getInt("status");
                        int fee = rs.getInt("fee");
                        int total = rs.getInt("total");
                        Date createDate = rs.getDate("createDate");
                        Date endDate = rs.getDate("endDate");
                        ContractDTO nw = new ContractDTO(CoID, CName, RName, OName, SName, check, fee, total, createDate, endDate);
                        result.add(nw);
                    }
                }
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }

        }
        return result;
    }

    public static ArrayList<ContractDTO> searchContract(String name, Date from, Date to, int userID, char userType, int Status) {
        if (name == null) {
            name = "";
        }
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        int type = 0;
        try {
            cn = abc.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "select Contract.[CoID],[RoID],Contract.[CID],[dbo].[Contract].[RID],[dbo].[Owner].[OID],[dbo].[Contract].[SID],[dbo].[Contract].[status],[fee],[total],[createDate],[endDate],\n"
                        + "[dbo].[Customer].[fullname] AS [CName], [dbo].[Owner].[fullname] AS [OName], [dbo].[Seller].[fullname] AS [SName], [dbo].[Resident].[fullname] AS [RName], [dbo].[Contract].[status]\n"
                        + "from Contract \n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[Customer] on [dbo].[Contract].CID = [dbo].[Customer].CID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n"
                        + "left join [dbo].[Seller] on [dbo].[Contract].[SID] = [dbo].[Seller].[SID]\n"
                        + "left join [dbo].[Resident] on [dbo].[Contract].[RID] = [dbo].[Resident].[RID]\n";
                switch (userType) {
                    case 'C':
                        sql = sql + "where Contract.[CID]=? and \n"
                                + "(\n"
                                + "	dbo.Seller.fullname like ? or\n"
                                + "	dbo.Resident.fullname like ? or\n"
                                + "	dbo.Owner.fullname like ? \n"
                                + ")";
                        break;
                    case 'O':
                        sql = sql + "where Contract.[OID]=? and \n"
                                + "(\n"
                                + "	dbo.Seller.fullname like ? or\n"
                                + "	dbo.Resident.fullname like ? or\n"
                                + "	dbo.Customer.fullname like ?\n"
                                + ")";
                        break;
                    case 'R':
                        sql = sql + "where Contract.[RID]=? and \n"
                                + "(\n"
                                + "	dbo.Seller.fullname like ? or\n"
                                + "	dbo.Owner.fullname like ? or\n"
                                + "	dbo.Customer.fullname like ?\n"
                                + ")";
                        break;
                    case 'S':
                        sql = sql + "where Contract.[SID]=? and \n"
                                + "(\n"
                                + "	dbo.Resident.fullname like ? or\n"
                                + "	dbo.Owner.fullname like ? or\n"
                                + "	dbo.Customer.fullname like ?\n"
                                + ")";
                        break;
                }
                if (from != null) {
                    if (to != null) {
                        sql = sql + " and ([createDate]>=? or [endDate] <=?)";
                        type = 3;
                    } else {
                        sql = sql + " and ([createDate]>=?)";
                        type = 2;
                    }
                } else {
                    if (to != null) {
                        sql = sql + " and ([endDate] <=?)";
                        type = 1;
                    }
                }
                if (Status != -1) {
                    sql = sql + " and [Contract].[status] = ?";
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                pst.setString(2, "%" + name + "%");
                pst.setString(3, "%" + name + "%");
                pst.setString(4, "%" + name + "%");
                switch (type) {
                    case 3:
                        pst.setDate(5, from);
                        pst.setDate(6, to);
                        if (Status != -1) {
                            pst.setInt(7, Status);
                        }
                        break;
                    case 2:
                        pst.setDate(5, from);
                        if (Status != -1) {
                            pst.setInt(6, Status);
                        }
                        break;
                    case 1:
                        pst.setDate(5, to);
                        if (Status != -1) {
                            pst.setInt(6, Status);
                        }
                        break;
                    case 0:
                        if (Status != -1){
                            pst.setInt(5, Status);
                        }
                }
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int CoID = rs.getInt("CoID");
                        int RoID = rs.getInt("RoID");
                        int CID = rs.getInt("CID");
                        String CName = "";
                        if (rs.wasNull()) {
                            CID = 0;
                        } else {
                            CName = rs.getString("CName");
                        }
                        int RID = rs.getInt("RID");
                        String RName = "";
                        if (rs.wasNull()) {
                            RID = 0;
                        } else {
                            RName = rs.getString("RName");
                        }
                        int OID = rs.getInt("OID");
                        String OName = rs.getString("OName");
                        int SID = rs.getInt("SID");
                        String SName = "";
                        if (rs.wasNull()) {
                            SID = 0;
                        } else {
                            SName = rs.getString("SName");
                        }
                        int check = rs.getInt("status");
                        int fee = rs.getInt("fee");
                        int total = rs.getInt("total");
                        Date createDate = rs.getDate("createDate");
                        Date endDate = rs.getDate("endDate");
                        int status = rs.getInt("status");
                        ContractDTO nw = new ContractDTO(CoID, RoID, CID, CName, RID, RName, OID, OName, SID, SName, check, fee, total, createDate, endDate, status);
                        result.add(nw);
                    }
                }
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String test = "";
        test = test + "hello";
        Date from = new Date(120, 1, 9);
        Date to = new Date(125, 10, 10);
        String nullString = null;
        ArrayList<ContractDTO> list = searchContract("A", from, to, 1, 'C');
        System.out.println(list.size());
        System.out.println(from.toString());
        list = searchContractFromDate(from, 'C', 1);
        System.out.println(list.size());
        list = searchContractToDate(to, 'C', 1);
        System.out.println(list.size());
        list = searchContractByStatus(0, 1, 'C');
        System.out.println("status = 1: list's size: " + list.size());
        list = searchContract("A", from, to, 1, 'C', 0);
        System.out.println("all: " + list.size());

        Date date3 = null;
        if (date3 == null) {
            System.out.println("null :D ?");
        }
        Date date1 = new Date(2023, 01, 01);
        Date date2 = new Date(2023, 02, 01);
        System.out.println(date3);
        System.out.println(date1.compareTo(date2));
    }
//DECLARE @date1 DATE, @date2 DATE;                               
//SET @date1='2023-02-10';
//SET @date2='2021-02-02';  
//select *
//from [dbo].[Contract] 
//left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID]
//left join [dbo].[Customer] on [dbo].[Contract].CID = [dbo].[Customer].CID
//left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]
//left join [dbo].[Seller] on [dbo].[Contract].[SID] = [dbo].[Seller].[SID]
//left join [dbo].[Resident] on [dbo].[Contract].[RID] = [dbo].[Resident].[RID]
//where [createDate]><=@date1
}
