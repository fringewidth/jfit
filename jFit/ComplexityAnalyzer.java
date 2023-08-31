package jFit;
import java.util.Arrays;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class ComplexityAnalyzer {
    public static void generateMatPlotLib(long startRange, long endRange, long incrementValue, EFFICIENCY_CLASS efficiencyClass){
        long pointCount=(endRange-startRange)/incrementValue;
        Pair<String, Integer> objectiveFunctionBody=chooseObjectiveFunction(efficiencyClass);
        int argsLength=objectiveFunctionBody.u;
        String objectiveFunctionArgs=generateObjectiveFunctionArgs(argsLength);
        try {
            FileWriter fileWriter = new FileWriter("fit.py");

            fileWriter.write(
            "\nfrom scipy.optimize import curve_fit"
            +"\nimport numpy as np"
            +"\nfrom matplotlib import pyplot as plt"
            +"\nfrom math import factorial"
            +"\n"
            +String.format("\ndef objective(x,%s):",objectiveFunctionArgs)
            +"\n\treturn " + objectiveFunctionBody.t
            +"\n"
            +String.format("\nx=np.arange(%d, %d, %d)",startRange, endRange, incrementValue)
            +"\ny="+Arrays.toString(generateRunningTimes(startRange, endRange, incrementValue))
            +"\npopt, _ = curve_fit(objective, x, y)"
            +String.format("\n%s = popt",objectiveFunctionArgs)
            +String.format("\nx_line=np.linspace(%d,%d,%d)",startRange,endRange,pointCount)
            +String.format("\ny_line=objective(x,%s)",objectiveFunctionArgs)
            +"\nplt.scatter(x, y)"
            +"\nplt.plot(x_line, y_line,\"r-\")"
            +"\nplt.show()"
        );
        
        System.out.println("Written to file.py successfully");
        fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    private static String generateObjectiveFunctionArgs(int argsLength) {
        if(argsLength<1){
            return null;
        }
        String argsList="";
        char argument='a';
        for(int i=0; i<argsLength-1; i++){
            argsList+=argument;
            argsList+=",";
            argument++;
        }
        argsList+=argsLength!=1?argument:"";

        return argsList;
    }

    private static long[] generateRunningTimes(long startRange, long endRange, long incrementValue) {
        long pointCount=(endRange-startRange)/incrementValue;
        long runningTimes[] = new long[(int) pointCount];
        long startTime, endTime, totalTime;
        int i=0;
            for(long n=startRange; n<endRange; n+=incrementValue){
            long[] testArray = randomizeArray(n);
            startTime = System.nanoTime();
            Main.method(testArray, n);
            endTime=System.nanoTime();
            totalTime=endTime-startTime;
            runningTimes[i]=totalTime;
            i++;
        }
        return runningTimes;
    }

    private static long[] randomizeArray(long n) {
        long[] randomArray = new long[(int)n];
        Random random = new Random();
        for(int i=0; i<n; i++){
            randomArray[i]=random.nextLong();
        }
        return randomArray;
    }

    private static Pair<String, Integer> chooseObjectiveFunction(EFFICIENCY_CLASS efficiencyClass) {
        
        switch(efficiencyClass){
            case CONSTANT:
                return new Pair<String, Integer>("a", 1);

            case LOGARITHMIC:
                return new Pair<String, Integer>("a*np.log2(x)+b", 2);

            case POLYNOMIAL:
                return new Pair<String, Integer>("a*x**2+b", 2);

            case LINEARITHMIC:
                return new Pair<String, Integer>("a*x*np.log2(x)+b", 2);

            case EXPONENTIAL:
            return new Pair<String, Integer>("a*2**(b*x)", 2);

            case FACTORIAL:
                return new Pair<String, Integer>("a*factorial(x)", 1);

            default:
                return new Pair<String, Integer>("help me debug", 0);
        }
    }
}