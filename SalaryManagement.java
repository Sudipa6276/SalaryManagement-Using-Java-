import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Worker {
    private String name;
    private double salary;

    public Worker(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class SalaryManagement {
    private static List<Worker> workers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Salary Management System");
            System.out.println("------------------------");
            System.out.println("1. Add Worker");
            System.out.println("2. Display All Workers");
            System.out.println("3. Update Worker Salary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
                System.out.print("Enter your choice: ");
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addWorker(scanner);
                    break;
                case 2:
                    displayAllWorkers();
                    break;
                case 3:
                    updateWorkerSalary(scanner);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        } while (choice != 4);

        scanner.close(); // Close the scanner when done
    }

    private static void addWorker(Scanner scanner) {
        System.out.println("Adding Worker");
        System.out.println("-------------");

        System.out.print("Enter worker name: ");
        scanner.nextLine(); // Consume the newline
        String name = scanner.nextLine();

        System.out.print("Enter worker salary: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid salary.");
            scanner.next(); // Clear invalid input
            System.out.print("Enter worker salary: ");
        }
        double salary = scanner.nextDouble();

        Worker worker = new Worker(name, salary);
        workers.add(worker);

        System.out.println("Worker added successfully.");
    }

    private static void displayAllWorkers() {
        if (workers.isEmpty()) {
            System.out.println("No workers found.");
        } else {
            System.out.println("List of Workers");
            System.out.println("---------------");

            for (Worker worker : workers) {
                System.out.println("Name: " + worker.getName());
                System.out.println("Salary: $" + worker.getSalary());
                System.out.println();
            }
        }
    }

    private static void updateWorkerSalary(Scanner scanner) {
        if (workers.isEmpty()) {
            System.out.println("No workers found.");
        } else {
            System.out.println("Updating Worker Salary");
            System.out.println("----------------------");

            System.out.print("Enter worker name: ");
            scanner.nextLine(); // Consume the newline
            String name = scanner.nextLine();

            boolean found = false;

            for (Worker worker : workers) {
                if (worker.getName().equalsIgnoreCase(name)) {
                    System.out.print("Enter new salary: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a valid salary.");
                        scanner.next(); // Clear invalid input
                        System.out.print("Enter new salary: ");
                    }
                    double newSalary = scanner.nextDouble();
                    worker.setSalary(newSalary);
                    found = true;
                    System.out.println("Salary updated successfully.");
                    break;
                }
            }

            if (!found) {
                System.out.println("Worker not found.");
            }
        }
    }
}
