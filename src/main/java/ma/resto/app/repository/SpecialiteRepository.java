package ma.resto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.resto.app.entite.Specialite;

public interface SpecialiteRepository extends JpaRepository<Specialite, Integer> {
	public Specialite findById(int id);
}
