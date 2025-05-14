package com.Gustavo.AgendaEntregas.Controller;


import com.Gustavo.AgendaEntregas.Controller.docs.EntregaControllerDocs;
import com.Gustavo.AgendaEntregas.Service.EntregaService;
import com.Gustavo.AgendaEntregas.data.dto.EntregaDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/entrega")
@Tag(name = "Deliveries", description = "EndPoints for Managing Deliveries")
public class EntregaController implements EntregaControllerDocs {

@Autowired
private EntregaService service;

@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
@Override
public EntregaDTO create(@RequestBody EntregaDTO entrega){
    return service.create(entrega);
}

@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
@Override
public List<EntregaDTO> findAll(){
    return service.findAll();
}

@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
@Override
public EntregaDTO findById(@PathVariable("id") Long id){
return service.findById(id);
}

@PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
@Override
public EntregaDTO update(@PathVariable Long id, @RequestBody EntregaDTO entrega){
    return service.update(id, entrega);
}

@DeleteMapping(value = "/{id}")
@Override
public ResponseEntity<?> delete(@PathVariable Long id){
    service.delete(id);
    return ResponseEntity.noContent().build();
}



}
