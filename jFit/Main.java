package jFit;

public class Main {

    public static void method(long[] array, long n) {
        /*
         replace function body with your function
         */
        int sum=0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++)
                sum+=array[i];
        }  
    }

    public static void main(String[] args){
        ComplexityAnalyzer.generateMatPlotLib(0, 5000, 10, EFFICIENCY_CLASS.POLYNOMIAL);
    }

}
