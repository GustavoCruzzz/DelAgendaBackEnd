package com.gustavocruz.DelAgenda.repositories;

import com.gustavocruz.DelAgenda.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
}
