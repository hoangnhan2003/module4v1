package com.example.uploadimage.repository;

import com.example.uploadimage.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
