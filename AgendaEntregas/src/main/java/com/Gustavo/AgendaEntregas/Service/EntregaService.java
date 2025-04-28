package com.Gustavo.AgendaEntregas.Service;

import com.Gustavo.AgendaEntregas.Exception.ResourceNotFoundException;
import com.Gustavo.AgendaEntregas.Model.Entrega;
import com.Gustavo.AgendaEntregas.Repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {

@Autowired
private EntregaRepository repository;


public Entrega create(Entrega entrega){
    return repository.save(entrega);
}

public Entrega findById(Long id){
   return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("entrega nao encontrada"));
}

public List<Entrega> findAll(){
    return  repository.findAll();
}

public Entrega update(Long id, Entrega novaentrega){
  Entrega oldEntrega = findById(id);
  oldEntrega.setDataEntrega(novaentrega.getDataEntrega());
  oldEntrega.setEndereco(novaentrega.getEndereco());
  oldEntrega.setNomeCliente(novaentrega.getNomeCliente());
  oldEntrega.setNumeroCliente(novaentrega.getNumeroCliente());
  return repository.save(oldEntrega);
}

public void delete(Long id){
    repository.deleteById(id);
}


}
