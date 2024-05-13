import java.lang.*;
class Check {
    private String checkin;
    private String checkout;
    private String person;
    private String gender;

    public Check(String checkin, String checkout, String person) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.person = person;
    }

    public String getcheckin() {
        return checkin;
    }

    public String getcheckout() {
        return checkout;
    }

    public String getperson() {
        return person;
    }

  
}