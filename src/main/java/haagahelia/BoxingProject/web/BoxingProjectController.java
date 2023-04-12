package haagahelia.BoxingProject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import haagahelia.BoxingProject.domain.Boxer;
import haagahelia.BoxingProject.domain.BoxerRepository;
import haagahelia.BoxingProject.domain.StanceRepository;
@CrossOrigin
@Controller
public class BoxingProjectController {

@Autowired
private BoxerRepository boxerrepository;
@Autowired
private StanceRepository stancerepository;
	// INDEX HOMEPAGE WHERE THERE IS A LIST OF ALL BOXERS
	@GetMapping({"/index", "/"})
	public String helloWorld(Model model) {
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
	// MAPPING FOR A SINGLE BOXER USING A ID PATH FOR REST
	// ALSO REMEMBER API/BOXERS FOR REST API!
	@GetMapping("/boxers/{id}")
	public @ResponseBody Optional<Boxer> getOneBoxer(@PathVariable("id") Long boxer_Id) {
		return boxerrepository.findById(boxer_Id);
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
		return "boxerform";
	}
	// POST FOR SAVE NEW BOXER
	@PostMapping("/saveboxer")
	public String saveBoxer(Boxer boxer, Model model) {
		boxerrepository.save(boxer);
		return "redirect:/indexadmin";
	}
	// GET FOR DELETE BOXER
	@GetMapping("/deleteboxer/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")// METHOD SECURITY, ONLY ADMIN CAN DELETE BOXER
	public String deleteBoxer(@PathVariable("id") Long boxer_id) {
		boxerrepository.deleteById(boxer_id);
		return "redirect:/indexadmin";
	}
	// GET FOR EDIT BOXER
	@GetMapping("/editboxer/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editBoxer(@PathVariable("id") Long boxer_id, Model model) {
		model.addAttribute("boxer", boxerrepository.findById(boxer_id));
		// ADDED STANCE TO EDIT BOXER
		model.addAttribute("stances", stancerepository.findAll());
		return "editboxerform";
	}
	// MAPPING FOR LOGIN PAGE
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
}
