package com.afc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.afc.model.Faculty;
import com.afc.repo.FacultyRepository;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
	@Autowired
    private FacultyRepository repository; 
	
	@RequestMapping("")
	public String faculty(Model model) {
		 List<Faculty> faculty = (List<Faculty>) repository.findAll();
		
		model.addAttribute("faculties", faculty);
		
    	return "faculty";
    }

    @RequestMapping(value = "addFaculty")
    public String addFaculty(Model model){
	    	model.addAttribute("faculty", new Faculty());
        return "addFaculty";
    }
    
    
    @RequestMapping(value = "updateFaculty", method = RequestMethod.POST)
    public String updateFaculty( @Valid Faculty faculty, BindingResult bindingResult, Model model){
    	
        repository.save(faculty);
       
    	return "redirect:/faculty";
    }
    
    @RequestMapping(value = "editFaculty/{id}", method = RequestMethod.GET)
    public String editFaculty(@PathVariable("id") Long facultyid, Model model) {
    	Faculty faculty = repository.findOne(facultyid);
    	
    	model.addAttribute("faculty", faculty);
        return "editFaculty";
    }
	
    @RequestMapping(value = "saveFaculty", method = RequestMethod.POST)
    public String saveFaculty( @Valid Faculty faculty, BindingResult bindingResult, Model model){
        repository.save(faculty);
    	return "redirect:/faculty";
    }
    
    @RequestMapping(value = "deleteFaculty/{id}", method = RequestMethod.GET)
    public String deleteFaculty(@PathVariable("id") Long facultyid, Model model) {
    	repository.delete(facultyid);
        return "redirect:/faculty";
    } 
}
