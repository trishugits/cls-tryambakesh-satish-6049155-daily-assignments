package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Myusers;

public interface MyusersRepo extends JpaRepository<Myusers, String> {

}
