package doyourbestapp.controller;

import doyourbestapp.models.RetroCalender;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author shivanidwivedi on 03/08/20
 * @project DoYourBest
 */
@Data
@Builder
public class FetchResponse {
    private String value;
    private String errorMessage;
    private List<RetroCalender> retroCalenders;
    private ResponseEntity<String> responseEntity;
}
