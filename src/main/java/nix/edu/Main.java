package nix.edu;

import nix.edu.util.DateUtil;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


public class Main {

    private static List<LocalDateTime> dateTimeList = Arrays.asList(

            LocalDateTime.of(2020, 1, 1, 12, 5, 7),
            LocalDateTime.of(2020, 5, 30, 6, 8, 1),
            LocalDateTime.of(2019, 3, 5, 16, 4, 7),
            LocalDateTime.of(2020, 1, 1, 15, 35, 4),
            LocalDateTime.of(2019, 8, 24, 6, 12, 5),
            LocalDateTime.of(2020, 1, 1, 21, 12, 4)
    );

    public static void main(String[] args) {
        System.out.println("Original list of LocalDateTime: " + dateTimeList + "\n");

        System.out.println("Map-converted list: " + DateUtil.convertListToAssociativeArray(dateTimeList) + "\n");

        System.out.println("Max duration between two dates in days: " + DateUtil.findMaxDurationBetweenTwoDates(dateTimeList));
    }
}
