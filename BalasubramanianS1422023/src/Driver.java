import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
//        map with the train data
        Map<Integer, Train> trainData = new HashMap<>();
        trainData.put(1001, new Train("Shatabdi Express","Banglore","Delhi",2500));
        trainData.put(1002, new Train("Shatabdi Express", "Delhi","Banglore",2500));
        trainData.put(1003, new Train("Udyan Express","Banglore","Mumbai",1500));
        trainData.put(1004, new Train("Udyan Express","Mumbai","Banglore",1500));
        trainData.put(1005, new Train("Brindavan Express","Banglore","Chennai",1000));
        trainData.put(1006, new Train("Brindavan Express","Chennai","Banglore",1000));
//        arraylist for passenger data
        List<Passenger> passengers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the train number");
        Integer trainNumber = scanner.nextInt();
        System.out.println("Enter travel date (dd/MM/yyyy)");
        String inputDate = scanner.next();
//        converting string to date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate travelDate = LocalDate.parse(inputDate,formatter);

        System.out.println("Enter number of passenger");
        int count = scanner.nextInt();
//        iterating the count of passengers to get input details of passengers
        for(int i =0;i<count;i++){
            System.out.println("Enter passenger name");
            String passengerName = scanner.next();
            System.out.println("Enter age");
            int passengerAge = scanner.nextInt();
            System.out.println("Enter Gender (M/F)");
            String passengerGender = scanner.next();
//            appending the passenger detail to list
            passengers.add(new Passenger(passengerName,passengerAge,passengerGender));
        }

        PriceCalculator price = new PriceCalculator();
        double totalPrice = 0.0;
//        list for storing individual price of passengers
        List<Double> individualPrice = new ArrayList<>();
//        iterating to calculate totalprice and ticket price of individual passenger
        for (int i=0;i<count;i++){
            double temp = price.ticketPriceCalculator(trainNumber, trainData, passengers, i);
            individualPrice.add(temp);
            totalPrice += temp;
        }
        int counter = 100;
//        generating pnr number
        String PNR = "" + trainData.get(trainNumber).getTrainSource().charAt(0) + trainData.get(trainNumber).getTrainDestination().charAt(0) +
                "_" + travelDate.getYear() + travelDate.getMonthValue() + travelDate.getDayOfMonth() + "_" + counter ;
        counter+=1;
//        displaying output
        System.out.println("PNR: " + PNR);
        System.out.println("Train No.: " + trainNumber);
        System.out.println("Train Name: " + trainData.get(trainNumber).getTrainName());
        System.out.println("From: " + trainData.get(trainNumber).getTrainSource());
        System.out.println("To: " + trainData.get(trainNumber).getTrainDestination());
        System.out.println("TravelDate: " + travelDate);
        System.out.println("Passengers");
//        iterating to display individual passenger and their ticket price
        for(int i = 0; i<count;i++){
            System.out.println(passengers.get(i).toString() + "price: " + individualPrice.get(i));
        }
        System.out.println("TotalPrice: " + totalPrice);

    }
}