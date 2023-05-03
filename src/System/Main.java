/**
 * Daniel Vaknin 314753161
 * Lin Sadon 209487370
 */

package System;
import vehicle.*;

import java.util.Scanner;

/**
 The master class is the main entry point of the car dealership program.
 It allows users to add vehicles, purchase vehicles, take a vehicle for a test drive,
 resetting the distance of all vehicles, changing the flag of all marine vehicles, and exit the program.
 */

public class Main {
    static Scanner sc = new Scanner(System.in);

    /**
     * The main function of the program.
     * It creates an array of Vehicle objects and allows users to perform various actions on them.
     */
    public static void main(String[] args) {
        boolean finish = false;
        String addCar;
        Vehicle[] vehicle = new Vehicle[0];
        Vehicle tmp;
        System.out.println("Welcome to the Vehicle Agency !");
        int choice = 0, count = 0;

        // Add vehicles to the agency
        while (!finish) {
            System.out.println("Do you want to add a new vehicle to a Vehicle Agency? yes or no");
            addCar = sc.next();
            if (addCar.equals("yes")) {
                tmp = createVehicle();
                vehicle = addVehicle(vehicle, tmp);
            } else {
                finish = true;
            }
        }

        // Perform actions on the vehicles
        while (true) {
            System.out.println("Please enter your choice:");
            System.out.println("1. Buy vehicle.");
            System.out.println("2. Test drive the vehicle.");
            System.out.println("3. Reset the distance.");
            System.out.println("4. Change the flag of all Marine Vehicle.");
            System.out.println("5. Exit.");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    // Purchase a vehicle
                    print(vehicle);
                    count = 0;
                    tmp = createVehicle();
                    System.out.print("Enter the vehicle traveled: ");
                    int distance = sc.nextInt();
                    tmp.setKm(distance);
                    for (int i = 0; i < vehicle.length; i++) {
                        if (tmp.equals(vehicle[i])) {
                            vehicle = removeVehicle(vehicle, i);
                            count = 1;
                        }
                    }
                    if (count == 0) {
                        System.out.println("The vehicle not found.");
                    } else System.out.println("Successfully purchase.");
                }
                case 2 -> {
                    // Test drive a vehicle
                    count = 0;
                    print(vehicle);
                    tmp = createVehicle();
                    System.out.print("Enter the vehicle traveled: ");
                    int distance = sc.nextInt();
                    tmp.setKm(distance);
                    for (int i = 0; i < vehicle.length; i++) {
                        if (tmp.equals(vehicle[i])) {
                            testDrive(vehicle, i);
                            count = 1;
                        }
                    }
                    if(count == 0){
                        System.out.println("The vehicle not found.");
                    }else System.out.println("The test drive passed.");
                }
                case 3 -> {
                    // Reset the distance of all vehicles
                    for (int i = 0; i < vehicle.length; i++) {
                        vehicle[i].setKm(0);
                    }
                    System.out.println("All km vehicle has been reset.");
                }
                case 4 -> {
                    // Change the flag of all marine vehicles
                    count = 0;
                    System.out.println("Enter the name of the flag.");
                    String flag = sc.next();
                    for (int i = 0; i < vehicle.length; i++) {
                        if (vehicle[i] instanceof Marine) {
                            ((Marine) vehicle[i]).setFlag(flag);
                            count = 1;
                        }
                    }
                    if (count == 1) {
                        System.out.println("All marine flag has been changed.");
                    } else System.out.println("There is no marine vehicle in the agency.");
                }
                case 5 -> {
                    System.out.println("Bye Bye! see you next time.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Print method that takes an array of Vehicle objects and prints out each object using the toString method.
     * @param vehicle Array of Vehicle objects.
     */
    private  static void print(Vehicle[] vehicle){
        for (int i = 0; i < vehicle.length; i++) {
            System.out.println(vehicle[i]);
        }
    }

    /**
     * testDrive method get the distance and index of the vehicle chosen for a test drive.
     * @param vehicle Array of Vehicle objects.
     * @param i Index of vehicle object to test drive.
     */
    private static void testDrive(Vehicle[] vehicle, int i) {
        int distance;
        System.out.println("Enter the test drive distance.");
        distance = sc.nextInt();
        vehicle[i].Move(distance);
    }

    /**
     * RemoveVehicle method takes an array of Vehicle objects and an index and returns a new array that excludes
     * the Vehicle object at the specified index.
     * @param vehicle Array of Vehicle objects
     * @param i Index to remove.
     * @return A new array that excludes the Vehicle object at the specified index.
     */
    private static Vehicle[] removeVehicle(Vehicle[] vehicle, int i) {
        Vehicle[] newVehicle = new Vehicle[vehicle.length - 1];
        int k = 0;
        for (int j = 0; j < vehicle.length; j++) {
            if (j != i){
                newVehicle[k] = vehicle[j];
                k++;
            }
        }
        return newVehicle;
    }

    /**
     * AddVehicle method takes an array of Vehicle objects and a new Vehicle object and returns a new array that
     * includes the new Vehicle object.
     * @param vehicle Array of Vehicle objects
     * @param tmpVehicle New Vehicle object
     * @return New array that includes the new Vehicle object.
     */
    public static Vehicle[] addVehicle(Vehicle[] vehicle, Vehicle tmpVehicle){
        Vehicle[] newVehicle = new Vehicle[vehicle.length + 1];
        for (int i = 0; i < vehicle.length; i++) {
            newVehicle[i] = vehicle[i];
        }
        newVehicle[vehicle.length] = tmpVehicle;
        return newVehicle;
    }

    /**
     * CreateVehicle method prompts the user to choose the type of vehicle they want to create and then gathers input
     * from the user to create a new instance of the chosen vehicle type.
     * @return Vehicle object.
     */
    public static Vehicle createVehicle() {
        String model, power;
        Vehicle vehicle = null;
        int max_speed, max_passengers;
        float fuel, life;
        int choice, with_wind;
        boolean wind = true;
        do {
            System.out.println("Choose type of car:\n1.Jeep\n2.Frigate\n3.Spy\n4.Game");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Jeep");
                    System.out.print("Enter model name:");
                    model = sc.next();
                    System.out.print("Enter max speed:");
                    max_speed = sc.nextInt();
                    System.out.print("Enter average fuel:");
                    fuel = sc.nextFloat();
                    System.out.print("Enter average life:");
                    life = sc.nextFloat();
                    vehicle = new Jeep(model, max_speed, fuel, life);
                    break;
                case 2:
                    System.out.println("Frigate");
                    System.out.print("Enter model name:");
                    model = sc.next();
                    System.out.print("Enter max speed:");
                    max_speed = sc.nextInt();
                    System.out.print("Enter max passengers:");
                    max_passengers = sc.nextInt();
                    do {
                        System.out.println("Does it move with the direction of the wind? (Please write 0 for against the wind direction or 1 for with the wind direction)");
                        with_wind = sc.nextInt();
                        if (with_wind == 0) {
                            vehicle = new Frigate(model, max_passengers, max_speed, false);
                            wind = false;
                        }
                        else if (with_wind == 1) {
                            vehicle = new Frigate(model, max_passengers, max_speed, true);
                            wind = false;
                        }
                        else System.out.println("Your choice is not correct. Please try again.");
                    }while(wind);
                    break;
                case 3:
                    System.out.println("Spy");
                    System.out.print("What is the source of his power?");
                    power = sc.next();
                    vehicle = new Spy(power);
                    break;
                case 4:
                    vehicle = new Game();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (vehicle == null);
        return vehicle;
    }
}
