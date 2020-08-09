package doyourbestapp.activities;

import doyourbestapp.util.AppConstants;
import doyourbestapp.cache.CreateActivityCache;
import doyourbestapp.contracts.Activity;
import doyourbestapp.controller.FetchRequest;
import doyourbestapp.controller.FetchRequestType;
import doyourbestapp.controller.FetchResponse;
import doyourbestapp.models.RetroCalendarInventory;
import doyourbestapp.models.RetroCalender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 03/08/20
 * @project DoYourBest
 */
@Service
public class FetchActivity implements Activity<FetchRequest, FetchResponse> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FetchActivity.class);

    @Autowired
    CreateActivityCache doYourBestCache;

    @Autowired
    RetroCalendarInventory retroCalendarInventory;

    @Override
    public boolean validate(FetchRequest request) {
        if (request.getId() <= 0) {
            return false;
        }
        return true;
    }

    @Override
    public FetchResponse processRequest(FetchRequest fetchRequest) {
        switch (FetchRequestType.ALL) {
            case ALL:
                List<RetroCalender> retroCalenders = new ArrayList<>();
                retroCalenders.add(retroCalendarInventory.getDaysByUser(fetchRequest.getId()));
                return FetchResponse.builder()
                        .retroCalenders(retroCalenders)
                        .responseEntity(ResponseEntity.status(HttpStatus.OK).body(retroCalendarInventory.toString()))
                        .build();
            case DAY:
                break;
            case MONTH:
                break;
            case YEAR:
                break;
        }
        return null;
    }

    @Override
    public FetchResponse errorResponse() {
        return FetchResponse.builder().errorMessage(AppConstants.INVALID_REQUEST_MESSAGE).build();
    }


}
