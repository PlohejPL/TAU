package pl.edu.pjatk.zad11_spring_dbunit.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "pizza.all", query = "Select p from Pizza p"),
	@NamedQuery(name = "person.byPin", query = "Select p from Person p where p.pin = :pin"),
	@NamedQuery(name = "pizza.update", query = "Update pizza p Set p.name = :name , p.additons = :additions Where id = :id")
})
public class Pizza {

	private Long id;

	private String name;// = "unknown";

	private List<Addition> additions;// = new ArrayList<Addition>();
	
	public Pizza () {
		
	}
	
	public Pizza (String name) {
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
	public void setName(String name) {
		this.name = name;
	}


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@OneToMany(orphanRemoval=true)
    //@JoinColumn(name="OWNER")
	public List<Addition> getAdditions() {
		return additions;
	}
	public void setAdditions(List<Addition> additions) {
		this.additions = additions;
	}
}
