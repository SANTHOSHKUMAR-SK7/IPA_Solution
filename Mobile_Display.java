import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// Class to store mobile details
class Mobile {
    private String brand;
    private String model;
    private double price;
    private String processor;
    private String range;
    private int ram; // in GB
    private int storage; // in GB
    private String camera;
    private int battery; // in mAh
    private String os;

    public Mobile(String brand, String model, double price, String processor, String range, int ram, int storage, String camera, int battery, String os) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.processor = processor;
        this.range = range;
        this.ram = ram;
        this.storage = storage;
        this.camera = camera;
        this.battery = battery;
        this.os = os;
    }

    public void displayDetails() {
        System.out.println("\nBrand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
        System.out.println("Processor: " + processor);
        System.out.println("Range: " + range);
        System.out.println("RAM: " + ram + "GB");
        System.out.println("Storage: " + storage + "GB");
        System.out.println("Camera: " + camera);
        System.out.println("Battery: " + battery + "mAh");
        System.out.println("Operating System: " + os);
        System.out.println("-----------------------------------");
    }

    public double getPrice() { return price; }
    public String getBrand() { return brand; }
    public int getRam() { return ram; }
}

public class Mobile_Display {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Mobile> mobileList = new ArrayList<>();

    // Display all mobiles
    public static void displayAllMobiles() {
        if (mobileList.isEmpty()) {
            System.out.println("No mobiles available.");
        } else {
            System.out.println("Available Mobiles:");
            for (Mobile mobile : mobileList) {
                mobile.displayDetails();
            }
        }
    }

    // Add a new mobile
    public static void addNewMobile() {
        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Processor: ");
        String processor = scanner.nextLine();
        System.out.print("Enter Range (Budget/Mid-range/Flagship): ");
        String range = scanner.nextLine();
        System.out.print("Enter RAM (GB): ");
        int ram = scanner.nextInt();
        System.out.print("Enter Storage (GB): ");
        int storage = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Camera Details (e.g., 50MP + 12MP): ");
        String camera = scanner.nextLine();
        System.out.print("Enter Battery Capacity (mAh): ");
        int battery = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Operating System: ");
        String os = scanner.nextLine();

        mobileList.add(new Mobile(brand, model, price, processor, range, ram, storage, camera, battery, os));
        System.out.println(" Mobile added successfully!");
    }

    // Sort mobiles by price
    public static void sortMobiles() {
        if (mobileList.isEmpty()) {
            System.out.println("No mobiles available.");
            return;
        }

        System.out.println("\n1. Sort by Price (Low to High)");
        System.out.println("2. Sort by Price (High to Low)");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            mobileList.sort(Comparator.comparingDouble(Mobile::getPrice));
            System.out.println(" Sorted by Price (Low to High).");
        } else if (choice == 2) {
            mobileList.sort(Comparator.comparingDouble(Mobile::getPrice).reversed());
            System.out.println(" Sorted by Price (High to Low).");
        } else {
            System.out.println(" Invalid choice.");
            return;
        }

        displayAllMobiles();
    }

    // Filter mobiles
    public static void filterMobiles() {
        if (mobileList.isEmpty()) {
            System.out.println("No mobiles available.");
            return;
        }

        System.out.println("\n Filter Options:");
        System.out.println("1. By Price Range");
        System.out.println("2. By Brand");
        System.out.println("3. By RAM");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Min Price: ");
                double minPrice = scanner.nextDouble();
                System.out.print("Enter Max Price: ");
                double maxPrice = scanner.nextDouble();
                scanner.nextLine();
                System.out.println(" Mobiles in price range $" + minPrice + " - $" + maxPrice);
                for (Mobile mobile : mobileList) {
                    if (mobile.getPrice() >= minPrice && mobile.getPrice() <= maxPrice) {
                        mobile.displayDetails();
                    }
                }
                break;

            case 2:
                System.out.print("Enter Brand: ");
                String brand = scanner.nextLine().toLowerCase();
                System.out.println(" Mobiles from brand: " + brand);
                for (Mobile mobile : mobileList) {
                    if (mobile.getBrand().toLowerCase().contains(brand)) {
                        mobile.displayDetails();
                    }
                }
                break;

            case 3:
                System.out.print("Enter Minimum RAM (GB): ");
                int minRam = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Mobiles with at least " + minRam + "GB RAM:");
                for (Mobile mobile : mobileList) {
                    if (mobile.getRam() >= minRam) {
                        mobile.displayDetails();
                    }
                }
                break;

            default:
                System.out.println(" Invalid choice.");
        }
    }

    // Main menu function
    public static void mainMenu() {
        while (true) {
            System.out.println("\n Mobile Store Menu:");
            System.out.println("1. Display All Mobiles");
            System.out.println("2. Add New Mobile");
            System.out.println("3. Sort Mobiles by Price");
            System.out.println("4. Filter Mobiles");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllMobiles();
                    break;
                case 2:
                    addNewMobile();
                    break;
                case 3:
                    sortMobiles();
                    break;
                case 4:
                    filterMobiles();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye! ");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Main function
    public static void main(String[] args) {
        // Preloaded data
        mobileList.add(new Mobile("Samsung", "Galaxy S23", 999.99, "Snapdragon 8 Gen 2", "Flagship", 8, 256, "50MP + 12MP", 4500, "Android 13"));
        mobileList.add(new Mobile("Apple", "iPhone 14", 1099.99, "A16 Bionic", "Flagship", 6, 128, "48MP + 12MP", 4000, "iOS 16"));

        mainMenu();
    }
}
