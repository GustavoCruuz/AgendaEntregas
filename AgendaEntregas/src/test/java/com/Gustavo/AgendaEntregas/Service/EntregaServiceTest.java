package com.Gustavo.AgendaEntregas.Service;

import com.Gustavo.AgendaEntregas.Exception.RequiredObjectIsNullException;
import com.Gustavo.AgendaEntregas.Model.Entrega;
import com.Gustavo.AgendaEntregas.Repository.EntregaRepository;
import com.Gustavo.AgendaEntregas.data.dto.EntregaDTO;
import com.Gustavo.AgendaEntregas.unitetests.mapper.mocks.MockEntrega;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class EntregaServiceTest {

    MockEntrega input;

    @InjectMocks
    private EntregaService service;

    @Mock
    EntregaRepository repository;

    @BeforeEach
    void setUp() {
        input = new MockEntrega();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
        Entrega entrega = input.mockEntity(1);
        Entrega persisted = entrega;
        persisted.setId(1L);

        EntregaDTO dto = input.mockDTO(1);
        when(repository.save(any(Entrega.class))).thenReturn(persisted);
        var result = service.create(dto);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self") && link.getHref().endsWith("/entrega/1") && link.getType().equals("GET")));
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll") && link.getHref().endsWith("/entrega") && link.getType().equals("GET")));
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create") && link.getHref().endsWith("/entrega") && link.getType().equals("POST")));
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update") && link.getHref().endsWith("/entrega/1") && link.getType().equals("PUT")));
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete") && link.getHref().endsWith("/entrega/1") && link.getType().equals("DELETE")));

        assertEquals("Endereco1", result.getEndereco());
        assertEquals("nomeCliente1", result.getNomeCliente());
        assertEquals("Item1", result.getItems());



    }

    @Test
    void findById() {
      Entrega entrega = input.mockEntity(1);
      entrega.setId(1L);
      when(repository.findById(1L)).thenReturn(Optional.of(entrega));
      var result = service.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self") && link.getHref().endsWith("/entrega/1") && link.getType().equals("GET")));
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll") && link.getHref().endsWith("/entrega") && link.getType().equals("GET")));
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create") && link.getHref().endsWith("/entrega") && link.getType().equals("POST")));
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update") && link.getHref().endsWith("/entrega/1") && link.getType().equals("PUT")));
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete") && link.getHref().endsWith("/entrega/1") && link.getType().equals("DELETE")));

        assertEquals("Endereco1", result.getEndereco());
        assertEquals("nomeCliente1", result.getNomeCliente());
        assertEquals("Item1", result.getItems());
    }

    @Test
    void findAll() {
        List<Entrega> list = input.mockEntityList();
        when(repository.findAll()).thenReturn(list);
        List<EntregaDTO> entregas = service.findAll();

        assertNotNull(entregas);
        assertEquals(14, entregas.size());

        var entregaOne = entregas.get(1);


        assertNotNull(entregaOne);
        assertNotNull(entregaOne.getId());
        assertNotNull(entregaOne.getLinks());
        assertNotNull(entregaOne.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self") && link.getHref().endsWith("/entrega/1") && link.getType().equals("GET")));
        assertNotNull(entregaOne.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll") && link.getHref().endsWith("/entrega") && link.getType().equals("GET")));
        assertNotNull(entregaOne.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create") && link.getHref().endsWith("/entrega") && link.getType().equals("POST")));
        assertNotNull(entregaOne.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update") && link.getHref().endsWith("/entrega/1") && link.getType().equals("PUT")));
        assertNotNull(entregaOne.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete") && link.getHref().endsWith("/entrega/1") && link.getType().equals("DELETE")));

        assertEquals("Endereco1", entregaOne.getEndereco());
        assertEquals("nomeCliente1", entregaOne.getNomeCliente());
        assertEquals("Item1", entregaOne.getItems());

        var entregafour = entregas.get(4);


        assertNotNull(entregafour);
        assertNotNull(entregafour.getId());
        assertNotNull(entregafour.getLinks());
        assertNotNull(entregafour.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self") && link.getHref().endsWith("/entrega/4") && link.getType().equals("GET")));
        assertNotNull(entregafour.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll") && link.getHref().endsWith("/entrega") && link.getType().equals("GET")));
        assertNotNull(entregafour.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create") && link.getHref().endsWith("/entrega") && link.getType().equals("POST")));
        assertNotNull(entregafour.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update") && link.getHref().endsWith("/entrega/4") && link.getType().equals("PUT")));
        assertNotNull(entregafour.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete") && link.getHref().endsWith("/entrega/4") && link.getType().equals("DELETE")));

        assertEquals("Endereco4", entregafour.getEndereco());
        assertEquals("nomeCliente4", entregafour.getNomeCliente());
        assertEquals("Item4", entregafour.getItems());

    }

    @Test
    void testeCreateWithNullEntrega(){
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {service.create(null);});
        String expectedMessage = "It is not allowed to persist a null object !!!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void update() {
        Entrega entrega = input.mockEntity(1);
        Entrega persisted = entrega;
        entrega.setId(1L);
        EntregaDTO dto = input.mockDTO(1);
        when(repository.findById(1L)).thenReturn(Optional.of(entrega));
        when(repository.save(entrega)).thenReturn(persisted);
        var result = service.update(dto.getId(), dto);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self") && link.getHref().endsWith("/entrega/1") && link.getType().equals("GET")));
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll") && link.getHref().endsWith("/entrega") && link.getType().equals("GET")));
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create") && link.getHref().endsWith("/entrega") && link.getType().equals("POST")));
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update") && link.getHref().endsWith("/entrega/1") && link.getType().equals("PUT")));
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete") && link.getHref().endsWith("/entrega/1") && link.getType().equals("DELETE")));

        assertEquals("Endereco1", result.getEndereco());
        assertEquals("nomeCliente1", result.getNomeCliente());
        assertEquals("Item1", result.getItems());


    }

    @Test
    void testeUpdateWithNullEntrega(){
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {service.update(1L, null);});
        String expectedMessage = "It is not allowed to persist a null object !!!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void delete() {
        Entrega entrega = input.mockEntity(1);
        entrega.setId(1L);
        service.delete(1L);
    }
}