package com.gustavocruz.DelAgenda.repositories;

import com.gustavocruz.DelAgenda.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {
}
