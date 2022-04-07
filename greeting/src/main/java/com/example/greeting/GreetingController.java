package com.example.greeting;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static java.lang.Integer.parseInt;

@RestController
public class GreetingController {
    @Autowired
    GreetingRepository repository;
    //    below gives static data
//    private List<String> greetings = List.of("Hello", "Hola", "Bonjour");
//
//    Instead of refferring to an array list of greetings we want a greetign repo
//    private ArrayList<Greeting> greetings = new ArrayList<>();



//
//    @GetMapping("/welcome")
//    public String welcome() {
//        return "Hello World!";
//    }

    // Path Variables
    @GetMapping("/greeting/{id}")
    public Greeting getGreetingById(@PathVariable String id) {
//        return repository.findById(parseInt(id));
        for (Greeting greeting:repository.findAll()){

            try{
            if(greeting.getId() == parseInt(id)){
                return greeting;
            }} catch (NumberFormatException e){
                System.out.println("Invalid ID");
                return null;
            }
        }
        return null;
    }
//
//    // Request Parameters
////    Request Param goes into the string
//    @GetMapping("/greeting")
//    public String getGreeting(@RequestParam String name) {
//        return "Hello " + name;
//    }
//
//    // Returning a list
    @GetMapping("/greetings")
    public List<Greeting> getGreetings() {
        return repository.findAll();
    }
//
//    // Get a random greeting
    @GetMapping("/random")
    public Greeting getRandomGreeting() {
        List<Greeting> greetings = repository.findAll();
        Random random = new Random();
        int randomArrayIndex = random.nextInt(greetings.size());
        return greetings.get(randomArrayIndex);
    }
//
//    //    writing a post
////    we already have a get request at the same mapping addrress (endpoint).
////    Depending on the request type at the endpoint we will either use post or get
////    Same deal in JS when we do a fetch request
////    We can't just get parameter from url - we need to add @Request body - get from body of request
////    remember we're trying to post a Greeting object now, not a string!
////    In postman change the type of request body from text -> JSON
////
    @PostMapping("/greeting")
    public String createGreeting(@RequestBody Greeting greeting) {
        repository.save(greeting);
        return "Greeting added";
    }
//
//
////        Delete Request
//    @DeleteMapping("/greeting")
//    public String deleteGreeting(@RequestBody Greeting greeting) {
//        int lengGreetings = greetings.size();
//
//        greetings.remove(greeting.getId());
//
//        if (lengGreetings == greetings.size()) {
//            return "Delete Failed";
//        }
//        return "delete success";
//    }
//
////    generally we don't use strings to search. We would use IDs
////    Alternatively could have used a path variable instead and deleted it by name
////    path vairable instead!
//
//
    @DeleteMapping("/greeting/{id}")
    public String deleteGreeting2 (@PathVariable int id){
//        List<Greeting> greetings = repository.findAll();
       long startLen=repository.count();
            repository.deleteById(id);
            long endLen = repository.count();
            if(startLen-endLen ==0){
                return "Delete Unsuccessful";
            } else {return "Great delete success";}
//        boolean isDeleted = greetings.removeIf(element -> element.getId() == id);
//        if(isDeleted){
//            return "greeting was deleted";
//        }
//        return "greeting not found, can't delete";
    }

    //    make get greeting by id - should now return the greeting class
//    make sure delete is working
//    Should update the delete so we use ID to delete instead of greeting  -


}


