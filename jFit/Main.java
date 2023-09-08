package jFit;
import java.io.IOException;
public class Main {

    public static void method(long[] array, int n) {
        /*
         replace function body with your function.
         */
        double ln7 = Math.log(7);
        double logn = Math.log(array[n-1])/ln7;
    }


    public static void main(String[] args){
        ComplexityAnalyzer.generatePy(1, 5001, 10, EFFICIENCY_CLASS.CONSTANT);
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