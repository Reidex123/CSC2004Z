package sampleII;

public class Oddities {

    public static void main(String[] args) {

        try (java.util.Scanner input = new java.util.Scanner(System.in)) {

            System.out.println("Enter the name of the text file of dates:");
            String filename = input.nextLine();

            Dates dates = new Dates(filename);

            for (java.time.LocalDate date : dates.list) {

                if (hasAllOddDigits(date)) {
                    System.out
                            .println("The date " + date.format(java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy"))
                                    + " has all odd digits.");

                } else {
                    java.time.LocalDate nextDate = findNextOddDate(date);

                    long numDays = java.time.temporal.ChronoUnit.DAYS.between(date, nextDate);

                    if (numDays == 1) {
                        System.out.println("The first date after "
                                + date.format(java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy"))
                                + " with all odd digits is "
                                + nextDate.format(java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy"))
                                + " which is " + numDays + " day later.");

                    } else {
                        System.out.println("The first date after "
                                + date.format(java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy"))
                                + " with all odd digits is "
                                + nextDate.format(java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy"))
                                + " which is " + numDays + " days later.");
                    }
                }
            }

            System.out.println("Done");

        }
    }

    private static boolean hasAllOddDigits(java.time.LocalDate date) {
        char[] arr = date.format(java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy")).replace("/", "")
                .toCharArray();

        for (char c : arr) {
            int digit = Character.getNumericValue(c);

            if (digit % 2 == 0) {
                return false;
            }
        }

        return true;
    }

    private static java.time.LocalDate findNextOddDate(java.time.LocalDate date) {
        java.time.LocalDate next = date.plusDays(1);

        while (!hasAllOddDigits(next)) {
            next = next.plusDays(1);
        }

        return next;
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
        } catch (java.io.IOException e) {
            System.out.println("File not found!!");
        }
    }
}
