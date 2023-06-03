package ma.resto.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.resto.app.IDao.diao;
import ma.resto.app.entite.Restaurant;
import ma.resto.app.repository.RestaurantRepository;

@Service
public class RestaurantService implements diao<Restaurant> {
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public Restaurant save(Restaurant o) {
		return this.restaurantRepository.save(o);
	}

	@Override
	public Restaurant update(Restaurant o) {
		return this.restaurantRepository.save(o);
	}

	@Override
	public void delete(Restaurant o) {
		this.restaurantRepository.delete(o);
	}

	@Override
	public Restaurant findById(int id) {
		return this.restaurantRepository.findById(id);
	}

	@Override
	public List<Restaurant> findAll() {
		return this.restaurantRepository.findAll();
	}

	@Override
	public void delete(int id) {
		this.restaurantRepository.deleteById(id);
		
	}

}
