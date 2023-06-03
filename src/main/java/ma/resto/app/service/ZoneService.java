package ma.resto.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.resto.app.IDao.diao;
import ma.resto.app.entite.Zone;
import ma.resto.app.repository.ZoneRepository;

@Service
public class ZoneService implements diao<Zone> {
	
	public List<Zone> getZonesByVilleId(Long villeId) {
		return zoneRepository.findByVilleId(villeId);
	}
	@Autowired
	private ZoneRepository zoneRepository;

	@Override
	public Zone save(Zone o) {
		return this.zoneRepository.save(o);
	}

	@Override
	public Zone update(Zone o) {
		return this.zoneRepository.save(o);
	}



	@Override
	public Zone findById(int id) {
		return this.zoneRepository.findById(id);
	}

	@Override
	public List<Zone> findAll() {
		return this.zoneRepository.findAll();
	}

	@Override
	public void delete(int id) {
		this.zoneRepository.deleteById(id);
		
	}

	@Override
	public void delete(Zone o) {
		this.zoneRepository.delete(o);
		
	}

}
