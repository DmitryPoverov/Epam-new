package com.epam.informationHandler.component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    
    private final List<Component> components = new ArrayList<>();

    public Composite() {
    }
    public Composite(List<Component> children) {
        this.components.addAll(children);
    }

    public List<Component> getTextParts() {
        return new ArrayList<>(components);
    }
    public int getNumberOfChildren() {
        return components.size();
    }

    public void add(Component component) {
        components.add(component);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return components.equals(composite.components);
    }
    public int hashCode() {
        return components.hashCode();
    }
    public String toString() {
        return "Composite{" +
                "components=" + components +
                '}';
    }

    @Override
    public String getValue() {
        throw new UnsupportedOperationException();
    }
}
