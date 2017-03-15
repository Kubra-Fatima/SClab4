/**
 * Created by Hp-pc on 3/15/2017.
 */
public class rest_reserv {
    public static void main(String args[]) {
//available_tables AT[]=new available_tables[2]; ; // AT[0] for lunch time availability;// AT[1] for dinner time availability;
        available_tables AT[]=new available_tables[2];
        AT[0]=new available_tables(); //for lunch time // initially have all the tables in it as they all are initially available
        AT[1]=new available_tables();//for dinner time// initially have all the tables in it as they all are initially available

        reserved Res=new reserved(); // list for reservations //initially empty as no reservation in the begining

        System.out.println("RESERVATION OF 12 (only one Table) at same time");
        Reservation R1=new Reservation(1,"Menobia","Lunch",12);
        Reservation R2=new Reservation(2,"Hassan","Lunch",12);
        System.out.println( Res.reserve(R1,AT));
        System.out.println( Res.reserve(R2,AT));
        Res.remove(1,AT); // removing reservation R1

        System.out.println("RESERVATION OF 12 after removing the first reservation of 12");
        System.out.println( Res.reserve(R2,AT)); // trying for R2 after removing R!
        Res.remove(2,AT); // removing reservation R2

        System.out.println("RESERVATION OF 12 (only one Table) at Different time");
        Reservation R5=new Reservation(5,"Hamid","Dinner",12);
        Reservation R6=new Reservation(6,"ALi","Lunch",12);
        System.out.println( Res.reserve(R5,AT));
        System.out.println( Res.reserve(R6,AT));

        System.out.println("RESERVATION OF 4,3  at same time (3 tables of 4 available");
        Reservation R3=new Reservation(3,"Sanea","Lunch",4);
        Reservation R4=new Reservation(4,"Ayesha","Lunch",3);
        System.out.println( Res.reserve(R3,AT));
        System.out.println( Res.reserve(R4,AT));
    }
}
