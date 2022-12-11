package teamproject.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LibraryManager extends Program{
    ArrayList<String> text = new ArrayList<>();
    public static String[][] table = new String[16][3];

    LibraryManager(String path) {
        File file = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i < 2) {
                    text.add(line);
                    i++;
                } else {
                    String[] a = line.split("\t");
                    text.addAll(Arrays.asList(a).subList(0, 3));
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        for(int i = 1; i <= 16; i++) {
            for(int j = 0; j < 3; j++) {
                table[i-1][j] = text.get(3*i+(j-1));
            }
        }
    }
    static void start(Scanner a) {

        System.out.println("# DMU 도서실 좌석 관리 시스템 #");
        System.out.println("############ 메 뉴 ############");
        System.out.println("\t0. 종\t료");
        System.out.println("\t1. 입\t실");
        System.out.println("\t2. 퇴\t실");
        System.out.println("\t3. 정기 이용권");
        System.out.println("\t4. 정기이용 탈퇴");
        System.out.println("###############################");
        int num = a.nextInt();

        switch (num) {
            case 0 -> Exit();
            case 1 -> Check_In();
            case 2 -> Check_Out();
            case 3 -> Season_Pass();
            case 4 -> Season_Pass_Withdraw();
            default -> {
                System.out.println("잘못된 번호를 입력하였습니다.");
                System.out.println("다시 올바른 번호를 입력해주세요.");
                start(a);
            }
        }
    }
}