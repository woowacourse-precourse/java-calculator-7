package calculator.input;

import calculator.repository.number.NumberRepository;
import calculator.repository.separator.SeparatorRepository;
import calculator.utils.SeparatorUtils;
import camp.nextstep.edu.missionutils.Console;

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
     * @throws IllegalArgumentException
     * 입력의 형식이 잘못되었을 때 발생한다
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
        String firstLine;
        try {
            firstLine = Console.readLine();
        } catch (NoSuchElementException e) {
            firstLine = "";
        }

        try {
            //s가 구분자인지 확인
            if (SeparatorUtils.isSeparator(firstLine)) {
                separatorRepository.saveSeparator(firstLine);

                String secondLine = Console.readLine();
                numberRepository.saveNumbers(secondLine);
            } else {
                numberRepository.saveNumbers(firstLine);
            }
        } catch (NoSuchElementException e) {
            //readLine에서 읽을 라인이 없을때 발생한다
            throw new IllegalArgumentException("입력의 형식이 잘못되었습니다");
        }

        // /n이 여러번 들어가 예측하지 못한 라인이 더 들어가 있을 경우
        try {
            String MoreLine = Console.readLine();

            //정상 작동되지 않을 때 실행된다
            throw new IllegalArgumentException("입력의 형식이 잘못되었습니다");

        } catch (NoSuchElementException e) {
            //정상 작동이다
        }

        //Console의 모든 기능이 종료되었음으로 close를 통해 scanner를 닫는다
        Console.close();
    }
}
