package com.Gustavo.AgendaEntregas.unitetests.mapper.mocks;

import com.Gustavo.AgendaEntregas.Model.Entrega;
import com.Gustavo.AgendaEntregas.data.dto.EntregaDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class MockEntrega {


    public Entrega mockEntity() {
        return mockEntity(0);
    }
    
    public EntregaDTO mockDTO() {
        return mockDTO(0);
    }
    
    public List<Entrega> mockEntityList() {
        List<Entrega> Entregas = new ArrayList<Entrega>();
        for (int i = 0; i < 14; i++) {
            Entregas.add(mockEntity(i));
        }
        return Entregas;
    }

    public List<EntregaDTO> mockDTOList() {
        List<EntregaDTO> Entregas = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Entregas.add(mockDTO(i));
        }
        return Entregas;
    }
    
    public Entrega mockEntity(Integer number) {
        Entrega Entrega = new Entrega();
        Entrega.setItems("Item" + number);
        Entrega.setNomeCliente("nomeCliente" + number);
        Entrega.setId(number.longValue());
        Entrega.setNumeroCliente(number.longValue());
        Entrega.setDataEntrega(LocalDateTime.now());
        Entrega.setEndereco("Endereco" + number);
        return Entrega;
    }

    public EntregaDTO mockDTO(Integer number) {
        EntregaDTO entrega = new EntregaDTO();
        entrega.setItems("Item" + number);
        entrega.setNomeCliente("nomeCliente" + number);
        entrega.setId(number.longValue());
        entrega.setNumeroCliente(number.longValue());
        entrega.setDataEntrega(LocalDateTime.now());
        entrega.setEndereco("Endereco" + number);
        return entrega;
    }

}