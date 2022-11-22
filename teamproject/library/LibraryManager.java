package teamproject.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager extends Program{

    ArrayList<Object> list = new ArrayList<>();

    LibraryManager(String path) {
        File file = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i=0;
            while((line = br.readLine()) != null) {
                if(i < 2) {
                    list.add(Integer.parseInt(line));
                    i++;
                }
                else {
                    String a = line.split(" ")[0];
                    String b = line.split(" ")[1];
                    int c = Integer.parseInt(line.split(" ")[2]);
                    list.add(a);
                    list.add(b);
                    list.add(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void start(Scanner sc) {
        
        System.out.println("# DMU 도서실 좌석 관리 시스템 #");
        System.out.println("############ 메 뉴 ############");
        System.out.println("\t0. 종\t료");
        System.out.println("\t1. 입\t실");
        System.out.println("\t2. 퇴\t실");
        System.out.println("\t3. 정기 이용권");
        System.out.println("\t4. 정기이용 탈퇴");
        System.out.println("###############################");
        int num = sc.nextInt();
        switch (num) {
            case 0: Exit(); break;
            case 1: Check_In(); break;
            case 2: Check_Out(); break;
            case 3: Season_Pass(); break;
            case 4: Season_Pass_Withdraw(); break;
            default:
                System.out.println("잘못된 번호를 입력하였습니다.");
                System.out.println("다시 올바른 번호를 입력해주세요.");
                start(sc); break;
            
        }
    }
}