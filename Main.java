import gasBooking.Delivery;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import static gasSupplier.gasAgency.*;

public class Main {
    static int count, bCount=0, cCount=0, dCount=0, pCount=0;
    static String dpName;
    public static void cylCount(Delivery[] del){
        String[] months= new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for(Delivery delivery:del){
            count=0;
            System.out.println("In the month of "+ months[(delivery.getDelDate().getMonth()-1)]+" : ");
            System.out.print(" * In "+delivery.getArea());

            if(delivery.getStatus().equals("D")){
                count+=delivery.getNumberOfCylinders();
            }
            System.out.println(" - "+count+" cylinders delivered.");
        }
        System.out.println("\n");
    }
    public static void chkLateDel(Delivery[] del){
        String[] months= new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] month= new int[12];
        for (Delivery delivery:del){
            if(delivery.getStatus().equals("D") && delivery.getAmnt()==750.00){
                month[delivery.getDelDate().getMonth()]+=1;
            }
        }
        System.out.println("-------------Late Delivery-------------");
        for (int i=0; i<12;i++){
            if(month[i]!=0){
                System.out.println(" * In "+months[i]+" there are "+month[i]+ " late deliveries.");
            }
        }
        System.out.println("\n");
    }
    public static void numOfSingleCyl(Delivery[] del){
        System.out.println("-------------Single Cylinder Holders-------------");
        for (Delivery delivery : del) {
            if (delivery.getNumberOfCylinders() == 1) {
                System.out.println(" * Customer Name: " + delivery.getName());
                System.out.println("    - Mobile Number: " + delivery.getMobNumber());
                System.out.println("    - Address: "+delivery.getAddress());
                System.out.println("    - Gas Connection Number: " + (delivery.getConnectionNumber() + 1)+"\n");
                delivery.setConnectionNumber((delivery.getConnectionNumber())+1);
            }
        }
        System.out.println("\n");
    }
    public static void numOfDoubleCyl(Delivery[] del){
        System.out.println("-------------Double Cylinder Holders-------------");
        for (Delivery delivery : del) {
            if (delivery.getNumberOfCylinders() == 2) {
                System.out.println(" * Customer Name: " + delivery.getName());
                System.out.println("    - Mobile Number: " + delivery.getMobNumber());
                System.out.println("    - Address: "+delivery.getAddress());
                System.out.println("    - Gas Connection Number: " + (delivery.getConnectionNumber() + 1));
                delivery.setConnectionNumber((delivery.getConnectionNumber())+1);
            }
        }
        System.out.println("\n");
    }
    public static void delPersonDetails(Delivery[] del){
        System.out.println("-------------Delivery Person Details-------------");
        System.out.print("Enter the name of the delivery person: ");
        dpName=new Scanner(System.in).nextLine();
        for(Delivery delivery: del){
            if(delivery.getStatus().equals("D") &&delivery.getDelPerson().equals(dpName)){
                System.out.println(" * Customer Name: " + delivery.getName());
                System.out.println("    - "+delivery.getAddress());
            }
        }
        System.out.println("\n");
    }
    public static void printReport(Delivery[] del) {
        System.out.println("-------------Final Report-------------");
        for (Delivery delivery : del) {
            switch (delivery.getStatus()) {
                case "B" -> bCount++;
                case "D" -> dCount++;
                case "P" -> pCount++;
                case "C" -> cCount++;
                default -> System.out.println("Invalid Status");
            }
        }
        System.out.println(" * Booked: ");
        System.out.println(" - "+bCount+" cylinders booked.");
        System.out.println(" * Delivered: ");
        System.out.println(" - "+dCount+" cylinders delivered.");
        System.out.println(" * Pending: ");
        System.out.println(" - "+pCount+" cylinders pending.");
        System.out.println(" * Cancelled: ");
        System.out.println(" - "+cCount+" cylinders canceled.");
        System.out.println("\n");
    }
    public static void printInvoice(Delivery[] del){
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String invoiceDate=sdf.format(d);
        for (Delivery delivery:del){
            if(delivery.getStatus().equals("D")){
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("                                    Invoice                                      ");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Gas Agency Code: "+agencyCode+"\t\t\t\t\t"+" Invoice Date: "+invoiceDate);
                System.out.println("Gas Agency Name: "+agencyName+"\t\t\t\t\t"+" Agency Phone Number: "+phnNumber);
                System.out.println("Gas Connection Number: "+delivery.getConnectionNumber()+"\t\t\t"+" Customer Name: "+delivery.getName());
                System.out.println("Customer Address: "+delivery.getAddress());
                System.out.println("Booking Date: "+delivery.getBookingDate()+ "\t\t\t"+" Mobile Number: "+delivery.getMobNumber());
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Amount: "+delivery.getAmnt());
                System.out.println("Refund: "+delivery.getRefund());
                System.out.println("Amount payable: "+(delivery.getAmnt()-delivery.getRefund()));
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Delivery person name: "+delivery.getDelPerson()+"\t\t"+
                        "Delivery Person Mobile.No: "+ delivery.getDelMobilenum());
                System.out.println("Delivery Date: "+sdf.format(delivery.getDelDate()));
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("\n\n");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("************************************************************************");
        System.out.println("                             ABC GAS AGENCY                             ");
        System.out.println("************************************************************************");
        Delivery[] delObj=new Delivery[5];

        delObj[0]=new Delivery("Agilan","2222222222","Karuna Street",
                "karumathampatti","22","222222",1);

        delObj[1]=new Delivery("Riya Agilan","6969696969","Power Street",
                "JSpatti","69","696969",1);

        delObj[2]=new Delivery("Karunambika Agilan","2254225422","Vicky Street",
                "Noodlespatti","22, Vicky veedu","225422",2);

        delObj[3]=new Delivery("Roopa Shree Agilan","6666666666","EnI Street",
                "FeministPatti","33","333333",2);

        delObj[4]=new Delivery("Kanishka Agilan","1431431431","Love Street",
                "Stickerpatti","43","143143",1);

        for (Delivery delivery:delObj){
            delivery.delPersonDetails();
            delivery.outLastDate();
            delivery.outBookingDate();
            delivery.validate();
            delivery.amntCalc();
            delivery.verifyOTP();
        }
        System.out.println();
        cylCount(delObj);
        chkLateDel(delObj);
        numOfSingleCyl(delObj);
        numOfDoubleCyl(delObj);
        delPersonDetails(delObj);
        printReport(delObj);
        printInvoice(delObj);
    }
}