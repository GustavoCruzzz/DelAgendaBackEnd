package com.gustavocruz.DelAgenda.Controllers;

import com.gustavocruz.DelAgenda.Services.DeliveryService;
import com.gustavocruz.DelAgenda.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
