package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.ICategoryRepository;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.*;

@RestController
@RequestMapping("blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
//    @GetMapping("")
//    public String listBlog(@PageableDefault(value = 1)Pageable pageable, Model model){
//        model.addAttribute("blogList",blogService.getAll(pageable));
//        return "list_blog1";
//    }
//    @GetMapping("")
//    public ResponseEntity<List<Blog>> findAllBlog(){
//        List<Blog> blogList = blogService.getAll();
//        if(blogList.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList,HttpStatus.OK);
//    }

    // AJAX
//    @GetMapping("")
//    public ResponseEntity<List<Blog>> getAllBlog(Model model){
//        List<Category> blogList = categoryService.findAll();
//        model.addAttribute("categoryList",blogList);
//        return new ResponseEntity<>(blogService.getAll(),HttpStatus.OK);
//    }
    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("list_blog1");
        modelAndView.addObject("categories",categoryService.findAll());
        modelAndView.addObject("blogList",blogService.getAll());
        return modelAndView;
    }
    @GetMapping("showList")
    public ResponseEntity<List<Blog>> showAllBlog(){
        return new ResponseEntity<>(blogService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/create")
    public String showCreate(@PageableDefault(value = 10) Pageable pageable, Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categories",categoryService.findAll(pageable));
        return "create_blog";
    }
//    @PostMapping("/create")
//    public String addBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
//        blogService.save(blog);
//        redirectAttributes.addFlashAttribute("msg","Add blog successful");
//        return "redirect:/blog";
//    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Blog blog){
        Category category = categoryService.findById(blog.getCategory().getId());
        blog.setCategory(category);
        Blog blog1 = blogService.saveBlog(blog);
        if(blog1 == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/update")
    public String showEditForm(@RequestParam("codeBlog") String codeBlog,Model model,@PageableDefault(value = 20) Pageable pageable){
        Blog blog = blogService.findByCodeBlog(Long.parseLong(codeBlog));
        Page<Category> categoryPage = categoryService.findAll(pageable);
        model.addAttribute("blog",blog);
        model.addAttribute("categoryList",categoryPage);
        return "edit_blog";
    }
    @PostMapping("/update")
    public String updateBlog(@ModelAttribute("blog") Blog blog, Model model){
        blogService.update(blog);
        return "redirect:/blog";
    }
//    @GetMapping("/delete")
//    public String delteBlog(@RequestParam("codeBlog") String codeBlog,Model model){
//        blogService.delete(codeBlog);
//        return "redirect:/blog";
//    }
//    @GetMapping("/delete/{codeBlog}")
//    public ResponseEntity<?> deleteBlog(@PathVariable("codeBlog") String codeBlog){
//        Blog blog = blogService.findByCodeBlog(codeBlog);
//        if(blog!= null){
//            blogService.delete(codeBlog);
//            return new ResponseEntity<>(HttpStatus.ACCEPTED);
//        }
//        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
    @DeleteMapping ("/delete")
    public ResponseEntity<?> deleteBlog(@RequestParam(value = "codeBlog") String codeBlog){
        Long codeBlog1 =  Long.parseLong(codeBlog);
        Blog blog = blogService.findByCodeBlog(codeBlog1);
        if(blog!= null){
            blogService.delete(Long.parseLong(codeBlog));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//    @PostMapping("searchByTitle")
//    public String searchBlogByTitle(@RequestParam String title,Model model,@PageableDefault(value = 1)Pageable pageable){
//        Page<Blog> blogList = blogService.findAllByTitle(pageable,title);
//        model.addAttribute("blogList",blogList);
//        return "list_blog1";
//    }
    @GetMapping("/searchByTitle")
    public ResponseEntity<?> getByTitle(@RequestParam(value = "title")String title){
        List<Blog> blogList = blogService.findAllByTitleLike("%"+title+"%");
       return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @PostMapping("searchByAuthor")
    public String searchBlogByAuthor(@RequestParam String author,Model model,@PageableDefault(value = 1)Pageable pageable){
        Page<Blog> blogList = blogService.findAllByAuthor(pageable,author);
        model.addAttribute("blogList",blogList);
        return "list_blog1";
    }
    @GetMapping("/searchByTitle/{title}")
    public ResponseEntity<List<Blog>> searchByTitle(@PathVariable("title") String title){
        List<Blog> blogList = blogService.findAllBlogByTitle(title);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
}
