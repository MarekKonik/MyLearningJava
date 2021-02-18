package com.marekkonik.repository;

import com.marekkonik.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
