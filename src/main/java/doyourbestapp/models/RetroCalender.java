package doyourbestapp.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 29/07/20
 * @project DoYourBest
 */
@Data
public class RetroCalender {
    List<RetroDay> retroDays;

    public RetroCalender() {
        retroDays = new ArrayList<>();
    }

    public void addDay(RetroDay singleDay) {
        if (getSameDay(singleDay) == null) { //if date is different
            retroDays.add(singleDay);
        } else {
            retroDays.set(retroDays.indexOf(singleDay), singleDay);
        }
    }

    public RetroDay getSameDay(RetroDay retroDay) {
        for(RetroDay currDay : retroDays) {
            if(currDay.equals(retroDay)) { //equals() method will take care of this comparison.
                return retroDays.get(retroDays.indexOf(retroDay));
            }
        }
        return null;
    }
}
