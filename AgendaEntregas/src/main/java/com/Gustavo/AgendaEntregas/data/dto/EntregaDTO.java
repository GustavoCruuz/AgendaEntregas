package com.Gustavo.AgendaEntregas.data.dto;



import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


public class EntregaDTO extends RepresentationModel<EntregaDTO> implements Serializable {

private static final long SerialVersionUID = 1L;


private Long id;
private String nomeCliente;
private Long numeroCliente;
private String endereco;
private LocalDateTime dataEntrega;
private String items;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Long getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(Long numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public EntregaDTO() {
    }

@Override
public boolean equals(Object o) {
        if (!(o instanceof EntregaDTO entrega)) return false;
        return Objects.equals(getId(), entrega.getId()) && Objects.equals(getNomeCliente(), entrega.getNomeCliente()) && Objects.equals(getNumeroCliente(), entrega.getNumeroCliente()) && Objects.equals(getEndereco(), entrega.getEndereco()) && Objects.equals(getDataEntrega(), entrega.getDataEntrega());
    }

@Override
public int hashCode() {
        return Objects.hash(getId(), getNomeCliente(), getNumeroCliente(), getEndereco(), getDataEntrega());
    }
}
