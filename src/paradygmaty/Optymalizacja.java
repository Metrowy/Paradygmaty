package paradygmaty;

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

    }

    public static void limitedVariables()
    {

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
