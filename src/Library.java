import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {
        Scanner read = new Scanner(System.in);
        int option;


        do {
            System.out.println("""
                            Library menu
                                    
                    [1] Register a book.
                    [2] Search book.
                    [3] Delete book.
                    [4] Generate report.
                    [5] Leave.
                    """);

            System.out.println("Type your option: ");
            option = read.nextInt();

            if (option == 1) {
                RegisterBook();
            }
            if (option == 2) {
                SearchBook();
            }
            if (option == 3) {
                DeleteBook();
            }
            if (option == 4) {
                GenerateReport();
            }
            if (option != 5) {
                System.out.println("Invalid option. Try again!");

            }
        } while (option != 5);

        System.out.println("Leaving! good bye :)");

    }

    public static void RegisterBook() {
        Scanner read = new Scanner(System.in);
        int keep;
        do {
            System.out.println("Type the book name:");
            String bookName = read.nextLine();

            System.out.println("Type the author's name:");
            String authorsName = read.nextLine();

            System.out.println("Type the area of interest:");
            String areaOfInterest = read.nextLine();

            String pagesNumber;
            while (true) {
                System.out.println("Type the pages number:");
                pagesNumber = read.next();
                if (pagesNumber.matches("\\d+")) {
                    break;
                } else {
                    System.out.println("Only numbers!");
                }
            }
            String register = bookName + "," + authorsName + "," + areaOfInterest + "," + pagesNumber;

            String filename = "C:\\Users\\galof\\OneDrive\\Área de Trabalho\\Library.csv";

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
                writer.write(register);
                writer.newLine();
                writer.close();
                System.out.println("\nSuccessfully saved data!\n");
            } catch (Exception e) {
                e.printStackTrace();
            }


            System.out.println("""
                    Do you want to register another book??
                    1. Yes
                    2. No
                    """);

            System.out.println("Type your option: ");
            keep = read.nextInt();
            read.nextLine();

        } while (keep != 2);
    }


    public static void SearchBook() throws IOException {
        Scanner read = new Scanner(System.in);
        int keep;

        String fileName = "C:\\Users\\galof\\OneDrive\\Área de Trabalho\\Library.csv";

        do {
            String[] datas = Files.readAllLines(Paths.get(fileName)).toArray(new String[0]);

            if (datas.length > 0) {
                System.out.println("""
                                By which data do you wish to search the book?
                                
                        [1] Tittle.
                        [2] Author's name.
                        [3] Area of interest.
                        [4] Pages number.
                                
                        """);
                int option = read.nextInt();
                read.nextLine();

                if (option == 1) {
                    System.out.println("What's the book title?");
                    String bookName = read.nextLine();

                    boolean found = false;
                    for (String data : datas) {
                        String[] field = data.split(",");
                        if (field[0].equals(bookName)) {
                            found = true;
                            break;
                        }
                    }

                    if (found) {

                        System.out.println("Book(s) found with that title:");
                        for (String data : datas) {
                            String[] field = data.split(",");

                            if (field[0].equals(bookName)) {
                                System.out.println("👉🏻 Name: " + field[0] + ", Number of pages: " + field[3] + ", Author: " + field[1] + ", Area de interest: " + field[2]);
                            }
                        }
                    } else {
                        System.out.println("\nBook not found. Try again!\n");
                    }
                } else if (option == 2) {
                    System.out.println("What's the author's name?");
                    String authorsName = read.nextLine();

                    boolean found = false;
                    for (String data : datas) {
                        String[] field = data.split(",");
                        if (field[1].equals(authorsName)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        System.out.println("Book(s) found with that author's name: ");
                        for (String data : datas) {
                            String[] field = data.split(",");

                            if (field[1].equals(authorsName)) {
                                System.out.println("👉🏻 Name: " + field[0] + ", Number of pages: " + field[3] + ", Author: " + field[1] + ", Area de interest: " + field[2]);
                            }
                        }
                    } else {
                        System.out.println("\nAuthor not found. Try again!\n");
                    }
                } else if (option == 3) {
                    System.out.println("What's the area of interest?");
                    String areaOfInterest = read.nextLine();

                    boolean found = false;
                    for (String data : datas) {
                        String[] field = data.split(",");
                        if (field[2].equals(areaOfInterest)) {
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        System.out.println("Book(s) found with that area of interest: ");
                        for (String data : datas) {
                            String[] field = data.split(",");

                            if (field[2].equals(areaOfInterest)) {
                                System.out.println("👉🏻 Name: " + field[0] + ", Number of pages: " + field[3] + ", Author: " + field[1] + ", Area de interest: " + field[2]);
                            }
                        }
                    } else {
                        System.out.println("\nArea of interest not found. Try again!\n");
                    }
                } else if (option == 4) {
                    System.out.println("What's the pages number?");
                    String pagesNumber = read.nextLine();

                    boolean found = false;
                    for (String data : datas) {
                        String[] field = data.split(",");
                        if (field[3].equals(pagesNumber)) {
                            found = true;

                            break;
                        }
                    }
                    if (found) {
                        System.out.println("Book(s) found with that pages number: ");
                        for (String data : datas) {
                            String[] field = data.split(",");

                            if (field[3].equals(pagesNumber)) {
                                System.out.println("👉🏻 Name: " + field[0] + ", Number of pages: " + field[3] + ", Author: " + field[1] + ", Area de interest: " + field[2]);
                            }
                        }
                    } else {
                        System.out.println("\nPages number not found. Try again!\n");
                    }
                }
                System.out.println("""
                        Do you want to search another book?
                        [1] Yes
                        [2] No
                        """);
                keep = read.nextInt();
            } else {
                System.out.println("No one book registered at the moment!\n");
                break;
            }


        } while (keep != 2);
    }

    public static void DeleteBook() throws IOException {
        Scanner read = new Scanner(System.in);
        int keep = 0;

        String fileName = "C:\\Users\\galof\\OneDrive\\Área de Trabalho\\Library.csv";

        do {
            String[] datas = Files.readAllLines(Paths.get(fileName)).toArray(new String[0]);

            if (datas.length > 0) {
                System.out.println("""
                                By which data do you wish to delete a book?
                                
                        [1] Title.
                        [2] Author's name.
                        [3] Area of interest.
                        """);
                int option = read.nextInt();
                read.nextLine();

                if (option == 1) {

                    System.out.print("What's the book name to be deleted?");
                    String stringToExclude = read.nextLine();

                    boolean found = false;
                    for (String data : datas) {
                        String[] field = data.split(",");
                        if (field[0].equals(stringToExclude)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

                        for (String data : datas) {
                            String[] field = data.split(",");
                            if (!field[0].equals(stringToExclude)) {
                                writer.write(data);
                                writer.newLine();
                            } else {
                                System.out.println("\nSuccessfully deleted book!");
                            }
                        }
                        writer.close();

                    }
                    if (!found) {
                        System.out.println("\nBook not found. try again!\n");
                        continue;
                    }

                } else if (option == 2) {
                    System.out.print("What's the author's name to be deleted?");
                    String stringToExclude = read.nextLine();

                    boolean found = false;
                    for (String data : datas) {
                        String[] field = data.split(",");
                        if (field[1].equals(stringToExclude)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

                        for (String data : datas) {
                            String[] field = data.split(",");
                            if (!field[1].equals(stringToExclude)) {
                                writer.write(data);
                                writer.newLine();
                            } else {
                                System.out.println("\nSuccessfully deleted book!\n");
                            }
                        }
                        writer.close();
                    }
                    if (!found) {
                        System.out.println("\nAuthor not found. try again!\n");
                        continue;
                    }
                } else if (option == 3) {

                    System.out.print("What's the area of interest to be deleted?");
                    String stringToExclude = read.nextLine();

                    boolean found = false;
                    for (String data : datas) {
                        String[] field = data.split(",");
                        if (field[2].equals(stringToExclude)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

                        for (String data : datas) {
                            String[] field = data.split(",");
                            if (!field[2].equals(stringToExclude)) {
                                writer.write(data);
                                writer.newLine();
                            } else {
                                System.out.println("\nSuccessfully deleted book!\n");
                            }
                        }
                        writer.close();
                    }
                    if (!found) {
                        System.out.println("\nArea of interested not found. try again!\n");
                        continue;
                    }
                }

                System.out.println("""
                        Do you want to delete another book?
                        [1] Yes
                        [2] No
                        """);
                keep = read.nextInt();
                read.nextLine();
            } else {
                System.out.println("No one book registered at the moment!\n");
                break;
            }

        } while (keep != 2);
    }

    public static void GenerateReport() throws IOException {
        Scanner read = new Scanner(System.in);
        int keep;
        int R = 0;
        int RD = 0;

        String fileName = "C:\\Users\\galof\\OneDrive\\Área de Trabalho\\Library.csv";
        String[] datas = Files.readAllLines(Paths.get(fileName)).toArray(new String[0]);

        if (datas.length >= 1) {
            do {
                System.out.println("Which report do you want to generate?");
                System.out.println("[1] All books");
                System.out.println("[2] Specific book");

                System.out.print("\nType your option: ");
                int option = read.nextInt();
                read.nextLine();

                if (option == 1) {
                    try {
                        String nameOfNewFile = "C:\\Users\\galof\\OneDrive\\Área de Trabalho\\relatorio(" + R + ").csv";
                        R++;
                        FileWriter file = new FileWriter(nameOfNewFile);
                        PrintWriter recorder = new PrintWriter(file);

                        for (String line : datas) {
                            recorder.println(line);
                        }

                        recorder.close();
                        file.close();

                        System.out.println("Successfully generated file!");
                        System.out.println("👉🏻 " + nameOfNewFile);

                    } catch (IOException e) {
                        System.out.println("Error to generate CSV file: " + e.getMessage());
                    }
                } else if (option == 2) {
                    System.out.println("By which data do you wish to generate?");
                    System.out.println("[1] Book name");
                    System.out.println("[2] Pages number");
                    System.out.println("[3] Author's name");
                    System.out.println("[4] Area of interest");

                    System.out.print("\nType your option: ");
                    option = read.nextInt();
                    read.nextLine();

                    if (option == 1) {
                        while (true) {
                            boolean nameExist = false;

                            System.out.print("\nType the name of the book(s): ");
                            String bookName = read.nextLine();

                            for (String data : datas) {
                                String[] field = data.split(",");
                                if (field[0].equals(bookName)) {
                                    nameExist = true;
                                    break;
                                }
                            }

                            if (nameExist) {
                                String nameOfNewFile = "C:\\Users\\galof\\OneDrive\\Área de Trabalho\\relatorioDetalhado(" + RD + ").csv";
                                RD++;

                                try {
                                    FileWriter fw = new FileWriter(nameOfNewFile, true);
                                    BufferedWriter bw = new BufferedWriter(fw);

                                    for (String data : datas) {
                                        String[] field = data.split(",");
                                        if (field[0].equals(bookName)) {
                                            bw.write(data);
                                            bw.newLine();
                                        }
                                    }

                                    bw.close();
                                    fw.close();

                                    System.out.println("Successfully generated file!");
                                    System.out.println("👉🏻 " + nameOfNewFile);

                                } catch (Exception e) {
                                    System.out.println("Error adding filtered data to file: " + nameExist + ".");
                                    e.printStackTrace();
                                }

                                break;
                            } else {
                                System.out.println("\nThere isn't any book with that name. Try again!");
                            }
                        }
                    } else if (option == 2) {
                        while (true) {
                            boolean pagesExist = false;
                            String pagesNumber;

                            while (true) {
                                System.out.print("\nType the pages number of the book(s): ");
                                pagesNumber = read.nextLine();

                                if (pagesNumber.matches("\\d+")) {
                                    break;
                                } else {
                                    System.out.println("\nNúmero inválido, tente novamente!\n");
                                }
                            }

                            for (String data : datas) {
                                String[] field = data.split(",");
                                if (field[3].equals(pagesNumber)) {
                                    pagesExist = true;
                                    break;
                                }
                            }

                            if (pagesExist) {

                                String nameOfNewFile = "C:\\Users\\galof\\OneDrive\\Área de Trabalho\\relatorioDetalhado(" + RD + ").csv";
                                RD++;

                                try {
                                    FileWriter fw = new FileWriter(nameOfNewFile, true);
                                    BufferedWriter bw = new BufferedWriter(fw);

                                    for (String data : datas) {
                                        String[] field = data.split(",");
                                        if (field[3].equals(pagesNumber)) {
                                            bw.write(data);
                                            bw.newLine();
                                        }
                                    }

                                    bw.close();
                                    fw.close();

                                    System.out.println("Successfully generated file!");
                                    System.out.println("👉🏻 " + nameOfNewFile);

                                } catch (Exception e) {
                                    System.out.println("Error adding filtered data to file: " + nameOfNewFile + ".");
                                    e.printStackTrace();
                                }

                                break;
                            } else {
                                System.out.println("\nThere isn't any book with that pages number. Try again!");
                            }
                        }
                    } else if (option == 3) {
                        while (true) {
                            boolean nameExist = false;

                            System.out.print("\nType the author's name of the book(s): ");
                            String authorsName = read.nextLine();

                            for (String data : datas) {
                                String[] field = data.split(",");
                                if (field[1].equals(authorsName)) {
                                    nameExist = true;
                                    break;
                                }
                            }

                            if (nameExist) {

                                String nameOfNewFile = "C:\\Users\\galof\\OneDrive\\Área de Trabalho\\relatorioDetalhado(" + RD + ").csv";
                                RD++;

                                try {
                                    FileWriter fw = new FileWriter(nameOfNewFile, true);
                                    BufferedWriter bw = new BufferedWriter(fw);

                                    for (String data : datas) {
                                        String[] field = data.split(",");
                                        if (field[1].equals(authorsName)) {
                                            bw.write(data);
                                            bw.newLine();
                                        }
                                    }

                                    bw.close();
                                    fw.close();

                                    System.out.println("Successfully generated file!");
                                    System.out.println("👉🏻 " + nameOfNewFile);

                                } catch (Exception e) {
                                    System.out.println("Error adding filtered data to file " + nameOfNewFile + ".");
                                    e.printStackTrace();
                                }

                                break;
                            } else {
                                System.out.println("\nThere isn't any book with that author's name. Try again!");

                            }
                        }
                    } else if (option == 4) {
                        while (true) {
                            boolean nameExist = false;

                            System.out.print("\nType the area of interest of the book(s): ");
                            String areaOfInterest = read.nextLine();

                            for (String data : datas) {
                                String[] field = data.split(",");
                                if (field[2].equals(areaOfInterest)) {
                                    nameExist = true;
                                    break;
                                }
                            }

                            if (nameExist) {

                                String nameOfNewFile = "C:\\Users\\galof\\OneDrive\\Área de Trabalho\\relatorioDetalhado(" + RD + ").csv";
                                RD++;

                                try {
                                    FileWriter fw = new FileWriter(nameOfNewFile, true);
                                    BufferedWriter bw = new BufferedWriter(fw);

                                    for (String data : datas) {
                                        String[] field = data.split(",");
                                        if (field[2].equals(areaOfInterest)) {
                                            bw.write(data);
                                            bw.newLine();
                                        }
                                    }

                                    bw.close();
                                    fw.close();

                                    System.out.println("Successfully generated file!");
                                    System.out.println("👉🏻 " + nameOfNewFile);

                                } catch (Exception e) {
                                    System.out.println("Error adding filtered data to file: " + nameOfNewFile + ".");
                                    e.printStackTrace();
                                }

                                break;
                            } else {
                                System.out.println("\nThere isn't any book with that area of interest. Try again!");
                            }
                        }
                    }
                }

                System.out.println("""
                        Do you want to generate another report?
                        [1] Yes
                        [2] No
                        """);
                System.out.print("Type your option: ");
                keep = read.nextInt();

            } while (keep != 2);
        } else {
            System.out.println("\nNo one book registered at the moment!");
        }
    }
}