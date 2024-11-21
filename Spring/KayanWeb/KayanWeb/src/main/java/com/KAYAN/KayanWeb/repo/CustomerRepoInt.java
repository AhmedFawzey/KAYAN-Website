package com.KAYAN.KayanWeb.repo;

import com.KAYAN.KayanWeb.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepoInt extends JpaRepository<CustomerEntity,Integer> {

    CustomerEntity findByUsername( String username);
}
