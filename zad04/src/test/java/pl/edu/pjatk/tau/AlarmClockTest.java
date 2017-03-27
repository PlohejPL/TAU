package pl.edu.pjatk.tau;

import static org.easymock.EasyMock.*;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.joda.time.DateTime;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import junit.framework.TestCase;

@RunWith(JUnit4.class)
public class AlarmClockTest extends TestCase {

	@Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @TestSubject
    public AlarmClock alarmClock = new AlarmClockImpl();

    @Mock
    public MyTime now;
	
	@Test
	public void testAlarmShouldRing() {
		DateTime timeRing = new DateTime(1995,1,1,12,30);
        alarmClock.addAlarmTime(timeRing);
        expect(now.getTime())
                .andReturn(new DateTime(1995,1,1,12,30))
                .andReturn(new DateTime(1995,2,1,12,30)).times(2)
                .andReturn(new DateTime(1995,1,1,12,30));
        replay(now);
        assertEquals(true, alarmClock.shouldRing());
        assertEquals(false, alarmClock.shouldRing());
        assertEquals(false, alarmClock.shouldRing());
        assertEquals(true, alarmClock.shouldRing());
        verify(now);
	}
}
