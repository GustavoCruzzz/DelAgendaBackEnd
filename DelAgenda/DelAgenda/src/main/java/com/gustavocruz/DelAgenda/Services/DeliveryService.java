package com.gustavocruz.DelAgenda.Services;

import com.gustavocruz.DelAgenda.model.Delivery;
import com.gustavocruz.DelAgenda.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

@Autowired
DeliveryRepository rep;


public Delivery create(Delivery del){
    return rep.save(del);
}


}
