package com.anuradha.boot.crudapp.service.impl;

import com.anuradha.boot.crudapp.dto.CustomerDTO;
import com.anuradha.boot.crudapp.entity.Customer;
import com.anuradha.boot.crudapp.repository.CustomerRepository;
import com.anuradha.boot.crudapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws Exception {
        return null != customerRepository.save(new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        /**
         *
         * You cannot call getCustomer and saveCustomer methods to complete this task.
         * Customer entity is not updating if you create a new instance of the entity.
         *
         */

        Optional<Customer> byId = customerRepository.findById(customerDTO.getId());
        /**
         * You should set name and address to the fetched object
         */
        if (byId.isPresent()) {
            Customer customer = byId.get();
            customer.setName(customerDTO.getName());
            customer.setAddress(customerDTO.getAddress());

            return null != customerRepository.save(customer);
        }
        return false;

    }

    @Override
    public boolean deleteCustomer(CustomerDTO customerDTO) throws Exception {
        Customer customer = customerRepository.findById(customerDTO.getId()).get();

        customerRepository.delete(customer);
        return true;
    }

    @Override
    public CustomerDTO getCustomer(int id) throws Exception {
        Optional<Customer> byId = customerRepository.findById(id);
        if (byId.isPresent()) {
            Customer customer = byId.get();

            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customerDTO.getId());
            customerDTO.setName(customer.getName());
            customerDTO.setAddress(customer.getAddress());

            return customerDTO;
        } else {
            return null;
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        List<Customer> all = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer :
                all) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customerDTO.getId());
            customerDTO.setName(customer.getName());
            customerDTO.setAddress(customer.getAddress());

            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }
}
