import java.util.Scanner;

public class IT24101446Lab5Q3 {
    public static void main(String[] args) {
      
      Scanner input = new Scanner(System.in);
      
      final double roomChargesPerDay = 48000;
      int discount = 0;
      final double total;
      int daysStayed;
      
     System.out.print("Enter start date(1-31) : ");
     int startDate = input.nextInt();
     
     System.out.print("Enter end date(1-31) : ");
     int endDate = input.nextInt();
     
     if(endDate <= startDate) {
        System.out.println("Error : Start day must be less than end date");
        return;
     }
     
     if ((startDate < 1 || startDate > 31) || endDate < 1 || endDate > 31){
       System.out.println("Error : Days must be between 1 and 31");
       return;
     }
     
     daysStayed = endDate - startDate;
     
     if(daysStayed < 3 ){
         discount = 0;
     }
     else if(daysStayed <= 4 && daysStayed >= 3){
         discount = 10;
     }
     else if(daysStayed > 5){
         discount = 20;
     }
     
     total = (roomChargesPerDay * daysStayed ) + (roomChargesPerDay * daysStayed ) * discount/100;
     
     System.out.println("Room charges per day = Rs." + roomChargesPerDay);
     System.out.println("Number of days reserved = " + daysStayed);
     System.out.println("Total amount to be paid = Rs." + total);
     
     
    }
}