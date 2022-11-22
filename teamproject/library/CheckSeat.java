package teamproject.library;

public class CheckSeat extends SeosonPassSale {

    public Object isStudent(int no) {
        return Member_List.get(no*5+1);
    }

    public boolean Stu_Check(int no) {
        Object a = isStudent(no);
        if(a.equals("학생")) {
            return true;
        }
        else {
            return false;
        }
    }
}
