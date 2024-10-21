commit d77efacfa80aa4253522fb4534cca300c7ab3a64
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 21 20:14:40 2024 +0900

    docs: 클래스와 메서드에 주석 추가
    
    - Application, InputHandler, StringSplitter, Accumulator, OutputHandler 클래스에 주석을 추가하여 코드 설명 보강
    - 코드 이해와 유지보수를 쉽게 하기 위해 주석 작성

commit 42d2683d65b869794848d51eec07e6c7f13a6028
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 21 20:00:30 2024 +0900

    docs(readme): 기능 구현 체크리스트 업데이트

commit 1ad2ef519016eab2ed4751ae68b36448c5d46cbf
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 21 19:41:15 2024 +0900

    refactor(input): 사용자에게 보일 입력 메세지 final로 선언

commit e38276fa7d3e3b59aaed9b38fd08ca0201401a82
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 21 19:39:58 2024 +0900

    feat(exception): int의 범위가 넘어가는 입력에 대해 예외처리 추가

commit 689a92a25d244d2aa9af5d9a9d69f881da893938
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 21 19:37:53 2024 +0900

    refactor(output): 출력을 담당하는 OutputHandler 클래스 구현
    
    - 메인에서 직접 결과를 출력하는 형식에서 OutputHandler가 출력을 담당하게 하여 책임 분리

commit 4025e1e1ba209726de1a51f91bc1eeed8cdab423
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 19 19:39:14 2024 +0900

    refactor(accumulator): 파싱 전 숫자 유효성 검사 로직 추가
    
    - sum 메서드에서 ExceptionHandler를 통해 숫자 형식 검증 처리
    - 음수 입력 검사를 잘못된 부호 처리와 통합하여 예외 처리

commit ad57ea7f5af71a4d52e6c2128a84360acfbabb68
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 19 19:38:46 2024 +0900

    refactor(exception): 예외 생성 로직을 일관되게 처리하도록 메서드 추가
    
    - handleInvalidDelimiter와 handleNonNumbericInput에서 공통 예외 생성 메서드 사용
    - 음수와 잘못된 문자를 함께 처리하는 로직으로 개선
    - IllegalArgumentException 생성을 위한 createIllegalArgumentException 메서드 도입

commit 3fc408c718312af14eac4eb4883b79ec036f541c
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 19 18:03:19 2024 +0900

    refactor(splitter): 정규식 특수 문자 처리 위한 이스케이프 로직 추가
    
    - 커스텀 구분자가 정규식 특수 문자일 경우 올바르게 처리되도록 escapeRegexChars 메서드 추가
    - [, ], \ 문자를 이스케이프 처리하여 구분자로 사용할 수 있게 개선

commit 9a400e60fa1c635ce3fc0d49b7c8894fd8a82bc7
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 19 17:21:08 2024 +0900

    feat(splitter): 커스텀 구분자와 기본 구분자를 동시에 지원하는 기능 추가
    
    - 커스텀 구분자 사용시에도 기본 구분자 , :를 사용할 수 있도록 수정
    - combineDelimiters 메소드를 통해 기본 구분자와 커스텀 구분자를 결합

commit ec5be452d1bd2972bba33b484f35371e14603cb6
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 19 16:25:37 2024 +0900

    refactor(splitter, accumulator): 정적 메소드 예외 처리 로직 추가
    
    - StringSplitter에서 커스텀 구분자가 비어있을 경우 예외 발생
    - Accumulator에서 음수가 들어왔을 경우 예외 발생

commit d0938f4a0b82f40a06cdceedde5a8af7cf6d0ae0
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 19 16:23:20 2024 +0900

    feat(exception): 정적 메소드를 이용한 예외 처리 클래스 구현
    
    - 커스텀 구분자가 비어있을 때 예외 처리
    - 음수가 입력됐을 때 예외 처리

commit db26625afa76b65bb296e66d39156bdf6050707d
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 19 01:29:55 2024 +0900

    docs(readme): 체크리스트 수정

commit d14adc4e2a1ea14fc242208bb1638ff20d2335ed
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 19 01:26:31 2024 +0900

    fix(calculator): 빈 문자열을 0으로 처리하여 오류 해결
    
    - Accumulator 클래스에서 빈 문자열이 입력 될 경우 발생하던 숫자 변환 오류 해결\n- 빈 문자열을 0으로 처리하도록 하여 예외 발생 방지

commit 97d1bf0fbfe75273042b1a2b793d7f481a450a3c
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Fri Oct 18 23:14:37 2024 +0900

    feat(splitter): 커스텀 구분자 추출 함수 구현
    
    - 구분자 관련 상수를 final로 선언
    
    - input이 CUSTOM_DELIMITER_PREFIX로 시작할 경우 커스텀 구분자로 split 후 기본 구분자로 split 처리

commit 0f609ff4857e49bf6b11ab287ff03c61e027cf78
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Fri Oct 18 01:28:22 2024 +0900

    docs(readme): 체크리스트 업데이트

commit cbbc6c68139eae28e40ea2964a435dc768ba3375
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Fri Oct 18 01:27:38 2024 +0900

    feat: Accumulator와 StringSplitter를 사용하여 계산 로직 구현
    
    Application 클래스에서 Accumulator와 StringSplitter를 사용해 입력 문자열을 분리하고, 합산 처리 로직을 추가함.

commit f986dd62da7e7a40d89cb7072be0289c0058f6a3
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Fri Oct 18 01:11:42 2024 +0900

    feat(calculator): 합산 처리 클래스 Accumulator 추가
    
    Accumulator 클래스를 통해 문자열 배열을 정수로 변환하고 합산 처리.

commit 332885fb4d8c2519b2f83211eb6825de2886d059
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Fri Oct 18 01:09:32 2024 +0900

    feat(spliter): 문자열 분리 클래스 StringSplitter 추가

commit 28ab69f2a4c734edd664190387d0e3d9f5d26fef
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Thu Oct 17 20:13:09 2024 +0900

    feat(input): 입력 처리 클래스 InputHandler 추가
    
    InputHandler 클래스를 통해 사용자의 입력을 처리. Application 클래스에서 InputHandler를 의존성 주하여 사용. 추후 입력에 대한 예외처리 필요.

commit 4cff6ecb8389af436cdaa27512f64152dad1d24b
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Thu Oct 17 00:41:25 2024 +0900

    docs(readme): 기능 목록 추가
    
    - 문자열 계산기 요구 사항에 맞춰 기능 목록을 작성

commit d0a82b7d11bbabce3253514c307545ccb608c384
Author: woowabrie <buyong.jo@woowahan.com>
Date:   Tue Oct 15 09:30:11 2024 +0900

    feat: setup project
