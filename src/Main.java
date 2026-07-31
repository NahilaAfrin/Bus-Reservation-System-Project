import java.util.Scanner;

class Bus {
    int busNo;
    String source;
    String destination;
    String arrivalTime;
    String departureTime;
    int totalSeats;
    int availableSeats;

    double fare;

    Bus(int busNo, String source, String destination,String arrivalTime,String departureTime, int totalSeats, double fare) {
        this.busNo = busNo;
        this.source = source;
        this.destination = destination;
        this.arrivalTime=arrivalTime;
        this.departureTime=departureTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.fare = fare;
    }

    void displayBus() {
        System.out.println("----------------------------------------");
        System.out.println("Bus Number      : " + busNo);
        System.out.println("Route           : " + source + " -> " + destination);
        System.out.println("Arrival Time    :"+arrivalTime);
        System.out.println("Departure Time  :"+departureTime);
        System.out.println("Available Seats : " + availableSeats);
        System.out.println("Fare           Rs : " + fare);
    }
}

 class BusReservationSystem {

    static Scanner sc = new Scanner(System.in);

    static Bus[] buses = {
            new Bus(101, "Chennai", "Madurai", "5:30 AM", "1:00 PM",45,450),
            new Bus(102, "Coimbatore", "Salem", "10:30 PM", "3:30 AM",45,300),
            new Bus(103, "Trichy", "Chennai", "9:45 AM", "3:30 PM",45,400),
            new Bus(104,"Chennai","Bangalore","8:00 PM","4:00 AM",45,650),
            new Bus(105,"Cochin","Chennai","1:10 AM","2:00 PM",45,850)
    };

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========== BUS RESERVATION SYSTEM ==========");
            System.out.println("1. View Buses");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewBuses();
                    break;

                case 2:
                    bookTicket();
                    break;

                case 3:
                    cancelTicket();
                    break;

                case 4:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

    }

    static void viewBuses() {

        System.out.println("\nAvailable Buses:");

        for (int i=0;i< buses.length;i++) {
            buses[i].displayBus();
        }
    }

    static void bookTicket() {

        System.out.print("Enter Bus Number: ");
        int busNo = sc.nextInt();

        Bus selectedBus = null;

        for (int i=0;i<buses.length;i++) {
            if (buses[i].busNo == busNo) {
                selectedBus = buses[i];
                break;
            }
        }

        if (selectedBus == null) {
            System.out.println("Bus not found.");
            return;
        }

        if (selectedBus.availableSeats == 0) {
            System.out.println("No seats available.");
            return;
        }

        sc.nextLine();

        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Aadhar Number for Identification :");
        String aadharNumber= sc.nextLine();
        System.out.println("Enter Journey Date (Date/Month/Year) :");
        String journeyDate= sc.nextLine();
        System.out.print("Number of Seats: ");
        int seats = sc.nextInt();

        if (seats > selectedBus.availableSeats) {
            System.out.println("Requested seats not available.");
            return;
        }

        selectedBus.availableSeats -= seats;

        double totalFare = seats * selectedBus.fare;

        System.out.println("\n========== TICKET ==========");
        System.out.println("Passenger Name : " + name);
        System.out.println("Age            : " + age);
        System.out.println("Bus Number     : " + selectedBus.busNo);
        System.out.println("Route          : " + selectedBus.source + " -> " + selectedBus.destination);
        System.out.println("Identification(Aadhar Number):"+aadharNumber);
        System.out.println("Journey Date   :"+journeyDate);
        System.out.println("Arrival Time   :"+selectedBus.arrivalTime);
        System.out.println("Departure Time :"+selectedBus.departureTime);
        System.out.println("Seats Booked   : " + seats);
        System.out.println("Total Fare     : Rs." + totalFare);
        System.out.println("Booking Successful!");
    }

    static void cancelTicket() {

        System.out.print("Enter Bus Number: ");
        int busNo = sc.nextInt();

        Bus selectedBus = null;

        for (int i=0;i<buses.length;i++) {
            if (buses[i].busNo == busNo) {
                selectedBus = buses[i];
                break;
            }
        }

        if (selectedBus == null) {
            System.out.println("Bus not found.");
            return;
        }

        System.out.print("Enter number of seats to cancel: ");
        int seats = sc.nextInt();

        if (selectedBus.availableSeats + seats > selectedBus.totalSeats) {
            System.out.println("Invalid cancellation.");
            return;
        }

        selectedBus.availableSeats += seats;

        System.out.println("Ticket cancelled successfully.");
    }
}