package teamproject.library;

import java.util.Scanner;

public class LibraryManagerTest {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "C:/Java_Workspace/Dmirae/src/teamproject/library/test.txt";
        LibraryManager library = new LibraryManager(path);
        library.start(sc);
        sc.close();  
    }
}