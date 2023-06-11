package br.dev.jstec.learn.core.enums;

public enum DeliverStatus {
    PENDING(0),
    ACCEPTED(1),
    REJECTED(2);

    private final int value;

    DeliverStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
