# java-calculator-precourse

----

# 과제 요구 사항

----

* [x] 미션은 문자열 덧셈 계산기 저장소를 포크하고 클론하는 것으로 시작한다.
* [ ] 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
    * 기능 구현 후 목록을 정리함.
    * [기능 요구 사항 추후 정리](#기능-요구-사항-정리)
* [ ] Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
    * 기능 구현 후 목록을 정리함.
    * [기능 요구 사항 추후 정리](#기능-요구-사항-정리)
* [ ] AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
    * 첫 commit 에선 지키지 않음.
* [x] 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

----

# 기능 요구 사항

----

* [x] 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

* [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.

#### 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6

* [x] 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.

#### 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

* [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

----

## 프로그래밍 요구 사항

----

* [x] JDK 21 버전에서 실행 가능해야 한다.
* [x] 프로그램 실행의 시작점은 Application의 main()이다.
* [x] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
* [x] 프로그램 종료 시 System.exit()를 호출하지 않는다.
* [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
* [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다. -> 기본적으로 Java Style Guide를 원칙으로 한다.

# 기능 요구 사항 정리

## 개발 순서

1. 구분자 기준으로, 덧셈 가능 코드 생성
    * 음수가 들어올 경우 IllegalArgumentException
    * 정수형으로 들어오지 않을 시 IllegalArgumentException
2. 커스텀 구분자 기능 추가
    * 구분자를 ArrayList or HastSet로 저장하여 구분
    * 구분자가 특수기호여야 함
3. 구분자로 들어올 경우, 덧셈 가능 모듈 변경
    * 구분자들을 정규표현식을 이용해 연결
    * 이스케이프 처리를 통해서, 특정 문자를 해결하지 못할 경우를 "\\"로 해결



