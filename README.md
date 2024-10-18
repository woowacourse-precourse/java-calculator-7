# java-calculator-precourse

# 학습 목표

Git, GitHub, IDE 등 실제 개발을 위한 환경에 익숙해진다.
교육 분야에 맞는 프로그래밍 언어를 사용하여 간단한 문제를 해결한다.

---

# 프리코스 진행 방식

진행 방식

- 미션은 과제 진행 요구 사항, 기능 요구 사항, 프로그래밍 요구 사항 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.
- 매주 진행할 미션은 화요일 오후 3시부터 확인할 수 있으며, 다음 주 월요일까지 구현을 완료하여 제출해야 한다. 제출은 일요일 오후 3시부터 가능하다.
    - 정해진 시간을 지키지 않을 경우 미션을 제출하지 않은 것으로 간주한다.
    - 종료 일시 이후에는 추가 푸시를 허용하지 않는다.

---

# 과제 진행 요구사항

> - 미션은 문자열 덧셈 계산기 저장소를 포크하고 클론하는 것으로 시작한다.
> - 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
> - Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
> - AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
> - 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

---

# 프로그래밍 요구 사항

> - JDK 21 버전에서 실행 가능해야 한다.
> - 프로그램 실행의 시작점은 Application의 main()이다.
> - build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
> - 프로그램 종료 시 System.exit()를 호출하지 않는다.
> - 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
> - 자바 코드 컨벤션을 지키면서 프로그래밍한다.
> - 기본적으로 Java Style Guide를 원칙으로 한다.

### 라이브러리

> - camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.

- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

---

# 기능 요구 사항

> 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
> - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    >

- 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6

> - 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    >

- 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

> - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항

### 입력

> - 구분자와 양수로 구성된 문자열

### 출력

- 덧셈 결과

> - 결과 : 6

### 실행 결과 예시

> 덧셈할 문자열을 입력해 주세요.<br>
> 1,2:3<br>
> 결과 : 6


--- 

## 기능 목록

1. 입력 받기

- [✓] readLine() 사용하여 사용자 입력 받기 -
- [✓] 입력 문자열 검증 (빈 문자열 체크,입력 값이 숫자만 있는 경우 처리)


2. 구분자 확인 및 문자열 분리

- [✓] 구분자 확인 및 문자열 분리
- [✓] 커스텀 구분자 확인
- [✓] 문자열이 "//"로 시작하는지 확인
- [✓] "//"와 "\n" 사이의 문자를 커스텀 구분자로 추출
- [✓] 기본 구분자 설정 (쉼표, 콜론)
- [✓] 구분자 목록 생성 (기본 구분자 + 커스텀 구분자)
- [✓] 정규표현식을 사용하여 구분자로 문자열 분리

3. 숫자 추출 및 변환

- [ ] 분리된 문자열 배열 순회
- [ ] 각 문자열 trim 처리
- [ ] 빈 문자열 처리
- [ ] 문자열을 정수로 변환
- [ ] 음수 확인 및 예외 처리


4. 숫자 합산

- [ ] 변환된 정수들을 저장할 리스트or배열 생성
- [ ] 리스트에 있는 모든 정수 합산
- [ ] 합산 결과 저장

5. 예외 처리

- [ ] IllegalArgumentException 클래스 정의
- [ ] 음수 입력 시 예외 발생
- [ ] 숫자로 변환할 수 없는 입력 시 예외 발생
- [ ] 예외 메시지 설정


6. 결과 출력

- [ ] 결과 문자열 포맷 정의 ("결과 : (계산 결과) ")
- [ ] System.out.println()을 사용하여 결과 출력
  
