package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값은 비어있을 수 없습니다.");
        }
        
        String customDelimiter = "[,:]";
        if (input.startsWith("//")) {
            int indexOfDoubleSlash = input.indexOf("//");
            int indexOfReveredSlashN = input.indexOf("\\n");
            
            customDelimiter = input.substring(indexOfDoubleSlash + 2, indexOfReveredSlashN);
            if (customDelimiter.matches(".*[+*?^$().{}|\\[\\]].*")) {
                customDelimiter = customDelimiter.replaceAll("([+*?^$().{}|\\[\\]])", "\\\\$1");
            }
            
            input = input.substring(indexOfReveredSlashN + 2);
        }
        
        String[] split = input.split(customDelimiter + "|[,:]");
        if (split.length == 0) {
            throw new IllegalArgumentException("입력된 값에 숫자가 없습니다.");
        }
        
        int result = 0;
        try {
            for (String s : split) {
                if (!s.matches("\\d+")) {
                    throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + s);
                }
                result += Integer.parseInt(s);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식이 입력되었습니다: " + e.getMessage());
        }
        
        System.out.println("결과 : " + result);
    }
}
