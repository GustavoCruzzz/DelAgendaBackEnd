package com.gustavocruz.DelAgenda.repository;

import com.gustavocruz.DelAgenda.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
