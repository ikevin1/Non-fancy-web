package edu.wctc.myComic.controller;

import edu.wctc.myComic.entity.Comedian;
import edu.wctc.myComic.service.ComedianNameService;
import edu.wctc.myComic.service.ComedianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/comedian")
public class ComedianController {
    @Autowired
    private ComedianService comedianService;

    @Autowired
    private ComedianNameService comedianNameService;

    @RequestMapping("/list")
    public String listDonuts(Model theModel) {
        List<Comedian> theList = comedianService.getComedians();

        theModel.addAttribute("comedians", theList);

        return "list-comedians";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String theSearchTerm,
                         Model theModel) {

        List<Comedian> theList = comedianService.getComediansByName(theSearchTerm);

        theModel.addAttribute("donuts", theList);

        return "list-comedians";
    }

    @GetMapping("/delete")
    public String deleteComedian(@RequestParam("comedianId") int theId){
        comedianService.deleteComedian(theId);

        return "redirect:/comedian/list";
    }

    @RequestMapping("/showUpdateComedianForm")
    public String showUpdateComedianForm(@RequestParam("comedianId") int theId,
                                      Model theModel) {
        Comedian existingComedian = comedianService.getComedian(theId);

        theModel.addAttribute("aComedian", existingComedian);

        theModel.addAttribute("names", comedianNameService.getNames());

        return "add-comedian-form";
    }

    @GetMapping("/showAddComedianForm")
    public String showAddComedianForm(Model theModel) {
        Comedian plainComedian = new Comedian();

        theModel.addAttribute("aComedian", plainComedian);

        theModel.addAttribute("names", comedianNameService.getNames());

        return "add-comedian-form";
    }

    @PostMapping("/save")
    public String saveDonut(@RequestParam(name = "comedianImage") MultipartFile file,
                            @Valid @ModelAttribute(name = "aComedian") Comedian theComedian,
                            BindingResult bindingResult,
                            Model theModel,
                            HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);

            theModel.addAttribute("names", comedianNameService.getNames());

            return "add-comedian-form";
        }

        comedianService.saveComedian(theComedian, file, request.getServletContext().getRealPath("/"));

        return "redirect:/comedian/list";
    }


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, ste);
    }
}
