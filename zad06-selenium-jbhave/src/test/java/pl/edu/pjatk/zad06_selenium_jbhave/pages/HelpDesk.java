package pl.edu.pjatk.zad06_selenium_jbhave.pages;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HelpDesk extends WebDriverPage {

    public HelpDesk(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void open() {
        get("http://szuflandia.pjwstk.edu.pl/helpdesk.html");
        manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    public void click(String linkText) {
        WebElement e = findElement(By.partialLinkText(linkText));
        e.click();
    }

    public String getClassesForLink(String linkText) {
        WebElement e = findElement(By.partialLinkText(linkText));
        return e.getAttribute("class");
    }
}