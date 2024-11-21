package com.KAYAN.KayanWeb.service;

import com.KAYAN.KayanWeb.model.CustomerDto;

import java.util.List;

public interface CustomerServiceInt {
    public CustomerDto findCustomerById(int id);
    public CustomerDto findByUsername(String UserName, String Password);

    public List<CustomerDto> findAllCustomers();
    public CustomerDto addCustomer(CustomerDto customer);
    public CustomerDto updateCustomer(CustomerDto customer);
    public CustomerDto patchUpdateCustomer(CustomerDto customer,Integer customerId);
    public void deleteCustomer(int id);
    public CustomerDto assignServiceToCustomer(CustomerDto customer,Integer serviceId);

}
