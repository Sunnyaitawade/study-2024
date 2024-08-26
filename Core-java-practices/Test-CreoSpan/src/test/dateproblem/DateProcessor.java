package test.dateproblem;/**
 * @name DateProcessor
 * @author NSA Studios
 * @date 8/6/2024
 */

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @name DateProcessor
 * @author NSA Studios
 * @date 8/6/2024
 */
public class DateProcessor {

    public LocalDate processDate(Date dateValue) {

        Instant instant =  dateValue.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        LocalDate localDate = zdt.toLocalDate();
        return localDate.plusDays(32);
    }

    public boolean validateWithMyDate(LocalDate startDate,LocalDate endDate,LocalDate mytDate){
        if(startDate.compareTo(mytDate) > 0 || startDate.compareTo(mytDate) == 0)
        {
            return true;
        }
          else if(endDate.compareTo(mytDate)  < 0)
        {
             return true;
        }
          return false;
    }
}
