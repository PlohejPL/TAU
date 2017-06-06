package pl.edu.pjatk.zad11_spring_dbunit.service;

import java.util.List;

import pl.edu.pjatk.zad11_spring_dbunit.domain.Addition;
import pl.edu.pjatk.zad11_spring_dbunit.domain.Pizza;

public interface PizzaMaker {
	
	void addPizza(Pizza pizza);
	List<Pizza> getAllPizzas();
	void updatePizza(Pizza pizza);
	void deletePizza(Pizza pizza);
	Pizza findPizzaByName(String name);
	
	Long addAddition(Addition addition);
	List<Addition> getAdditions	();
	void deleteAddition(Addition addition);
	void updateAddition(Addition addition);
	Addition findAdditionById(Long id);
	Addition findAdditionByName(String name);

	/*List<Car> getOwnedCars(Person person);
	void sellCar(Long personId, Long carId);

    void updateClient(Person client);*/
}
