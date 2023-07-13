package gasBooking;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Delivery extends Booking{
    private String delPerson;
    private int cusOTP;
    public int getCusOTP() {
        return cusOTP;
    }
    public void setCusOTP(int cusOTP) {
        this.cusOTP = cusOTP;
    }
    public String getDelPerson() {
        return delPerson;
    }
    public void setDelPerson(String delPerson) {
        this.delPerson = delPerson;
    }
    public void amntCalc(){
        long diff=getDelDate().getTime()-getBookingDate().getTime();
        long interv= TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
        if(interv>7){
            setRefund(50);
            setAmnt(getAmnt()-getRefund());
        }
    }
    public void verifyOTP(){
        if(getStatus().equals("B")){
            System.out.print("Enter OTP: ");
            setCusOTP(new Scanner(System.in).nextInt());
            if(getCusOTP()!=getOtp()){
                setStatus("C");
                System.out.println("Incorrect OTP.\n");
            }else{
                setStatus("D");
                System.out.println("OTP verified.\n");
            }
        }else{
            System.out.println("No bookings found!!!\n");
        }
    }
    public void delPersonDetails(){
        System.out.print("Enter Delivery Person name: ");
        delPerson=new Scanner(System.in).nextLine();
    }

    public Delivery(String name, String mobNumber, String street, String area, String doorNo, String pincode, int numberOfCylinders) {
        super(name, mobNumber, street, area, doorNo, pincode, numberOfCylinders);
    }
}