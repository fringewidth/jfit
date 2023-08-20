package jFit;

public class Main {

    public static void method(long[] array, long n) {
        long sum=0;
        for(int i=0; i<n; i++){
            sum+=array[i];
        }
    }

    public static void main(String args){
        ComplexityAnalyzer.generateMatPlotLib(0, 5000, 10, EFFICIENCY_CLASS.LINEARITHMIC);
    }

}
