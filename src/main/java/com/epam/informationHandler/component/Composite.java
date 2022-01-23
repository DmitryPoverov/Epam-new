package com.epam.informationHandler.component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private List<Component> children = new ArrayList<>();

    public Composite() {
    }
    public Composite(List<Component> children) {
        this.children.addAll(children);
    }

    public List<Component> getChildren() {
        return new ArrayList<>(children);
    }
    public int getChildrenQuantity() {
        return children.size();
    }

    public void add(Component child) {
        children.add(child);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return children.equals(composite.children);
    }
    public int hashCode() {
        return children.hashCode();
    }
    public String toString() {
        return "Composite{" +
                "children=" + children +
                '}';
    }
}
