package module3oop;

public class ComplexNumber {

    private double re;
    private double im;

    public ComplexNumber() {
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;
        ComplexNumber that = (ComplexNumber) other;
        return Double.compare(this.re, that.re) == 0 && Double.compare(this.im, that.im) == 0;
    }

    @Override
    public int hashCode() {

//        return java.util.Objects.hash(re, im);
        int result = 1;
        result = (int) (31 * result + re);
        result = (int) (31 * result + im);
        return result;
    }

}
