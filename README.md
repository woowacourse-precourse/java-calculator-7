# java-calculator-precourse 
## 문자열 덧셈 계산기

<br>

### 1) 과제 진행 요구 사항

---

* [문자열 덧셈 계산기](https://github.com/woowacourse-precourse/java-calculator-7) 저장소를 포크하고 클론하는 것으로 시작한다.   
* **기능을 구현하기 전** `README.md`에 **구현할 기능 목록을 정리**해 추가한다.   
* Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.   
  * [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.   
* 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

<br> 

### 2) 프로그래밍 요구 사항

---

* JDK 21 버전에서 실행 가능해야 한다.   
* 프로그램 실행의 시작점은 `Application`의 `main()`이다.   
* `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 일부 라이브러리는 사용하지 않는다.**   
* 프로그램 종료 시 `System.exit()`를 호출하지 않는다.   
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  * 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 한다.   

#### 라이브러리
* `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 구현해야 한다.   
  * 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

<br>

### 3) 기능 요구 사항

---

* [ ] `문자열 계산기 output` 기능
* [ ] `문자열 계산기 input` 기능
* [ ] `숫자 추출` 기능
  * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리
  * [ ] `잘못된 문자열 판별` 기능
    * 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생
  * [ ] `커스텀 구분자 판별` 기능
    * 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용
* [ ] `숫자 덧셈` 기능
* [ ] `결과 출력` 기능

#### 입력
* **구분자**와 **양수**로 구성된 문자열
#### 출력
```java
결과 : 6
```
#### 실행 결과 예시
```java
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

