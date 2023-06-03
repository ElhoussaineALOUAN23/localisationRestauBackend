package ma.resto.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.resto.app.IDao.diao;
import ma.resto.app.entite.Specialite;
import ma.resto.app.repository.SpecialiteRepository;

@Service
public class SpecialiteService implements diao<Specialite> {
	@Autowired
	private SpecialiteRepository specialiteRepository;

	@Override
	public Specialite save(Specialite o) {
		return this.specialiteRepository.save(o);
	}

	@Override
	public Specialite update(Specialite o) {
		return this.specialiteRepository.save(o);
	}

	@Override
	public void delete(Specialite o) {
		this.specialiteRepository.delete(o);
	}

	@Override
	public Specialite findById(int id) {
		return this.specialiteRepository.findById(id);
	}

	@Override
	public List<Specialite> findAll() {
		return this.specialiteRepository.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
