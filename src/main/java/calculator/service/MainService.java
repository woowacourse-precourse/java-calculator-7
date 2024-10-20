package calculator.service;

import java.util.ArrayList;

import static calculator.exception.MainException.containsNegative;
import static calculator.exception.MainException.putError;

public class MainService {

    private int result = 0;
    private ArrayList<Integer> checkLocated;
    private ArrayList<Integer> numberList;

    public int sumDelimitedStr(String str){
        checkLocated = new ArrayList(); // 몇 번째 문자열에 구분자가 있는지 확인하는 장소
        numberList = new ArrayList(); // 문자열을 토대로 분리하여 숫자 넣는 장소

        try{
            //아무것도 없는 수 일 경우 0을 리턴
            if(str.length() == 0){
                return 0;
            }

            //구분자가 어디에 위치에 있는지 확인하고 List에 담는 과정
            extractedDelimited(str, checkLocated);

            //구분자에 따라 숫자를 List에 넣어주는 과정
            extractNumber(str, checkLocated, numberList);

            //각 구분자를 제외한 곳에 양수가 들어있는지 확인하는 과정
            if(containsNegative(numberList)){
                throw new IllegalArgumentException(containsNegative);
            };

            //결과를 구하는 메서드
            result = calculateNumber(numberList, result);
        }catch (Exception e){
            throw new IllegalArgumentException(putError);
        }

        return result;
    }

    private void extractedDelimited(String str, ArrayList<Integer> strList) {
        for(int i = 0; i < str.length(); i++){
            //각 , 또는 : 이 나오는 위치를 strList에 담기.
            if(str.charAt(i) == ',' || str.charAt(i) == ':'){
                strList.add(i);
            }
        }
    }

    private static int calculateNumber(ArrayList<Integer> numberList, int result) {

        for(int i = 0; i < numberList.size(); i++){
            result += numberList.get(i);
        }
        return result;
    }

    private void extractNumber(String str, ArrayList<Integer> strList, ArrayList<Integer> numberList) {
        for(int i = 0; i < strList.size(); i++){
            //맨 처음 숫자 확인해서 넣어주기
            if(i == 0){
                numberList.add(Integer.parseInt(str.substring(0, strList.get(i))));
            }

            //마지막 문자이면 넣어주기
            if(i == strList.size() - 1){
                numberList.add(Integer.parseInt(str.substring(strList.get(i) + 1, str.length())));
            }else{
                numberList.add(Integer.parseInt(str.substring(strList.get(i) + 1, strList.get(i + 1))));
            }
        }
    }


    private boolean containsNegative(ArrayList<Integer> numberList) {
        return numberList.stream().anyMatch(num -> num < 0); // 음수가 하나라도 있으면 true 반환
    }

}
