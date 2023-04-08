/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.customer;

import abc.contract.ContractDAO;
import abc.contract.ContractDTO;
import abc.resident.ResidentDAO;
import abc.resident.ResidentDTO;
import java.util.ArrayList;

/**
 *
 * @author mical
 */
public class test {
    public static void main(String[] args) {
        ResidentDTO test = ResidentDAO.getAccount("cudana@gmail.com", "123");
        System.out.println(test.toString());
        System.out.println(test.getAvatar());
        ArrayList<ContractDTO> list = ContractDAO.get2Contracts('R', 1);
        for (ContractDTO contractDTO : list) {
            System.out.println(contractDTO.toString());
        }
    }
}
