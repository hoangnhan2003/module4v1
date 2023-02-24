package com.example.blog.repository;


import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface IBlogRepository extends JpaRepository<Blog,String> {
    Blog findBlogByTitle(String title);
    Blog findBlogByCodeBlog(Long codeBlog);
    @Query(value = "SELECT * from Blog where title like %:title%",nativeQuery = true)
    List<Blog> findBlogsByTitleLike(@Param("title") String title);

    Page<Blog> findAllByTitleLike(Pageable pageable,String title);
    Page<Blog> findAllByAuthorLike(Pageable pageable,String author);
    List<Blog> findAllByTitleLike(String title);

    void deleteByCodeBlog(Long codeBlog);


}
