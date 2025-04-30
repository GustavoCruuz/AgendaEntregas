package com.Gustavo.AgendaEntregas.Service;

import com.Gustavo.AgendaEntregas.Controller.EntregaController;
import com.Gustavo.AgendaEntregas.Exception.ResourceNotFoundException;
import com.Gustavo.AgendaEntregas.Model.Entrega;
import com.Gustavo.AgendaEntregas.Repository.EntregaRepository;
import com.Gustavo.AgendaEntregas.data.dto.EntregaDTO;
import static com.Gustavo.AgendaEntregas.mapper.ObjectMapper.parseListObjects;
import static com.Gustavo.AgendaEntregas.mapper.ObjectMapper.parseObject;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {

@Autowired
private EntregaRepository repository;


public EntregaDTO create(EntregaDTO entrega){
    var entity = parseObject(entrega, Entrega.class);
    var dto =  parseObject(repository.save(entity), EntregaDTO.class);
    addHateoasLinks(dto);
    return dto;
}

public EntregaDTO findById(Long id){
  var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("entrega nao encontrada"));
  var dto = parseObject(entity, EntregaDTO.class);

    addHateoasLinks(dto);
    return dto;
}

public List<EntregaDTO> findAll(){
    var entregas =  parseListObjects(repository.findAll(), EntregaDTO.class);

    entregas.forEach(this::addHateoasLinks);
    return entregas;
}

public EntregaDTO update(Long id, EntregaDTO novaentrega){
  Entrega oldEntrega = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("entrega nao encontrada"));
  oldEntrega.setDataEntrega(novaentrega.getDataEntrega());
  oldEntrega.setEndereco(novaentrega.getEndereco());
  oldEntrega.setNomeCliente(novaentrega.getNomeCliente());
  oldEntrega.setNumeroCliente(novaentrega.getNumeroCliente());
  oldEntrega.setItems(novaentrega.getItems());
  var dto = parseObject(repository.save(oldEntrega), EntregaDTO.class);

    addHateoasLinks(dto);
    return dto;
}

public void delete(Long id){
    repository.deleteById(id);
}


    private void addHateoasLinks(EntregaDTO dto) {
        dto.add(linkTo(methodOn(EntregaController.class).create(dto)).withRel("create").withType("Post"));
        dto.add(linkTo(methodOn(EntregaController.class).findAll()).withRel("findAll").withType("Get"));
        dto.add(linkTo(methodOn(EntregaController.class).findById(dto.getId())).withSelfRel().withType("Get"));
        dto.add(linkTo(methodOn(EntregaController.class).update(dto.getId(), dto)).withRel("update").withType("Put"));
        dto.add(linkTo(methodOn(EntregaController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }

}
