package com.Gustavo.AgendaEntregas.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Entrega")
@Getter
@Setter
public class Entrega implements Serializable {

    private static final long SerialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "nomeCliente", nullable = false, length = 80)
private String nomeCliente;

@Column(name = "numeroCliente", nullable = false)
private Long numeroCliente;

@Column(name = "endereco", nullable = false)
private String endereco;

@Column(name = "dataEntrega", nullable = false)
@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
private LocalDateTime dataEntrega;

@Column(name = "items", nullable = false)
private String items;

@Column(name = "finalizada", nullable = false)
private Boolean finalizada;


public Entrega() {
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Entrega entrega)) return false;
        return Objects.equals(getId(), entrega.getId()) && Objects.equals(getNomeCliente(), entrega.getNomeCliente()) && Objects.equals(getNumeroCliente(), entrega.getNumeroCliente()) && Objects.equals(getEndereco(), entrega.getEndereco()) && Objects.equals(getDataEntrega(), entrega.getDataEntrega()) && Objects.equals(getItems(), entrega.getItems()) && Objects.equals(getFinalizada(), entrega.getFinalizada());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNomeCliente(), getNumeroCliente(), getEndereco(), getDataEntrega(), getItems(), getFinalizada());
    }
}
