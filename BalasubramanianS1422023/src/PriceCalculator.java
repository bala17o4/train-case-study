import java.util.*;
public class PriceCalculator {
    public double discountPrice;
    public double totalFair;
    public double ticketPriceCalculator(int trainNumber, Map<Integer, Train> trainData, List<Passenger> passengers, int count){

        discountPrice = 0.0;
        totalFair = 0.0;

        if(passengers.get(count).getGender().equals("F")){
            discountPrice += trainData.get(trainNumber).getTicketPrice() * 0.25;
            if(passengers.get(count).getAge() <= 12){

                discountPrice += trainData.get(trainNumber).getTicketPrice() * 0.5;
            }
            else if(passengers.get(count).getAge()>=60){
                discountPrice += trainData.get(trainNumber).getTicketPrice() * 0.6;
            }
            System.out.println(discountPrice);
        }
        else{
            if(passengers.get(count).getAge() <= 12){

                discountPrice += trainData.get(trainNumber).getTicketPrice() * 0.5;

            }
            else if(passengers.get(count).getAge()>=60){
                discountPrice += trainData.get(trainNumber).getTicketPrice() * 0.6;
            }
        }
        totalFair = trainData.get(trainNumber).getTicketPrice() - discountPrice;
        return totalFair;

    }

}
