import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;

/**
 * @author shivanidwivedi on 06/08/20
 * @project DoYourBest
 */
public class JavaDateValidation {
    public static void main(String[] args)
    {
        String dateFormat = "MM-dd-yyyy";
        String dateString = "09-20-2021";

        Date parsedDate = validateAndParseDateJava7(dateString, dateFormat);

        System.out.println(parsedDate);
    }

    //Java 7 - Use SimpleDateFormat (not thread-safe)
    public static Date validateAndParseDateJava7(String dateString, String dateFormat) {
        Date date = null;
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
