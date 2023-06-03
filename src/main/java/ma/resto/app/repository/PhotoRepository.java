package ma.resto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.resto.app.entite.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
	public Photo findById(int id);
}
