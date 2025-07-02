package com.gustavocruz.DelAgenda.Services;

import com.gustavocruz.DelAgenda.model.Delivery;
import com.gustavocruz.DelAgenda.model.Item;
import com.gustavocruz.DelAgenda.repositories.DeliveryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeliveryServiceTest {

    @InjectMocks
    private DeliveryService deliveryService;

    @Mock
    private DeliveryRepository deliveryRepository;

    private Delivery delivery;
    private List<Item> itemList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        itemList = List.of(
                new Item(UUID.randomUUID(), "Item 1", 2),
                new Item(UUID.randomUUID(), "Item 2", 5)
        );

        delivery = new Delivery();
        delivery.setId(UUID.randomUUID());
        delivery.setClient_name("Cliente A");
        delivery.setClient_number(123456L);
        delivery.setAddress("Rua Exemplo, 123");
        delivery.setStatus("PENDENTE");
        delivery.setDate(new Date());
        delivery.setItems(itemList);
    }

    @Test
    void testCreate() {
        when(deliveryRepository.save(delivery)).thenReturn(delivery);

        Delivery created = deliveryService.create(delivery);

        assertEquals(delivery, created);
        assertEquals(2, created.getItems().size());
        verify(deliveryRepository, times(1)).save(delivery);
    }

    @Test
    void testFindById() {
        UUID id = delivery.getId();
        when(deliveryRepository.findById(id)).thenReturn(Optional.of(delivery));

        Delivery found = deliveryService.findById(id);

        assertEquals(delivery, found);
        assertEquals("Cliente A", found.getClient_name());
        assertEquals(2, found.getItems().size());
        verify(deliveryRepository, times(1)).findById(id);
    }

    @Test
    void testFindById_NotFound() {
        UUID id = UUID.randomUUID();
        when(deliveryRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> deliveryService.findById(id));
    }

    @Test
    void testFindAll() {
        List<Delivery> deliveries = List.of(delivery);
        when(deliveryRepository.findAll()).thenReturn(deliveries);

        List<Delivery> result = deliveryService.findAll();

        assertEquals(deliveries, result);
        assertEquals(1, result.size());
        verify(deliveryRepository, times(1)).findAll();
    }

    @Test
    void testUpdate() {
        UUID id = delivery.getId();

        List<Item> updatedItems = List.of(
                new Item(UUID.randomUUID(), "Novo Item", 10)
        );

        Delivery newDelivery = new Delivery();
        newDelivery.setClient_name("Cliente B");
        newDelivery.setClient_number(654321L);
        newDelivery.setAddress("Nova Rua, 456");
        newDelivery.setStatus("ENTREGUE");
        newDelivery.setDate(new Date());
        newDelivery.setItems(updatedItems);

        when(deliveryRepository.findById(id)).thenReturn(Optional.of(delivery));
        when(deliveryRepository.save(any(Delivery.class))).thenReturn(delivery);

        Delivery updated = deliveryService.update(id, newDelivery);

        assertEquals("Cliente B", updated.getClient_name());
        assertEquals("ENTREGUE", updated.getStatus());
        assertEquals(1, updated.getItems().size());
        assertEquals("Novo Item", updated.getItems().get(0).getName());

        verify(deliveryRepository, times(1)).findById(id);
        verify(deliveryRepository, times(1)).save(delivery);
    }

    @Test
    void testDelete() {
        UUID id = delivery.getId();
        doNothing().when(deliveryRepository).deleteById(id);

        deliveryService.delete(id);

        verify(deliveryRepository, times(1)).deleteById(id);
    }
}
