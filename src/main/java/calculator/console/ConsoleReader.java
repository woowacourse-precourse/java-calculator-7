package calculator.console;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader {
    public String read(){
        return Validator.validate(Console.readLine());
    }

    private static class Validator{
        public static String validate(String target){
            return target;
        }
    }
}
