package doyourbestapp.controller;

import doyourbestapp.models.RetroCalendarInventory;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

/**
 * @author shivanidwivedi on 05/08/20
 * @project DoYourBest
 */
@Data
@Builder
public class CreateResponse {
    private String errorMessage;
    private boolean isSuccess;
    private RetroCalendarInventory retroCalendarInventory;
    private ResponseEntity<String> responseEntity;
}
