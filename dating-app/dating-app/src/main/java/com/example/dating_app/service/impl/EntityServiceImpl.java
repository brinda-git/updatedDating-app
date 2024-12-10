package com.example.dating_app.service.impl;

import com.example.dating_app.model.Entity;
import com.example.dating_app.repository.EntityRepository;
import com.example.dating_app.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntityServiceImpl implements EntityService {



    EntityRepository entityRepository;

    public EntityServiceImpl(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }


    @Override
    public String createEntity(Entity entity) {
        Entity saved = entityRepository.save(entity);
        return "successfully created";
    }

    @Override
    public String updateEntity(Entity entity) {
        Entity updated = entityRepository.save(entity);
        return "Update success";
    }

    @Override
    public String deleteEntity(String name) {
        entityRepository.deleteById(name);
        return "Succeeded";
    }

    @Override
    public Entity getEntity(String name) {
        return entityRepository.findById(name).get();
    }

    @Override
    public List<Entity> getAllEntities() {
        return entityRepository.findAll();
    }
}
