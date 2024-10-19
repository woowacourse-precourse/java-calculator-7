# 우아한테크코스 7기 백엔드 프리코스 1주차
![우아한테크코스 7기](https://oopy.lazyrockets.com/api/v2/notion/image?src=https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Ff71cbdcd-b763-41af-9bbb-42abdb18bd6a%2F8725996b-9c63-4691-927f-2989a2f47ca8%2Fcover-22x.png&blockId=8705deab-d8f2-476b-9892-98b37b020779&width=2400')

## 문자열 덧셈 계산기

<span style="color: #808080">이 프로젝트는 특정 기호를 통해 구분된 문자열의 덧셈을 수행하는 기능을 구현하는 것을 목표로 합니다. 사용자가 입력한 문자열에서 숫자를 추출하고, 이를 더하여 결과를 반환하는 계산기를 개발합니다. 이 과제를 통해 문자열 처리 및 기본적인 계산 로직을 이해하고, Java 프로그래밍 언어의 기초를 다지는 데 중점을 두고 있습니다.</span>

## 주요 기능

- 문자열 입력: 사용자가 특정 기호로 구분된 숫자 문자열을 입력할 수 있습니다.
- 구분 기호 처리: 기본 구분 기호(예: 쉼표, 콜론) 외에도 사용자 정의 구분 기호를 지원합니다.
- 숫자 추출 및 덧셈: 입력된 문자열에서 숫자를 추출하고, 이를 합산하여 결과를 계산합니다.
- 예외 처리: 음수나 잘못된 입력에 대한 예외 처리를 통해 사용자에게 적절한 피드백을 제공합니다.
- 결과 출력: 계산된 결과를 사용자에게 명확하게 출력합니다.

## Code Highlighting

```java
        /**
         * 입력에서 구분 문자를 추출하는 메서드
         *
         * @param input 입력 문자열
         * @return 구분 문자
         */
        private static String extractSpecialChars(String input) {
                if (input.startsWith("//")) {
                        int start = input.indexOf("//") + 2;
                        int end = input.indexOf("\\n");
                        return input.substring(start, end); // 구분 문자 반환
                }
                return ",:"; // 기본 구분 문자
        }

        /**
         * 입력에서 숫자 부분을 추출하는 메서드
         *
         * @param input 입력 문자열
         * @return 숫자 부분
         */
        private static String extractNumbers(String input) {
                if (input.startsWith("//")) {
                        int end = input.indexOf("\\n");
                        return input.substring(end + 2); // 숫자 부분만 반환
                }
                return input; // 구분 문자가 없는 경우 전체 입력 반환
        }
```

## 참고 자료

- [code style](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)
- [readme](https://insight.infograb.net/blog/2023/08/23/good-readme/)
- [git fork](https://github.com/woowacourse-precourse/java-calculator-7)
- [commit convention](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

## 포함된 라이브러리

|라이브러리|출처|설명|
|:---:|:---:|:---:|
|camp.nextstep.edu.missionutils|[우아한테크코스](https://www.woowacourse.io/)|우아한테크코스 자체 제작 라이브러리|

## 실행 요구사항
* JDK21 버전에서 구현하였습니다.
* 프로그램 실행의 시작점은 Application의 main()입니다,
