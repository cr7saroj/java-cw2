
package task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class LiteraturePrize {
    private String year;
    private Laureate laureate;

    public LiteraturePrize(String year, Laureate laureate) {
        this.year = year;
        this.laureate = laureate;
    }

    public String getYear() {
        return year;
    }

    public Laureate getLaureate() {
        return laureate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Year: ").append(year).append("\n");
        sb.append("Laureate: ").append(laureate.toString()).append("\n");
        return sb.toString();
    }

    
}

class Laureate {
    private String name;
    private String birthYear;
    private String deathYear;
    private String nationality;
    private String language;
    private String citation;
    private String genre;

    public Laureate(String name, String birthYear, String deathYear, String nationality, String language, String citation, String genre){
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.nationality = nationality;
        this.language = language;
        this.citation = citation;
        this.genre = genre;
    }

    public String getName(){
        return name;
    }

    // Constructor, getters, setters omitted for brevity

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        // Append other fields similarly
        return sb.toString();
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getDeathYear() {
        return deathYear;
    }

    public String getNationality() {
        return nationality;
    }

    public String getLanguage() {
        return language;
    }

    public String getCitation() {
        return citation;
    }

    public String getGenre() {
        return genre;
    }

}

public class ApplicationRunner {
    private static List<LiteraturePrize> prizes = new ArrayList<>();

    public static void main(String[] args) {
        
        String fileLocation = System.getProperty("user.dir");
        String dataPath = fileLocation + File.separator + "Task1" + File.separator + "literature-prizes.txt";
        loadPrizes(dataPath);
        runMenu();
    }

    private static void loadPrizes(String dataPath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(dataPath)));
            String[] parts = content.split("-----");

            for (int i = 1; i < parts.length; i++) {
                String[] lines = parts[i].split("\n");
                // System.out.println(lines[2]);

                System.out.println(lines.length); 

                // // System.out.println(parts[3]);

                // // check to see if the year is in the given array
                // int[] yearsNotAwarded = {1914, 1918, 1935, 1940, 1941, 1942, 1943, 1944, 1945};
                
                // for (int year : yearsNotAwarded) {
                //     if (lines[1].contains(String.valueOf(year))) {
                //         // System.out.println("Not awarded");
                //     }
           
                // }



                // String[] data = lines[2].split("\\|"); // Use pipe as delimiter

                // String nameAndYears = data[0];
                // String nationality = data[1];
                // String language = data[2];

                // String[] nameAndYearsData = nameAndYears.split("\\s\\("); // Split name and years
                // String name = nameAndYearsData[0];
                // String[] years = nameAndYearsData[1].replace(")", "").split("-"); // Remove closing parenthesis and split years

                // String yearBorn = years[0];
                // String yearDied = years[1];
                // System.out.println("Birthplace: " + yearBorn);

                    // Continue processing data...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runMenu() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("----------------------");
            System.out.println("Literature prize menu");
            System.out.println("----------------------");
            System.out.println("List ................1");
            System.out.println("Select ..............2");
            System.out.println("Search ..............3");
            System.out.println("Exit.................0");
            System.out.println("----------------------");
            System.out.print("Enter choice > ");

            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    listPrizes();
                    break;
                case "2":
                    selectPrize();
                    break;
                case "3":
                    searchPrizes();
                    break;
                case "0":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("0"));
    }
    private static void listPrizes() {
        // Implement the functionality to list all prizes
        for (LiteraturePrize prize : prizes) {
            System.out.println(prize);
        }
    }
    
    private static void selectPrize() {
        // Implement the functionality to select a prize
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year of the prize: ");
        String year = scanner.nextLine();

        for (LiteraturePrize prize : prizes) {
            if (prize.getYear().equals(year)) {
                System.out.println(prize);
            }
        }
    }
    
    private static void searchPrizes() {
        // Implement the functionality to search for prizes
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the laureate: ");
        String name = scanner.nextLine();

        for (LiteraturePrize prize : prizes) {
            if (prize.getLaureate().getName().equalsIgnoreCase(name)) {
                System.out.println(prize);
            }
        }
    }
    
}

