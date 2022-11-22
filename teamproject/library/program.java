package teamproject.library;

import java.util.Scanner;

public class Program{
    // 0. 종료
    public void Exit() {
        System.exit(0);
    }
    // 1. 입실
    public void Check_In() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("--> 정기 이용 회원인가요? (Y/N) ");
        String is_mem = sc.nextLine();
        
        // 1-1. 정기회원인 경우 
        if(is_mem.equals("y") || is_mem.equals("Y")) {
            System.out.println();
            System.out.println("--> 회원번호를 입력하세요");
            int no = sc.nextInt();
            CheckSeat member = new CheckSeat();
            String mem = member.isStudent(no);

            if(mem.equals("학생")) {
                System.out.println("여기서부터");
            }
            
            else {
                System.out.println("만들면 됨");
            }
        }

        // 1-2. 정기회원이 아닌 경우 
        if (is_mem.equals("n") || is_mem.equals("N")) {
            System.out.println();

            System.out.print("--> 학생인가요? (Y/N) ");
            String student = sc.nextLine();
            System.out.println();

            System.out.print("--> 이름 입력 : ");
            String name = sc.nextLine();
            System.out.println();

            System.out.print("--> 전화번호 입력: ");
            String tel = sc.nextLine();
            System.out.println();

        }

    }

    // 2. 퇴실
    public void Check_Out() {
        
    }

    // 3. 정기 이용권
    public void Season_Pass() {
        SeasonPassSale member = new SeasonPassSale();
        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.print("--> 학생인가요? (Y/N) ");
        String stu = sc.nextLine();
        member.isStudent(stu);
        System.out.println();

        System.out.print("--> 이름 입력 : ");
        String name = sc.nextLine();
        member.setName(name);
        System.out.println();

        System.out.print("--> 전화번호 입력 :  ");
        String tele = sc.nextLine();
        member.setTele(tele);
        System.out.println();
        
        member.register();
        sc.close();
    }

    //4.정기이용 탈퇴
    public void Season_Pass_Withdraw() {
        System.out.println(4);
    }

}
