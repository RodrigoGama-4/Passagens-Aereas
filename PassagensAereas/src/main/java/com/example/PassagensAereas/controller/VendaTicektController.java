package com.example.PassagensAereas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PassagensAereas.model.Ticket;
import com.example.PassagensAereas.model.TicketDTO;
import com.example.PassagensAereas.repository.TicketRepository;

import org.springframework.transaction.annotation.Transactional;

@RestController
@RequestMapping("companhia")

public class VendaTicektController {
    @Autowired
    private TicketRepository ticketRepository;

    /*CRUD de tickets */
    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getTicket(){
        List<Ticket> tickets = this.ticketRepository.findAll();
        return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
    }

    @PostMapping("tickets")
    public Ticket saveTicket(@RequestBody TicketDTO ticketDTO){
        Ticket ticket = new Ticket(ticketDTO);
        return this.ticketRepository.save(ticket);
    }
    
    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@PathVariable Long id){
        Optional<Ticket> ticket = this.ticketRepository.findById(id);
        ticket.ifPresent(ticketDelete -> this.ticketRepository.delete(ticketDelete));
    }

    @Transactional
    @PutMapping("/tickets/{id}")
    public ResponseEntity<Ticket> putTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
        Optional<Ticket> ticketOptional = this.ticketRepository.findById(id);

        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            ticket.setDestino(ticketDTO.destino());
            ticket.setPassageiro(ticketDTO.idPassageiro());
            ticket.setDataSaida(ticketDTO.dataVoo());

            Ticket ticketAtualizado = this.ticketRepository.save(ticket);

            return new ResponseEntity<>(ticketAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
