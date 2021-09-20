package module3oop;

import java.util.Arrays;

public class AsciiCharSequence implements java.lang.CharSequence {

    byte[] value;

    public AsciiCharSequence() {
        value = new byte[256];
        for (int i = 0; i < value.length; i++) {
            value[i] = (byte) i;
        }
    }

    public AsciiCharSequence(byte[] chars) {
        this.value = chars;
    }


    @Override
    public int length() {
        return value.length;
    }

    @Override
    public char charAt(int index) {
        return (char) value[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
//        return new String(value).subSequence(start, end);
        return new AsciiCharSequence(Arrays.copyOfRange(value, start, end));
    }

    @Override
    public String toString() {
        return new String(value);
    }
}
