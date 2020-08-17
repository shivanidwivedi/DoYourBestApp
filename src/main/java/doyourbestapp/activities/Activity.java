package doyourbestapp.activities;

import java.text.ParseException;

/**
 * @author shivanidwivedi on 05/08/20
 * @project DoYourBest
 */
public interface Activity<Request, Response> {
    boolean validate(Request request) throws ParseException;
    Response processRequest(Request request) throws ParseException;
    default Response process(Request request) throws ParseException {
        if(validate(request)) {
            return processRequest(request);
        } else {
            //throw exception
            return errorResponse();
        }
    }
    Response errorResponse();
}
