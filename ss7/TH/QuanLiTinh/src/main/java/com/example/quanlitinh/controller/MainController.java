package com.example.quanlitinh.controller;

import com.example.quanlitinh.model.Customer;
import com.example.quanlitinh.service.ICustomerService;
import com.example.quanlitinh.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("general")
public class MainController {
    @Autowired
    IProvinceService provinceService;
    @Autowired
    ICustomerService customerService;
    @GetMapping("")
    public ModelAndView showListCustomer(@PageableDefault(value = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("list_customer");
        Page<Customer> customers = customerService.getAll(pageable);
        modelAndView.addObject("customerList",customers);
        return modelAndView;
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("provinceList",provinceService.getAll());
        model.addAttribute("customer",new Customer());
        return "create_customer";
    }
    @PostMapping("/create")
    public String addCustomer(@ModelAttribute("customer") Customer customer, Model model){
        customerService.save(customer);
        return "redirect:/general";
    }
    @GetMapping("/edit")
    public String showEditForm(@RequestParam("customerId") Long id,Model model){
        Optional<Customer> customer = customerService.findById(id);
        model.addAttribute("customer",customer.get());
        return "edit_customer";
    }
    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("customer") Customer customer,Model model){
        customerService.save(customer);
        return "redirect:/general";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") Long id,Model model){
        customerService.remove(id);
        return "redirect:/general";
    }

}
