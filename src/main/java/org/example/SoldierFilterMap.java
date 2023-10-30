package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoldierFilterMap {

    public static void main(String[] args) {
        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(new Soldier (4, "Jens"));
        soldiers.add(new Soldier (4, "Jens1"));
        soldiers.add(new Soldier (3, "Jens2"));
        soldiers.add(new Soldier (1, "Ole"));
        soldiers.add(new Soldier (5, "Kurt"));

        Predicate<Soldier> isHighRanked = soldier -> soldier.getRank()>3;
        Predicate<Soldier> startsWithJ = s -> s.getName().startsWith("J");

        Stream<Soldier> highSoldiers = soldiers.stream().filter(isHighRanked);
        highSoldiers.forEach(s -> System.out.println(s));

        Stream<Soldier> highAndJ = soldiers.stream().filter(isHighRanked).filter(startsWithJ);
        //highAndJ.forEach(s -> System.out.println(s));

        List<Soldier> highAndJList = highAndJ.collect(Collectors.toList());
        //Function<Integer, String> f1 = a -> a.toString();
        Function<Soldier, String> getNames = sold -> sold.getName();

        List<String> lst = highAndJList.stream().map(getNames).collect(Collectors.toList());
        lst.forEach(s -> System.out.println(s));

    }

}
