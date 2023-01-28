package pgdp.company;

import java.util.Scanner;

public class CompanySimulation {
    public static void main(String[] args) {
        simulation("Novak","ATP");
    }

    private static void simulation(String ceoName, String companyName) {
        Employee ceo = new Employee(ceoName,null);
        ceo.setID(0);
        Company company = new Company(companyName,ceo);
        Scanner scanner = new Scanner(System.in);
        String numberOfQueries = scanner.nextLine();

        for (int k = 0; k < Integer.parseInt(numberOfQueries); k++) {
            String query = scanner.nextLine();
            // TO-DO
            query = query.trim();
            String[] strArr = query.split("\\s+");

            if(strArr[0].equals("EmployeeWithID") && strArr.length == 2){
                try {
                    System.out.println(company.findByID(Integer.parseInt(strArr[1])));
                } catch (Exception E) {
                    System.out.println("Second Argument after EmployeeWithID can not be converted into an integer");
                }
            }else if(strArr[0].equals("Fire") && strArr.length == 2){
                try {
                    company.fireEmployee(Integer.parseInt(strArr[1]));
                } catch (Exception E) {
                    System.out.println("Second Argument after Fire can not be converted into an integer");
                }
            }else if (strArr[0].equals("Add") && strArr.length == 3){
                try {
                    if(company.findByID(Integer.parseInt(strArr[2])) != null){
                       company.addEmployee(new Employee(strArr[1],company.findByID(Integer.parseInt(strArr[2]))));
                    }else{
                        System.out.println("Boss does not exist");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid arguments for 'Add'");
                }
            }else if(strArr[0].equals("FindCommonBoss") && strArr.length == 3){
                try {
                    if(company.findByID(Integer.parseInt(strArr[1])) != null && company.findByID(Integer.parseInt(strArr[2])) != null){
                        System.out.println(company.findCommonBoss(company.findByID(Integer.parseInt(strArr[1])),company.findByID(Integer.parseInt(strArr[2]))));
                    }else{
                        System.out.println("Either ID1 or ID2 is not present in the company");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid arguments for 'FindCommonBoss'");
                }
            }else{
                System.out.println("Invalid command");
            }
        }
        scanner.close();
    }
}
