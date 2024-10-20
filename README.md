# java-calculator-precourse

# 프로젝트 개요

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.


# 구현 흐름

1. 사용자 입력 받기
    - [x] "덧셈할 문자열을 입력해 주세요." 출력
    - [x] Console.readLine()을 사용하여 사용자 입력 받기
2. 입력된 문자 검증 (Validation)
    - [x] 빈 문자열 입력 시 예외처리
3. 입력된 문자열 파싱
    - [x] 커스텀 구분자 확인
        - [x] 커스텀 구분자가 없을 경우 쉼표(,) 또는 콜론(:) 사용
        - [x] 커스텀 구분자 사용 시 커스텀 구분자 사용 체크
            - [x] 커스텀 구분자가 빈 값인 경우 예외처리 or 기본 값으로 설정
    - [x] 구분자 기준으로 문자열 분리
        - 이때 구분자는 (기존 구분자 + 커스텀 구분자) or 커스텀 구분자로만 구현
4. 숫자 추출 및 덧셈
    - [x] 추출된 숫자 덧셈
        - [x] 추출된 숫자 중에 음수가 있을 경우 예외처리
        - [x] 숫자가 아닌 다른 값이 있을 경우 예외처리
5. 결과 출력
    - [x] System.out.printIn()을 사용하여 결과 출력


# 세부적인 구현 목록

1. 도메인 계층
    - [x] StringCalculator 클래스 구현
        - [x] 문자열 입력을 처리하는 메서드 구현
        - [x] Delimiter 객체를 이용한 구분자 관리
    - [x] Delimiter 클래스 구현 (값 객체)
        - [x] 기본 구분자와 커스텀 구분자 관리
2. 서비스 계층
    - [x] StringCalculatorService 인터페이스 정의
    - [x] StringCalculatorServiceImpl 클래스 구현
        - [x] 문자열 파싱 및 계산 로직 구현
        - [x] 예외 처리 로직 구현
3. 프레젠테이션 계층
    - [x] CalculatorConsole 클래스 구현
        - [x] 사용자 입력 받기 메서드 구현
        - [x] 결과 출력 메서드 구현
    - [x] StringCalculatorController 클래스 구현
        - [x] StringCalculatorService와 연결
        - [x] 계산 로직 실행
4. 유틸리티
    - [x] DelimiterParser 클래스 구현
        - [x] 커스텀 구분자 추출 및 처리 메서드 구현
        - [x] 구분자 패턴 생성 메서드 구현
    - [x] ConsoleReader 클래스 구현
    - [x] ConsoleWriter 클래스 구현
5. 테스트
    - [x] StringCalculatorTest 클래스 구현
    - [x] StringCalculatorServiceImplTest 클래스 구현
    - [x] DelimiterParserTest 클래스 구현
6. 예외 처리
    - [x] ErrorMessage 열거형 구현
        - [x] 구체적인 예외 메시지 정의
7. 애플리케이션 실행
    - [x] Application 클래스에 main 메서드 구현
        - [x] CalculatorConsole 생성 및 실행
    

# 추가 체크 목록

- [ ] 결과값이 StackOverFlow 발생할 경우
- [ ] 커스텀 구분자가 숫자일 경우
- [ ] 입력값 제한


