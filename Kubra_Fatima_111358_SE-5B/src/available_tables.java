/**
 * Created by Hp-pc on 3/15/2017.
 */
public class available_tables {

    private Table head;
    private Table current;

    public available_tables(){
        head=null;
        current=null;
        initialize(); // it will add all the tables in the list because initially they all are empty

// by default all the tables will be available in the begining

    }
    public void initialize() // adds all the tables initially
    {
        add("small",2);
        add("small",2);
        add("small",2);
        add("small",2);
        add("medium",4);
        add("medium",4);
        add("medium",4);
        add("medium",4);
        add("medium",4);
        add("medium",4);
        add("medium",4);
        add("medium",4);
        add("large",6);
        add("large",6);
        add("large",6);
        add("extralarge",12);
    }

    public void add(String T,int S) // inserts available table in list in ascending order (by number of seats )
    {
        Table newT=new Table(T,S);
        Table previous=null;
        Table current=head;
        while (current!=null&&S>current.seats)
        {
            previous=current;
            current=current.next;
        }
        if (previous==null)
            head=newT;
        else
            previous.next=newT;
        newT.next=current;
    }

    public void remove(int N) // when table is reserverd, this function removes it from the list
    {
        Table temp,previous;
        previous=head;
        temp=head;
        while ((temp != null) && (temp.seats< N))
        {
            previous = temp;
            temp = temp.next;
        }
        if (temp == head)//if user wants to delete the first node
        {
            head = temp.next;
            temp = null;
        }
        else if (temp.next==null)         //if want to delete node at end
        {
            previous.next=null;
            current = previous;
            temp = null;
        }
        else if (temp.next != null) //if want to delete node in-between the list
        {
            previous.next= temp.next;
            temp = null;
        }

    }

    public boolean searchtable(int N){ // search if a table for N people is available or not
        Table temp;
        temp=head;
        while ((temp != null) && (temp.seats< N))
        {
            temp = temp.next;
        }
        if (temp!=null)
            return true;
        else return false;
    }

    public void display() // function to display the list
    {
        current = head;
        if (head==null){ // if no nodes
            System.out.println("EMPTY");
        }
        while (current!=null)
        {
            System.out.println(current.type);
            System.out.println(current.seats);
            current = current.next;
            System.out.println("----");
        }

    }
}
