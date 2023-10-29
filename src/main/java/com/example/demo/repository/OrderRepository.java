package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Orderr;


public interface OrderRepository extends JpaRepository<Orderr, Long> {

}
