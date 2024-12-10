package com.example.dating_app.controller;

import com.example.dating_app.model.Entity;
import com.example.dating_app.service.EntityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entity")
public class EntityController {

     @Autowired
    EntityService entityService;
    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    private static final List<Entity> users = new ArrayList<>();

    static {
        // Adding some dummy data to the list
        users.add(new Entity("user1", "female", 25, "Cricket, Chess"));
        users.add(new Entity("user2", "male", 27, "Cricket, Football, Movies"));
        users.add(new Entity("user3", "male", 26, "Movies, Tennis, Football, Cricket"));
        users.add(new Entity("user4", "female", 24, "Tennis, Football, Badminton"));
        users.add(new Entity("user5", "female", 32, "Cricket, Football, Movies, Badminton"));

    }


    @GetMapping("/{name}")
    public List<Entity> getEntitiesByNameWithGenderAndInterests(@PathVariable String name) {
        // Find the user by the provided name
        Entity user = users.stream()
                .filter(u -> u.getName().equalsIgnoreCase(name))  // Filter by name (case-insensitive)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("User not found"));  // Throw an exception if no user is found

        // Get the age, gender, and interests of the found user
        int ageToCompare = user.getAge();
        String oppositeGender = user.getGender().equalsIgnoreCase("male") ? "female" : "male";
        String[] userInterestsArray = user.getInterests().split(",\\s*");

        // Filter users whose age is less than the found user's age, opposite gender, and shares interests
        return users.stream()
                .filter(u -> oppositeGender.equals("male") ? u.getAge() > ageToCompare: u.getAge() < ageToCompare)  // Filter by age
                .filter(u -> u.getGender().equalsIgnoreCase(oppositeGender))  // Filter by opposite gender
                .filter(u -> Arrays.stream(userInterestsArray)  // Convert the string of interests to an array
                        .anyMatch(interest -> Arrays.asList(u.getInterests().split(",\\s*")).contains(interest)))  // Filter by shared interests
                .collect(Collectors.toList());  // Return the list of matching users
    }


    //    @GetMapping("{name}")
//    public Entity getEntityByName(@PathVariable String name) {
//        return users.get(name);
//    }
    @GetMapping()
    public List<Entity> getAllResources() {
        return entityService.getAllEntities();
    }
    @PostMapping
    public String createEntity(@RequestBody Entity entity) {
        entityService.createEntity(entity);
        return "Resource created successfully";
    }
    @PutMapping
    public String updateResource(@RequestBody Entity entity) {
        entityService.updateEntity(entity);
        return "Resource updated successfully";
    }
    @DeleteMapping("{name}")
    public String deleteResource(@PathVariable String name)
    {
        entityService.deleteEntity(name);
        return "Resource deleted successfully";
    }


    // This method will fetch a specific user by their name
//    @GetMapping("/{name}")
//    public Entity getEntityByName(@PathVariable String name) {
//        return users.stream()
//                .filter(user -> user.getName().equals(name))
//                .findFirst()
//                .orElse(null); // Return null if no user is found
//    }

    // This method will return all users
//    @GetMapping("/{age}")
//    public Entity getEntityByAge(@PathVariable int age) {
//        return users.stream()
//                .filter(user -> user.getAge() == age)
//                .findFirst()
//                .orElse(null); // Return null if no user is found
//    }
}
