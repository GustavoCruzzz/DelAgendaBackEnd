package com.gustavocruz.DelAgenda.Controllers;

import com.gustavocruz.DelAgenda.Services.DeliveryService;
import com.gustavocruz.DelAgenda.model.Delivery;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/Delivery")
public class DeliveryController {

@Autowired
DeliveryService service;

@PostMapping()
public Delivery create(@RequestBody Delivery del){
    return service.create(del);
}

@GetMapping(value = "/{id}")
public Delivery findById(@PathVariable(value = "id")UUID id){
    return service.findById(id);
}

@GetMapping
public List<Delivery> findAll(){
    return service.findAll();
}

@PutMapping(value = "/{id}")
public Delivery update(@PathVariable UUID id, @RequestBody Delivery del){
    return service.update(id, del);
}

@DeleteMapping(value = "/{id}")
public void delete(@PathVariable UUID id){
    service.delete(id);
}

}
