package lw01.unguided;

public class LaptopRental extends Rental {
    public LaptopRental(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        return (40000 * super.getDays()) + 10000;
    }

    @Override
    public String label() {
        return "Laptop";
    }
}
