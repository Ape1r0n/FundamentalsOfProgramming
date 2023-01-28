package Colors;

public class RgbColor {
    private final int red, green, blue, bitDepth;

    public RgbColor(int bitDepth, int red, int green, int blue) {
        int allPossibleValues = IntMath.powerOfTwo(bitDepth);
        this.bitDepth = bitDepth;
        this.red = red;
        this.green = green;
        this.blue = blue;

        if(bitDepth < 0 || bitDepth > 31) ExceptionUtil.unsupportedOperation("BitDepth exceeded");
        if(red < 0 || red > allPossibleValues-1) ExceptionUtil.unsupportedOperation("BitDepth not satisfied in argument: red");
        if(green < 0 || green > allPossibleValues-1) ExceptionUtil.unsupportedOperation("BitDepth not satisfied in argument: green");
        if(blue < 0 || blue > allPossibleValues-1) ExceptionUtil.unsupportedOperation("BitDepth not satisfied in argument: blue");
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getBitDepth(){
        return bitDepth;
    }

    public int greaterThanEight(int bitDepth, int color){
        int result = color;
        result /= IntMath.powerOfTwo(bitDepth-9);
        int remainder = result%2;
        result = (result/2) + remainder;
        if(result > 255) result = 255;
        return result;
    }

    public int lessThanEight(int bitDepth, int color){
        int occurrence = 8/bitDepth; // How many times pattern should be repeated. i.e. if provided color is 101, 101 should be repeated two times in 101_101_10
        int remaindingOccurrence = 8 % bitDepth; // How many empty slots we have until we reach depth of 8. In the case of 101_101_10 remaining occurrence is 2 and remainder is 10
        int remainder =  color >>> bitDepth - remaindingOccurrence; // remainder is 10 in binary

        int clr = color; // 101
        int ogColor = color; // 101
        while(occurrence != 1){
            clr = clr << bitDepth; // 101 << 3 = 101000
            clr += ogColor; // 101101
            occurrence--;
        }
        clr = clr << remaindingOccurrence; // 10110100
        clr += remainder; //10110110

        return clr;
    }

    public RgbColor8Bit toRgbColor8Bit(){
        if(this.bitDepth == 8){
            return new RgbColor8Bit(this.getRed(), this.getGreen(), this.getBlue());
        }else if(this.bitDepth > 8){
            return new RgbColor8Bit(greaterThanEight(this.bitDepth, this.red), greaterThanEight(this.bitDepth, this.green), greaterThanEight(this.bitDepth, this.blue));
        }else{
            return new RgbColor8Bit(lessThanEight(this.bitDepth, this.red), lessThanEight(this.bitDepth, this.green), lessThanEight(this.bitDepth, this.blue));
        }
    }

}