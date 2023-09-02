# jFit
jFit is a Java utility that automates the generation of Python code for empirical complexity analysis by producing plots of time against input size (n) using Matplotlib, and fitting an appropriate curve

## Features
- ### Automated python code generation

## Prerequisites
- jFit relies on the Java Runtime Environment (JRE) for its proper execution. To run jFit, a compatible version of JDK and a compatible JVM must be installed on the system. Please refer to the official documentation for specific version requirements
- To execute the generated Python code, install the following packages using pip
    ```sh
    pip install scipy numpy matplotlib
    ```

## Installation
- Clone the git repository:
    ```sh
    git clone https://github.com/fringewidth/jfit.git
    ```
- Open the package in a Java IDE of your choice(e.g., VSCode):
    ```sh
    code jfit/jFit
    ```

## Using jFit
- Replace the body of ```public static void method(long[] array, long n)``` with the body of the java method of your choice. The ```array[]``` parameter represents the array to be manipulated, and ```n``` signifies the array's length.

- **Important:** Limitation on array analysis:
Please note that jFit currently supports the analysis of algorithms that work with a single, one dimensional array only.
- Modify the parameters of ```ComplexityAnalyzer.generateMatPlotLib()``` in the ```main``` method. Adjust the parameters of:
    - ```startRange```: Start of the input size `n`
    - ```endRange```: End (non-inclusive) of the size `n`
    - ```incrementValue```: Step size of input size `n`
    - ```efficiencyClass```: Specify the efficiency class for your method. jFit generates empirical data on the running time across the specified `n` range and fits a corresponding curve.

- The following efficiency classes are currently avaliable:
    - ```EFFICIENCY_CLASS.CONSTANT``` for $O(1)$ complexities
    - ```EFFICIENCY_CLASS.POLYNOMIAL``` for $O(n^2)$ complexities
    - ```EFFICIENCY_CLASS.LINEARITHMIC``` for $O(n\log n)$ complexities
    - ```EFFICIENCY_CLASS.EXPONENTIAL``` for $O(2^n)$ complexities
    - ```EFFICIENCY_CLASS.FACTORIAL``` for $O(n!)$ complexities<br>
    [Support for $O(n^k)$ is planned]

- Run the script.