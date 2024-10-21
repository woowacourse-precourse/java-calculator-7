package calculator.business.command;

import calculator.domain.model.value.MajorData;
import calculator.domain.model.value.Separator;
import calculator.presentation.InputData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static calculator.global.AffixConst.CUSTOM_AFFIX_FORM;

public final class CalculateCommand {

    public final MajorData majorData;
    public final Separator customSeparators;

    public CalculateCommand(final InputData userInput) {
        int majorDataIndex = userInput.lastIndexOfCustomInfo();

        this.majorData = setMajorData(userInput, majorDataIndex);
        this.customSeparators = setCustomSeparators(userInput, majorDataIndex);
    }

    private MajorData setMajorData(final InputData userInput, final int majorDataIndex) {
        String majorInfo = userInput.substringAfter(majorDataIndex);
        return new MajorData(majorInfo);
    }

    private Separator setCustomSeparators(final InputData userInput, final int majorDataIndex) {

        String customInfo = userInput.substringBefore(majorDataIndex);
        String[] splitData = customInfo.split(CUSTOM_AFFIX_FORM);

        String customSeparatorText = Arrays.stream(splitData)
                .filter(data -> !data.isEmpty())
                .collect(Collectors.joining());

        return new Separator(customSeparatorText);
    }
}
