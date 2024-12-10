package com.example.dating_app.service;

import com.example.dating_app.model.Entity;

import java.util.List;

public interface EntityService {

    public String createEntity(Entity entity);
    public String updateEntity(Entity entity);
    public String deleteEntity(String name);
    public Entity getEntity(String name);
    public List<Entity> getAllEntities(); //to
}
