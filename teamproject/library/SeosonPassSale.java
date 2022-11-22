package teamproject.library;

import java.util.LinkedList;
import java.util.List;

public class SeosonPassSale {
    private boolean student;
    private int no = 0;
    private String name;
    private String tele;

    List<Object> Member_List = new LinkedList<>();

    public void register() {
        
        Member_List.add(no+1);
        if(student == true) {
            Member_List.add("학생");
        }
        else {
            Member_List.add("일반");
        }
        Member_List.add(name);
        Member_List.add(tele);
        Member_List.add(10000);
        System.out.println(Member_List.get(5*no+2) + "님 정기회원으로 등록되었습니다.");
        System.out.println("이용금액 만원이 자동충전되었습니다.");
        System.out.println("회원번호는 " + Member_List.get(no*5) + "입니다.");
    }

    public void isStudent(String stu) {
        if(stu.equals("Y") || stu.equals("y")) {
            student = true;
        }
        else {
            student = false;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }
}
