package ma.resto.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.resto.app.IDao.diao;
import ma.resto.app.entite.Serie;
import ma.resto.app.repository.SerieRepository;

@Service
public class SerieService implements diao<Serie> {
	@Autowired
	private SerieRepository serieRepository;

	@Override
	public Serie save(Serie o) {
		return this.serieRepository.save(o);
	}

	@Override
	public Serie update(Serie o) {
		return this.serieRepository.save(o);
	}

	@Override
	public void delete(Serie o) {
		this.serieRepository.delete(o);
	}

	@Override
	public Serie findById(int id) {
		return this.serieRepository.findById(id);
	}

	@Override
	public List<Serie> findAll() {
		return this.serieRepository.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
