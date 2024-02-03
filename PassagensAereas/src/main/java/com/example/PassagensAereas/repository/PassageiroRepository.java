package com.example.PassagensAereas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PassagensAereas.model.Passageiro;

public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {

    
} 
