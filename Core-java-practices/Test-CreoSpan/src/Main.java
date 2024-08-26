import test.dateproblem.DateProcessor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @author NSA Studios
 * @name ${NAME}
 * @date 8/6/2024
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the no of dates you want to process?");

        int n;

        Scanner in = new Scanner(System.in);


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        DateProcessor dp = new DateProcessor();
        in.nextLine();


        try {



            System.out.println("Enter the start date ");
            String startDateStr = in.nextLine();
            Date startDate =  sdf.parse(startDateStr);
            System.out.println("Enter the end date ");
            String endDateStr = in.nextLine();
            Date endDate =  sdf.parse(endDateStr);
            System.out.println("Enter the my date ");
            String myDateStr = in.nextLine();
            Date myDate =  sdf.parse(myDateStr);



        } catch (ParseException e) {

            e.printStackTrace();
        }


        in.close();


    }
}