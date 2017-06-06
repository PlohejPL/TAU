package pl.edu.pjatk.zad11_spring_dbunit.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pjatk.zad11_spring_dbunit.domain.Addition;
import pl.edu.pjatk.zad11_spring_dbunit.domain.Pizza;

@Component
@Transactional
public class PizzaMakerHibernateImpl implements PizzaMaker {

	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Override
	public void addPizza(Pizza pizza) {
		pizza.setId(null);
		sessionFactory.getCurrentSession().persist(pizza);
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public List<Pizza> getAllPizzas() {
		return sessionFactory.getCurrentSession().getNamedQuery("pizza.all")
				.list();
	}

	@Override
	public void deletePizza(Pizza pizza) {
		pizza = (Pizza) sessionFactory.getCurrentSession().get(Pizza.class,
				pizza.getId());

		sessionFactory.getCurrentSession().delete(pizza);

	}

	@Override
	public Pizza findPizzaByName(String name) {
		return (Pizza) sessionFactory.getCurrentSession().getNamedQuery("addition.byName").setString("name", name).uniqueResult();
	}

	@Override
	public Long addAddition(Addition addition) {
		addition.setId(null);
		return (Long) sessionFactory.getCurrentSession().save(addition);
	}

	@Override
	public List<Addition> getAdditions() {
		return sessionFactory.getCurrentSession().getNamedQuery("additions.all")
				.list();
	}

	@Override
	public void deleteAddition(Addition addition) {
		addition = (Addition) sessionFactory.getCurrentSession().get(Addition.class,
				addition.getId());
		sessionFactory.getCurrentSession().delete(addition);

	}

	@Override
	public Addition findAdditionById(Long id) {
		return (Addition) sessionFactory.getCurrentSession().get(Addition.class, id);
	}

	@Override
	public void updatePizza(Pizza pizza) {
		sessionFactory.getCurrentSession().getNamedQuery("pizza.update")
		.setParameter("name", pizza.getName())
		//.setParameter("additions", pizza.getAdditions())
		.setParameter("id", pizza.getId()).executeUpdate();
		
	}

	@Override
	public void updateAddition(Addition addition) {
		sessionFactory.getCurrentSession().getNamedQuery("addition.update")
		.setParameter("name", addition.getName())
		.setParameter("pizzaId", addition.getPizzaID())
		.setParameter("id", addition.getId()).executeUpdate();
		
	}

	@Override
	public Addition findAdditionByName(String name) {
		// TODO Auto-generated method stub
		return (Addition) sessionFactory.getCurrentSession().getNamedQuery("addition.byName").setString("name", name).uniqueResult();
	}

}
