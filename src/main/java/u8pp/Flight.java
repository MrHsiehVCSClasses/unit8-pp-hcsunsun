package u8pp;
import java.util.ArrayList;

public class Flight{
    
    //Variables
    int row;
    int col;
    Reservation[][] seats; 

    //Constructor
    public Flight(int rowEntered, int colEntered){
        row = rowEntered;
        col = colEntered;
        seats = new Reservation[row][col + 1];
        aisle();
    }

    //Methods
    public ArrayList<String> getFrequentFlyers(){
        ArrayList<String> toReturn = new ArrayList<String>();
        for(Reservation[] currRow : seats){
            for(Reservation curr : currRow){
                if(!(curr == null)){
                    if(!(curr.getPassengerName().equals("AISLE")) && curr.isFrequentFlyer())
                        toReturn.add(curr.getPassengerName());
                }
            }
        }
        return toReturn;
    }

    public boolean reserveNextAvailableSeat(String name, boolean freqFlyer)
    {

        for(int row = 0; row < seats.length; row++){
            for(int col = 0; col < seats[0].length; col++){
                if(seats[row][col] == null){
                    seats[row][col] = new Reservation(name, freqFlyer);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean reserveAdjacentSeats(String passengerName, boolean firstFrequentFlyer, String passengerNameTwo, boolean secondFrequentFlyer){
        for(int row = 0; row < seats.length; row++){
            for(int col = 0; col < seats[0].length - 1; col++){
                if(seats[row][col] == null && seats[row][col+1] == null){
                    seats[row][col] = new Reservation(passengerName, firstFrequentFlyer);
                    seats[row][col + 1] = new Reservation(passengerNameTwo, secondFrequentFlyer);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean reserveWindowSeat(String name, boolean freqFlyer){
        for(int row = 0; row < seats.length; row++){
            for(int col = 0; col < seats[0].length; col++){
                if(seats[row][col] == null && (col == 0 || col == seats[0].length -1)){
                    seats[row][col] =  new Reservation(name, freqFlyer);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean reserveAisleSeat(String name, boolean freqFlyer){
        for(int row = 0; row < seats.length; row++){
            for(int col = 0; col < seats[0].length; col++){
                if(seats[row][col] == null){
                    if(isAisle(row, col)){
                        seats[row][col] =  new Reservation(name, freqFlyer);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<String> getIsolatedPassengers()
    {
        ArrayList<String> toReturn = new ArrayList<String>();

        //non window
        for(int row = 0; row < seats.length; row++){
            for(int col = 0; col < seats[0].length; col++){
                if(seats[row][col] != null && !seats[row][col].getPassengerName().equals("AISLE")){
                    if(isIsolated(row, col)){
                        toReturn.add(seats[row][col].getPassengerName());
                    }
                }
            }
        }
        return toReturn;
    }

    public Reservation[][] getSeats(){
        return seats;
    }

    public String toString(){
        String toReturn = "";
        for(Reservation[] currRow : seats){
            String temp = "";
            for(Reservation curr : currRow){
                if(curr != null){
                    temp += curr.getPassengerName() + " ";
                }else{
                    temp += "EMPTY ";
                }
            }
            temp = temp.substring(0, temp.length() - 1);
            toReturn += temp + "\n";
            
        }

        return toReturn;
    }

    //Helper Method
    public void aisle(){
        int colOfAisle = (col+1) / 2;
        for(int i = 0; i < seats.length; i++)
            seats[i][colOfAisle] = new Reservation("AISLE", false);
        
    }

    public boolean isIsolated(int r, int c)
    {
        //check left
        boolean leftEmpty = false;
        if(c == 0)
        {leftEmpty = true;}
        else if((seats[r][c - 1] == null || seats[r][c - 1].getPassengerName().equals("AISLE"))){
            leftEmpty = true;
        }

        //check right
        boolean rightEmpty = false;
        if(c == seats[0].length - 1)
        {rightEmpty = true;}
        else if((seats[r][c + 1] == null || seats[r][c + 1].getPassengerName().equals("AISLE"))){
            rightEmpty = true;
        }

        return leftEmpty && rightEmpty;
    }

    public boolean isAisle(int r, int c)
    {
        //check left
        boolean left = false;
        if(c == 0)
        {left = false;}
        else if(!(seats[r][c - 1] == null) && seats[r][c - 1].getPassengerName().equals("AISLE")){
            left = true;
        }

        //check right
        boolean right = false;
        if(c == seats[0].length - 1)
        {right = false;}
        else if(!(seats[r][c + 1] == null) && seats[r][c + 1].getPassengerName().equals("AISLE")){
            right = true;
        }

        return left || right;
    }
}