package adventofcode;

import java.util.Objects;

public final class Bag {
    private int red;
    private int blue;
    private int green;

    public Bag(int red, int blue, int green) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public Bag() {
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Bag) obj;
        return this.red == that.red &&
                this.blue == that.blue &&
                this.green == that.green;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, blue, green);
    }

    @Override
    public String toString() {
        return "Bag[" +
                "red=" + red + ", " +
                "blue=" + blue + ", " +
                "green=" + green + ']';
    }
}
