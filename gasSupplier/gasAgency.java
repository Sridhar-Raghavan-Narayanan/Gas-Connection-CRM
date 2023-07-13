package gasSupplier;

public interface gasAgency {
    String agencyName = "dummy";
    int agencyCode=1234;
    String phnNumber ="0000000000";
    int pinCode=111111;

    default void agencyDisplay(){
        System.out.println("Agency Details: \n");
        System.out.println("Agency Name: "+agencyName);
        System.out.println("Agency Contact Number: "+phnNumber);
        System.out.println("Agency Pincode: "+pinCode);
    }

}
