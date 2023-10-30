package org.example;

import java.util.Arrays;
import java.util.List;

public class ValutaOmregner {
    public interface TwoArgumentFloat {
        public Float myFunc(Float a, Float b);
    }

    public interface TwoArgument {
        public int myFunc(int a, int b);
    }

    static int sumTwoArgFunction(List<Integer> list, TwoArgument two) {
        int sum = 0;
        for (int t : list) {
            sum += two.myFunc(t, t);
        }
        return sum;
    };

    static int valutaomregnerint(List<Integer> list, TwoArgument two, int kurs) {
        int sum = 0;
        for (int t : list) {
            sum += two.myFunc(t, kurs);
        }
        return sum;
    };

    static Float valutaomregner(List<Float> list, TwoArgumentFloat two, Float kurs) {
        Float sum = 0f;
        for (Float t : list) {
            sum += two.myFunc(t, kurs);
        }
        return sum;
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        TwoArgument twoplus = (x, y) -> x + y;
        int ss = sumTwoArgFunction(list, twoplus);
        System.out.println(ss);

        TwoArgument twomult = (x, y) -> x * y;
        ss = sumTwoArgFunction(list, twomult);
        System.out.println(ss);

        List<Integer> dollarSedler = Arrays.asList(1,5,10);
        int pengedk = valutaomregnerint(dollarSedler, twomult, 6);
        System.out.println("du har dk=" + pengedk);

        //    List<Float> dollarSedlerf = Arrays.asList(1,5,10,0.25f);
        //    int pengedk = valutaomregner(dollarSedler, twomult, 6);
        //    System.out.println("du har dk=" + pengedk);


    }

}
