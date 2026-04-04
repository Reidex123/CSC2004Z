package sampleII;

public class Oddities {

    public static void main(String[] args) {

        try (java.util.Scanner input = new java.util.Scanner(System.in)) {

            System.out.println("Enter the name of the text file of dates:");
            String filename = input.nextLine();

            Dates dates = new Dates(filename);

            for (java.time.LocalDate date : dates.list) {
                System.out.println(date.toString());
            }

        }
    }
}

// Store dates from the text file (formatted)
class Dates {

    public java.util.List<java.time.LocalDate> list = new java.util.ArrayList<>();

    public Dates(String filename) {
        this.store(filename);
    }

    private void store(String filename) {

        try (java.io.BufferedReader file = new java.io.BufferedReader(new java.io.FileReader(filename))) {
            String line = file.readLine();

            while (line != null) {
                java.time.LocalDate d = java.time.LocalDate.parse(line,
                        java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy"));

                list.add(d);

                line = file.readLine();
            }
        }
        catch (java.io.IOException e) {
            System.out.println("File not found!!");
        }
    }
}
