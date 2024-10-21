# java-calculator-precourse

## 과제 제출 전 체크 리스트

1. 요구 사항 출력 형식 확인
2. 테스트
    - java -version으로 버전 21 확인
    - gradlew.bat clean test 또는 .\gradlew.bat clean test로 모든 테스트 통과 확인
3. 커밋 단위는 해당 리스트의 목록 단위로 추가
4. 기능 요구사항
    - 쉼표 또는 콜론을 구분자로 가지는 문자열 전달 시 구분자를 기준으로 분리한 각 숫자의 합 반환
    - 기존 구분자(쉼표, 콜론)외에 커스텀 구분자 지정 가능 ("//"와 "\n"사이 위치하는 문자를 커스텀 구분자로 사용)
    - 잘못된 값 입력 시 IllegalArgumentException 발생 후 종료
5. 프로그래밍 요구사항
    - build.gradle 변경 불가, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
    - 프로그램 종료 시 System.exit()를 호출하지 않는다.
    - 자바 코드 컨벤션을 지키며 프로그래밍한다.
        - 기본적으로 Java Style Guide를 원칙으로 함
6. 라이브러리
    - camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
        - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.