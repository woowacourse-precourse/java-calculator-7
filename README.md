# 필요한 기능들

## 입력값을 변환하기

- [ ] 구분자를 기준으로 문자열을 자른다.
- [ ] 문자열을 정수형으로 변환한다.
- [x] 커스텀 구분자를 추출한다.

## 계산하기

- [ ] 숫자들을 더한다.

## 출력하기

- [ ] 결과값을 형태에 맞게 출력한다.

## 유효성을 검사하기

- [ ] 양수가 아닌 경우
    - 이유 : `입력값은 구분자와 양수로 구성된 문자열`
- [ ] 구분자가 커스텀 구분자와 : , 이외에도 존재하는 경우
    - 이유 : `커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.`

# 제출 전 체크리스트

- [ ] JDK 21 버전에서 실행 가능해야 한다.
- [ ] 프로그램 실행의 시작점은 Application의 main()이다.
- [ ] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [ ] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [ ] 기본적으로 Java Style Guide를 원칙으로 한다.