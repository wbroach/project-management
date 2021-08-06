package com.jrp.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectRepository proRepo;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		model.addAttribute("project", new Project());
		return "new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		proRepo.save(project);
		return "redirect:/new"; 	
	}
	
}
