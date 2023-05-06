package Graphic;

import java.awt.Component;

public interface VehiclePanel {
    public boolean addVehicleToAgency();

    public Component PanelComponent();

    public void resetValues();

    public void setImg(String nameImg);

    public String getEqualName();
}


