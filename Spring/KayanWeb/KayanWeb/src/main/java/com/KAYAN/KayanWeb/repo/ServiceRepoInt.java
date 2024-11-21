package com.KAYAN.KayanWeb.repo;

import com.KAYAN.KayanWeb.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepoInt extends JpaRepository<ServiceEntity,Integer> {
}
