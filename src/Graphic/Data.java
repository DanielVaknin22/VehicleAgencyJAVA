//package Graphic;
//
//import Graphic.images.ChangeStorageListener;
//import Vehicle.ILand;
//import Vehicle.MarineTransportVehicle;
//import Vehicle.Vehicle;
//
//import javax.swing.*;
//import java.util.*;
//import java.util.concurrent.atomic.AtomicInteger;
//
//
//public class Storage {
//
//    private final Object lock = new Object();
//
//
//    private Map<VehicleType, AtomicInteger> indexOfTestMap = new HashMap<VehicleType, AtomicInteger>() {{
//        put(VehicleType.Air, new AtomicInteger(-1));
//        put(VehicleType.Marine, new AtomicInteger(-1));
//        put(VehicleType.Overland, new AtomicInteger(-1));
//    }};
//
//    private Map<VehicleType, AtomicInteger> buyOfTestMap = new HashMap<VehicleType, AtomicInteger>() {{
//        put(VehicleType.Air, new AtomicInteger(-1));
//        put(VehicleType.Marine, new AtomicInteger(-1));
//        put(VehicleType.Overland, new AtomicInteger(-1));
//    }};
//
//    public boolean isInProgress() {
//        VehicleType[] arr = VehicleType.values();
//        for (VehicleType vehicleType : arr) {
//            if (indexOfTestMap.get(vehicleType).get() != -1) {
//                return true;
//            }
//            if (buyOfTestMap.get(vehicleType).get() != -1) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean isInTestbyType(int index) {
//        synchronized (lock) {
//            Vehicle vehicle = vehicles.get(index);
//            VehicleType type = getVehcileType(vehicle);
//            if (buyOfTestMap.get(type).get() == index) {
//                JOptionPane.showMessageDialog(null, "Vehicle type is current in buy mode - please try again later");
//                return true;
//            }
//            if (indexOfTestMap.get(type).get() == -1) {
//                indexOfTestMap.get(type).set(index);
//                return false;
//            } else {
//                JOptionPane.showMessageDialog(null, "Vehicle type is current in test - please try again later");
//                return true;
//            }
//        }
//    }
//
//    public boolean isInTestbyIndex(int index) {
//        synchronized (lock) {
//            Vehicle vehicle = vehicles.get(index); //Jeep
//            VehicleType type = getVehcileType(vehicle); // Land
//            int currentInTest = indexOfTestMap.get(type).get();
//            if (currentInTest == -1) {
//                return false;
//            } else {
//                if (index == currentInTest) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        }
//    }
//
//    private VehicleType getVehcileType(Vehicle vehicle) {
//        VehicleType type;
//        if (vehicle instanceof MarineTransportVehicle) {
//            type = VehicleType.Marine;
//        } else if (vehicle instanceof LandVehicle) {
//            type = VehicleType.Overland;
//        } else {
//            type = VehicleType.Air;
//        }
//        return type;
//    }
//
//
//    private List<Vehicle> vehicles = new ArrayList<>();
//
//    private List<ChangeStorageListener> listeners = new ArrayList<>();
//
//
//    public void addListener(ChangeStorageListener listener) {
//        listeners.add(listener);
//    }
//
//    public void removeListener(ChangeStorageListener listener) {
//        listeners.remove(listener);
//    }
//
//    /**
//     * Adds an image to a Vehicle object and adds it to the vehicleArray and images arrays.
//     *
//     * @param obj The Vehicle object to add the image to
//     */
//    public void addVehicle(JFrame parent, Vehicle obj) {
//        new Thread(() -> {
//            sleepDBAction(parent);
//            synchronized (lock) {
//                vehicles.add(obj);
//            }
//            notifyDataChanged();
//        }).start();
//    }
//
//    private void notifyDataChanged() {
//        for (ChangeStorageListener listener : listeners) {
//            listener.onStorageChanged();
//        }
//    }
//
//    public void removeVehcile(JFrame parent, int index) {
//        new Thread(() -> {
//            Vehicle vehicle = vehicles.get(index);
//            VehicleType type = getVehcileType(vehicle);
//            buyOfTestMap.get(type).set(index);
//            sleepDBAction(parent);
//            synchronized (lock) {
//                vehicles.remove(index);
//            }
//            buyOfTestMap.get(type).set(-1);
//            notifyDataChanged();
//        }).start();
//
//    }
//
//    public List<Vehicle> getVehicles() {
//        return vehicles;
//    }
//
//    private static Storage single_instance = null;
//
//    private Storage() {
//    }
//
//
//    public static Storage getInstance() {
//        if (single_instance == null) {
//            single_instance = new Storage();
//        }
//        return single_instance;
//    }
//
//
//    public void updateVehcileDistance(int index, int kilometr, long sleepTime) {
//        synchronized (lock) { //->
//            System.out.println(index + ",Sleeptime - " + sleepTime);
//            try {
//                Thread.sleep(sleepTime);
//            } catch (Exception e) {
//
//            }
//            Vehicle vehicle = vehicles.get(index);
//            vehicle.setdistanceInHisLifetime(kilometr);
//            indexOfTestMap.get(getVehcileType(vehicle)).set(-1);
//        }
//        notifyDataChanged();
//    }
//
//    private void sleepDBAction(JFrame parent) {
//        JOptionPane optionPane = new JOptionPane("Updating Database", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
//        JDialog dialog = optionPane.createDialog(parent, "Updating Database.");
//        dialog.setModal(false); // Set dialog as non-modal
//        Random random = new Random();
//        int randomNumber = random.nextInt(6) + 3;
//        dialog.setVisible(true);
//        System.out.println("DB - Sleeptime - " + randomNumber);
//        try {
//            Thread.sleep(randomNumber * 1000);
//        } catch (Exception e) {
//
//        }
//        dialog.dispose();
//    }
//
//    public void resetDistances(JFrame parent) {
//        new Thread(() -> {
//            sleepDBAction(parent);
//            synchronized (lock) {
//                for (Vehicle vehicle : vehicles) {
//                    vehicle.setdistanceInHisLifetime(0);
//                }
//            }
//            notifyDataChanged();
//        }).start();
//    }
//
//    public void changeFlag(JFrame parent, String flag) {
//        new Thread(() -> {
//            sleepDBAction(parent);
//            synchronized (lock) {
//                for (Vehicle vehicle : vehicles) {
//                    if (vehicle instanceof MarineTransportVehicle) {
//                        ((MarineTransportVehicle) vehicle).setFlag(flag);
//                    }
//                }
//            }
//            notifyDataChanged();
//        }).start();
//    }
//}
//
//
//
