package doyourbestapp.contracts;

import java.text.ParseException;

/**
 * @author shivanidwivedi on 05/08/20
 * @project DoYourBest
 */
public interface Activity<K,V> {
    boolean validate(K request) throws ParseException;
    V processRequest(K request) throws ParseException;
    default V process(K request) throws ParseException {
        if(validate(request)) {
            return processRequest(request);
        } else {
            //throw exception
            return errorResponse();
        }
    }
    V errorResponse();
}
