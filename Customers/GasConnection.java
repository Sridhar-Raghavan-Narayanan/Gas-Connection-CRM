package Customers;
import java.text.SimpleDateFormat;
import java.util.*;
public class GasConnection extends Customer {
    private int numberOfCylinders;
    private int connectionNumber=100000;
    private String date;
    {
        connectionNumber++;
    }
    private Date lastDate;
    SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }
    public void setNumberOfCylinders(int numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }
    public int getConnectionNumber() {
        return connectionNumber;
    }

    public void setConnectionNumber(int connectionNumber) {
        this.connectionNumber = connectionNumber;
    }

    public String getlDate() {
        return date;
    }
    public void setlDate(String date) {
        this.date = date;
    }
    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }
    public Date getLastDate() {
        return lastDate;
    }
    public void outLastDate(){
        System.out.print("Enter the last date: ");
        setlDate(new Scanner(System.in).nextLine());
        try {
            setLastDate(dateFormat.parse(date));
        } catch (Exception e) {
            System.out.println("Encountered an Error!!!"+e);
        }
    }

    public GasConnection(String name, String mobNumber, String street, String area, String doorNo, String pincode, int numberOfCylinders) {
        super(name, mobNumber, street, area, doorNo, pincode);
        this.numberOfCylinders = numberOfCylinders;
    }

}