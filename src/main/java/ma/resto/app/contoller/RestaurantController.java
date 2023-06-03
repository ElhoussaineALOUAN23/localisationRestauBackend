package ma.resto.app.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.resto.app.entite.Restaurant;
 
import ma.resto.app.service.RestaurantService;

@RestController
@RequestMapping(value = "api/restaurants")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;

	@PostMapping(value = "/save")
	public Restaurant save(@RequestBody Restaurant o) {
		return restaurantService.save(o);
	}

	@PutMapping(value = "/update")
	public Restaurant update(@RequestBody Restaurant o) {
		return restaurantService.update(o);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Restaurant r =restaurantService.findById(Integer.parseInt(id));
		restaurantService.delete(r);
	}


	@GetMapping(value = "/{id}")
	public Restaurant findById(@PathVariable String id) {
		return restaurantService.findById(Integer.parseInt(id));
	}

	@GetMapping(value = "/all")
	public List<Restaurant> findAll() {
		return restaurantService.findAll();
	}

}
