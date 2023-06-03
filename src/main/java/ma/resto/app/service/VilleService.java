package ma.resto.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.resto.app.IDao.diao;
import ma.resto.app.entite.Ville;
import ma.resto.app.repository.VilleRepository;

@Service
public class VilleService implements diao<Ville> {
	@Autowired
	private VilleRepository villeRepository;

	@Override
	public Ville save(Ville o) {
		return this.villeRepository.save(o);
	}

	@Override
	public Ville update(Ville o) {
		return this.villeRepository.save(o);
	}

	@Override
	public void delete(int id) {
		this.villeRepository.deleteById(id);
	}

	@Override
	public Ville findById(int id) {
		return this.villeRepository.findById(id);
	}

	@Override
	public List<Ville> findAll() {
		return this.villeRepository.findAll();
	}

	@Override
	public void delete(Ville o) {
		this.villeRepository.delete(o);
		
	}

	

}
