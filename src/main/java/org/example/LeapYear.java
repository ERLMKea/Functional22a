package org.example;

import java.time.LocalDate;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LeapYear {

    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(2023,7,9);
        Stream<LocalDate> tendates = IntStream.range(1,10).mapToObj(i -> birthday.plusYears(i));
        var obj = tendates.map(date -> "Year= " + date.getYear() + " ugedag=" + date.getDayOfWeek());
        obj.forEach(System.out::println);

        IntPredicate leapYear = year -> (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        //var obj = IntStream.iterate(LocalDate.now().getYear(), year -> year + 1).limit(4);

        IntStream leapYears = IntStream.iterate(LocalDate.now().getYear(), year -> year + 1)
                .filter(leapYear).limit(4);

        leapYears.forEach(System.out::println);

    }

}
