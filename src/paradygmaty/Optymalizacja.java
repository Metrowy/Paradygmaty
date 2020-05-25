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
        System.out.println("Optymalizacja lokalna (" + repeat + " powtórzeń)");
        minimizeOperations();
        limitedVariables();
        constantValues();
        System.out.println("---------");
        System.out.println("Optymalizacja globalna (" + repeat + " powtórzeń)");
        developLoops();
        joinLoops();
    }

    private static void joinLoops()
    {
        System.out.println("---------");
        System.out.println("Łączenie pętli");
        System.out.println("");
        int a = 0;
        int b = 0;
        long result;
        long start = System.currentTimeMillis();
        for (int i=0; i<repeat; i++)
        {
            for (int j=0; j<200; j++)
            {
                a+=j;
            }
            for (int j=0; j<200; j++)
            {
                b+=j;
            }
        }
        long finish = System.currentTimeMillis();
        result = finish-start;
        totalTimeWithoutOpt += result;
        System.out.println("Bez optymalizacji");
        System.out.println("");
        System.out.println("for (int j=0; j<200; j++)");
        System.out.println("\ta+=j;");
        System.out.println("for (int j=0; j<200; j++)");
        System.out.println("\tb+=j;");
        System.out.println("");
        System.out.println("czas: " + result + " ms");
        start = System.currentTimeMillis();
        for (int i = 0; i < repeat; i++)
        {
            for (int j = 0; j < 200; j++)
            {
                a+=j;
                b+=j;
            }
        }
        finish = System.currentTimeMillis();
        result = finish-start;
        totalTimeWithOpt += result;
        System.out.println("");
        System.out.println("Z optymalizacją");
        System.out.println("");
        System.out.println("for (int j=0; j<200; j++) {");
        System.out.println("\ta+=j;");
        System.out.println("\tb+=j;");
        System.out.println("}");
        System.out.println("");
        System.out.println("czas: " + result + " ms");
    }

    public static void developLoops()
    {
        System.out.println("---------");
        System.out.println("Rozwijanie pętli");
        System.out.println("");
        double[] tab = new double[10];
        long result;
        long start = System.currentTimeMillis();
        for(int i = 0; i < repeat; i++)
        {
            for (int j=0; j<tab.length; j++)
            {
                tab[j] = 997;
            }
        }
        long finish = System.currentTimeMillis();
        result = finish-start;
        totalTimeWithoutOpt += result;
        System.out.println("Bez optymalizacji (for (int i=0; i<tab.length; i++) tab[i]=997;) czas: " +
                result + " ms");
        start = System.currentTimeMillis();
        for(int i = 0; i < repeat; i++)
        {
            tab[0] = 997;
            tab[1] = 997;
            tab[2] = 997;
            tab[3] = 997;
            tab[4] = 997;
            tab[5] = 997;
            tab[6] = 997;
            tab[7] = 997;
            tab[8] = 997;
            tab[9] = 997;
        }
        finish = System.currentTimeMillis();
        result = finish-start;
        totalTimeWithoutOpt += result;
        System.out.println("Z optymalizacją (10 razy tab[i] = 997) czas: " +
                result + " ms");


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

    private static void minimizeOperations() {
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
        for (int i = 0; i < repeat; i++)
            r = a*b*c+a*b*d+a*e;
        long finish = System.currentTimeMillis();
        result = finish-start;
        totalTimeWithoutOpt += result;
        System.out.println("Bez optymalizacji (r=a*b*c+a*b*d+a*e) czas: " + result + " ms");
        start = System.currentTimeMillis();
        for (int i = 0; i < repeat; i++)
            r=a*(b*(c+d)+e);
        finish = System.currentTimeMillis();
        result = finish-start;
        totalTimeWithOpt += result;
        System.out.println("Z optymalizacją (r=a*(b*(c+d)+e)) czas: " + result + " ms");
    }


}
