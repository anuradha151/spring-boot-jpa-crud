package com.anuradha.boot.crudapp.service;

import com.anuradha.boot.crudapp.dto.CustomerDTO;
import com.anuradha.boot.crudapp.entity.Customer;

import java.util.List;

public interface CustomerService {

    boolean saveCustomer(CustomerDTO customerDTO) throws Exception;

    boolean updateCustomer(CustomerDTO customerDTO) throws Exception;

    boolean deleteCustomer(CustomerDTO customerDTO) throws Exception;

    CustomerDTO getCustomer(int id) throws Exception;

    List<CustomerDTO> getAllCustomers() throws Exception;
}
