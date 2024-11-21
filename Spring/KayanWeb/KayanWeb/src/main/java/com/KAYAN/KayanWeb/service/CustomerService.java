package com.KAYAN.KayanWeb.service;

import com.KAYAN.KayanWeb.entity.CustomerEntity;
import com.KAYAN.KayanWeb.entity.ServiceEntity;
import com.KAYAN.KayanWeb.model.CustomerDto;
import com.KAYAN.KayanWeb.repo.CustomerRepoInt;
import com.KAYAN.KayanWeb.repo.ServiceRepoInt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements CustomerServiceInt {
    private final CustomerRepoInt customerRepoInt;
    private final ServiceRepoInt serviceRepoInt;
    private final ModelMapper modelMapper = new ModelMapper();
    CustomerService(CustomerRepoInt customerRepoInt, ServiceRepoInt serviceRepoInt) {
        this.customerRepoInt = customerRepoInt;
        this.serviceRepoInt = serviceRepoInt;

    }


    @Override
    public CustomerDto findCustomerById(int id) {

        return modelMapper.map(customerRepoInt.findById(id), CustomerDto.class);
    }

    @Override
    public CustomerDto findByUsername(String UserName, String Password) {
        return modelMapper.map(customerRepoInt.findByUsername(UserName), CustomerDto.class);
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        List<CustomerEntity> customerEntities = customerRepoInt.findAll();
        List<CustomerDto> customerDtos = customerEntities.stream().map(customerEntity -> modelMapper.map(customerEntity,CustomerDto.class)).collect(Collectors.toList());
        return customerDtos;
    }

    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
        CustomerEntity savedCustomerEntity = customerRepoInt.save(customerEntity);
        return modelMapper.map(savedCustomerEntity, CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customer) {

        CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
        CustomerEntity savedCustomerEntity = customerRepoInt.save(customerEntity);
        return modelMapper.map(savedCustomerEntity, CustomerDto.class);
    }

    @Override
    public CustomerDto patchUpdateCustomer(CustomerDto customerDto,Integer customerId) {
        CustomerEntity customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
        CustomerEntity oldCustomer = customerRepoInt.findById(customerId).get();
        if(customerEntity != null) {

            if(customerEntity.getName()!=null)
                oldCustomer.setName(customerEntity.getName());

            if(customerEntity.getUsername()!=null)
                oldCustomer.setUsername(customerEntity.getUsername());

            if(customerEntity.getPassword()!=null)
                oldCustomer.setPassword(customerEntity.getPassword());

            if(customerEntity.getPhone()!=null)
                oldCustomer.setPhone(customerEntity.getPhone());


        }
        CustomerEntity savedCustomerEntity = customerRepoInt.save(oldCustomer);
        return modelMapper.map(savedCustomerEntity, CustomerDto.class);
    }

    @Override
    public void deleteCustomer(int id) {
    customerRepoInt.deleteById(id);
    }

    @Override
    public CustomerDto assignServiceToCustomer(CustomerDto customer, Integer serviceId) {
        CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
        ServiceEntity serviceEntity = serviceRepoInt.findById(serviceId).get();
        customerEntity.setServiceEntity(serviceEntity);
        CustomerEntity savedCustomerEntity = customerRepoInt.save(customerEntity);
        return modelMapper.map(savedCustomerEntity, CustomerDto.class);
    }

}
