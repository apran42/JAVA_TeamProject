package teamproject.library;

import static teamproject.library.CheckIn.In_Use;
import static teamproject.library.CheckIn.seated;
import static teamproject.library.SeasonPass.Member_List;

public class CheckOut {

    private static final int fee = 1000;
    public static void Calc_Fee(int index) {
        int now = (int)Member_List.get(index);
        if(now >= 3*fee) {
            Member_List.set(index, now-fee*3);
            System.out.println("정산 후 남은 요금은 "+Member_List.get(index)+"원 입니다. 감사합니다!!");
        } else {
            System.out.println("충전금액이 모자라서 자동으로 만원 충전됩니다.");
            Member_List.set(index, now+10000-(3*fee));
            System.out.println("정산 후 남은 요금은 "+Member_List.get(index)+"원 입니다. 감사합니다!!");
        }
    }
    public static void Out(int seat) {
        String[] values = In_Use.get(seat);
        int member = SeasonPass.getNo();

        if(values[1].equals("정기")) {
            for (int i = 0; i < member; i++) {
                if(Member_List.get(i*5+3).equals(values[0])) {
                    int index = i*5+4;
                    Calc_Fee(index);
                    System.out.println(seat+"번 좌석 퇴장 완료");
                    seated[seat-1] = false;
                }
            }
        } else {
            System.out.println("정산 요금은 "+fee*3+"원 입니다. 감사합니다!!");
            System.out.println(seat+"번 좌석 퇴장 완료");
            seated[seat-1] = false;
        }
    }

}
