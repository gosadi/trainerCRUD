/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplecert.controller;

import peoplecert.entity.Trainer;
import peoplecert.service.TrainerService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author alkinoos
 */
@Controller
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private TrainerService service;
   
    
    @RequestMapping
    public ModelAndView showTrainer(ModelAndView modelAndView){
        List<Trainer> trainers = service.getTrainers();
        modelAndView.addObject("listOfTrainers", trainers);
        modelAndView.setViewName("trainer/trainerList");
        return modelAndView;
    }
    
    @ModelAttribute("listOfSubjects")
    public List<String> listOfSubjects(){
        return service.listOfSubjects();
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(){
        return "trainer/trainerForm";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid Trainer trainer, BindingResult result , RedirectAttributes attributes){//object gia to redirect pou kaname gia na valoume attributes sto request
        if (result.hasErrors()) {
            attributes.addFlashAttribute("message", "Please enter a valid value between 1 and 20 letters");
            return "redirect:create";
        }
        service.saveTrainer(trainer);
        String minima = "Trainer " + trainer.getTfirstname() + " " +trainer.getTlastname() +" successfully created!!";
        attributes.addFlashAttribute("message",minima);
        return "redirect:/trainer"; //cliend send a new GET request to /trainer
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id,RedirectAttributes attributes){
        service.deleteTrainer(id);
        String minima = "Trainer  successfully deleted!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/trainer";
    }
    
//    edo exoume tsimpisi to path variable  apo to update sti lista
    @GetMapping("/update/{scode}")
    public String showFormUpdate(@PathVariable(name = "scode") int scode, Model model){
        Trainer trainer = service.getTrainerById(scode);
        model.addAttribute("trainerToEdit", trainer);
        return "trainer/trainerForm";
    }

    @PostMapping("/update")
    public String update(@Valid Trainer trainer, BindingResult result, RedirectAttributes attributes){
        
        if (result.hasErrors()) {
            attributes.addFlashAttribute("message", "Please enter a name between 3 and 20 letters");
            return "redirect:create";
        }
        service.saveTrainer(trainer);
        String minima = "Trainer  updated successfully!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/trainer"; 
    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(RedirectAttributes attributes) {
        return "redirect:/trainer";
    }
}
