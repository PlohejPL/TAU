package pl.artur.pjwst.zad3;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class AlarmClockImpl implements AlarmClock {

	private ArrayList<DateTime> alarmList = new ArrayList<DateTime>();
	private MyTime now;
	
	public boolean shouldRing() {
		boolean shouldRing = false;
		
		
		for (DateTime tmpDate : alarmList)
		{
			if (tmpDate.withTimeAtStartOfDay().isEqual(now.getTime().withTimeAtStartOfDay()))
			{
				shouldRing=true;
			}
		}
		
		return shouldRing;
	}

	public void addAlarmTime(DateTime alarmTime) {
		alarmList.add(alarmTime);
	}

	public void clearAlarmTime(DateTime clearTime) {
		alarmList.remove(clearTime);
	}

}
