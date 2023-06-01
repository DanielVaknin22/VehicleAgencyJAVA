package Graphic;

import vehicle.Vehicle;

public class sleepCar implements Runnable {
    private Vehicle vehicle;
    private Thread sThread;
    private int time;
    public sleepCar(Vehicle vehicle, int time){
        this.vehicle = vehicle;
        this.time = time;
        sThread = new Thread(this);
        sThread.start();
    }

    @Override
    public void run() {
        vehicle.startTest();
        try {
            sThread.sleep(time * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        vehicle.endTest();
    }
}
