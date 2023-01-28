package PhonyBook;

public class PhoneBookEntry implements CsvEntry{
    private String firstName, lastName;
    private int number;

    public PhoneBookEntry(String firstName, String lastName, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public String toHtml(){
        return "<tr><td>" + firstName + " " + lastName + "</td><td>" + number + "</td></tr>";
    }

    public static CsvEntry cellsToEntry(String[] cells){
        if(cells.length != 3) return null;

        try {
            return new PhoneBookEntry(cells[0],cells[1],Integer.parseInt(cells[2]));
        } catch (NumberFormatException e){
            return null;
        }
    }
}
