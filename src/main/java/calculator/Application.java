package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {

        String s = Console.readLine();

        // 기본 구분자 넣어줌
        HashSet<String> sepLetterHash = new HashSet<>();
        sepLetterHash.add(":");
        sepLetterHash.add(",");

        int letterIndex = 0;

        // 커스텀 구분자 있는지 확인
        while (s.length() > 2 && letterIndex + 1 < s.length() && s.charAt(letterIndex) == '/' && s.charAt(letterIndex + 1) == '/') {
            letterIndex += 2;  // "//" 스킵
            StringBuilder sepLetter = new StringBuilder();
            boolean endFlagChk = false;

            // 새로운 구분자 추출
            while (letterIndex + 1 < s.length() && (s.charAt(letterIndex) != '\\' || s.charAt(letterIndex + 1) != 'n')) {
                if (s.charAt(letterIndex) == '\\' && s.charAt(letterIndex + 1) == 'n') {
                    endFlagChk = true;
                    break;
                }
                sepLetter.append(s.charAt(letterIndex));
                letterIndex++;
            }

            System.out.println("cur 구분자: " + sepLetter);
            if (endFlagChk = true) {
                sepLetterHash.add(sepLetter.toString());
                letterIndex += 2;  // '\n'을 스킵
            }
        }

        // 디버깅: 구분자 확인
        System.out.println("sep: ");
        for (String sep : sepLetterHash) {
            System.out.println(sep);
        }
    }
}