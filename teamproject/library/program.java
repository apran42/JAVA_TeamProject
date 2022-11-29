package teamproject.library;

import java.util.Scanner;
import  static teamproject.library.CheckIn.seated;

public class Program {
    // 0. 종료
    public static void Exit() {
        System.exit(0);
    }
    // 1. 입실
    public static void Check_In() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("--> 정기 이용 회원인가요? (Y/N) ");
        String is_mem = sc.nextLine();
        
        // 1-1. 정기회원인 경우 
        if(is_mem.equals("y") || is_mem.equals("Y")) {
            CheckIn jungi = new CheckIn();
            System.out.println();
            jungi.Show_Mem();
        }

        // 1-2. 정기회원이 아닌 경우 
        if (is_mem.equals("n") || is_mem.equals("N")) {
            CheckIn bijungi = new CheckIn();
            System.out.println();
            bijungi.Show_Non_Mem();
        }

    }

    // 2. 퇴실
    public static void Check_Out() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("--> 좌석번호 입력 : ");
        int seat = sc.nextInt();

        if(!seated[seat-1]) {
            System.out.println("착석 중인 좌석이 아닙니다.\n다시 선택해주세요.");
            Check_Out();
        } else {
            CheckOut.Out(seat);
            LibraryManager.start(sc);
        }
    }

    // 3. 정기 이용권
    public static void Season_Pass() {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.print("--> 학생인가요? (Y/N) ");
        String stu = sc.nextLine();
        SeasonPass.isStudent(stu);
        System.out.println();

        System.out.print("--> 이름 입력 : ");
        String name = sc.nextLine();
        SeasonPass.setName(name);
        System.out.println();

        System.out.print("--> 전화번호 입력 :  ");
        String tele = sc.nextLine();
        SeasonPass.setTele(tele);
        System.out.println();

        SeasonPass.Insert();

        System.out.println(name + "님 정기회원으로 등록되었습니다.");
        System.out.println("이용금액 만원이 자동 충전되었습니다.");
        System.out.println("회원번호는 " + SeasonPass.getNo() + "입니다.");

        LibraryManager.start(sc);
    }

    //4.정기이용 탈퇴
    public static void Season_Pass_Withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("회원번호를 입력하세요 : ");
        int no = sc.nextInt();
        SeasonPass.withdraw(no);

        LibraryManager.start(sc);
    }

}
