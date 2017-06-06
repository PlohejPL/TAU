package pl.edu.pjatk.zad11_spring_dbunit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "addition.all", query = "Select a from Addition a"),
		@NamedQuery(name = "addition.byName", query = "Select a from Addition a WHERE a.name = :name"),
		@NamedQuery(name = "addition.update", query = "Update Addition a Set a.name = :name , a.pizzaId = :pizzaId Where id = :id")
})
public class Addition {

	private Long id;
	private String name;
	private Long pizzaId;
	
	public Addition () {
		
	}
	
	public Addition(String name){
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setMake(String name) {
		this.name = name;
	}

	public Long getPizzaID() {
		return pizzaId;
	}

	public void setPizzaID(Long pizzaID) {
		this.pizzaId = pizzaID;
	}
	
	

}
