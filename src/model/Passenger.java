package model;

public class Passenger {
    private int passId;
    private String name;
    private int age;
    private String bookingDate;
    private  double amount;
    private int busId;
    private String startPoint;
    private String dest;
    private String travelData;

    public Passenger(String name,int age, String bookingDate, double amount, int busId, String startPoint, String dest, String travelData){
        this.name = name;
        this.age = age;
        this.bookingDate = bookingDate;
        this.amount = amount;
        this.busId = busId;
        this.startPoint = startPoint;
        this.dest = dest;
        this.travelData = travelData;
    }
    public Passenger(int passId,String name,int age, String bookingDate, double amount, int busId, String startPoint, String dest){
        this.passId = passId;
        this.name = name;
        this.age = age;
        this.bookingDate = bookingDate;
        this.amount = amount;
        this.busId = busId;
        this.startPoint = startPoint;
        this.dest = dest;
    }
    public int getPassId() {return passId;}
    public void setPassId(int passId) {this.passId = passId; }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    public String getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getBusId() {
        return busId;
    }
    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getStartPoint() {
        return startPoint;
    }
    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getDest() {
        return dest;
    }
    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getTravelData() {
        return travelData;
    }
    public void setTravelData(String travelData) {
        this.travelData = travelData;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passId=" + passId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", busId=" + busId +
                '}';
    }

}
