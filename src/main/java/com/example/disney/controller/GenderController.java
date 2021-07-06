package com.example.disney.controller;


import com.example.disney.model.Gender;
import com.example.disney.service.api.GenderServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class GenderController {

    @Autowired
    private GenderServiceAPI genderServiceAPI;

    @GetMapping("gender")
    public String listar(Model model){
        model.addAttribute("list", genderServiceAPI.getAll());
        return "gender";
    }

    @GetMapping("/gender/formGender")
    public String create(Model model){
        model.addAttribute("gender", new Gender());
        return "gender/formGender";
    }

    @PostMapping("gender/save")
    public String save(@Validated Gender gender, Model model, @RequestParam(name = "file") MultipartFile image, RedirectAttributes flash){
        if (!image.isEmpty()){
            Path directorioImg = Paths.get("src//main//resources//static//img/gender");
            String ruta = directorioImg.toFile().getAbsolutePath();

            try {
                byte[] bytes = image.getBytes();
                Path rutaPrimaria = Paths.get(ruta + "//" + image.getOriginalFilename());
                Files.write(rutaPrimaria, bytes);
                gender.setImage(image.getOriginalFilename());


            }catch (Exception e){
                e.printStackTrace();

            }

            genderServiceAPI.save(gender);
            flash.addFlashAttribute("success", "imagen subida");
        }


        return "redirect:/gender";
    }

    @GetMapping("gender/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("gender", genderServiceAPI.get(id));
        return "gender/formGender";
    }

    @GetMapping("gender/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        genderServiceAPI.delete(id);
        return "redirect:/gender";
    }
}
