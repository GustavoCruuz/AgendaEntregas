package com.Gustavo.AgendaEntregas.Controller;


import com.Gustavo.AgendaEntregas.Service.EntregaService;
import com.Gustavo.AgendaEntregas.data.dto.EntregaDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrega")
public class EntregaController {

@Autowired
private EntregaService service;

@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public EntregaDTO create(@RequestBody EntregaDTO entrega){
    return service.create(entrega);
}

@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public List<EntregaDTO> findAll(){
    return service.findAll();
}

@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public EntregaDTO findById(@PathVariable("id") Long id){
return service.findById(id);
}

@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public EntregaDTO update(@PathVariable Long id, @RequestBody EntregaDTO entrega){
    return service.update(id, entrega);
}

@DeleteMapping(value = "/{id}")
public void delete(@PathVariable Long id){
    service.delete(id);
}



}
