package com.example.productmanagerment.controller;

import com.example.productmanagerment.model.Product;
import com.example.productmanagerment.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping("")
    public String showAllProduct(@PageableDefault(value = 3)Pageable pageable, Model model){
        Page<Product> productPage = productService.findAll(pageable);
        model.addAttribute("productList",productPage);
        return "list_product";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("product",new Product());
        return "create_product";
    }
    @PostMapping("/create")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "create_product";
        }
        productService.save(product);
        redirectAttributes.addFlashAttribute("msg","Add product success");
        return "redirect:/product";
    }
    @GetMapping("/edit")
    public String showEditForm(@RequestParam("productCode") Long productCode, Model model){
        Product product = productService.findById(productCode);
        model.addAttribute("product",product);
        return "edit_product";
    }
    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute("product") Product product,Model model,RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("msg","Update success");
        return "redirect:/product";
    }
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("productCode") Long productCode,Model model){
        productService.deleteProductById(productCode);
        return "redirect:/product";
    }
    @GetMapping("detail")
    public String showDetailProduct(@RequestParam("productCode") Long productCode,Model model){
        Product product = productService.findById(productCode);
        model.addAttribute("product",product);
        return "detail_product";
    }
}
