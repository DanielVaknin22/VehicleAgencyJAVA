package Graphic;

import vehicle.Vehicle;

/**
 * A class that handles the test drive process of a vehicle with a specified duration.
 */
public class sleepCar implements Runnable {
    private Vehicle vehicle;
    private Thread sThread;
    private int time;
    /**
     * Constructs a sleepCar object with the specified Vehicle and duration.
     * @param vehicle The Vehicle object for the test drive.
     * @param time    The duration of the test drive in seconds.
     */
    public sleepCar(Vehicle vehicle, int time){
        this.vehicle = vehicle;
        this.time = time;
        sThread = new Thread(this);
        sThread.start();
    }


    /**
     * Executes the test drive process by putting the thread to sleep for the specified duration.
     */
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
