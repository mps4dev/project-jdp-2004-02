package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericEntityRepository<T extends GenericEntity> extends JpaRepository<T, Long> { }
