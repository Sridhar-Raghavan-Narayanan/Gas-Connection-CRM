package gasBooking;

import Customers.GasConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Booking extends GasConnection {
    private double otp=2233;
    private double amnt=800.0, refund=0;
    private String date, date2, Status, delMobilenum="1111111111";
    private Date BookingDate, DelDate;
    SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
    public double getOtp() {
        return otp;
    }
    public double getAmnt() {
        return amnt;
    }
    public void setAmnt(double amnt) {
        this.amnt = amnt;
    }
    public double getRefund() {
        return refund;
    }
    public void setRefund(double refund) {
        this.refund = refund;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDate2() {
        return date2;
    }
    public void setDate2(String date2) {
        this.date2 = date2;
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
    public String getDelMobilenum() {
        return delMobilenum;
    }
    public void setDelMobilenum(String delMobilenum) {
        this.delMobilenum = delMobilenum;
    }
    public void setBookingDate(Date bookingDate) {
        BookingDate = bookingDate;
    }
    public Date getBookingDate() {
        return BookingDate;
    }
    public Date getDelDate() {
        return DelDate;
    }
    public void setDelDate(Date delDate) {
        DelDate = delDate;
    }
    public Booking(String name, String mobNumber, String street, String area, String doorNo, String pincode, int numberOfCylinders) {
        super(name, mobNumber, street, area, doorNo, pincode, numberOfCylinders);
    }
    public void outBookingDate() {
        System.out.print("Enter the Booking Date: ");
        setDate(new Scanner(System.in).nextLine());
        try {
            setBookingDate(dateFormat.parse(date));
        } catch (Exception e) {
            System.out.println("Error Encountered!!!"+e);
        }

        System.out.print("Enter the delivery date: ");
        setDate2(new Scanner(System.in).nextLine());
        try {
            setDelDate(dateFormat.parse(date2));
        } catch (Exception e) {
            System.out.println("Error Encountered!!!"+e);
        }

        try{
            long difference=getDelDate().getTime()-getBookingDate().getTime();
            long interval= TimeUnit.DAYS.convert(difference,TimeUnit.MILLISECONDS);
            if(interval>7){
                setStatus("P");
            }
        }catch (Exception e){
            System.out.println("Error Encountered"+e);
        }
    }
    public void validate(){
        long bookingDiff=getBookingDate().getTime()-getLastDate().getTime();
        long bookingInterval=TimeUnit.DAYS.convert(bookingDiff,TimeUnit.MILLISECONDS);
        System.out.println("The difference between two dates: "+bookingInterval);

        switch (getNumberOfCylinders()) {
            case 1 -> {
                if (bookingInterval < 30) {
                    System.out.println("Booking cannot be done.");
                    setStatus("C");
                } else {
                    System.out.println("Cylinder Booked.");
                    setStatus("B");
                    setLastDate(getBookingDate());
                }
            }
            case 2 -> {
                if (bookingInterval < 50) {
                    System.out.println("Booking cannot be done.");
                    setStatus("C");
                } else {
                    System.out.println("Cylinder Booked.");
                    setStatus("B");
                    setLastDate(getBookingDate());
                }
            }
        }
    }
}