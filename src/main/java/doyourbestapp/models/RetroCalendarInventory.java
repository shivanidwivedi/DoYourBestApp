package doyourbestapp.models;

import doyourbestapp.activities.CreateActivity;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * @author shivanidwivedi on 30/07/20
 * @project DoYourBest
 * This class is responsible for storing all the data in a Hashmap where,
 * userId is a key and the calender is the value.
 */
@Getter
public class RetroCalendarInventory {
    private static final Logger LOGGER = LoggerFactory.getLogger(RetroCalendarInventory.class);
    //user id and their calendar
    private HashMap<Integer, RetroCalender> userDaysMap;

    private static RetroCalendarInventory bestDaysInventory;

    public RetroCalender getDaysByUser(int userId) {
        if (userDaysMap.containsKey(userId)) {
            return userDaysMap.get(userId);
        }
        return null;
    }

    private RetroCalendarInventory() {
        userDaysMap = new HashMap<>();
    }

    public void addToCalendar(RetroDay day) {
        if(userDaysMap.containsKey(day.getUserId())) {
            userDaysMap.get(day.getUserId()).addDay(day);
        } else {
            LOGGER.error("day {} does nto exist in calendar", day.toString());
        }
    }

    public static RetroCalendarInventory createInventory() {
        if (bestDaysInventory == null) {
            bestDaysInventory = new RetroCalendarInventory();
        }
        return bestDaysInventory;
    }

}
