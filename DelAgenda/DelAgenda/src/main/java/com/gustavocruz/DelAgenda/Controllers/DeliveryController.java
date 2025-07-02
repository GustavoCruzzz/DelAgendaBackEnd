package com.gustavocruz.DelAgenda.Controllers;

import com.gustavocruz.DelAgenda.Services.DeliveryService;
import com.gustavocruz.DelAgenda.model.Delivery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/Delivery")
@Tag(name = "Delivery", description = "Endpoints for managing Deliveries")
public class DeliveryController {

    @Autowired
    DeliveryService service;

    @PostMapping()
    @Operation(summary = "Create a Delivery", description = "Create a delivery in database", tags = {"Delivery"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content =
            @Content(schema = @Schema(implementation = Delivery.class))
            ),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
    })
    public Delivery create(@RequestBody Delivery del) {
        return service.create(del);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Find A Single Delivery", description = "Find a specific Delivery by your ID in database", tags = {"Delivery"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content =
                    @Content(schema = @Schema(implementation = Delivery.class))
            ),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
    })
    public Delivery findById(@PathVariable(value = "id") UUID id) {
        return service.findById(id);
    }

    @GetMapping
    @Operation(summary = "Find All Deliveries", description = "Find all Deliveries in database", tags = {"Delivery"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = Delivery.class))
                    )
            }),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),})
    public List<Delivery> findAll() {
        return service.findAll();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update a Delivery", description = "Update data of a delivery based on its ID", tags = {"Delivery"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content =
            @Content(schema = @Schema(implementation = Delivery.class))
            ),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
    })
    public Delivery update(@PathVariable UUID id, @RequestBody Delivery del) {
        return service.update(id, del);
    }

    @Operation(summary = "Delete a Delivery", description = "Delete a specific delivery from database based on its ID", tags = {"Delivery"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content =
            @Content(schema = @Schema(implementation = Delivery.class))
            ),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
    })
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

}
