package ma.resto.app.contoller;
//prime react
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;
import ma.resto.app.entite.Restaurant;
import ma.resto.app.entite.Ville;
import ma.resto.app.entite.Zone;
import ma.resto.app.service.VilleService;

@RestController
@RequestMapping(value = "api/villes")
@CrossOrigin
public class VilleController {
	@Autowired
	private VilleService villeService;

	@PostMapping("/save")
	public Ville save(@Valid @RequestBody Ville ville) throws JsonProcessingException {
	    ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(ville);
	    System.out.println(json);
	    return this.villeService.save(ville);
	}
   
	  @PutMapping("/{id}")
	    public Ville update(@PathVariable int id, @RequestBody Ville ville) {
	        Ville existingVille = villeService.findById(id);
	        if (existingVille != null) {
	            existingVille.setNom(ville.getNom());
	            return villeService.update(existingVille);
	        }
	        return null;
	    }

 
	@GetMapping(value = "/{id}")
	public Ville findById(@PathVariable String id) {
		return villeService.findById(Integer.parseInt(id));
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Ville v =villeService.findById(Integer.parseInt(id));
		villeService.delete(v);
	}


	@GetMapping(value = "/all")
	public List<Ville> findAll() {
		return villeService.findAll();
	}

	@GetMapping(value = "/{villeNom}/zones")
	public List<Zone> findZoneByVille(@PathVariable String villeNom) {
		List<Zone> zones = null;
		for (Ville ville : this.findAll()) {
			if (ville.getNom().equals(villeNom)) {
				zones = ville.getZones();
				break;
			}
		}
		return zones;
	}

	@GetMapping(value = "/{villeNom}/zones/{zoneNom}/restaurants")
	public List<Restaurant> findRestoByZone(@PathVariable String villeNom, @PathVariable String zoneNom) {
		List<Restaurant> restaurants = null;
		for (Zone zone : this.findZoneByVille(villeNom)) {
			if (zone.getNom().equals(zoneNom)) {
				restaurants = zone.getRestaurants();
			}
		}
		return restaurants;
	}

	@GetMapping(value = "/{villeNom}/zones/{zoneNom}/restaurants/specialite")
	public List<Restaurant> findRestoBySpecialite(@PathVariable String villeNom, @PathVariable String zoneNom,
			@RequestParam(name = "specialite") String specialite) {
		return null;
	}

	@GetMapping(value = "/{villeNom}/zones/{zoneNom}/restaurants/serie")
	public List<Restaurant> findRestoBySerie(@PathVariable String villeNom, @PathVariable String zoneNom,
			@RequestParam(name = "chaine") String chaine) {
		return null;
	}

	@GetMapping(value = "/{villeNom}/zones/{zoneNom}/restaurants/{id}")
	public Restaurant findRestoById(@PathVariable String villeNom, @PathVariable String zoneNom, @PathVariable String id) {
		List<Restaurant> restaurants = null;
		for (Zone zone : this.findZoneByVille(villeNom)) {
			if (zone.getNom().equals(zoneNom)) {
				restaurants = zone.getRestaurants();
				for (Restaurant re : restaurants) {
					if (re.getId() == Integer.parseInt(id)) {
						return re;
					}
				}
			}
		}
		return null;
	}
	
	@GetMapping(value = "/{villeNom}/zones/{zoneNom}/restaurants/{id}/itineraire")
	public Restaurant findRestoByItineraire(@PathVariable String villeNom, @PathVariable String zoneNom, @RequestParam(name = "depart") String depart) {
		return null;
	}
}
