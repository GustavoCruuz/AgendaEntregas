package com.Gustavo.AgendaEntregas.Controller.docs;

import com.Gustavo.AgendaEntregas.data.dto.EntregaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EntregaControllerDocs {
    @Operation(summary = "Create one deliverie", description = "Create one Deliverie", tags = {"Deliveries"}, responses = {@ApiResponse(description = "Succes", responseCode = "200", content = @Content(schema = @Schema(implementation = EntregaDTO.class))),
            @ApiResponse(description = "Succes", responseCode = "200", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = EntregaDTO.class)))}),
            @ApiResponse(description = "No content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)

    })
    EntregaDTO create(@RequestBody EntregaDTO entrega);

    @Operation(summary = "FindAll Deliveries", description = "Find all of the Deliveries", tags = {"Deliveries"}, responses = {
            @ApiResponse(description = "Succes", responseCode = "200", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = EntregaDTO.class)))}),
            @ApiResponse(description = "No content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)

    })
    List<EntregaDTO> findAll();

    @Operation(summary = "Find Deliveries by its id", description = "Find one Deliveries", tags = {"Deliveries"}, responses = {@ApiResponse(description = "Succes", responseCode = "200", content = @Content(schema = @Schema(implementation = EntregaDTO.class))),
            @ApiResponse(description = "Succes", responseCode = "200", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = EntregaDTO.class)))}),
            @ApiResponse(description = "No content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)

    })
    EntregaDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Update Deliverie", description = "Update a specific Deliverie", tags = {"Deliveries"}, responses = {@ApiResponse(description = "Succes", responseCode = "200", content = @Content(schema = @Schema(implementation = EntregaDTO.class))),
            @ApiResponse(description = "Succes", responseCode = "200", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = EntregaDTO.class)))}),
            @ApiResponse(description = "No content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)

    })
    EntregaDTO update(@PathVariable Long id, @RequestBody EntregaDTO entrega);

    @Operation(summary = "Delete Deliverie", description = "Delete one Deliverie", tags = {"Deliveries"}, responses = {@ApiResponse(description = "Succes", responseCode = "200", content = @Content(schema = @Schema(implementation = EntregaDTO.class))),
            @ApiResponse(description = "Succes", responseCode = "200", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = EntregaDTO.class)))}),
            @ApiResponse(description = "No content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)

    })
    ResponseEntity<?> delete(@PathVariable Long id);
}
