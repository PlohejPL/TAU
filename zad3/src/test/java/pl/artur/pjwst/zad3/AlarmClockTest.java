package pl.artur.pjwst.zad3;

import java.util.ArrayList;

import static org.easymock.EasyMock.*;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.joda.time.DateTime;
import org.junit.Rule;
import org.junit.Test;

import junit.framework.TestCase;

public class AlarmClockTest extends TestCase {

	@Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @TestSubject
    public AlarmClock alarmClock = new AlarmClockImpl();

    @Mock
    public DateTime time;
	
	@Test
	public void testAlarmShouldRing() {
		DateTime timeRing = new DateTime(1995,1,1,12,30);
        alarmClock.addAlarmTime(timeRing);
        expect(alarmClock.shouldRing())
                .andReturn(true)
                .andReturn(false).times(2)
                .andReturn(true);
        replay(alarmClock);
        assertEquals(true, alarmClock.shouldRing());
        assertEquals(false, alarmClock.shouldRing());
        assertEquals(false, alarmClock.shouldRing());
        assertEquals(true, alarmClock.shouldRing());
        verify(alarmClock);
	}
}
