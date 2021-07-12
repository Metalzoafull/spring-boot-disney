package com.example.disney.controller;


import com.example.disney.model.FilmSerie;
import com.example.disney.service.api.FilmSerieServiceAPI;
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
import java.util.stream.Collectors;

@Controller
public class FilmSerieController {


    @Autowired
    private FilmSerieServiceAPI filmSerieServiceAPI;

    @GetMapping("movies")
    public String listar(Model model){
        model.addAttribute("list", filmSerieServiceAPI.getAll());
        return "movies";
    }

    @GetMapping(value = "movies", params = "title")
    public String findName(@RequestParam(name = "title") String title, Model model ){
        model.addAttribute("list", filmSerieServiceAPI.getAll().stream().filter(f -> f.getTitle().equals(title)).collect(Collectors.toList()));
        return "movies";
    }

    @GetMapping(value = "movies", params = "order")
    public String order(@RequestParam(name = "order") String order, Model model){
        model.addAttribute("list",filmSerieServiceAPI.ordenar(order));
        return "movies";
    }

    @GetMapping(value = "movies", params = "genre")
    public String genero(@RequestParam(name = "genre") Long genre, Model model){
        model.addAttribute("list", filmSerieServiceAPI.filterGender(genre));
        return "movies";
    }

    @GetMapping("/movies/description/{id}")
    public String description(@PathVariable("id") Long id, Model model){
        model.addAttribute("films", filmSerieServiceAPI.get(id));
        return "movies/description";
    }

    @GetMapping("/movies/formMovies")
    public String create(Model model){
        model.addAttribute("movies", new FilmSerie());
        return "movies/formMovies";
    }



    @PostMapping("movies/save")
    public String save(@Validated FilmSerie filmSerie, Model model, @RequestParam(name = "file") MultipartFile image, RedirectAttributes flash){
        if (!image.isEmpty()){
            Path directorioImg = Paths.get("src//main//resources//static//img/movies");
            String ruta = directorioImg.toFile().getAbsolutePath();

            try {
                byte[] bytes = image.getBytes();
                Path rutaPrimaria = Paths.get(ruta + "//" + image.getOriginalFilename());
                Files.write(rutaPrimaria, bytes);
                filmSerie.setImage(image.getOriginalFilename());


            }catch (Exception e){
                e.printStackTrace();

            }

            filmSerieServiceAPI.save(filmSerie);
            flash.addFlashAttribute("success", "imagen subida");
        }


        return "redirect:/movies";

    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("movies", filmSerieServiceAPI.get(id));
        return "filmSeries/formFilmSe";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        filmSerieServiceAPI.delete(id);
        return "redirect:/movies";
    }

}
