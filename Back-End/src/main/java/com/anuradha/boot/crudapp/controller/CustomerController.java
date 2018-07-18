package com.anuradha.boot.crudapp.controller;

import com.anuradha.boot.crudapp.dto.CustomerDTO;
import com.anuradha.boot.crudapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "save")
    public boolean saveCustomer(@RequestBody CustomerDTO customerDTO) throws Exception {
        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping(value = "update")
    public boolean updateCustomer(@RequestBody CustomerDTO customerDTO) throws Exception {
        return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping(value = "delete")
    public boolean deleteCustomer(@RequestBody CustomerDTO customerDTO) throws Exception {
        return customerService.deleteCustomer(customerDTO);
    }

    @GetMapping( value = "get")
    public CustomerDTO getCustomer(@RequestParam int id) throws Exception {
        return customerService.getCustomer(id);
    }

    @GetMapping(value = "getAll")
    public List<CustomerDTO> getAllCustomers() throws Exception {
        return customerService.getAllCustomers();
    }
}
