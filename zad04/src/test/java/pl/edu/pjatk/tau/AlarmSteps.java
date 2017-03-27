package pl.edu.pjatk.tau;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.joda.time.DateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
/*
 * Given You set up alarm for Wolfgang for the alarmTime he wants.
When The time of alarm is the currentTime Walfgang wants to wake up.
Then You will be told weather the time is right result.

0-3;4-5;6-7;8-9;10-11;
1995-01-01 12:30
 */

public class AlarmSteps {
    AlarmClock alarmClock;
    MyTime now = mock(MyTime.class);

    @Given("You set up alarm for Wolfgang for the $alarmTime he wants")
    public void setAlarmForWolfgang(String alarmTime){
        alarmClock  = new AlarmClockImpl();
        alarmClock.addAlarmTime(
        		new DateTime(Integer.parseInt(alarmTime.substring(0, 3)),
        				Integer.parseInt(alarmTime.substring(4, 5)),
        				Integer.parseInt(alarmTime.substring(6, 7)),
        				Integer.parseInt(alarmTime.substring(8, 9)),
        				Integer.parseInt(alarmTime.substring(10, 11))));
    }

    @When("The time of alarm is the $currentTime Walfgang wants to wake up")
    public void theTimeOfAlarmIsTheTime(String currentTime){
        //alarmClock.shouldRing();
        given(now.getTime()).willReturn(
        	new DateTime(Integer.parseInt(currentTime.substring(0, 3)),
				Integer.parseInt(currentTime.substring(4, 5)),
				Integer.parseInt(currentTime.substring(6, 7)),
				Integer.parseInt(currentTime.substring(8, 9)),
				Integer.parseInt(currentTime.substring(10, 11))));
    }

    @Then("You will be told weather the time is right $result")
    public void tellResult(Boolean result) {
        assertEquals(result, alarmClock.shouldRing());
    }
}
