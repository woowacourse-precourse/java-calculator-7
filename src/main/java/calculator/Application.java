package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        String input = Console.readLine(); // 입력
        int endIndex = findSeparatorEndIndex(input); // 커스텀 구분자 입력의 끝부분('\n' 다음 인덱스)
        Set<String> separatorSet = parseSeparator(input, endIndex); // 구분자를 전부 모아놓을 Set
        String afterSeparator = endIndex<=input.length()-1 ? input.substring(endIndex) : ""; // 커스텀 구분자 입력을 전부 받은 후의 문자열('\n' 다음 문자열)
        BigInteger ans = processNumber(afterSeparator, separatorSet); // 합을 저장할 결과값
        System.out.println("결과 : " + ans); // 출력
    }
    // 구분자 Set을 만드는 함수
    public static Set<String> parseSeparator(String s, int endIndex) {
        Set<String> separatorSet = new HashSet<>();
        separatorSet.add(":"); // 이 2개는 기본
        separatorSet.add(",");
        if (endIndex < 4) { // 만약 "//\n" 정도도 없다면 커스텀 구분자 입력 없음
            return separatorSet;
        }
        for (char c : s.substring(2, endIndex - 2).toCharArray()) { // "//" 부터 "\n"의 앞부분까지 한글자씩 구분자 저장
            separatorSet.add(c + "");
        }
        return separatorSet;
    }

    // 구분자 끝을 찾는 함수
    private static int findSeparatorEndIndex(String input) {
        if (input.startsWith("//")) { // "//"로 입력을 시작해야만 커스텀 구분자 입력 가능
            for (int i = 2; i < input.length(); i++) { // "//" 이후부터 끝까지
                if (input.charAt(i) == '\\') { // 만약 "\" 발견시
                    if (i < input.length() - 1 && input.charAt(i + 1) == 'n') { // index out of bound 대비, "\n"이어야 끝이므로 "n"이 붙어있는지 확인
                        return Math.min(i+2,input.length()-1); // 만약 끝이 "\n"이라면 마지막 인덱스 반환, 아니라면 다음 인덱스 반환
                    }
                }
            }
        }
        return 0; // 커스텀 구분자가 없는 경우
    }
    // 숫자의 합을 계산하는 함수
    private static BigInteger processNumber(String input, Set<String> separatorSet) {
        if (input.isEmpty()) return BigInteger.ZERO; // 빈 입력은 합이 0
        BigInteger sum = BigInteger.ZERO;
        String regex = String.join("|", separatorSet); // 정규 표현식 or를 위해 "|"로 구분자 붙이기
        String[] tokens = input.split(regex); // 구분자 중 하나라도 보이면 분리
        for (String token : tokens) {
            if (!token.isEmpty()) { // 비어있지 않고
                if (isValid(token)) { // 구분자로 분리한 뭉치 안에 숫자가 아닌 문자가 있지 않다면
                    sum = sum.add(BigInteger.valueOf(Integer.parseInt(token))); // 합산
                }
            }
        }
        return sum;
    }
    // 구분자로 나눈 뭉치가 숫자로만 되어있는지 확인하는 함수
    private static boolean isValid(String input) {
        for (char c : input.toCharArray()) { 
            if ((int) c < 48 || (int) c > 57) { // 아스키 코드 48은 0, 57은 9이므로 이 밖은 문자로 간주함
                throw new IllegalArgumentException("Invalid Input"); // 에외 발생
            }
        }
        return true;
    }
}
