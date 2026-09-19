package lw01.prelab;

public abstract class PrintJob implements Chargeable {
    private String id;
    private int pages;

    PrintJob(String id, int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be higher than 0!");
        }
        this.id = id;
        this.pages = pages;
    }

    String getId() {
        return this.id;
    }

    int getPages() {
        return this.pages;
    }

    @Override
    public abstract int calculateCharge();

    int calculateCharge(int copies) {
        if (copies <= 0) {
            throw new IllegalArgumentException("Copies must be higher than 0!");
        }
        return copies * calculateCharge();
    }

    String label() {
        return "Print";
    }

    String summary() {
        return getId() + " | " + label() + " | " + calculateCharge();
    }
}
