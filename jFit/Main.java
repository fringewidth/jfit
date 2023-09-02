package jFit;
import java.io.IOException;
public class Main {

    public static void method(long[] array, int n) {
        /*
         replace function body with your function.
         */
        quickSort(array, 0, n - 1);
    }

    private static void quickSort(long[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(long[] array, int low, int high) {
        long pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(long[] array, int i, int j) {
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        ComplexityAnalyzer.generatePy(0, 5000, 10, EFFICIENCY_CLASS.LINEARITHMIC);
        String pyFilePath = "../fit.py";
        runPy(pyFilePath);

    }

    public static void runPy(String pyFilePath){
        ProcessBuilder processBuilder = new ProcessBuilder("python3",pyFilePath);
        processBuilder.redirectErrorStream(true);

        Process process;
        try {
            process = processBuilder.start();
            int exitCode = process.waitFor();
            if(exitCode==0){
                System.out.println(pyFilePath + "run successfully");
            }
            else{
                System.out.println(pyFilePath + "Execution failed. Manually run 'file.py'");
            }
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}
