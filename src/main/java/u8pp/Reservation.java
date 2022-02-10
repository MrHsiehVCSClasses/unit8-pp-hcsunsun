package u8pp;

public class Reservation{

    //variables
    String name;
    boolean frequentFlyer;

    //Constructor
    public Reservation(String enteredName, boolean isit)
    {
        name = enteredName;
        frequentFlyer = isit;
    }

    //methods
    public boolean isFrequentFlyer()
    {
        return this.frequentFlyer;
    }

    //helper method
    public String getPassengerName()
    {
        return this.name;
    }
}