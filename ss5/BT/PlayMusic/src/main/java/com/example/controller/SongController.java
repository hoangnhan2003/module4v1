package com.example.controller;

import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("music")
public class SongController {
    @Autowired
    ISongService songService;
    @GetMapping("")
    public String getList(Model model){
        model.addAttribute("songList",songService.getAll());
        return "list_music";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("song",new Song());
        return "create_song";
    }
    @PostMapping("/create")
    public String addSong(@Valid @ModelAttribute("song")Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "create_song";
        }
        songService.save(song);
        redirectAttributes.addFlashAttribute("msg","Add song successful ");
        return "redirect:/music";
    }
    @GetMapping("/delete/{songName}")
    public String deleteSong(@PathVariable("songName") String songName, Model model){
        songService.deleteBySongName(songName);
        return "redirect:/music";
    }

    @GetMapping ("/edit/{songName}")
    public String showEditForm(@PathVariable("songName")String songName,Model model){
        Song song = songService.findBySongName(songName);
        model.addAttribute("song",song);

        return "edit_music";
    }
    @PostMapping("update")
    public String updateSong(@ModelAttribute("song") Song song,Model model){

        songService.edit(song);
        return "redirect:/music";
}
}
