package com.example.demo.controller;

import com.example.demo.dao.SimpleDao;
import com.example.demo.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prashant Kumar on 1/8/18
 */
@RestController
public class SimpleController {

    @Autowired
    private SimpleDao simpleDao;

    @GetMapping("/get/all/persons")
    public List<Person> getAllPersons(){

        return simpleDao.getPersons();
    }

    @PostMapping("/add/persons")
    public boolean getAllPersons(@RequestBody Person person){
        return simpleDao.addPerson(person);
    }

}
