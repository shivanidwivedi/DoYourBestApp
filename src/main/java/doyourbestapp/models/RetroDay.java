package doyourbestapp.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

/**
 * @author shivanidwivedi on 30/07/20
 * @project DoYourBest
 */
@Builder
@Data
public class RetroDay implements Comparable<RetroDay> {
    int userId; //think if it should be stored here ?
    boolean isMyBestDay;
    String note;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RetroDay request = (RetroDay) o;
        return userId == request.userId && date.equals(request.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId + date.toString());
    }

    @Override
    public String toString() {
        return "CreateRequest{" +
                "userId=" + userId +
                ", isMyBestDay=" + isMyBestDay +
                ", note='" + note +
                ", date = " + date +
                '}';
    }

    @Override
    public int compareTo(RetroDay o) {
        if (this.equals(o)) {
            return 0;
        } else {
            return -1;
        }
    }
}

