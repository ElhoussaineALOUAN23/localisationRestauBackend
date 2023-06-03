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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RequestBody;

import ma.resto.app.entite.Serie;
import ma.resto.app.entite.Ville;
import ma.resto.app.entite.Zone;
import ma.resto.app.service.ZoneService;

@RestController
@RequestMapping(value = "api/zones")
@CrossOrigin
public class ZoneController {
	@Autowired
	private ZoneService zoneService;
 
	
	@PostMapping("/save")
	public Zone save(@RequestBody Zone zone) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(zone);
		System.out.println(json);
		return this.zoneService.save(zone);
	}
	
	

	@PutMapping("/update")
	public Zone update(@PathVariable int id, @RequestBody Zone zone) {
		Zone existingZone = zoneService.findById(id);
		if (existingZone != null) {
			existingZone.setNom(zone.getNom());
			return zoneService.update(existingZone);
		}
		return null;
	}

 
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Zone z =zoneService.findById(Integer.parseInt(id));
		zoneService.delete(z);
	}

	@GetMapping(value = "/{id}")
	public Zone findById(@PathVariable String id) {
		return zoneService.findById(Integer.parseInt(id));
	}

	@GetMapping(value = "/all")
	public List<Zone> findAll() {
		return zoneService.findAll();
	}

	@GetMapping("/ville/{villeId}")
	public List<Zone> getZonesByVilleId(@PathVariable Long villeId) {
		return zoneService.getZonesByVilleId(villeId);
	}
}
