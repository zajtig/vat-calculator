package com.globalblue.common.core.entity;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public abstract class BaseProperty<T> {

    private static final String IS_MANDATORY = "IS_MANDATORY";

    public final String name;
    public final boolean isMandatory;
    public final T value;

    public boolean isPresent() {
        return nonNull(value);
    }

    protected BaseProperty(String name, boolean isMandatory, String value) {
        this.name = name;
        this.isMandatory = isMandatory;
        checkMandatory(value);
        this.value = convert(value);
    }

    protected BaseProperty(String name, boolean isMandatory, T value) {
        this.name = name;
        this.isMandatory = isMandatory;
        checkMandatory(value);
        this.value = value;
    }

    protected abstract T convert(String value);

    private void checkMandatory(Object value) {
        if (isMandatory && isNull(value)) {
            throw new IllegalArgumentException(String.format("%s_%s", name, IS_MANDATORY));
        }
    }
}
