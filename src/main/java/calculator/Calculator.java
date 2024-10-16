package calculator;

import separator.CustomSeparator;
import separator.CustomSeparatorFormat;
import separator.DefaultSeparator;
import separator.Separator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private Separator defaultSeparator;

    public Calculator(DefaultSeparator defaultSeparator) {
        this.defaultSeparator = defaultSeparator;
    }
    public Calculator(List<String> separatorData) {
        this.defaultSeparator = new DefaultSeparator(separatorData);
    }

    public void run(){
        String inputData = readCalculatorInput();
        Separator separator = generateSeparators(inputData);

    }

    public String readCalculatorInput(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputData = br.readLine();
            return inputData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Separator generateSeparators(String inputData){
        if(validateStartChar(inputData)){
            return this.defaultSeparator;
        }else {
            CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
            validateCustomSeparatorFormat(inputData,customSeparatorFormat.getPattern());
            return new CustomSeparator(inputData,customSeparatorFormat);
        }
    }

    public Boolean validateStartChar(String inputData) {
        try {
            Integer.parseInt(inputData.substring(0,1));
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }


    public boolean validateCustomSeparatorFormat(String inputData,Pattern customSeparatorFormat){
        Matcher matcher = customSeparatorFormat.matcher(inputData);
        if(!matcher.find()){
            throw new IllegalArgumentException("커스텀구분자 생성형식을 확인해주세요.");
        }else {
            return true;
        }

    }

}
