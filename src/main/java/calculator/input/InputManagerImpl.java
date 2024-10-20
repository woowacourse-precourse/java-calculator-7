package calculator.input;

import calculator.Constants;
import calculator.repository.number.NumberRepository;
import calculator.repository.separator.SeparatorRepository;
import calculator.utils.SeparatorUtils;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Input과 관련된 객체
 */
public class InputManagerImpl implements InputManager {

    private final NumberRepository numberRepository;
    private final SeparatorRepository separatorRepository;

    //중복 호출 방지 필드
    private boolean isSaved = false;

    public InputManagerImpl(NumberRepository numberRepository, SeparatorRepository separatorRepository) {
        this.numberRepository = numberRepository;
        this.separatorRepository = separatorRepository;
    }

    /**
     * Console API를 이용해서 구분자와 숫자를 리포지토리에 저장함
     *
     * @throws IllegalStateException saveSeparatorAndNumbers를 여러번 호출할 경우 발생
     * @throws IllegalArgumentException 입력의 형식이 잘못되었을 때 발생한다
     */
    @Override
    public void saveSeparatorAndNumbers() {

        //메서드 중복 호출을 방지
        if(isSaved) {
            throw new IllegalStateException("이미 저장했습니다");
        }
        isSaved = true;

        //첫번째 라인 읽기
        //비어있으면 에러를 잡고 빈 문자열을 넣는다
        String line;
        try {
            line = Console.readLine();
        } catch (NoSuchElementException e) {
            line = "";
        }

        try {
            //s가 구분자인지 확인
            if (SeparatorUtils.hasSeparator(line)) {
                List<String> splitList = splitSeparatorAndNumbers(line);

                //splitList의 0번 인덱스에 있는 구분자를 저장
                separatorRepository.saveSeparator(splitList.get(0));

                //splitList의 1번 인덱스에 있는 숫자를 저장
                numberRepository.saveNumbers(splitList.get(1));
            } else {
                //구분자가 없으므로 숫자만 저장
                numberRepository.saveNumbers(line);
            }
        } catch (NoSuchElementException e) {
            //readLine에서 읽을 라인이 없을때 발생한다
            throw new IllegalArgumentException("입력의 형식이 잘못되었습니다");
        }

        //Console의 모든 기능이 종료되었음으로 close를 통해 scanner를 닫는다
//        Console.close();
    }

    /**
     * @throws IllegalArgumentException \\n이 발견되지 않을때 예외 발생
     *
     * @param line 구분자와 숫자가 포함되어있는 전체 문자열
     *
     * @return
     * 구분자를 인덱스0에 리턴
     * 숫자를 인덱스1에 리턴
     */
    private List<String> splitSeparatorAndNumbers(final String line) {
        List<String> splitList = new ArrayList<>();
        int index = line.indexOf(Constants.POSTFIX);

        // \\n이 발견되지 않을 때
        if(index == -1) {
            throw new IllegalArgumentException("입력의 형식이 잘못되었습니다");
        }

        splitList.add(line.substring(0, index+Constants.POSTFIX.length()));
        splitList.add(line.substring(index+Constants.POSTFIX.length()));

        return splitList;
    }
}
