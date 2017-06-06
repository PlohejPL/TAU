package pl.edu.pjatk.zad11_spring_dbunit.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import pl.edu.pjatk.zad11_spring_dbunit.domain.Pizza;
import pl.edu.pjatk.zad11_spring_dbunit.domain.Addition;
import pl.edu.pjatk.zad11_spring_dbunit.service.PizzaMaker;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@Rollback
//@Commit
@Transactional(transactionManager = "txManager")
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
public class PizzaMakerBDUnitTest {


	@Autowired
	PizzaMaker sellingManager;
	
	//PIZZA TESTS

	@Test
	@DatabaseSetup("/fullData.xml")
	@ExpectedDatabase(value = "/addPizzaData.xml", table = "Pizza", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void addPizzaTest() {
	    assertEquals(1, sellingManager.getAllPizzas().size());
	    
        sellingManager.addPizza(new Pizza("Funghi"));
        
        assertEquals(2, sellingManager.getAllPizzas().size());
    }
	
	@Test
	@DatabaseSetup("/fullData.xml")
	@ExpectedDatabase(value = "/deletePizzaData.xml", table = "Pizza", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void deletePizzaTest() {
	    assertEquals(1, sellingManager.getAllPizzas().size());
	    
	    Pizza p = sellingManager.getAllPizzas().get(0);
        sellingManager.deletePizza(p);
   
        assertEquals(0, sellingManager.getAllPizzas().size());
    }
	
	@Test
	@DatabaseSetup("/fullData.xml")
	@ExpectedDatabase(value = "/updatePizzaData.xml", table = "Pizza", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void updatePizzaTest() {
	    assertEquals(1, sellingManager.getAllPizzas().size());

	    Pizza p = sellingManager.getAllPizzas().get(0);
	    p.setName("Prosciutto");
        sellingManager.updatePizza(p);
        
        assertEquals(1, sellingManager.getAllPizzas().size());
    }	
	
	
	//ADDITION TESTS	
	
	@Test
	@DatabaseSetup("/fullData.xml")
	@ExpectedDatabase(value = "/addPizzaData.xml", table = "Addition", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void addAdditionTest() {
	    assertEquals(1, sellingManager.getAdditions().size());
	    
        sellingManager.addAddition(new Addition("Ser"));
        
        assertEquals(2, sellingManager.getAdditions().size());
    }



// More advanced business method tests

	
	@Test
	@DatabaseSetup("/fullData2.xml")
	public void moreAdvancedBusinessMethodTest() {
		assertEquals(5, 6);
  }
}
