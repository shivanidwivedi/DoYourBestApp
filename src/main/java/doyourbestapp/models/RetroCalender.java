package doyourbestapp.models;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 29/07/20
 * @project DoYourBest
 */
@Data
public class RetroCalender {
    List<RetroDay> monthDays;

    public RetroCalender() {
        monthDays = new ArrayList<>();
    }

    public List<RetroDay> getCurrentMonth() {
        return null;
    }
    public List<RetroDay> getCurrentYear(){ return null; }

    public void addDay(RetroDay singleDay) {
        if (getSameDay(singleDay) == null) { //if date is different
            monthDays.add(singleDay);
        } else {
            monthDays.set(monthDays.indexOf(singleDay), singleDay);
        }
    }

    public RetroDay getSameDay(RetroDay retroDay) {
        for(RetroDay currDay : monthDays) {
            if(currDay.getDate().equals(retroDay.getDate())) {
                return monthDays.get(monthDays.indexOf(retroDay));
            }
        }
        return null;
    }
}
