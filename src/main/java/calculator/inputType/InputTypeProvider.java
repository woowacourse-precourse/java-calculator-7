package calculator.inputType;

import java.util.ArrayList;
import java.util.List;

public class InputTypeProvider {


    public static List<InputType> provideInputTypelist() {
        List<InputType> inputTypeList = new ArrayList<>();
        inputTypeList.add(new CustomInput());
        inputTypeList.add(new DefaultInput());
        return inputTypeList;
    }
}
