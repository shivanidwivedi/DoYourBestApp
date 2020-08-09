package doyourbestapp.controller;

import doyourbestapp.cache.CreateActivityCache;
import doyourbestapp.activities.CreateActivity;
import doyourbestapp.activities.FetchActivity;
import doyourbestapp.models.RetroCalender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.concurrent.ExecutionException;

/**
 * @author shivanidwivedi on 29/07/20
 * @project DoYourBest
 */

@RestController
public class DoYourBestAppController {


    private static final Logger LOGGER= LoggerFactory.getLogger(DoYourBestAppController.class);
    /**
     * Main activity thta processes create/edit requests
     */
    @Autowired
    CreateActivity createActivity;

    /**
     * Main activity that processes fetch requests
     */
    @Autowired
    FetchActivity fetchActivity;

    @Autowired
    CreateActivityCache createActivityCache;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CreateResponse createUserFeed(@RequestBody CreateRequest createRequest) throws ExecutionException, ParseException {
        LOGGER.info("create request: {}", createRequest.toString());
        CreateResponse createResponse = createActivity.process(createRequest);
       // return ResponseEntity.status(HttpStatus.CREATED).body(createRequest.getDate() + " user is created, wohooooo !");
        return createResponse;
    }

    @RequestMapping(value = "/fetch", method = RequestMethod.GET)
    public FetchResponse fetchUserData(@RequestBody FetchRequest fetchRequest) throws ExecutionException, ParseException {
        LOGGER.info("/fetch request: {}", fetchRequest.toString());
        FetchResponse fetchResponse = fetchActivity.process(fetchRequest);
        return fetchResponse;
    }

    @GetMapping("/cacheStats")
    public String getCacheStats() {
        return createActivityCache.getCacheEntry().stats().toString();
    }

}
