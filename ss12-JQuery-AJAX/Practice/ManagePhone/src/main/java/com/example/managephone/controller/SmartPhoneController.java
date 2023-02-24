package com.example.managephone.controller;

import com.example.managephone.model.SmartPhone;
import com.example.managephone.repository.SmartPhoneRepository;
import com.example.managephone.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RestController
@RequestMapping("/smartPhones")
public class SmartPhoneController {
    @Autowired
    private ISmartPhoneService smartPhoneService;


    @PostMapping
    public ResponseEntity<SmartPhone> createSmartPhone(@RequestBody SmartPhone smartPhone){
        return new ResponseEntity<>(smartPhoneService.save(smartPhone), HttpStatus.CREATED);
    }
    @PostMapping("/editPhone")
    public ResponseEntity<?> editSmartPhone(@RequestBody SmartPhone smartPhone){
        return new ResponseEntity<>(smartPhoneService.save(smartPhone),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<SmartPhone>> getAllSmartPhones(){
        return new ResponseEntity<>(smartPhoneService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/list")
    public ModelAndView getAllSmartPhone(){
        ModelAndView model = new ModelAndView("showPhones");
        model.addObject("phones",smartPhoneService.findAll());
        return model;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        smartPhoneService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/findByModel")
    public ResponseEntity<?> findByModel(@RequestParam(value = "modelName")String modelName){
        return new ResponseEntity<>(smartPhoneService.findAllByModelLike(modelName),HttpStatus.OK);
    }
}
