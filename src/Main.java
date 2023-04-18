import vehicle.Jeep;
import vehicle.Vehicle;

import java.util.Scanner;



public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean finish = false;
        String addCar;
        Vehicle[] vehicle;
        Vehicle tmp;
        System.out.println("Welcome to the Vehicle Agency !");
        int i= 0;
        while (finish != true) {
            System.out.print("Do you want to add a new vehicle to a Vehicle Agency? yes or no");
            addCar = sc.next();
            if (addCar.equals("yes")) {
                tmp = carInsertion();
                if(tmp!=null){

                }
            }
        }
    }


    public static Vehicle carInsertion() {
        String model;
        Vehicle vehicle = null;
        int max_speed;
        float fuel, life;
        int choice;
        System.out.println("Choose type of car:\n1.Jeep\n2.Frigate\n3.Spy\n4.Game");
        choice = sc.nextInt();
        if (choice >= 1 && choice <= 4) {
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
                case 2:


            }
        }
        return vehicle;
    }
}
