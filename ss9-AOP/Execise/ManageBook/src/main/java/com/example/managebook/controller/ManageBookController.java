package com.example.managebook.controller;

import com.example.managebook.model.Book;
import com.example.managebook.model.BorrowBook;
import com.example.managebook.model.User;
import com.example.managebook.service.IBookService;
import com.example.managebook.service.IBorrowBookService;
import com.example.managebook.service.IUserService;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

@Controller
@RequestMapping("book_store")
public class ManageBookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IBorrowBookService borrowBookService;
    @GetMapping("")
    public String showAllBook(@PageableDefault(value = 10)Pageable pageable,Model model){
        Page<Book> bookPage= bookService.getAll(pageable);
        model.addAttribute("bookList",bookPage);
        return "bookPage";

    }
//    @GetMapping("/sign_up")
//    public String showFormSignUp(Model model){
//        model.addAttribute("user",new User());
//        return "sign_up";
//    }
    @PostMapping("/sign_up")
    public String doSignUp(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                           @RequestParam("retypePassword")String retypePassword,
                           RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "sign_up";
        }
        if(user.getPassword() == retypePassword){
            userService.save(user);
            redirectAttributes.addFlashAttribute("msg","Sign up success");
        }
        else{
            redirectAttributes.addFlashAttribute("msg","retype password wrong!");
        }

        return "sign_in";
    }
    @GetMapping("/sign_in")
    public String showFormSignIn(Model model){
        model.addAttribute("user",new User());
        return "sign_in";
    }
    @PostMapping("/sign_in")
    public String doSignIn(@ModelAttribute("user") User user,RedirectAttributes redirectAttributes){
        User user1 = userService.findUserByUserNameAndPassword(user.getUserName(),user.getPassword());
        if(user1 == null){
            redirectAttributes.addFlashAttribute("msg","user name or password wrong!!");
            return "sign_in";
        }
        else{
            redirectAttributes.addAttribute("user",user1);
            return "redirect:/book_store";
        }
    }
    @GetMapping("/info")
    public String showInfoUser(@PageableDefault (value = 10) Pageable pageable,
                               @RequestParam("userId") Long userId,Model model){
        User user = userService.findById(userId);
        model.addAttribute("user",user);
        Page<BorrowBook> borrowBookList = borrowBookService.findAllByUser(pageable,user);
        model.addAttribute("borrowBookList",borrowBookList);
        return "infor_user";

    }
    @GetMapping("return_book")
    public String returnBook(@RequestParam("borrowBookId") Long borrowBookId, Model model){
        BorrowBook borrowBook = borrowBookService.findByBorrowCode(borrowBookId);
        User user = userService.findById(borrowBook.getUser().getId());
        String returnTime = LocalDateTime.now().toString();
        borrowBook.setReturnDate(returnTime);
        borrowBookService.save(borrowBook);
        model.addAttribute("user",user);

        return "redirect:/book_store/info";
    }
    @GetMapping("/borrowBook")
    public String borrow(@RequestParam("bookId") Long bookId,
                         @RequestParam("userId") Long userId, Model model,RedirectAttributes redirectAttributes){
        Book book = bookService.findById(bookId);
        User user = userService.findById(userId);
        String dateTime = LocalDateTime.now().toString();
        BorrowBook borrowBook = new BorrowBook(user,book,dateTime);
        borrowBookService.save(borrowBook);
        book.setAmount(book.getAmount() -1 );
        bookService.save(book);
        redirectAttributes.addAttribute("user",user);
        return "redirect:/book_store";
    }



}
