package ma.resto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.resto.app.entite.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	public Restaurant findById(int id);
}
