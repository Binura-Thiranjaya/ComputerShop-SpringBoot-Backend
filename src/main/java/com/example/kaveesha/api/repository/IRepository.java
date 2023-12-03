package com.example.kaveesha.api.repository;

import com.example.kaveesha.api.Entitiy.stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository extends JpaRepository<stock, Integer> {

}