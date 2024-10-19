package calculator.part;

import java.beans.BeanProperty;
import java.util.Arrays;

public class CalculatorAdder {

    public int calculateAdd(int[] arrays){
        return Arrays.stream(arrays).sum();
    }

}
