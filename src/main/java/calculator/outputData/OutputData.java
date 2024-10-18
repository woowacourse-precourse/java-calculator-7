package calculator.outputData;

import camp.nextstep.edu.missionutils.Console;

public class OutputData {
    private OutputData(){}

    public static void Printout(int sum){
        String printing = ConvertIntStr(sum);
        System.out.println("결과 : " + printing);
        Console.close();
    }

    public static String ConvertIntStr(int sum){
        return Integer.toString(sum);
    }
}
