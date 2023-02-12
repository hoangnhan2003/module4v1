package com.example.uploadimage.controller;

import com.example.uploadimage.model.Image;
import com.example.uploadimage.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;

import java.io.IOException;
import java.util.Optional;

@Controller
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;
    @GetMapping("/create_image")
    public String create_Image(Model model){
        model.addAttribute("image",new Image());
        return "create_image";
    }

    @PostMapping("/images")
    public ResponseEntity<Image> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Image image = new Image();
            image.setName(file.getOriginalFilename());
            image.setData(file.getBytes());
            Image savedImage = imageRepository.save(image);
            return ResponseEntity.ok().body(savedImage);
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/all-images")
    public String getAllImages(Model model) {
        List<Image> images = imageRepository.findAll();
        model.addAttribute("images", images);
        return "images";
    }
}
