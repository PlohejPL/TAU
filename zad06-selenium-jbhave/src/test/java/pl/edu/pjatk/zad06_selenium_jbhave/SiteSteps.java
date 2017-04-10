package pl.edu.pjatk.zad06_selenium_jbhave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class SiteSteps {

    private final Pages pages;

    public SiteSteps(Pages pages) {
        this.pages = pages;
    }

    @Given("admin is on main page")
    public void userOnHelpdeskPage(){
        pages.carSite().openPage();
    }

    @When("admin click administration panel, writes his password $password and clicks login")
    public void userClicksTabLink(String password) {
        pages.carSite().login(password);
    }

    @Then("a element called Wyloguj should appear on page")
    public void tabWithTextAndClass() {
        assertTrue( pages.carSite().getWyloguj().equals("Wyloguj"));
    }

    /*
     * Given admin is on main page
	When admin click administration panel, writes his password haslo and clicks login
	Then a element called Wyloguj should appear on page
*/
}
