package com.gustavocruz.DelAgenda.Services;

import com.gustavocruz.DelAgenda.model.Delivery;
import com.gustavocruz.DelAgenda.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeliveryService {

@Autowired
DeliveryRepository rep;


public Delivery create(Delivery del){
    return rep.save(del);
}

public Delivery findById(UUID id){
    return rep.findById(id).orElseThrow();
}

public List<Delivery> findAll(){
    return rep.findAll();
}

public Delivery update(UUID id, Delivery newDel){
    Delivery del = rep.findById(id).orElseThrow();
    del.setStatus(newDel.getStatus());
    del.setDate(newDel.getDate());
    del.setItems(newDel.getItems());
    del.setAddress(newDel.getAddress());
    del.setClient_number(newDel.getClient_number());
    del.setClient_name(newDel.getClient_name());
    return rep.save(del);
}

public void delete(UUID id){
    rep.deleteById(id);
}




}
