package org.example.domain;

// App 에 적용하면 이후 확장 시 리팩토링 수월하지만 편의 상 적용하지 않았음
public enum Commands {
    REGISTER("등록"),
    EXIT("종료"),
    LIST("목록"),
    SEARCH("검색"),
    DELETE("삭제"),
    MODIFY("수정"),
    BUILD("빌드");

    private final String command;

    Commands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
