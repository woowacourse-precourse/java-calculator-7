# java-calculator-precourse

* * *

### 구현할 기능

* `camp.nextstep.edu.missionutills`에서 제공하는 `Console` 클래스 파일 확인과 활용하기
* `try`,`catch`를 사용하여 잘못된 값을 입력할 경우에 `IllegalArgumentException`을 처리 할 수 있도록 하기
* **Java21** 환경에서 실행되어야함.
* 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않을 것.
* Java Style Guide를 준수할 것.
* 프로그램 종료 시 `System.exit()`을 호출하지 않을 것.

### 예상치 못한 문제

* `Console` 명령어는 `Scanner.nextLine()`를 이용해 값을 입력받는데, `\n`을 할 경우, 입력값이 줄바꿈되며 사라진다.
  따라서 인덱스 값을 찾을 수 없다. 다른 방법을 찾아야겠다.

### 해결한 문제

* 앞선 예상치 못한 문제 중, `Console` 명령어는 `Scanner.nextLine()`를 이용해 값을 입력 받음.
  하지만 `indexOf()` 함수를 사용했을 때 `\n` 의 인덱스 값이 추출되지 않는 것을 확인.
  이것을 `\\n` `(더블역슬래쉬n)`을 `indexOf()` 함수에 입력했을 떄 오류가 발생하지 않고,
  올바른 인덱스 값을 반환하는 것을 확인하여 문제를 해결함.

#### 참고한 자료

* [https://www.sololearn.com/en/Discuss/1834735/what-does-n-do-and-is-it-the-same-as-n](Double Reversed Slash n에 대한 자료)
* [https://chatgpt.com](ChatGPT)
* [https://jamesdreaming.tistory.com/84](Java Split)
* [https://mparchive.tistory.com/45](Java Split with regex)
* [https://velog.io/@leo_c/JAVA-JAVA-substring으로-문자열-자르기](Java Substring)
* [https://kimsg.tistory.com/48](Java Substring from behind)
