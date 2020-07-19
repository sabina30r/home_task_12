package nix.edu.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class DateUtil {

    public static Map<LocalDate, Set<LocalTime>> convertListToAssociativeArray(List<LocalDateTime> listOfDate) {
        Map<LocalDate, Set<LocalTime>> associativeArrayFromList = listOfDate.stream()
                .collect(Collectors.groupingBy(LocalDateTime::toLocalDate,
                        Collectors.mapping(LocalDateTime::toLocalTime, Collectors.toSet())));

        Map<LocalDate, Set<LocalTime>> sortedAssociativeArrayFromList = associativeArrayFromList.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedAssociativeArrayFromList;
    }

    public static Long findMaxDurationBetweenTwoDates(List<LocalDateTime> listOfDate) {
        List<Long> durationList = new ArrayList<>();
        listOfDate.stream()
                .sorted()
                .max((t, t1) -> {
                    Long duration = Duration.between(t, t1).toDaysPart();
                    durationList.add(duration);
                    return 0;
                });
        Long maxDurationInDays = Collections.max(durationList);
        return maxDurationInDays;
    }

}
