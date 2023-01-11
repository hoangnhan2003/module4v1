package com.example.controller;

import com.example.model.Student;
import com.example.service.IStudentService;
import com.example.service.Impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    IStudentService studentService;
    @GetMapping(value = "")
    public String getList(Model model){
        model.addAttribute("studentList",studentService.getAll());
        return "list_thymeleaf";
    }
    @GetMapping("detail/{id}")
    public String detailByIdWithPathVariable(@PathVariable("id") Integer id,Model model){
        model.addAttribute("student",studentService.findById(id));
        return "detail_thymeleaf";
    }
    @GetMapping("/create")
    public String showFormCreate(@ModelAttribute("student")Student student, RedirectAttributes redirectAttributes){
        studentService.save(student);
        redirectAttributes.addFlashAttribute("msg","Them moi thanh cong");
        return "redirect:/student";
    }


}
