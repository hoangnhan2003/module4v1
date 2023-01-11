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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;
    @GetMapping("")
    public String listBlog(@PageableDefault(value = 1)Pageable pageable, Model model){
        model.addAttribute("blogList",blogService.getAll(pageable));
        return "list_blog1";
    }
    @GetMapping("/create")
    public String showCreate(@PageableDefault(value = 10) Pageable pageable, Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categories",categoryService.findAll(pageable));
        return "create_blog";
    }
    @PostMapping("/create")
    public String addBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg","Add blog successful");
        return "redirect:/blog";
    }
    @GetMapping("/update")
    public String showEditForm(@RequestParam("codeBlog") String codeBlog,Model model,@PageableDefault(value = 20) Pageable pageable){
        Blog blog = blogService.findByCodeBlog(codeBlog);
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
    @GetMapping("/delete")
    public String delteBlog(@RequestParam("codeBlog") String codeBlog,Model model){
        blogService.delete(codeBlog);
        return "redirect:/blog";
    }
    @PostMapping("searchByTitle")
    public String searchBlogByTitle(@RequestParam String title,Model model,@PageableDefault(value = 1)Pageable pageable){
        Page<Blog> blogList = blogService.findAllByTitle(pageable,title);
        model.addAttribute("blogList",blogList);
        return "list_blog1";
    }
    @PostMapping("searchByAuthor")
    public String searchBlogByAuthor(@RequestParam String author,Model model,@PageableDefault(value = 1)Pageable pageable){
        Page<Blog> blogList = blogService.findAllByAuthor(pageable,author);
        model.addAttribute("blogList",blogList);
        return "list_blog1";
    }
}
