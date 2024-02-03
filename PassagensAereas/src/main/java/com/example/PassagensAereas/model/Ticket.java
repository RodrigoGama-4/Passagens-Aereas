package com.example.PassagensAereas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue()
    @Column(name = "ticketId")
    private Long ticketId;

    @Column(name = "destino")
    private String destino;

    @Column(name = "dataSaida")
    private String dataSaida;

    @ManyToOne
    @JoinColumn(name = "passageiro_idfk", referencedColumnName = "passageiro_id")
    private Passageiro passageiro;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Ticket(TicketDTO ticketDTO){
        this.destino = ticketDTO.destino();
        this.dataSaida = ticketDTO.dataVoo();
        this.passageiro = ticketDTO.idPassageiro();
    }
    
}
