package com.Gustavo.AgendaEntregas.unitetests.mapper;
import static com.Gustavo.AgendaEntregas.mapper.ObjectMapper.parseListObjects;
import static com.Gustavo.AgendaEntregas.mapper.ObjectMapper.parseObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import com.Gustavo.AgendaEntregas.Model.Entrega;
import com.Gustavo.AgendaEntregas.data.dto.EntregaDTO;
import com.Gustavo.AgendaEntregas.unitetests.mapper.mocks.MockEntrega;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ObjectMapperTests {
    MockEntrega inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockEntrega();
    }

    @Test
    public void parseEntityToDTOTest() {
        EntregaDTO output = parseObject(inputObject.mockEntity(), EntregaDTO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("nomeCliente0", output.getNomeCliente());
        assertEquals("Endereco0", output.getEndereco());
        assertEquals("Item0", output.getItems());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<EntregaDTO> outputList = parseListObjects(inputObject.mockEntityList(), EntregaDTO.class);
        EntregaDTO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("nomeCliente0", outputZero.getNomeCliente());
        assertEquals("Endereco0", outputZero.getEndereco());
        assertEquals("Item0", outputZero.getItems());

        EntregaDTO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("nomeCliente7", outputSeven.getNomeCliente());
        assertEquals("Endereco7", outputSeven.getEndereco());
        assertEquals("Item7", outputSeven.getItems());

        EntregaDTO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("nomeCliente12", outputTwelve.getNomeCliente());
        assertEquals("Endereco12", outputTwelve.getEndereco());
        assertEquals("Item12", outputTwelve.getItems());
    }

    @Test
    public void parseDTOToEntityTest() {
        Entrega output = parseObject(inputObject.mockDTO(), Entrega.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("nomeCliente0", output.getNomeCliente());
        assertEquals("Endereco0", output.getEndereco());
        assertEquals("Item0", output.getItems());

    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<Entrega> outputList = parseListObjects(inputObject.mockDTOList(), Entrega.class);
        Entrega outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("nomeCliente0", outputZero.getNomeCliente());
        assertEquals("Endereco0", outputZero.getEndereco());
        assertEquals("Item0", outputZero.getItems());

        Entrega outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("nomeCliente7", outputSeven.getNomeCliente());
        assertEquals("Endereco7", outputSeven.getEndereco());
        assertEquals("Item7", outputSeven.getItems());

        Entrega outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("nomeCliente12", outputTwelve.getNomeCliente());
        assertEquals("Endereco12", outputTwelve.getEndereco());
        assertEquals("Item12", outputTwelve.getItems());
    }
}