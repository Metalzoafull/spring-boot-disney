package com.example.disney.controller;

import com.example.disney.model.Personage;
import com.example.disney.service.api.PersonageServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
public class PersonageController {


    @Autowired
    private PersonageServiceAPI personageServiceAPI;


    @GetMapping("characters")
    public String listar(Model model) {
        model.addAttribute("list", personageServiceAPI.getAll());
        return "characters";
    }

    @GetMapping("/create/createCharacter")
    public String create(Model model){
        model.addAttribute("personage", new Personage());
        return "create/createCharacter";
    }

    @PostMapping("/create/createCharacter")
    public String save(@Validated Personage personage,Model model,@RequestParam(name = "file")MultipartFile image, RedirectAttributes flash){
        if (!image.isEmpty()){
            Path directorioImg = Paths.get("src//main//resources//static/img");
            String ruta = directorioImg.toFile().getAbsolutePath();

            try {
                byte[] bytes = image.getBytes();
                Path rutaPrimaria = Paths.get(ruta + "//" + image.getOriginalFilename());
                Files.write(rutaPrimaria, bytes);
                personage.setImage(image.getOriginalFilename());


            }catch (Exception e){
                e.printStackTrace();

            }

            personageServiceAPI.save(personage);
            flash.addFlashAttribute("success", "imagen subida");
        }


        return "redirect:/home";
    }


}
