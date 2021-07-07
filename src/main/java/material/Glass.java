package material;

public class Glass extends Material {

    public Glass() {
        super(0.73);
    }

    protected Glass(double conversionFactor) {
        super(conversionFactor);
    }

}
