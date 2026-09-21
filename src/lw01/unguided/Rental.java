package lw01.unguided;

public abstract class Rental implements Chargeable {
    private String id;
    private int days;

    protected Rental(String id, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be higher than 0!");
        }
        this.id = id;
        this.days = days;
    }

    public String getId() {
        return this.id;
    }

    public int getDays() {
        return this.days;
    }

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int unit) {
        if (unit <= 0) {
            throw new IllegalArgumentException("Unit must be higher than 0!");
        }
        return unit * calculateCharge();
    }

    public String label() {
        return "Rental";
    }

    public String summary() {
        return getId() + " | " + label() + " | " + calculateCharge();
    }

    public String summary(int unit) {
        return getId() + " | " + label() + " | " + calculateCharge(unit);
    }
    // this is for unit can be calculated
}
