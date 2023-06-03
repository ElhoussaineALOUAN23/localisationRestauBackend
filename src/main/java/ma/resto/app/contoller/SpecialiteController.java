package ma.resto.app.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import ma.resto.app.entite.Specialite;
import ma.resto.app.entite.Ville;
import ma.resto.app.service.SpecialiteService;

@RestController
@RequestMapping(value = "api/specialites")
@CrossOrigin
public class SpecialiteController {
	@Autowired
	private SpecialiteService specialiteService;

	@PostMapping(value = "/save")
	public Specialite save(@RequestBody Specialite o) {
		return specialiteService.save(o);
	}

	@PutMapping(value = "/update")
	public Specialite update(@RequestBody Specialite o) {
		return specialiteService.save(o);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Specialite sp =specialiteService.findById(Integer.parseInt(id));
		specialiteService.delete(sp);
	}

	@GetMapping(value = "/{id}")
	public Specialite findById(@PathVariable String id) {
		return specialiteService.findById(Integer.parseInt(id));
	}

	@GetMapping(value = "/all")
	public List<Specialite> findAll() {
		return specialiteService.findAll();
	}

}
