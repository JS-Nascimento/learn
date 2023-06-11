package br.dev.jstec.learn.core.enums;

public enum ResourceType {
    LESSON_ONLY(0),
    LESSON_TASK(1),
    FORUM(2),
    EXTERNAL_LINK(3);

    private final int value;

    ResourceType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
