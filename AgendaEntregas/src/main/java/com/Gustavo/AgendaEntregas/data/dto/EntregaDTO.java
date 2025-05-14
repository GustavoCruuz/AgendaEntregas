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
private Boolean finalizada;

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

    public Boolean getFinalizada() {
        return finalizada;
    }

    public void setFinalizada(Boolean finalizada) {
        this.finalizada = finalizada;
    }

    public EntregaDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EntregaDTO that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNomeCliente(), that.getNomeCliente()) && Objects.equals(getNumeroCliente(), that.getNumeroCliente()) && Objects.equals(getEndereco(), that.getEndereco()) && Objects.equals(getDataEntrega(), that.getDataEntrega()) && Objects.equals(getItems(), that.getItems()) && Objects.equals(getFinalizada(), that.getFinalizada());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getNomeCliente(), getNumeroCliente(), getEndereco(), getDataEntrega(), getItems(), getFinalizada());
    }
}
