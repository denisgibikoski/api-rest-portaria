/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qge.portaria.api.repository;

import com.qge.portaria.api.model.Controle;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author denis.gibikoski
 */
public interface ControleRepository extends JpaRepository<Controle, Long> {

    List<Controle> findByStatus (String status);
    
    List<Controle> findByEmpresaIgnoreCaseContaining (String empresa);

    List<Controle> findByVeiculoIgnoreCaseContaining (String veiculo);
    
    List<Controle> findByAutorizacaoIgnoringCase (String autorizacao);
    
    /**
     *
     * @param pesquisa
     * 
     * Usar Formatazao "2018-08-31T12:30:54"
     * @return
     */
    List<Controle> findBySystemAfter(LocalDateTime pesquisa);
    
    /**
     *
     * @param start
     * @param end
     * 
     * ainda nao testado 
     * @return
     */
    List<Controle> findBySystemBetween(LocalDateTime start, LocalDateTime end);
    

    
    

}
