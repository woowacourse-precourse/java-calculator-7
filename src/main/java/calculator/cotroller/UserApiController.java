package calculator.cotroller;

import calculator.model.ExtractionData;


import calculator.model.UserInputData;
import calculator.service.CalculateService;
import calculator.service.NumValidService;

import java.util.List;

public class UserApiController {
    static CalculateService calculateService = new CalculateService();
    static NumValidService numValidService = new NumValidService();
    static UserInputData userInputData = new UserInputData();
    static ExtractionData extractionData = new ExtractionData();
    static String userInput;

    //입력 받은 데이터(String) 저장하기
    public void saveData(String strs){
        //들어온 가공(X)데이터 저장
        userInputData.setInput(strs);
        userInput = userInputData.getInput();
        //입력 방식이 옳은 경우
        if(numValidService.inputValid(userInput, getSeparators())) {
            int res = calculateService.calculate(getSeparators(), userInput);
            UserRequestController.requestView(res);
        }else{
            //에러 화면 띄워주기
            UserRequestController.isIllegalArgumentElement();
        }
    }

    public List<String> getSeparators(){
        return extractionData.getSeparators();
    }

}
