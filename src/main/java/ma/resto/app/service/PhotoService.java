package ma.resto.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.resto.app.IDao.diao;
import ma.resto.app.entite.Photo;
import ma.resto.app.repository.PhotoRepository;

@Service
public class PhotoService implements diao<Photo> {
	@Autowired
	private PhotoRepository photoRepository;
	
	@Override
	public Photo save(Photo o) {
		return this.photoRepository.save(o);
	}

	@Override
	public Photo update(Photo o) {
		return this.photoRepository.save(o);
	}

	@Override
	public void delete(Photo o) {
		this.photoRepository.delete(o);
	}

	@Override
	public Photo findById(int id) {
		return this.photoRepository.findById(id);
	}

	@Override
	public List<Photo> findAll() {
		return this.photoRepository.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
