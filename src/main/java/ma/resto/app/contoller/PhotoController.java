package ma.resto.app.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import ma.resto.app.entite.Photo;
import ma.resto.app.service.PhotoService;

@RestController
@RequestMapping(value = "api/photos")
@CrossOrigin
public class PhotoController {
	@Autowired
	private PhotoService photoService;
 
	@PostMapping(value = "/save")
	public Photo save(@RequestBody Photo o) {
		return photoService.save(o);
	}

	@PutMapping(value = "/update")
	public Photo update(@RequestBody Photo o) {
		return photoService.update(o);
	}

	@DeleteMapping(value = "/delete")
	public void delete(@RequestBody Photo o) {
		photoService.delete(o);
	}

	@GetMapping(value = "/{id}")
	public Photo findById(int id) {
		return photoService.findById(id);
	}

	@GetMapping(value = "/all")
	public List<Photo> findAll() {
		return photoService.findAll();
	}

}
