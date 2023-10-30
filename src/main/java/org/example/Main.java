package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
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