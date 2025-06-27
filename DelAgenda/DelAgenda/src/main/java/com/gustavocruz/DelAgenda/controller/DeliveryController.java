package com.gustavocruz.DelAgenda.controller;

import com.gustavocruz.DelAgenda.model.Delivery;
import com.gustavocruz.DelAgenda.model.Item;
import com.gustavocruz.DelAgenda.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Delivery")
public class DeliveryController {

    @Autowired
    DeliveryService service;


    @PostMapping()
    public Delivery create(@RequestBody Delivery del){
        if (del.getItems() != null) {
            for (Item item : del.getItems()) {
                item.setDelivery(del);
            }
        }
        return service.create(del);
    }

    @GetMapping(value = "/{id}")
    public Optional<Delivery> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Delivery> findAll(){
        return service.findAll();
    }

    @PutMapping(value = "/{id}")
    public Delivery update(@PathVariable Long id, @RequestBody Delivery del){
        return service.update(id, del);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


    @PutMapping("/{id}/{index}")
    public List<Item> updateItem(@PathVariable Long id, @PathVariable int index, @RequestBody Item item){

        return service.updateItem(id, index, item);
    }

    @DeleteMapping("/{id}/{index}")
    public List<Item> deleteItem(@PathVariable Long id,@PathVariable int index){
        return service.deleteItem(id, index);
    }

    @PatchMapping("/{id}/{index}")
    public List<Item> checkItemAsDelivered(@PathVariable Long id,@PathVariable int index){
        return service.checkItemAsDelivered(id, index);
    }


}
