package jFit;

public class Main {

    public static void method(long[] array, long n) {
        long temp;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(array[j]>array[j+1]){
                    temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
        }
    }

    public static void main(String[] args){
        ComplexityAnalyzer.generateMatPlotLib(0, 5000, 10, EFFICIENCY_CLASS.POLYNOMIAL);
    }

}
