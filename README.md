# java-calculator-precourse

## 구현
입력 문자열에서 숫자 추출해 더하는 계산기

## 구현 기능
- 문자열 분리
    1. **쉼표(,) 또는 콜론(:)** 을 기준으로 분리
    2. 커스텀 구분자 지정 가능: **"//"와 "\n"** 사이에 위치시키는 문자가 커스텀 구분자가 됨
- 분리된 문자를 숫자로 변환 후 각 숫자의 합을 반환
- 잘못된 값이 들어오면 IllegalArgumentException을 발생시키고 애플리케이션 종료

## 프로그램 요구 사항
- jdk 21 버전
- 프로그램 종료 시 System.exit() 호출 X
- 입력: 구분자, 양수
- camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현

## 기존 구현 순서
1. 문자열 입력
2. 문자열 분리
    - **쉼표(,) 또는 콜론(:)** 을 기준으로 분리
    - 커스텀 구분자로 분리
3. 분리된 문자를 숫자로 변환 후 각 숫자의 합을 반환
    - 잘못된 값이 들어오면(숫자X or 양수X) IllegalArgumentException을 발생시키고 애플리케이션 종료
4. 반환 값 출력

## 변경된 최종 구현 순서
1. 문자열 입력 구현: Calculator 클래스 사용
2. 문자열 입력 후 변수 초기화, 검증 실행: Input 클래스 사용
   - 테스트 코드 작성: CustomInputTest
3. 구분자 판단 후 검증 실행: Input 클래스 사용
   - 테스트 코드 작성: DefaultInputTest, CustomInputTest
4. 문자열 구분자로 구분: SplitManager 클래스 사용
5. 나눠진 문자 배열 양수인지 검증: SplitManager 클래스 사용
   - 테스트 코드 작성: SplitManagerTest 클래스 사용
6. 문자열 합 계산: Calculator 클래스 사용

## 고민한 것들
1. 커스텀 구분자 사용시 기본 구분자도 사용 가능한 것?
2. 커스텀 구분자가 하나의 문자가 아닌 여러개일수 있는건가?
   - e.g, //a$\n
   - e.g, //a\n//$\n
3. 클래스의 책임을 어디까지 주는 게 맞는걸까