package pl.edu.pjatk.zad06_selenium_jbhave.pages;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CarSite extends WebDriverPage {

    public CarSite(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void openPage() {
    	get("http://localhost/Projekt-komis_samochodowy/index.php?akcja=brak");
    	manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
			
    }

    public void login(String password) {
        findElement(By.linkText("Panel administracyjny")).click();
        WebElement element = findElement(By.name(password));
		element.sendKeys("haslo");
		element.submit();
        
    }

    public String getWyloguj() {        
        WebElement element = findElement(By.id("Wyloguj"));
        return element.getText();
        
    }
}
