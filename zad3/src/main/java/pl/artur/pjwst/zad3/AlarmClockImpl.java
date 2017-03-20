package pl.artur.pjwst.zad3;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class AlarmClockImpl implements AlarmClock {

	private ArrayList<DateTime> alarmList = new ArrayList<DateTime>();
	
	public boolean shouldRing() {
		boolean shouldRing = false;
		
		DateTime now = new DateTime();
		
		for (DateTime tmpDate : alarmList)
		{
			if (tmpDate.withTimeAtStartOfDay().isEqual(now.withTimeAtStartOfDay()))
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
