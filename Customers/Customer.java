package Customers;
import gasSupplier.gasAgency;
public class Customer implements gasAgency{
    private String name, mobNumber, street, area, doorNo, pincode;
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getDoorNo() {
        return doorNo;
    }
    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMobNumber() {
        return mobNumber;
    }
    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }
    public String getPincode() {
        return pincode;
    }
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    public String getAddress(){
        String Address=doorNo+", "+street+", "+area+", "+pincode+".";
        return Address;
    }
    public Customer(String name, String mobNumber, String street, String area, String doorNo, String pincode) {
        this.name = name;
        this.mobNumber = mobNumber;
        this.street = street;
        this.area = area;
        this.doorNo = doorNo;
        this.pincode = pincode;
    }
}