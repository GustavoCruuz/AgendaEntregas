package com.Gustavo.AgendaEntregas.Service;

import com.Gustavo.AgendaEntregas.Exception.ResourceNotFoundException;
import com.Gustavo.AgendaEntregas.Model.Entrega;
import com.Gustavo.AgendaEntregas.Repository.EntregaRepository;
import com.Gustavo.AgendaEntregas.data.dto.EntregaDTO;
import static com.Gustavo.AgendaEntregas.mapper.ObjectMapper.parseListObjects;
import static com.Gustavo.AgendaEntregas.mapper.ObjectMapper.parseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {

@Autowired
private EntregaRepository repository;


public EntregaDTO create(EntregaDTO entrega){
    var entity = parseObject(entrega, Entrega.class);
    return parseObject(repository.save(entity), EntregaDTO.class);
}

public EntregaDTO findById(Long id){
  var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("entrega nao encontrada"));
  return parseObject(entity, EntregaDTO.class);
}

public List<EntregaDTO> findAll(){
    return  parseListObjects(repository.findAll(), EntregaDTO.class);
}

public EntregaDTO update(Long id, EntregaDTO novaentrega){
  Entrega oldEntrega = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("entrega nao encontrada"));
  oldEntrega.setDataEntrega(novaentrega.getDataEntrega());
  oldEntrega.setEndereco(novaentrega.getEndereco());
  oldEntrega.setNomeCliente(novaentrega.getNomeCliente());
  oldEntrega.setNumeroCliente(novaentrega.getNumeroCliente());
  oldEntrega.setItems(novaentrega.getItems());
  return parseObject(repository.save(oldEntrega), EntregaDTO.class);
}

public void delete(Long id){
    repository.deleteById(id);
}


}
