/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qge.portaria.api.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author denis.gibikoski
 */
@Data
@ToString
@Embeddable
class Pessoas {
    
    @NotNull
    @Size(min = 3, max = 50 ,message = "Obrigadorio Nome do Motorista e deve Conter entre 3 e 50")
    private String pessoa1;

    private String pessoa2;

    private String pessoa3;

    private String pessoa4;

    private String pessoa5;
    
}
