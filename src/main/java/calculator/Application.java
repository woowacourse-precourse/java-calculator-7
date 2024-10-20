package calculator;

import calculator.tool1.StringChecker;
import calculator.tool1.StringInput;
import calculator.tool2.Extracts;
import calculator.tool3.Answer;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Application {

  public static void main(String[] args) {

    //입력값 받기
    StringInput input = new StringInput();

    Extracts extracts = new Extracts(input.getNums(), input.getDelimiterRegex());

    extracts.splitNums();

    Answer answer = new Answer(extracts.getNums());

    answer.calSum();
    answer.printAns();

  }

}
