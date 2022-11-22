package teamproject.library;

import java.util.Scanner;

public class Program extends SeosonPassSale{
    // 0. 종료
    public void exit() {
        System.exit(0);
    }
    // 1. 입실
    public void check_In() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("--> 정기 이용 회원인가요? (Y/N) ");
        String is_mem = sc.next();
        
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
            String student = sc.next();
            System.out.println();

            System.out.print("--> 이름 입력 : ");
            String name = sc.next();
            System.out.println();

            System.out.print("--> 전화번호 입력: ");
            String tel = sc.nextLine();
            System.out.println();

        }

    }

    // 2. 퇴실
    public void check_Out() {
        
    }

    // 3. 정기 이용권
    public void season_Pass() {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.print("--> 학생인가요? (Y/N) ");
        String stu = sc.nextLine();
        System.out.println();
        isStudent(stu);

        System.out.print("--> 이름 입력 : ");
        String name = sc.nextLine();
        System.out.println();
        setName(name);

        System.out.print("--> 전화번호 입력 :  ");
        String tele = sc.nextLine();
        System.out.println();
        setTele(tele);

        super.register();
        
        sc.close();
    }

    //4.정기이용 탈퇴
    public void season_Pass_Withdraw() {
        System.out.println(4);
    }

}
