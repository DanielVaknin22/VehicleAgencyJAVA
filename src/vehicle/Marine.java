package vehicle;

import java.util.Objects;

public abstract class Marine extends Vehicle {
    protected boolean withWind;
    protected String flag;

    public Marine(String model, int maxPassengers, int maxSpeed, boolean withWind, String flag) {
        super(model, maxPassengers, maxSpeed);
        this.flag = flag;
        this.withWind = withWind;
    }

    public boolean isWithWind() {
        return withWind;
    }

    public void setWithWind(boolean withWind) {
        this.withWind = withWind;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        String wind = withWind? " with": " without";
        return super.toString() +
                " Under " + flag + " flag, " + wind + " the wind.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Marine marine = (Marine) o;
        return withWind == marine.withWind && Objects.equals(flag, marine.flag);
    }
}
