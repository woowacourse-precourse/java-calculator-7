package calculator.parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 구분자를 설정하고, 구분자에 따라 데이터를 파싱한다.
 */
public class Parser {
    private final HashSet<String> separators = new HashSet<>();
    private String input;

    /**
     * @param basicSep 기본 구분자를 지정합니다
     */
    public Parser(List<String> basicSep) {
        separators.addAll(basicSep);
    }

    /**
     * parsing 할 문자열을 업데이트합니다.
     * @param input 업데이트할 문자열
     * @return 해당 객체를 반환합니다
     */
    public Parser updateInput(String input) {
        this.input = input;
        return this;
    }

    /**
     * updateInput 을 통해 받은 문자열로 구분자를 추가합니다.
     * @see calculator.parser.Parser#updateInput
     */
    public void addSeparators() {
        for(char c : input.toCharArray()) {
            separators.add(String.valueOf(c));
        }
    }

    /**
     * 입력받은 피연산자 문자열을 대상으로 parsing 후, 피연산자 List 를 반환합니다.
     *  parseInteger, validatePolicies 를 순차적으로 확인합니다.
     * @param operandPolicies parsing 과정에서 확인할 제한 사항들입니다
     * @return 피연산자 List 를 반환합니다
     * @throws IllegalArgumentException Integer 변환에 실패하거나, operandPolicies 를 통과하지 못 했을 때, 발생합니다
     * @see calculator.parser.Parser#parseInteger(String)
     * @see calculator.parser.Parser#validatePolicies(Integer, List)
     */
    public List<Integer> parse(List<Predicate<Integer>> operandPolicies) {
        String exp = String.join("|", separators);
        return Pattern.compile(exp).splitAsStream(input)
                .map(this::parseInteger)
                .map(num -> validatePolicies(num, operandPolicies))
                .collect(Collectors.toList());
    }

    /**
     * 주어진 문자열을 Integer 로 변환합니다.
     * @param s Integer 로 형변환할 문자열
     * @return 변환된 Integer
     * @throws IllegalArgumentException 형변환에 실패했을 때 발생합니다
     */
    private Integer parseInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid operand: " + s, e);
        }
    }

    /**
     * 주어진 제한사항을 확인하고 false 시, exception 을 반환합니다.
     * @param num 제한사항을 확인할 Integer
     * @param operandPolicies 확인할 제한사항들
     * @return 모든 제한사항 통과시 주어진 num 을 그대로 반환합니다
     */
    private Integer validatePolicies(Integer num, List<Predicate<Integer>> operandPolicies) {
        for (Predicate<Integer> policy : operandPolicies) {
            if (!policy.test(num)) {
                throw new IllegalArgumentException("Illegal policy: " + policy + "\n\tfor: " + num);
            }
        }
        return num;
    }
}
