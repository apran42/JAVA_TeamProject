package teamproject.library;

import java.util.LinkedList;

class SeasonPass {
    private static boolean student;
    private static int no;
    private static String name;
    private static String tele;
    private  static final int point = 10000;
    static LinkedList<Object> Member_List = new LinkedList<>();

    static void Insert() {
        plusNo();
        Member_List.add(getNo());
        if (isStudent()) {
            Member_List.add("학생");
        } else {
            Member_List.add("일반");
        }
        Member_List.add(getName());
        Member_List.add(getTele());
        Member_List.addLast(point);
    }

    static int getNo() {
        return no;
    }

    static void plusNo() {
        no++;
    }
    static void isStudent(String stu) {
        switch (stu) {
            case "Y", "y" -> setStudent(true);
            case "N", "n" -> setStudent(false);
        }
    }

    static void setName(String name) {
        SeasonPass.name = name;
    }

    static void setTele(String tele) {
        SeasonPass.tele = tele;
    }

    static boolean isStudent() {
        return student;
    }

    static void setStudent(boolean student) {
        SeasonPass.student = student;
    }

    static String getName() {
        return name;
    }

    static String getTele() {
        return tele;
    }

    static void withdraw(int no) {
        System.out.println(Member_List.get(no*5-3)+"님 정기회원 탈퇴 완료");
        for (int i = 5; i > 0; i--) {
            Member_List.set(no*5-i, "");
        }
    }
}
