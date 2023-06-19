package vehicle;

import javax.swing.*;
import java.awt.*;

public class HybridPlane extends Amphibious implements IAir{
    private String roadType;
    private String use;

    public HybridPlane(String model, int maxPassengers, int maxSpeed, int wheels, String flag, boolean withWind, float fuel, float life, ImageIcon img, Color color) {
        super(model, maxPassengers, maxSpeed, wheels, flag, withWind, fuel, life, img, color);
        this.roadType = "paved";
        this.use = "military";
    }

    @Override
    public String getUse() { return use; }

    @Override
    public void setUse(String use) { this.use = use; }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":" + super.toString() +
                " It is used for:" + use +
                "Can move on " + roadType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HybridPlane hybridPlane = (HybridPlane) o;
        return roadType.equals(hybridPlane.roadType) && use.equals(hybridPlane.use);
    }
}
