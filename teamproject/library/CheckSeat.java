package teamproject.library;

public class CheckSeat{

    public String isStudent(int no) {
        SeasonPassSale sps = new SeasonPassSale();
        return (String)sps.getElement((no - 1)*5 + 1);
    }
}
