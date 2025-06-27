package com.gustavocruz.DelAgenda.service;

import com.gustavocruz.DelAgenda.model.Delivery;
import com.gustavocruz.DelAgenda.model.Item;
import com.gustavocruz.DelAgenda.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

@Autowired
DeliveryRepository repository;


public Delivery create(Delivery del){
    return repository.save(del);
}


public Optional<Delivery> findById(Long id){
    return repository.findById(id);
}


public List<Delivery> findAll(){
    return repository.findAll();
}



public Delivery update(Long id, Delivery nw){
   Delivery old = repository.findById(id).orElseThrow(() -> new RuntimeException("Vai toma no cu" + id));
   old.setClientName(nw.getClientName());
   old.setClientNumber(nw.getClientNumber());
   old.setAdress(nw.getAdress());
   old.setStatus(nw.isStatus());

   old.setItems(nw.getItems());
   return repository.save(old);


}


public void delete(Long id){
    repository.deleteById(id);
}

public List<?> catchItems(Long id){
    List<Item> i = repository.findById(id).get().getItems();
    return i;
}


public List<Item> updateItem(Long id, int index, Item item){
    repository.findById(id).get().getItems().get(index).setName(item.getName());
    repository.findById(id).get().getItems().get(index).setQuantity(item.getQuantity());
    repository.findById(id).get().getItems().get(index).setDelivered(item.isDelivered());
    return repository.findById(id).get().getItems();
}


public List<Item> deleteItem(Long id,int index){
    repository.findById(id).get().getItems().remove(index);
    return repository.findById(id).get().getItems();
}


public List<Item> checkItemAsDelivered(Long id, int index){
    repository.findById(id).get().getItems().get(index).setDelivered(true);
    return repository.findById(id).get().getItems();
}





}
