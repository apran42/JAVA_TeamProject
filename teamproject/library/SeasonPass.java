package teamproject.library;

import java.util.LinkedList;

class SeasonPass {
    private static boolean student;
    private static int no;
    private static String name;
    private static String tele;
    private  static final int point = 10000;
    static LinkedList<Object> Member_List = new LinkedList<>();

    public static void Insert() {
        plusNo();
        getMember_List().add(getNo());
        if (isStudent()) {
            getMember_List().add("학생");
        } else {
            getMember_List().add("일반");
        }
        getMember_List().add(getName());
        getMember_List().add(getTele());
        getMember_List().addLast(point);
    }

    public static int getNo() {
        return no;
    }

    public static void plusNo() {
        no++;
    }
    public static void isStudent(String stu) {
        switch (stu) {
            case "Y", "y" -> setStudent(true);
            case "N", "n" -> setStudent(false);
        }
    }

    public static void setName(String name) {
        SeasonPass.name = name;
    }

    public static void setTele(String tele) {
        SeasonPass.tele = tele;
    }

    public static boolean isStudent() {
        return student;
    }

    public static void setStudent(boolean student) {
        SeasonPass.student = student;
    }

    public static String getName() {
        return name;
    }

    public static String getTele() {
        return tele;
    }

    public static void withdraw(int no) {
        System.out.println(getMember_List().get(no*5-3)+"님 정기회원 탈퇴 완료");
        for (int i = 5; i > 0; i--) {
            getMember_List().set(no*5-i, "");
        }
    }

    public static LinkedList<Object> getMember_List() {
        return Member_List;
    }

    public static void setMember_List(LinkedList<Object> member_List) {
        Member_List = member_List;
    }
}
