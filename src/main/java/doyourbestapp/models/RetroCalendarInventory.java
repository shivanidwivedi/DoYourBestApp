package doyourbestapp.models;

import lombok.Getter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shivanidwivedi on 30/07/20
 * @project DoYourBest
 * This class is responsible for storing all the data in a Hashmap where,
 * userId is a key and the calender is the value.
 */
@Getter
public class RetroCalendarInventory {
    private HashMap<RetroDay, RetroCalender> userDaysMap;

    private static RetroCalendarInventory bestDaysInventory;

    public RetroCalender getDaysByUser(int userId) {
        RetroDay retroDay = RetroDay.builder().userId(userId).build();
        if (userDaysMap.containsKey(retroDay)) {
            return userDaysMap.get(retroDay);
        }
        return null;
    }

    private RetroCalendarInventory() {
        userDaysMap = new HashMap<>();
    }

    public void addToCalendar(RetroDay day) {
        userDaysMap.get(day).addDay(day);
    }

    public static RetroCalendarInventory createInventory() {
        if (bestDaysInventory == null) {
            bestDaysInventory = new RetroCalendarInventory();
        }
        return bestDaysInventory;
    }

}
