import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File diploma = new File("diploma.csv");

        int index = 0;

        ArrayList<DiplomaData> diplomaData = new ArrayList<>();
        ArrayList<String> programs = new ArrayList<>();
        ArrayList<String> diplomaLanjutanNames = new ArrayList<>();
        ArrayList<String> kursusPengkhususanNames = new ArrayList<>();

        if(diploma.exists()) {
            System.out.println("File exists");

            if(diploma.canRead()){
                System.out.println("File is readable");
            } else {
                System.out.println("File is unreadable");
            }

            try(Scanner reader = new Scanner(diploma)) {
                while (reader.hasNext()){
                    String line = reader.nextLine();
                    if (index > 0) {
                    String[] items = line.split(",");

                    String category = items[1];
                    String name = items[2];

                    int total = Integer.parseInt(items[3]) + Integer.parseInt(items[4]) + Integer.parseInt(items[5]) + Integer.parseInt(items[6]) + Integer.parseInt(items[7]) + Integer.parseInt(items[8]);

                    int max = Math.max(Math.max(Math.max(Math.max(Math.max(Integer.parseInt(items[3]),  Integer.parseInt(items[4])), Integer.parseInt(items[5])), Integer.parseInt(items[6])), Integer.parseInt(items[7])), Integer.parseInt(items[8]));

                    int min = Math.min(Math.min(Math.min(Math.min(Math.min(Integer.parseInt(items[3]),  Integer.parseInt(items[4])), Integer.parseInt(items[5])), Integer.parseInt(items[6])), Integer.parseInt(items[7])), Integer.parseInt(items[8]));

                    DiplomaData data = new DiplomaData(category, name, total, max, min);

                    diplomaData.add(data);

                    System.out.print(index + " ");
                    System.out.println(data);
                    System.out.println();
                    }
                    index++;
                }

                for (DiplomaData row: diplomaData){
                    if (row.getCategory().equals(" Diploma Lanjutan")) {
                            diplomaLanjutanNames.add(row.getName());

                    }
                    if (row.getCategory().equals("Kursus Pengkhususan")) {
                            kursusPengkhususanNames.add(row.getName());

                    }
                    if (!(programs.contains(row.getCategory())) ){
                        programs.add(row.getCategory());

                    }
                }

                int index1 = 1;
                int index2 = 1;

                System.out.println("Diploma Lanjutan: ");
                for(String course: diplomaLanjutanNames){
                    System.out.print(index1 + ". ");
                    System.out.println(course);
                    index1++;
                }

                System.out.println();

                System.out.println("Kursus Pengkhususan: ");
                for(String course: kursusPengkhususanNames){
                    System.out.print(index2 + ". ");
                    System.out.println(course);
                    index2++;
                }



                for(String program: programs) {
                    try(PrintWriter writer = new PrintWriter(new File(program+".txt"))){
                        for(DiplomaData row: diplomaData) {
                            if(program.equals(row.getCategory())) {
                                writer.println(row);
                            }
                        }
                    } catch (FileNotFoundException exception) {
                        System.out.println(exception.getMessage());
                    }
                }


            } catch (FileNotFoundException exception) {
                System.out.println(exception.getMessage());
            }
        } else {
            System.out.println("File does not exists");
        }
    }
}