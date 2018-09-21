/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qge.portaria.api.resources;

import com.qge.portaria.api.model.Controle;
import com.qge.portaria.api.service.ControleService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author denis.gibikoski
 */
@CrossOrigin
@RestController
@RequestMapping("/controle")
public class ControleController {
    
    @Autowired
    private ControleService controleService;
    
   
    @GetMapping()
    public ResponseEntity<?> list() {
        
        return ResponseEntity.ok(this.controleService.getAll());
        
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<?> getStatus(@Valid @PathVariable String status) {
        
        return ResponseEntity.ok(this.controleService.getStatus(status));
    }
    @GetMapping("/datasystem")
    public ResponseEntity<?> getDataSystem(@Valid @RequestParam("data") String dataPes){
                
        return ResponseEntity.ok(this.controleService.getDataSystem(dataPes));
        
    } 

    /**
     *
     * @param dataStart
     * @param dataEnd
     * @return
     
    @GetMapping("/datasystem")
    public ResponseEntity<?> getDataEntreData(
            @Valid @RequestParam(value = "start", required = true) String dataStart,
            @Valid  @RequestParam(value = "end",required = false) String dataEnd){
                
        return ResponseEntity.ok(this.controleService.getDataEntreData(dataStart, dataEnd));  
    }
    * */
     @GetMapping("/empresa")
    public ResponseEntity<?> getEmpresa(@Valid @RequestParam("empresa") String empresa){
                
        return ResponseEntity.ok(this.controleService.getEmpresa(empresa));
        
    }
     @GetMapping("/veiculo")
    public ResponseEntity<?> getVeiculo(@Valid @RequestParam("nome") String nome){
                
        return ResponseEntity.ok(this.controleService.getVeiculo(nome));
        
    }
     @GetMapping("/autorizacao")
    public ResponseEntity<?> getAutorizacao(@Valid @RequestParam("nome") String nome){
                
        return ResponseEntity.ok(this.controleService.getAutorizacao(nome));
        
    }

    @GetMapping("/total")
    public ResponseEntity<?>  count() {
        return ResponseEntity.ok(this.controleService.quantidade());
    }
        
    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody Controle input) {
        this.controleService.save(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(input);
    }
        
}
