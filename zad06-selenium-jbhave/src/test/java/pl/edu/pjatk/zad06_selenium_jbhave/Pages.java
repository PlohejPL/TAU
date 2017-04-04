package pl.edu.pjatk.zad06_selenium_jbhave;

import org.jbehave.web.selenium.WebDriverProvider;
import pl.edu.pjatk.zad06_selenium_jbhave.pages.HelpDesk;


public class Pages {

    private WebDriverProvider driverProvider;

    //Pages -- moze byc ich kilka
    private HelpDesk helpDesk;

    public Pages(WebDriverProvider driverProvider) {
        super();
        this.driverProvider = driverProvider;
    }

    public HelpDesk helpdesk() {
        if (helpDesk == null) {
            helpDesk = new HelpDesk(driverProvider);
        }
        return helpDesk;
    }
}
