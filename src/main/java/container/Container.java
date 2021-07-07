package container;

import material.*;

public class Container<T extends Material> {

    private final T material;
    private final double mass;

    public Container(T material, double mass) {
        this.material = material;
        this.mass = mass;
    }

    public T getMaterial() {
        return material;
    }

    public double getConversionFactor() {
        return material.getConversionFactor();
    }

    @SuppressWarnings("unchecked")
    public Class<T> getType() {
        return (Class<T>) material.getClass();
    }

    public double getMass() {
        return mass;
    }

}
