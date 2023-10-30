package org.example;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class RandomNumbers {

    public static void main(String[] args) {
        Supplier<Double> ran = () -> Math.random();
        Stream<Double> randomNumbers = Stream.generate(ran);
        Function<Double, Long> dblround = d -> Math.round(d*100);
        Predicate<Long> longEqual = rannum -> rannum % 2 == 0;
        double sumd = randomNumbers.map(dblround).filter(longEqual)
                .limit(12).mapToDouble(d->d).sum();
        System.out.println("sum af 12numre=" + sumd);

        //obj.forEach(System.out::println);
        //Stream<Long> num100 = randomNumbers.map(dblround);
        //num100.forEach(System.out::println);

        //randomNumbers.forEach(s -> System.out.println(s));

    }

}
