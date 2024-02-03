package com.example.PassagensAereas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PassagensAereas.model.Passageiro;
import com.example.PassagensAereas.model.PassageiroDTO;
import com.example.PassagensAereas.repository.PassageiroRepository;

@RestController
@RequestMapping("companhia")
public class CadastroPassaController {
    @Autowired
    private PassageiroRepository passageiroRepository;

    /*CRUD de passageiros */
    @GetMapping("/passageiros")
    public ResponseEntity<List<Passageiro>> getPassageiros(){
        List<Passageiro> passageiro = this.passageiroRepository.findAll();
        return new ResponseEntity<List<Passageiro>>(passageiro, HttpStatus.OK);
    }

    @PostMapping("passageiros")
    public Passageiro savePassageiro(@RequestBody PassageiroDTO passageiroDTO){
        Passageiro passageiro = new Passageiro(passageiroDTO);
        return this.passageiroRepository.save(passageiro);
    }
    
    @DeleteMapping("/passageiro/{id}")
    public void deletePassageiro(@PathVariable Long id){
        Optional<Passageiro> passageiro = this.passageiroRepository.findById(id);
        passageiro.ifPresent(passageiroDelete -> this.passageiroRepository.delete(passageiroDelete));
    }

    @Transactional
    @PutMapping("/passageiro/{id}")
    public ResponseEntity<Passageiro> putPassageiro(@PathVariable Long id, @RequestBody PassageiroDTO passageiroDTO) {
        Optional<Passageiro> passageiroOptional = this.passageiroRepository.findById(id);

        if (passageiroOptional.isPresent()) {
            Passageiro passageiro = passageiroOptional.get();
            passageiro.setNacionalidade(passageiroDTO.nacionalidade());
            passageiro.setNome(passageiroDTO.nome());

            Passageiro passageiroAtualizado = this.passageiroRepository.save(passageiro);

            return new ResponseEntity<>(passageiroAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
