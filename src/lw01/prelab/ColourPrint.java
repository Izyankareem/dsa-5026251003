package lw01.prelab;

public class ColourPrint extends PrintJob {

    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        int pages = super.getPages();
        int charges;
        if (pages > 10) {
            pages -= 10;
            charges = (10 * 1500) + (pages * 1000);
        } else {
            charges = pages * 1500;
        }
        return charges + 2000;
    }

    @Override
    public String label() {
        return "Colour Print";
    }
}
