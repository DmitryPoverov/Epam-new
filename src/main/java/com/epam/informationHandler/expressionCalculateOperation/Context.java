package com.epam.informationHandler.expressionCalculateOperation;

import java.util.ArrayDeque;

public class Context {

    private ArrayDeque<Integer> contextValues = new ArrayDeque<>();

    public Integer popValue() {
        return contextValues.pop();
    }

    public void pushValue(Integer value) {
        contextValues.push(value);
    }
}
