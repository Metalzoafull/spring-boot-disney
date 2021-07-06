package com.example.disney.controller;

import com.example.disney.model.Personage;
import com.example.disney.service.api.PersonageServiceAPI;
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
public class PersonageController {


    @Autowired
    private PersonageServiceAPI personageServiceAPI;


    @GetMapping("characters")
    public String listar(Model model) {
        model.addAttribute("list", personageServiceAPI.getAll());
        return "characters";
    }

    /*@GetMapping("characters")
    public String listar(@RequestParam(name = "name",defaultValue = "none") String name ,Model model) {
        if(name == "none"){
            model.addAttribute("list", personageServiceAPI.getAll());
        }else{
            model.addAttribute("list", personageServiceAPI.getAll().stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList()));
        }

        return "characters";
    }*/

    @GetMapping(value = "characters", params = "name")
    public String listarPorNombre(@RequestParam(name = "name",defaultValue = "none") String name ,Model model) {
        model.addAttribute("list", personageServiceAPI.getAll().stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList()));
        return "characters";
    }

    @GetMapping(value = "characters", params = "age")
    public String listarPorEdad(@RequestParam(name = "age")Long age, Model model){
        model.addAttribute("list", personageServiceAPI.filterAge(age));
        return "characters";
    }
    @GetMapping(value = "characters", params = "movies")
    public String listarPorPeliSerie(@RequestParam(name = "movies")Long movies, Model model){
        model.addAttribute("list", personageServiceAPI.filterFilmS(movies));
        return "characters";
    }

    @GetMapping("/characters/formCharact")
    public String create(Model model){
        model.addAttribute("personage", new Personage());
        return "characters/formCharact";
    }

    /*@GetMapping("/characters/{age}")
    public String filterAges(@PathVariable("age") int age,Model model){
        model.addAttribute("list",personageServiceAPI.filterAge(age));
        return "characters";
    }*/



    @PostMapping("characters/save")
    public String save(@Validated Personage personage,Model model,@RequestParam(name = "file")MultipartFile image, RedirectAttributes flash){
        if (!image.isEmpty()){
            Path directorioImg = Paths.get("src//main//resources//static//img/personage");
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

    //en el parentesis de este get mapping le digo cuando tiene que trabajar, tiene que trabajar cuando algun HTML haga una llamada a "edit" con el id de algun personaje
    //cuuando esto pasa el metodo edit le dara al html un personaje, que se buscara con el metedo get y el parametro de ID que vino con el llamado al edit
    //estos datos se mostraran por pantalla en en el html que estan en la carpeta "character", dicho HTML se llama formCharact
    //este HTML estara encargado de modificar el personage y luego llamara al metodo "save" para guardar dichos cambios
    @GetMapping("characters/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("personage", personageServiceAPI.get(id));
        return "characters/formCharact";
    }

    @GetMapping("characters/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        personageServiceAPI.delete(id);
        return "redirect:/characters";
    }


}
