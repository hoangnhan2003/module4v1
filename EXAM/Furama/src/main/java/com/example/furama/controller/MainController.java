package com.example.furama.controller;

import com.example.furama.model.Customer;
import com.example.furama.service.ICustomerService;
import com.example.furama.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.validation.Valid;

@RestController
@RequestMapping("")
public class MainController {
    @Autowired
    private ICustomerTypeService customerTypeService;
    @Autowired
    private ICustomerService customerService;
    @GetMapping("")
    public ModelAndView showAll(@RequestParam(value = "customerName",defaultValue = "") String customerName,
                                @PageableDefault(value = 2) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("home");
        Page<Customer> customerPage = customerService.findAllByCustomerNameLike(customerName,pageable);
        modelAndView.addObject("searchName",customerName);
        modelAndView.addObject("customerPage",customerPage);
        return modelAndView;
    }
    @GetMapping("/addCustomer")
    public ModelAndView showCreateCustomer() {
        ModelAndView modelAndView = new ModelAndView("addCustomer");

        modelAndView.addObject("customerTypeList",customerTypeService.findAll());
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }
    @PostMapping("addCustomer")
    public ModelAndView addCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult bindingResult){
        Customer customer1 = customer;
        if(bindingResult.hasErrors()){
            return new ModelAndView("addCustomer");
        }
        else{
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        customerService.save(customer);
        return modelAndView;
        }
    }
    @GetMapping("/delete")
    public ModelAndView deleteCustomer(@RequestParam(value = "customerId") String id){
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        customerService.deleteById(Integer.parseInt(id));
        return modelAndView;
    }
    @GetMapping("/searchById")
    public ResponseEntity<Customer> findById(@RequestParam("customerId")String id){
        return new ResponseEntity<>(customerService.findById(Integer.parseInt(id)), HttpStatus.OK);
    }

}
