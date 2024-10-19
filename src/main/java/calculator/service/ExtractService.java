package calculator.service;

import calculator.domain.Delimiters;

public class ExtractService {
    public void extractDelimeter(String inputString, Delimiters delimiters){
        int startIndex = inputString.indexOf("//");
        int endIndex = inputString.indexOf("\\n");
        String customDelimeter = inputString.substring(startIndex+2, endIndex);
        if(customDelimeter.length()==1){
            delimiters.getDelimeterCollections().add(customDelimeter.charAt(0));
        }
    }
}
