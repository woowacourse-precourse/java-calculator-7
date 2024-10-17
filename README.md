# java-calculator-precourse
 - - -
# 문자열 덧셈 계산기
- - -
## 과제 진행 요구 사항
- 미션은 문자열 덧셈 계산기 저장소를 포크하고 클론하는 것으로 시작한다.
- 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
  - AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## 기능 목록
- - -
### 입력
- [ ] 문자열 입력
### 문자열 파싱
- [ ] 쉼표(,) 또는 콜론(:)을 구분자로 문자열 분리
- [ ] 커스텀 구분자("//"와 "\n" 사이에 위치하는 문자) 문자열 분리
  - ex) "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
-[ ] 분리된 문자열에서 숫자 추출
### 숫자 계산
- [ ] 추출한 숫자 문자열을 숫자 타입으로 변환
- [ ] 숫자의 합 계산
### 출력
- [ ] 출력 포맷에 맞는 출력
### 예외처리
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생
- [ ] 예외 발생 시, 애플리케이션 종료

### 입출력 요구 사항
**입력**
- 구분자와 양수로 구성된 문자열

**출력**
- 덧셈 결과
```
결과 : 6
```
**실행 결과 예시**
```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```
## 프로그래밍 요구 사항
- - - 
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 Java Style Guide를 원칙으로 한다.

***라이브러리***
- camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.