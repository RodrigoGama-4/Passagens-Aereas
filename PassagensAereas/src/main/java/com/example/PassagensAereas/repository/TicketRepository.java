package com.example.PassagensAereas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PassagensAereas.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long>  {
    
}
