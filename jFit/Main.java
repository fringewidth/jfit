package jFit;
import java.io.IOException;
public class Main {

    public static void method(long[] array, long n) {
        /*
         replace function body with your function.
         */
        int result=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += array[i] * array[j];
            }
        }
    }

    public static void main(String[] args){
        ComplexityAnalyzer.generateMatPlotLib(0, 5000, 10, EFFICIENCY_CLASS.LINEARITHMIC);
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
                System.out.println(pyFilePath + "Execution failed");
            }
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}
