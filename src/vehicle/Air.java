package vehicle;

import java.util.Objects;

public abstract class Air extends Vehicle {
    protected String use;
    public Air(String model, int maxPassengers, int maxSpeed, String use) {
        super(model, maxPassengers, maxSpeed);
        this.use = use;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    @Override
    public String toString() {
        return super.toString() + " It is used for:" + use;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Air air = (Air) o;
        return Objects.equals(use, air.use);
    }
}
