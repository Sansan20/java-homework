package edu.phystech.hw3.result;

import java.util.function.Function;

public record Failure<T>(Throwable exception) implements Result<T> {

    @Override
    public boolean isFailure() {
        return true;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public T getOrDefault(T defaultValue) {
        return defaultValue;
    }

    @Override
    public Throwable getExceptionOrNull() {
        return exception;
    }

    @Override
    public <R> Result<R> map(Function<T, R> transform) {
        return new Failure<>(exception);
    }

    @Override
    public String toString() {
        return "Failure(" + exception + ")";
    }
}
