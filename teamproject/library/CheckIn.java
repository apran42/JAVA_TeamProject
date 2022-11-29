package teamproject.library;

import java.util.HashMap;
import java.util.Scanner;

import static teamproject.library.SeasonPass.Member_List;
import static teamproject.library.LibraryManager.table;

public class CheckIn {

    static HashMap<Integer, String[]> In_Use = new HashMap<>();
    static boolean[] seated = new boolean[16];

    static {
        for (int i = 0; i < 16; i++) seated[i] = false;
    }

    public void Show_Mem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("--> 회원번호를 입력하세요 : ");
        int no = sc.nextInt();
        boolean isMem = false;
        for (int i = 0; i < SeasonPass.getNo(); i++) {
            if (Member_List.get(5 * i).equals(no)) {
                isMem = true;
                break;
            }
        }
        int hex = 0x245f;
        int already1 = 0x2775;
        int already2 = 0x24ea;

        if(isMem) {

            System.out.println("####### 좌석 #######");
            System.out.println();
            System.out.println("-------------------");

            if (Member_List.get(no*5-4).equals("학생")) {
                for (int i=1; i<=16; i++) {
                    // false(미착석)일 경우
                    if(!seated[i-1]) System.out.printf("|%2c ", hex+i);
                    else {
                        if(i<=10) {
                            System.out.printf("|%2c ", already1+i);
                        } else {
                            System.out.printf("|%2c ", already2+i-10);
                        }
                    }
                    if(i%4==0) {
                        System.out.println("|");
                    }
                }

                System.out.println("-------------------");
                System.out.println();
                System.out.print("--> 좌석번호 입력 : ");
                int seat = sc.nextInt();

                // 좌석의 범위를 벗어나는 경우

                if(seat < 1 || seat > 16) {
                    System.out.println("좌석 번호를 벗어났습니다.");
                    LibraryManager.start(sc);
                } else if(seated[seat-1]) {
                    System.out.println("이미 사용 중인 좌석입니다.");
                    Show_Mem();
                }

                // 착석 완료
                else {
                    System.out.println(Member_List.get(no*5-3)+"님 "+seat+"번 좌석 입장하십시오.");
                    seated[seat-1] = true;
                    In_Use.put(seat, new String[]{(String) Member_List.get(no*5-2), "정기"});
                }
                LibraryManager.start(sc);

            } else {
                for (int j=1; j<=16; j++) {
                    // false(미착석)이면서 table 각 행의 1번 열이 false 일 경우
                    if(!seated[j-1] && table[j-1][0].equals("false")) {
                        System.out.printf("|%2c ", hex+j);
                    }
                    // 이미 착석이면~
                    else if (seated[j-1] && table[j-1][0].equals("false")) {
                        if(j<=10) {
                            System.out.printf("|%2c ", already1+j);
                        } else {
                            System.out.printf("|%2c ", already2+j-10);
                        }
                    }
                    // 선택 불가
                    else {
                        System.out.printf("|%2c ", 0x2592);
                    }
                    if(j%4==0) {
                        System.out.println("|");
                    }
                }

                System.out.println("-------------------");
                System.out.println();
                System.out.print("--> 좌석번호 입력 : ");
                int seat = sc.nextInt();

                // 좌석의 범위를 벗어나는 경우
                if (seat<1 || seat>16) {
                    System.out.println("좌석 번호를 벗어났습니다.");
                    LibraryManager.start(sc);
                } else if (!(seat>=9)) {
                    System.out.println("착석 불가 좌석을 고르셨습니다.");
                    Show_Mem();
                } else if (seated[seat-1]) {
                    System.out.println("이미 사용 중인 좌석입니다.");
                    Show_Mem();
                }
                // 착석 완료
                else {
                    System.out.println(Member_List.get(no*5-3)+"님 "+seat+"번 좌석 입장하십시오.");
                    seated[seat-1] = true;
                    In_Use.put(seat, new String[]{(String) Member_List.get(no*5-2), "정기"});
                }
                LibraryManager.start(sc);
            }
        } else {
            System.out.println("회원번호를 찾을 수 없습니다.");

            LibraryManager.start(sc);
        }
    }

    public void Show_Non_Mem() {
        Scanner sc = new Scanner(System.in);

        System.out.print("--> 학생인가요? (Y/N) ");
        String stu = sc.nextLine();
        System.out.println();

        System.out.print("--> 이름 입력 : ");
        String name = sc.nextLine();
        System.out.println();

        System.out.print("--> 전화번호 입력 : ");
        String tele = sc.nextLine(); // 전화번호를 묻는 이유
        System.out.println();

        int hex = 0x245f;
        int already1 = 0x2775;
        int already2 = 0x24ea;

        System.out.println("####### 좌석 #######");
        System.out.println();
        System.out.println("-------------------");

        if(stu.equals("Y")||stu.equals("y")) {
            for (int i = 1; i <= 16; i++) {
                if(!seated[i-1] && table[i-1][1].equals("false")) {
                    System.out.printf("|%2c ", hex+i);
                } else if(seated[i-1] && table[i-1][1].equals("false")) {
                    if(i<=10) {
                        System.out.printf("|%2c ", already1+i);
                    } else {
                        System.out.printf("|%2c ", already2+i-10);
                    }
                } else {
                    System.out.printf("|%2c ", 0x2592);
                }
                if(i%4==0) {
                    System.out.println("|");
                }
            }

            System.out.println("-------------------");
            System.out.println();
            System.out.print("--> 좌석번호 입력 : ");
            int seat = sc.nextInt();

            // 좌석의 범위를 벗어나는 경우
            if (seat<1 || seat>16) {
                System.out.println("좌석 번호를 벗어났습니다.");
                LibraryManager.start(sc);
            } else if (!(seat >= 5 && seat <= 8 || seat >= 13)) {
                System.out.println("착석 불가 좌석을 고르셨습니다.");
                Show_Non_Mem();
            } else if (seated[seat-1]) {
                System.out.println("이미 사용 중인 좌석입니다.");
                Show_Non_Mem();
            }

            // 착석 완료
            else {
                System.out.println(name+"님 "+seat+"번 좌석 입장하십시오.");
                seated[seat-1] = true;
                In_Use.put(seat, new String[]{tele, "비정기"});
            }
            LibraryManager.start(sc);
        } else {
            for (int i = 1; i <= 16; i++) {
                if(!seated[i-1] && table[i-1][0].equals("false") && table[i-1][1].equals("false")) {
                    System.out.printf("|%2c ", hex+i);
                } else if(seated[i-1] && table[i-1][0].equals("false") && table[i-1][1].equals("false")) {
                    if(i<=10) {
                        System.out.printf("|%2c ", already1+i);
                    } else {
                        System.out.printf("|%2c ", already2+i-10);
                    }
                } else {
                    System.out.printf("|%2c ", 0x2592);
                }
                if(i%4==0) {
                    System.out.println("|");
                }
            }
            System.out.println("-------------------");
            System.out.println();
            System.out.print("--> 좌석번호 입력 : ");
            int seat = sc.nextInt();

            // 좌석의 범위를 벗어나는 경우
            if(seat<1 || seat>16) {
                System.out.println("좌석 번호를 벗어났습니다.");
                LibraryManager.start(sc);
            } else if (!(seat>=13)) {
                System.out.println("착석 불가 좌석을 고르셨습니다.");
                Show_Non_Mem();
            } else if (seated[seat-1]) {
                System.out.println("이미 사용 중인 좌석입니다.");
                Show_Non_Mem();
            }
            // 착석 완료
            else {
                System.out.println(name+"님 "+seat+"번 좌석 입장하십시오.");
                seated[seat-1] = true;
                In_Use.put(seat, new String[]{tele, "비정기"});
            }
            LibraryManager.start(sc);
        }
    }
}
