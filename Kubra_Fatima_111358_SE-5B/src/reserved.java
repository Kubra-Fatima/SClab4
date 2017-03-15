/**
 * Created by Hp-pc on 3/15/2017.
 */
public class reserved {
    private Reservation head;
    private Reservation current;

    public reserved() {
        head = null;
        current = null;
    }

    public boolean reserve(Reservation R, available_tables t[])
    // if table is available at that time it adds the reservation to the reserved list
    {
        if (R.is_available(t) == true) {
            Reservation newR = R;
            if (head == null)
                head = R;
            else {
                current = head;
                while(current.next!=null)
                    current=current.next;
                current.next=R;
            }
            if (R.Time=="lunch"||R.Time=="Lunch"||R.Time=="LUNCH") // if lunch time reservation then remove the table just reserved from available tables list of lunch time  so that it cannot be re reserved
            {
                t[0].remove(R.People);
            }
            else
            {
                t[1].remove(R.People); // if dinner time reservation then remove the table just reserved from available tables list of dinner time  so that it cannot be re reserved
            }
            return true;
        }
        else
            return false;
    }


    public void remove(int ID,available_tables t[] )// removes the reservation on cencellation
    {Reservation temp,previous;
        previous=head;
        temp=head;
        while ((temp != null) && (temp.ID!= ID))
        {
            previous = temp;
            temp = temp.next;
        }
        if (temp.Time=="lunch"||temp.Time=="Lunch"||temp.Time=="LUNCH") // removes from the list of respective time
        {
            t[0].add("type",temp.People);
        }
        else
        {
            t[1].add("type",temp.People);
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

    public boolean searchReservation(int ID){
        Reservation temp;
        temp=head;
        while ((temp != null) && (temp.ID!=ID))
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
            System.out.println(current.reservedby);
            System.out.println(current.T.seats);
            current = current.next;
            System.out.println("----");
        }

    }
}
