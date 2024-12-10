package com.example.dating_app.repository;

import com.example.dating_app.model.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRepository extends JpaRepository<Entity, String> {
}
