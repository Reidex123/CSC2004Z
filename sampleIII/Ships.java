package sampleIII;

public class Ships {

    public static void main(String[] args) {

        try (java.util.Scanner input = new java.util.Scanner(System.in)) {

            System.out.println("Enter the name of the ship data file:");
            String filename = input.nextLine();

            shipData data = new shipData(filename);

            for (int i = 0; i < data.getPairsOfLine().size(); i += 2) {
                String[] s1 = data.getPairsOfLine().get(i).split(" ");
                String[] s2 = data.getPairsOfLine().get(i + 1).split(" ");

                
            }
        }
    }

}

class shipData {

    private java.util.List<String> pairs_Line = new java.util.ArrayList<>();

    public shipData(String data) {

        this.readData(data);
    }

    private void readData(String data) {

        try (java.io.BufferedReader file = new java.io.BufferedReader(new java.io.FileReader(data))) {
            String line = file.readLine();

            while (line != null) {
                this.pairs_Line.add(line);
                line = file.readLine();
            }
        } catch (java.io.IOException e) {
            System.out.println("File not found!");
        }
    }

    public java.util.List<String> getPairsOfLine() {
        return this.pairs_Line;
    }
}
