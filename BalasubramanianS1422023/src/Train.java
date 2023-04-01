public class Train {
    public String trainName;
    public String trainSource;
    public String trainDestination;
    public Integer ticketPrice;

    public Train(String trainName,String trainSource, String trainDestination, Integer ticketPrice){
        this.trainName = trainName;
        this.trainSource = trainSource;
        this.trainDestination = trainDestination;
        this.ticketPrice = ticketPrice;

    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainSource() {
        return trainSource;
    }

    public void setTrainSource(String trainSource) {
        this.trainSource = trainSource;
    }

    public String getTrainDestination() {
        return trainDestination;
    }

    public void setTrainDestination(String trainDestination) {
        this.trainDestination = trainDestination;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainName='" + trainName + '\'' +
                ", trainSource='" + trainSource + '\'' +
                ", trainDestination='" + trainDestination + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
