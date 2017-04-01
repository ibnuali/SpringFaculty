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
import com.afc.model.Staff;
import com.afc.repo.FacultyRepository;
import com.afc.repo.StaffRepository;

@Controller
@RequestMapping("/staff")
public class StaffController {
	@Autowired
    private StaffRepository repository; 
	
	@Autowired
    private FacultyRepository frepository; 
	
	@RequestMapping("")
	public String faculty(Model model) {
		 List<Staff> staff = (List<Staff>) repository.findAll();
		
		model.addAttribute("staffs", staff);
		
    	return "staff";
    }

    @RequestMapping(value = "addStaff")
    public String addFaculty(Model model){
	    	model.addAttribute("staff", new Staff());
	    	List<Faculty> faculties = (List<Faculty>) frepository.findAll();
	    	model.addAttribute("faculties", faculties);
        return "addStaff";
    }
    
    
    @RequestMapping(value = "updateStaff", method = RequestMethod.POST)
    public String updateFaculty( @Valid Staff staff, BindingResult bindingResult, Model model){
    	
        repository.save(staff);
       
    	return "redirect:/staff/";
    }
    
    @RequestMapping(value = "editStaff/{id}", method = RequestMethod.GET)
    public String editStaff(@PathVariable("id") Long staffid, Model model) {
    	Staff staff = repository.findOne(staffid);
    	model.addAttribute("staff", staff);
    	List<Faculty> faculties = (List<Faculty>) frepository.findAll();
    	model.addAttribute("faculties", faculties);
        return "editStaff";
    }
	
    @RequestMapping(value = "saveStaff", method = RequestMethod.POST)
    public String saveFaculty( @Valid Staff staff, BindingResult bindingResult, Model model){
        repository.save(staff);
    	return "redirect:/staff/";
    }
    
    @RequestMapping(value = "deleteStaff/{id}", method = RequestMethod.GET)
    public String deleteStaff(@PathVariable("id") Long staffid, Model model) {
    	repository.delete(staffid);
        return "redirect:/staff/";
    } 
}
