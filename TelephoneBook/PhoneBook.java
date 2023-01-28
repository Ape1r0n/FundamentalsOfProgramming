//package TelephoneBook;
//
//public class PhoneBook{
//    private Entry[] entries;
//
//    public PhoneBook(Entry[] entries) {
//        this.entries = entries;
//    }
//
//    public String find(String firstName, String lastName){
//        int i = 0, k = entries.length - 1;
//
//        while(i <= k){
//            int pos = (k+i)/2;
//
//            if(entries[pos].getLastName().compareTo(lastName) == 0){
//                if(entries[pos].getFirstName().compareTo(firstName) == 0)
//                    return entries[pos].getPhoneNumber();
//                else if(entries[pos].getFirstName().compareTo(firstName) > 0)
//                    k = pos - 1;
//                else
//                    i = pos + 1;
//            }else if(entries[pos].getLastName().compareTo(lastName) > 0){
//                k = pos - 1;
//            }else{
//                i = pos + 1;
//            }
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        Entry[] entries = new Entry[5];
//        entries[0] = new Entry("Agathe", "Ackermann", "555-11133322");
//        entries[1] = new Entry("Bernd", "Ackermann", "555-2251243");
//        entries[2] = new Entry("Winfried", "Becker", "555-225123");
//        entries[3] = new Entry("Alex", "Dieß", "555-343112");
//        entries[4] = new Entry("Beatrix", "Dieß",  "555-2123123");
//        PhoneBook phoneBook = new PhoneBook(entries);
//        System.out.println(entries[0].getPhoneNumber().equals(phoneBook.find("Agathe", "Ackermann")));
//        System.out.println(phoneBook.find("Bernd","Ackermann"));
//    }
//}
