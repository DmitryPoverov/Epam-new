package com.epam.informationHandler.interpreterForExpressions;

import java.util.ArrayDeque;

public class ContextWrapper {

    private ArrayDeque<Integer> contextValues = new ArrayDeque<>();

    public Integer getAndDeleteValue() {
        return contextValues.pop();
    }

    public void addToQueueValue(Integer value) {
        contextValues.push(value);
    }
}
