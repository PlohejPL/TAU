package pl.artur.pjwst.zad3;

import org.joda.time.DateTime;

// WlasnyPersonalnyOsobisty
public interface AlarmClock {

	public boolean shouldRing();
	public void addAlarmTime(DateTime alarmTime);
	public void clearAlarmTime(DateTime clearTime);
}
