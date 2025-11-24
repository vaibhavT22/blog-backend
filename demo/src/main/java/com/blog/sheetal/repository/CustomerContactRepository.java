package com.blog.sheetal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.sheetal.model.CustomerContact;

public interface CustomerContactRepository extends JpaRepository<CustomerContact, Long> {

}
