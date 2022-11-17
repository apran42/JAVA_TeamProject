package teamproject.library;

import java.util.Scanner;

class Program {
    // 0. 퇴실
    static void exit() {
        System.exit(0);
    }
    // 1. 입실
    static void check_In() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("--> 정기 이용 회원인가요? (Y/N) ");
        String is_mem = sc.next();
        System.out.println();
        
        // 1-1. 정기회원인 경우 
        if(is_mem.equals("y") || is_mem.equals("Y")) {
            System.out.println();
            System.out.println("--> 회원번호를 입력하세요");
            int no = sc.nextInt();
        }

        // 1-2. 정기회원이 아닌 경우 
        if(is_mem.equals("n") || is_mem.equals("N")) {
            System.out.println();

            System.out.print("--> 학생인가요? (Y/N) ");
            String is_student = sc.next();
            System.out.println();

            System.out.print("--> 이름 입력 : ");
            String name = sc.next();
            System.out.println();

            System.out.print("--> 전화번호 입력: ");
            int tel = sc.nextInt();
            System.out.println();

            System.out.println(is_student + "\t\t" + name);
            System.out.println(tel);

        }

    }

    static void check_Out() {
        
    }

    static void season_Pass() {
        System.out.println(3);
    }

    static void season_Pass_Withdraw() {
        System.out.println(4);
    }

}
