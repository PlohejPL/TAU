package pl.edu.pjatk.zad06_selenium_jbhave;

import org.jbehave.web.selenium.WebDriverProvider;

import pl.edu.pjatk.zad06_selenium_jbhave.pages.CarSite;


public class Pages {

    private WebDriverProvider driverProvider;

    //Pages -- moze byc ich kilka
    private CarSite carSite;

    public Pages(WebDriverProvider driverProvider) {
        super();
        this.driverProvider = driverProvider;
    }

    public CarSite carSite() {
        if (carSite == null) {
        	carSite = new CarSite(driverProvider);
        }
        return carSite;
    }
}
