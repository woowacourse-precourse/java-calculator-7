# java-calculator-precourse

* * *

### 구현할 기능

* `camp.nextstep.edu.missionutills`에서 제공하는 `Console` 클래스 파일 확인과 활용하기
* `try`,`catch`를 사용하여 잘못된 값을 입력할 경우에 `IllegalArgumentException`을 처리 할 수 있도록 하기
* **Java21** 환경에서 실행되어야함.
* 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않을 것.
* Java Style Guide를 준수할 것.
* 프로그램 종료 시 `System.exit()`을 호출하지 않을 것.

* * *

### 문제 해결 방법

    1. camp.nextstep.edu.missionutils.Console 클래스를 임포트해서 입력값을 받아옴.
    2. 커스텀구분자가 있을 것을 생각해 기본 구분자를 변수에 할당.
    3. 조건문을 이용해서 "//"(이하 더블슬래쉬)로 시작하는 입력문은 조건문 내부로 진행.
    4. 조건문 내부에서 더블슬래쉬와 "\n"(이하 역슬래쉬n)의 인덱스 값을 받아옴.
    5. substring() 함수를 이용해서 커스텀구분자만 추출.
    6. 기존 입력값도 커스텀구분자 지정문을 뺀 입력값으로 변경.
    7. 본문으로 돌아와서, 문자열 배열으로 split()함수를 사용하여 추출한 커스텀구분자와 기본 구분자를 병합.
    8. try catch 문을 사용해 split의 배열요소 값 만큼 반복해서 result 변수에 더하며 할당.
    9. 잘못된 값을 입력하였을 때, IllegalArgumentException을 반환하며, 에러메세지를 표시함.
    10. 합산한 값 표시

* 번외 : 역슬래쉬n을 추출하는 과정에서 어려움을 겪음. "\n"의 인덱스 값을 구하려고 하니, -1이란 값이 나옴. 값이 존재하지 않음. 하지만 이것을 "\\n"으로 변경하여 문제를 해결함. 다른 방법도
  시도해보았지만
  효율적이지 않음.

* * *

### 예상치 못한 문제

* `Console` 명령어는 `Scanner.nextLine()`를 이용해 값을 입력받는데, `\n`을 할 경우, 입력값이 줄바꿈되며 사라진다.
  따라서 인덱스 값을 찾을 수 없다. 다른 방법을 찾아야겠다.
* 커스텀구분자에 정규표현식`+,*,?,^,$,.,(),{},[],|`을 입력했을 때 실행이 되지 않는 버그가 있음.

### 해결한 문제

* 앞선 예상치 못한 문제 중, `Console` 명령어는 `Scanner.nextLine()`를 이용해 값을 입력 받음.
  하지만 `indexOf()` 함수를 사용했을 때 `\n` 의 인덱스 값이 추출되지 않는 것을 확인.
  이것을 `\\n` `(더블역슬래쉬n)`을 `indexOf()` 함수에 입력했을 떄 오류가 발생하지 않고,
  올바른 인덱스 값을 반환하는 것을 확인하여 문제를 해결함.
* 커스텀구분자에 정규표현식이 들어갈 경우 실행이 되지 않는 버그를 `\\\\$1`로 대체하고 이스케이프하여 문제를 해결함.

#### 참고한 자료

* [Double Reversed Slash n에 대한 자료](https://www.sololearn.com/en/Discuss/1834735/what-does-n-do-and-is-it-the-same-as-n)
* [ChatGPT](https://chatgpt.com)
* [Java Split](https://jamesdreaming.tistory.com/84)
* [Java Split with regex](https://mparchive.tistory.com/45)
* [Java Substring](https://velog.io/@leo_c/JAVA-JAVA-substring으로-문자열-자르기)
* [Java Substring from behind](https://kimsg.tistory.com/48)
* [Double Back-Slash Escape](https://stackoverflow.com/questions/14260337/why-is-a-double-backslash-escape-required-inside-single-quoted-strings)
