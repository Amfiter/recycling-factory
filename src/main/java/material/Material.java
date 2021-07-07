package material;

public abstract class Material {

    private final double conversionFactor;

    public Material(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

}
