package ma.resto.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.resto.app.entite.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {
	public Zone findById(int id);
	 List<Zone> findByVilleId(Long villeId);
}
