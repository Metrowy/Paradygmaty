package paradygmaty;

import static java.lang.Math.PI;
import static java.lang.Math.atan;

public class Optymalizacja {

    private static long totalTimeWithoutOpt = 0;
    private static long totalTimeWithOpt = 0;
    private static int repeat = 1000000;

    public static void main(String[] args)
    {
        System.out.println("---------");
        System.out.println("Optymalizacja lokalna (" + repeat + "powtórzeń)");
        minimizeOperations();
        limitedVariables();
        constantValues();

    }

    public static void constantValues()
    {
        System.out.println("---------");
        System.out.println("Wyliczanie wartości stałych");
        System.out.println("");
        double a = 80;
        double b;
        double c = 90.1;
        long result;
        long start = System.currentTimeMillis();
        for(int i = 0; i < repeat; i++)
        {
            b=4*a*atan(1)/180+c;
        }
        long finish = System.currentTimeMillis();
        result = finish - start;
        totalTimeWithoutOpt += result;
        System.out.println("Bez wyliczenia (b=4*a*atan(1)/180+c) czas: " +
                result + " ms");
        start = System.currentTimeMillis();
        for(int i = 0; i < repeat; i++)
        {
            b=a*0.017453292519943295+c;
        }
        finish = System.currentTimeMillis();
        result = finish - start;
        totalTimeWithOpt += result;
        System.out.println("Z wyliczeniem (b=a*0.017453292519943295+c) czas: " +
                result + " ms");

    }

    public static void limitedVariables()
    {
        System.out.println("---------");
        System.out.println("Stosowanie oszczędniejszych operacji");
        System.out.println("");
        double a = 80;
        double r;
        long result;
        long start = System.currentTimeMillis();
        for(int i = 0; i < repeat; i++)
        {
            r = 3*a;
        }
        long finish = System.currentTimeMillis();
        result = finish - start;
        totalTimeWithoutOpt += result;
        System.out.println("Bez optymalizacji (r=3*a) czas: " + result + " ms");
        start = System.currentTimeMillis();
        for(int i = 0; i < repeat; i++)
        {
            r=a+a+a;
        }
        finish = System.currentTimeMillis();
        result = finish - start;
        totalTimeWithOpt += result;
        System.out.println("Z optymalizacją (r=a+a+a) czas: " + result + " ms");
    }

    private static void minimizeOperations()
    {
        System.out.println("---------");
        System.out.println("Minimalizacja liczby operacji");
        System.out.println("");
        double a = 80;
        double b = 2;
        double c = 90.1;
        double d = 3;
        double e = 4;
        double r;
        long result;
        long start = System.currentTimeMillis();
        for(int i = 0; i < repeat; i++)
        {
            r = a*b*c+a*b*d+a*e;
        }
        long finish = System.currentTimeMillis();
        result = finish - start;
        totalTimeWithoutOpt += result;
        System.out.println("Bez optymalizacji (r = a*b*c+a*b*d+a*e) czas: " +
                result + " ms");
        start = System.currentTimeMillis();
        for(int i = 0; i < repeat; i++)
        {
            r=a*(b*(c+d)+e);
        }
        finish = System.currentTimeMillis();
        result = finish - start;
        totalTimeWithOpt += result;
        System.out.println("Z optymalizacją (r=a*(b*(c+d)+e)) czas: " +
                result + " ms");
    }


}
