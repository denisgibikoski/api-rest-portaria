/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qge.portaria.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author denis.gibikoski
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "controle")
public class Controle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime system;

    @NotNull(message = "Obrigadorio e deve ser neste formato  yyyy-MM-dd HH:mm")
    @Size(min = 10, max = 20 ,message = "Obrigadorio e deve ser neste formato  yyyy-MM-dd HH:mm")
    private String digitada;
    @NotNull
    @Size(min = 0, max = 1)
    private String status;

    @NotNull
    @Size(min = 3, max = 50 ,message = "Obrigadorio e deve Conter entre 3 e 50")
    private String veiculo;

    private String km;

    @NotNull
    private String placa;
    @NotNull
    @Size(min = 3, max = 50 ,message = "Obrigadorio e deve Conter entre 3 e 50")
    private String empresa;

    @NotNull
    @Size(min = 3, max = 50 ,message = "Obrigadorio 'Nome de quem Autorizou' e deve Conter entre 3 e 50")
    private String autorizacao;
    
    @Embedded
    @NotNull(message ="Obrigadorio deve ter uma pessoa" )
    private Pessoas pessoas;

    

}
