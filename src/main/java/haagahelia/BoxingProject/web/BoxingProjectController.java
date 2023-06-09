package haagahelia.BoxingProject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import haagahelia.BoxingProject.domain.Boxer;
import haagahelia.BoxingProject.domain.BoxerRepository;
import haagahelia.BoxingProject.domain.Gloves;
import haagahelia.BoxingProject.domain.GlovesRepository;
import haagahelia.BoxingProject.domain.StanceRepository;
import jakarta.validation.Valid;
@CrossOrigin
@Controller
public class BoxingProjectController {

@Autowired
private BoxerRepository boxerrepository;
@Autowired
private StanceRepository stancerepository;
@Autowired
private GlovesRepository glovesrepository;
	// INDEX HOMEPAGE WHERE THERE IS A LIST OF ALL BOXERS
	@GetMapping({"/index", "/"})
	public String indexPage(Model model) {
		List<Boxer> boxerlist;
		model.addAttribute("boxerlist", boxerrepository.findAll());
		return "index";
	}
	@GetMapping("/indexadmin")
	public String indexAdmin(Model model) {
		List<Boxer> boxerlist;
		model.addAttribute("boxerlist", boxerrepository.findAll());
		return "boxerlistadmin";
	}
	// REST MAPPING FOR JSON
	@GetMapping("/boxers")
	public @ResponseBody List<Boxer> getBoxers() {
		return (List<Boxer>)boxerrepository.findAll();
	}
	
	@GetMapping("/gloves")
	public @ResponseBody List<Gloves> getGloves() {
		return (List<Gloves>)glovesrepository.findAll();
	}
	
	@PostMapping("/gloves")
	public @ResponseBody Gloves addNewGloves(@RequestBody Gloves gloves) {
		return glovesrepository.save(gloves);
	}
	// MAPPING FOR A SINGLE BOXER USING A ID PATH FOR REST
	// ALSO REMEMBER API/BOXERS FOR REST API!
	@GetMapping("/boxers/{id}")
	public @ResponseBody Optional<Boxer> getOneBoxer(@PathVariable("id") Long id) {
		return boxerrepository.findById(id);
	}
	// POST METHOD FOR POSTING BOXERS
	@PostMapping("/boxers")
	public @ResponseBody Boxer addNewBoxer(@RequestBody Boxer boxer) {
		return boxerrepository.save(boxer);
	}
	// GET FOR NEW BOXER
	@GetMapping("/newboxer")
	@PreAuthorize("hasAuthority('ADMIN')") // METHOD SECURITY FOR ROLE ADMIN
	public String addNewBoxer(Model model) {
		model.addAttribute("boxer", new Boxer());
		// ADDED STANCE TO NEW BOXER
		model.addAttribute("stances", stancerepository.findAll());
		model.addAttribute("gloves", glovesrepository.findAll());
		return "boxerform";
	}
	// POST FOR SAVE NEW BOXER
	@PostMapping("/saveboxer")
	public String saveBoxer(@Valid Boxer boxer,  Model model) {
		boxerrepository.save(boxer);
		return "redirect:/indexadmin";}
	
	// GET FOR DELETE BOXER
	@GetMapping("/deleteboxer/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")// METHOD SECURITY, ONLY ADMIN CAN DELETE BOXER
	public String deleteBoxer(@PathVariable("id") Long id) {
		boxerrepository.deleteById(id);
		return "redirect:/indexadmin";
	}
	// GET FOR EDIT BOXER
	@GetMapping("/editboxer/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editBoxer(@PathVariable("id") Long id, Model model) {
		model.addAttribute("boxer", boxerrepository.findById(id));
		// ADDED STANCE TO EDIT BOXER
		model.addAttribute("stances", stancerepository.findAll());
		// ADDED GLOVES TO EDIT BOXER
		model.addAttribute("gloves", glovesrepository.findAll());
		return "editboxerform";
	}
	// MAPPING FOR LOGIN PAGE
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
}
