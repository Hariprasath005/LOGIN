package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.modelL;

@Repository
public interface RepoL extends JpaRepository<modelL,String> 
{
    modelL findByuname(String uname);
}