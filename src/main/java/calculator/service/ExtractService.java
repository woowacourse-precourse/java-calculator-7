package calculator.service;

import calculator.domain.Delimiters;

import java.util.LinkedList;

public class ExtractService {
    public void extractDelimeter(String inputString, Delimiters delimiters){
        int startIndex = inputString.indexOf("//");
        int endIndex = inputString.indexOf("\\n");
        String customDelimeter = inputString.substring(startIndex+2, endIndex);
        if(customDelimeter.length()==1){
            delimiters.getDelimeterCollections().add(customDelimeter.charAt(0));
        }
    }

    public LinkedList<String> extractNumbers(String inputString) {
        LinkedList<String> numbers = new LinkedList<>();
        String number = "";
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                number += inputString.charAt(i);
            } else {
                if (!number.isEmpty()) {
                    numbers.add(number);
                }
                number = "";
            }
        }
        if (!number.isEmpty()) {
            numbers.add(number);
        }
        return numbers;
    }
}
