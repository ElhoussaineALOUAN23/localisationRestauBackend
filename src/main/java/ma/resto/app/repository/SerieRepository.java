package ma.resto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.resto.app.entite.Serie;

public interface SerieRepository extends JpaRepository<Serie, Integer> {
	public Serie findById(int id);
}
