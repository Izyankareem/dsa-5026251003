package lw01.unguided;

public class ProjectorRental extends Rental {
    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        int days = super.getDays();
        int charges;
        if (days > 3) {
            days -= 3;
            charges = (3 * 60000) + (days * 45000);
        } else {
            charges = days * 60000;
        }
        return charges + 20000;
    }

    @Override
    public String label() {
        return "Projector";
    }
}
