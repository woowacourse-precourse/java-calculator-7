package calculator.service;

import calculator.domain.Delimiters;
import calculator.domain.Numbers;

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

    public LinkedList<String> extractStringNumbers(String inputString) {
        LinkedList<String> numbers = new LinkedList<>();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                number.append(inputString.charAt(i));
            } else {
                addNumberIfNotEmpty(numbers, number.toString());
                number = new StringBuilder();
            }
        }
        addNumberIfNotEmpty(numbers, number.toString());
        return numbers;
    }

    private void addNumberIfNotEmpty(LinkedList<String> numbers, String number){
        if (!number.isEmpty()) {
            numbers.add(number);
        }
    }

    public Numbers addStringNumberToNumbers(LinkedList<String> stringNumbers, Numbers numbers){
        for (String stringNumber : stringNumbers) {
            if (stringNumber.isEmpty()) continue;
            numbers.getNumbersList().add(Integer.parseInt(stringNumber));
        }
        return numbers;
    }


}

