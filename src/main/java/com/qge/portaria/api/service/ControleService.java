/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qge.portaria.api.service;

import com.qge.portaria.api.model.Controle;
import com.qge.portaria.api.repository.ControleRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author denis.gibikoski
 */
@Service
public class ControleService {

    @Autowired
    private ControleRepository controleRepository;

    public List<Controle> getAll() {

        return (List<Controle>) this.controleRepository.findAll();
    }

    public List<Controle> getDataSystem(String dataSystemEntrada) {

        LocalDateTime dataPesquisa = LocalDateTime.parse(dataSystemEntrada);

        return this.controleRepository.findBySystemAfter(dataPesquisa);
    }

    public List<Controle> getDataEntreData(String entrada, String saida) {

        LocalDateTime dataStart;
        LocalDateTime dataEnd;

        if (saida == null || "".equals(saida)) {
            dataEnd = LocalDateTime.now();
        } else {
            dataEnd = LocalDateTime.parse(saida);
        }

        if (entrada == null || "".equals(entrada)) {
            dataStart = LocalDateTime.now();
        } else {
            dataStart = LocalDateTime.parse(entrada);
        }

        return this.controleRepository.findBySystemBetween(dataStart, dataEnd);
    }

    public List<Controle> getEmpresa(String empresa) {

        return this.controleRepository.findByEmpresaIgnoreCaseContaining(empresa);

    }

    public List<Controle> getVeiculo(String nome) {
        return this.controleRepository.findByVeiculoIgnoreCaseContaining(nome);
    }

    public List<Controle> getAutorizacao(String nome) {
        return this.controleRepository.findByAutorizacaoIgnoringCase(nome);
    }

    public List<Controle> getStatus(String status) {

        return this.controleRepository.findByStatus(status);
    }

    public long quantidade() {

        return this.controleRepository.count();
    }

    public void save(Controle controle) {

        controle.setSystem(LocalDateTime.now());

        controleRepository.save(controle);

    }

}
