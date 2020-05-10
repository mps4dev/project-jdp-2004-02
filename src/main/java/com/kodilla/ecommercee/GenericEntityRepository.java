package com.kodilla.ecommercee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericEntityRepository<P extends GenericEntity> extends JpaRepository<GenericEntity, Long> { }
