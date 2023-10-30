package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MainForEach {

    static void forEachString(List<String> listOfStrings, Consumer<String> consumer) {
        for (String s: listOfStrings) {
            consumer.accept(s);
        }
    }

    static <T> void forEach(List<T> lst, Consumer<T> consumer) {
        for (T s: lst) {
            consumer.accept(s);
        }
    }

    public static void main(String[] args) {
        Consumer<String> toUpper = x -> System.out.println(x.toUpperCase());
        toUpper.accept("viggo");
        Consumer<Long> square = t -> System.out.println(t * t);
        square.accept(50l);
        List<String> lstStr = Arrays.asList("hej", "du", "der");
        //forEachString(lstStr, toUpper);
        //forEach(lstStr, toUpper);

        lstStr.forEach(toUpper);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> out = x -> System.out.println(x);
        list.forEach(out);

    }


    }
