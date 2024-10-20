package calculator.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.exception.MainException.containsNegative;
import static calculator.exception.MainException.putError;

public class MainService {

    private int result = 0;
    private char customStr = ';';
    private String newStr = "";
    private ArrayList<Integer> checkLocated;
    private ArrayList<Integer> numberList;

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\\\n"; // 커스텀 구분자 패턴
    private static List<Character> DEFAULT_DELIMITERS = Arrays.asList(',', ':'); // 기본 구분자 목록


    public int sumDelimitedStr(String str){
        checkLocated = new ArrayList(); // 몇 번째 문자열에 구분자가 있는지 확인하는 장소
        numberList = new ArrayList(); // 문자열을 토대로 분리하여 숫자 넣는 장소
        newStr = str; // 커스텀 문자가 나올시 잘라주기 위한 newStr


        try{
            //아무것도 없는 수 일 경우 0을 리턴
            if(newStr.length() == 0){
                return 0;
            }

            //앞의 기본 구분자를 확인
            extractCustomStr(newStr);

            //구분자가 어디에 위치에 있는지 확인하고 List에 담는 과정
            extractedDelimited(newStr, checkLocated, customStr);

            //구분자에 따라 숫자를 List에 넣어주는 과정
            extractNumber(newStr, checkLocated, numberList);

            //각 구분자를 제외한 곳에 양수가 들어있는지 확인하는 과정
            if(containsNegative(numberList)){
                throw new IllegalArgumentException(containsNegative);
            }

            //결과를 구하는 메서드
            result = calculateNumber(numberList, result);
        }catch (Exception e){
            throw new IllegalArgumentException(putError);
        }

        return result;
    }

    private void extractCustomStr(String str) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(str);

        // 패턴이 일치하는 경우 커스텀 구분자를 추출 한 걸로 계산
        if (matcher.find()) {
            customStr = matcher.group(1).charAt(0); // 커스텀 구분자 추출
            newStr = str.substring(matcher.end()); // 커스텀 구분자 이후의 문자열로 갱신

            // 커스텀 구분자를 DEFAULT_DELIMITERS에 추가
            if (!DEFAULT_DELIMITERS.contains(customStr)) {
                DEFAULT_DELIMITERS = new ArrayList<>(DEFAULT_DELIMITERS);
                DEFAULT_DELIMITERS.add(customStr);
            }

        } else {
            newStr = str; // 커스텀 구분자가 없으면 입력 문자열 그대로
        }
    }




    private void extractedDelimited(String newStr, ArrayList<Integer> checkLocated, char customStr) {
        // 기본 구분자 및 커스텀 구분자의 위치를 찾는 과정
        for (int i = 0; i < newStr.length(); i++) {
            if (DEFAULT_DELIMITERS.contains(newStr.charAt(i))) {
                checkLocated.add(i);
            }
        }
    }


    /*
     * 계산 해주는 메서드
     */
    private int calculateNumber(ArrayList<Integer> numberList, int result) {
        for(int i = 0; i < numberList.size(); i++){
            result += numberList.get(i);
        }
        //숫자 단일로 나올 경우
        if (numberList.isEmpty() && Character.isDigit(newStr.charAt(0))) {
            result = newStr.charAt(0) - '0'; // 문자로부터 정수로 변환
        }
        return result;
    }

    private void extractNumber(String newStr, ArrayList<Integer> checkLocated, ArrayList<Integer> numberList) {
        for (int i = 0; i < checkLocated.size(); i++) {
            //아무런 숫자가 안들어가 있을 때
            if (i == 0) {
                numberList.add(Integer.parseInt(newStr.substring(0, checkLocated.get(i))));
            }

            //마지막 문자이면 넣어주기
            if (i == checkLocated.size() - 1) {
                numberList.add(Integer.parseInt(newStr.substring(checkLocated.get(i) + 1)));
            } else {
                numberList.add(Integer.parseInt(newStr.substring(checkLocated.get(i) + 1, checkLocated.get(i + 1))));
            }
        }
    }


    private boolean containsNegative(ArrayList<Integer> numberList) {
        return numberList.stream().anyMatch(num -> num < 0); // 음수가 하나라도 있으면 true 반환
    }

}
