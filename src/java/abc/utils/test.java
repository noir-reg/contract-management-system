/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.utils;

import abc.customer.CustomerDAO;
import abc.customer.CustomerDTO;
import abc.resident.ResidentDAO;
import abc.resident.ResidentDTO;

/**
 *
 * @author mical
 */
public class test {
    public static void main(String[] args) {
        ResidentDTO user = new ResidentDTO();
        user = ResidentDAO.searchResident(1);
        System.out.println(user.toString());
    }
}
