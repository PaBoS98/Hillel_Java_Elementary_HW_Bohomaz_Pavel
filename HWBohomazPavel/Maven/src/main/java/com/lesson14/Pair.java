package com.lesson14;

import java.util.Objects;

public class Pair {
    private final String key;
    private final String value;

    public Pair(String key) {
        this.key = key;
        this.value = key.toUpperCase();
    }

    @Override
    public String toString() {
        return "{" + key + " : " + value + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(key, pair.key) &&
                Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
