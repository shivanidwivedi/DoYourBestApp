package doyourbestapp.controller;

import doyourbestapp.activities.CreateActivity;
import doyourbestapp.activities.FetchActivity;
import doyourbestapp.cache.CreateActivityCache;
import doyourbestapp.contract.CreateRequest;
import doyourbestapp.contract.CreateResponse;
import doyourbestapp.contract.FetchRequest;
import doyourbestapp.contract.FetchResponse;
import doyourbestapp.contract.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Response> createUserFeed(@RequestBody CreateRequest createRequest) throws ParseException {
        LOGGER.info("create request: {}", createRequest.toString());
        CreateResponse createResponse = createActivity.process(createRequest);
        if(!createResponse.isSuccess()) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/fetch", method = RequestMethod.GET)
    public FetchResponse fetchUserData(@RequestBody FetchRequest fetchRequest) throws ParseException {
        LOGGER.info("/fetch request: {}", fetchRequest.toString());
        FetchResponse fetchResponse = fetchActivity.process(fetchRequest);
        return fetchResponse;
    }

    @GetMapping("/cacheStats")
    public String getCacheStats() {
        return createActivityCache.getCacheEntry().stats().toString();
    }

}
