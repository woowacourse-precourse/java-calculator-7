package calculator;

import java.util.HashSet;
import java.util.Set;

public class DelimiterParser {
    private Set<String> delimiters = new HashSet<>();
    private int parseIndex = 0;

    public void addDelimiters(String delimiter){
        delimiters.add(delimiter);
    }

    public Set<String> getDelimiters(){
        return delimiters;
    }
    public int addParseIndex(){
        return ++parseIndex;
    }

    public int getParseIndex(){
        return parseIndex;
    }

    public int parse(String input){

        // 커스텀 구분자 있는지 확인
        while (input.length() > 2 && parseIndex + 1 < input.length() && input.charAt(parseIndex) == '/' && input.charAt(parseIndex + 1) == '/') {
            parseIndex += 2;  // "//" 스킵
            StringBuilder sepLetter = new StringBuilder();
            boolean endFlagChk = false;

            // 새로운 구분자 추출
            while (parseIndex + 1 < input.length() && (input.charAt(parseIndex) != '\\' || input.charAt(parseIndex + 1) != 'n')) {
                if (input.charAt(parseIndex) == '\\' && input.charAt(parseIndex + 1) == 'n') {
                    endFlagChk = true;
                    break;
                }
                sepLetter.append(input.charAt(parseIndex));
                parseIndex++;
            }

            System.out.println("cur 구분자: " + sepLetter);
            if (endFlagChk = true) {
                delimiters.add(sepLetter.toString());
                parseIndex += 2;  // '\n'을 스킵
            }
        }

        // 디버깅: 구분자 확인
        System.out.println("sep: ");
        for (String sep : delimiters) {
            System.out.println(sep);
        }

        return parseIndex;
    }
}
