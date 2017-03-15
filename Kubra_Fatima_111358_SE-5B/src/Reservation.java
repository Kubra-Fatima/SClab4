/**
 * Created by Hp-pc on 3/15/2017.
 */
public class Reservation {
    public int ID;
    public String reservedby;
    public String Time;
    public int People;
    public Reservation next;
    public Table T;
    public Reservation(int I,String R,String T, int P){
        ID=I;
        reservedby=R;
        Time=T;
        People=P;
        T=null;
        next=null;
    }

    public boolean is_available(available_tables tabless[]) // checks if a table is available for reservation or not
    {
        if (Time=="lunch"||Time=="Lunch"||Time=="LUNCH") // if lunch time reservation then check list for lunch time available tables
        //else check for dinner time tablee
        {
            if (tabless[0].searchtable(People)==true)
                return true;
            else
                return false;
        }
        else
        {if (tabless[1].searchtable(People)==true)
            return true;
        else
            return false;

        }
    }

}
