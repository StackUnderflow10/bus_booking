package model;

public class Bus {
    private int busId;
    private String busNo;
    private int capacity;
    private int availableSeats;
    private String startPoint;
    private String destination;
    private String travelData;

    public Bus(int busId,String bus_no, int capacity, int available_seats, String start_point, String destination, String travel_date) {
        this.busId = busId;
        this.busNo = busNo;
        this.capacity = capacity;
        this.availableSeats =  availableSeats;
        this.startPoint = startPoint;
        this.destination = destination;
        this.travelData = travelData;
    }
    public int getBusId() { return busId; }
    public void setBusId(int busId) {this.busId = busId; }

    public String getBusNo() {return  busNo; }
    public void setBusNo(String busNo) {this.busNo = busNo; }

    public int getCapacity() { return capacity;}
    public void setCapacity(int capacity) {this.capacity = capacity;}

    public int getAvailableSeats() {return availableSeats;}
    public void setAvailableSeats(int availableSeats) {this.availableSeats = availableSeats;}

    public String getStartPoint() {return startPoint;}
    public void setStartPoint(String startPoint) {this.startPoint = startPoint;}

    public String getDestination() {return destination;}
    public void setDestination(String destination) {this.destination = destination;}

    public String getTravelDate() {return travelData;}
    public void setTravelDate(String travelDate) {this.travelData = travelData;}
}
