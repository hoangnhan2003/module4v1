package com.example.book_store.controller;

import com.example.book_store.model.Book;
import com.example.book_store.model.Contract;
import com.example.book_store.model.History;
import com.example.book_store.service.IBookService;
import com.example.book_store.service.IContractService;
import com.example.book_store.service.IHistoryService;
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

@Controller
@RequestMapping("book_store")
public class StoreBookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IContractService contractService;
    @Autowired
    private IHistoryService historyService;
    @GetMapping("")
    public String showAllBook(@PageableDefault(value = 10) Pageable pageable, Model model){
        model.addAttribute("bookList",bookService.getAll(pageable));
        return "display_book";
    }
    @GetMapping("create_new_book")
    public String createNewBook(Model model){
        model.addAttribute("book",new Book());
        return "create_book";
    }
    @PostMapping("create_new_book")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "create_book";
        }
        bookService.save(book);
        redirectAttributes.addFlashAttribute("msg","Add successful");
        return "redirect:";
    }
    @GetMapping("/borrow")
    public String borrowBook(@RequestParam("bookId") Long bookId,Model model,RedirectAttributes redirectAttributes){
        Book book = bookService.findByBookId(bookId);
        if(book.getAmount() > 0){
            String startTime = LocalDateTime.now().toString();
            book.setAmount(book.getAmount() -1);
            bookService.save(book);
            Contract contract = new Contract(startTime,book);
            contractService.save(contract);
            redirectAttributes.addFlashAttribute("msg","borrow book success");
        }
        else{
            redirectAttributes.addFlashAttribute("msg","out of book!!");
        }
        return "redirect:/book_store";
    }
    @GetMapping("showAllBorrowBook")
    public String showAllContract(@PageableDefault(value = 10) Pageable pageable,Model model){
        Page<Contract> contractPage = contractService.getAll(pageable);
        model.addAttribute("contractList",contractPage);
        return "contract_display";
    }
    @GetMapping("showAllHistory")
    public String showAllHistory(@PageableDefault(value = 20) Pageable pageable,Model model){
        Page<History> historyPage = historyService.getAll(pageable);
        model.addAttribute("historyList",historyPage);
        return "show_history";
    }
    @GetMapping("/return_book")
    public String returnBook(@RequestParam("contractCode") Long contractCode,Model model,
                             RedirectAttributes redirectAttributes){
        Contract contract = contractService.findByContractCode(contractCode);
        if(contract.getReturnTime()== null){
            String returnTime = LocalDateTime.now().toString();
            contract.setReturnTime(returnTime);
            contractService.save(contract);
            Book book = contract.getBook();
            book.setAmount(book.getAmount() +1 );
            bookService.save(book);
            redirectAttributes.addFlashAttribute("msgReturnBook","return book success");

        }
        else{
            redirectAttributes.addFlashAttribute("msgReturnBook","book returned");
        }
        return "redirect:/book_store/showAllBorrowBook";
    }
}
