package org.example;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class RandomNumbers {

    public static void main(String[] args) {
        Supplier<Double> ran = () -> Math.random(); //generate random numbers between 0 and 1
        Stream<Double> randomNumbers = Stream.generate(ran); //generate forever
        Function<Double, Long> dblround = d -> Math.round(d*100); //convert numbers 0-1 to 1-100
        Predicate<Long> longEqual = rannum -> rannum % 2 == 0; //we only want even numbers
        double sumd = randomNumbers.map(dblround).filter(longEqual) //get even numbers
                .limit(12).mapToDouble(d->d).sum(); //limit forever to 12 numbers, and then sum. could also call e.g. average() or max()
        System.out.println("sum af 12numre=" + sumd);

        Stream<Double> randomNumbers2 = Stream.generate(ran); //generate forever
        var optD = randomNumbers2.map(dblround).filter(longEqual) //get even numbers
                .limit(12).mapToDouble(d->d).average();
        System.out.println(optD.getAsDouble());


        //obj.forEach(System.out::println);
        //Stream<Long> num100 = randomNumbers.map(dblround);
        //num100.forEach(System.out::println);

        //randomNumbers.forEach(s -> System.out.println(s));

    }

}
