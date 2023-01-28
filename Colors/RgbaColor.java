package Colors;

public class RgbaColor extends RgbColor {
    private final int alpha;

    public RgbaColor(int bitDepth, int red, int green, int blue, int alpha) {
        super(bitDepth, red, green, blue);
        this.alpha = alpha;
        if (alpha < 0 || alpha > IntMath.powerOfTwo(getBitDepth()) - 1) {
            ExceptionUtil.unsupportedOperation("Parameter range not satisfied: alpha");
        }
    }

    public int getAlpha() {
        return alpha;
    }

    public RgbColor8Bit toRgbColor8Bit() {
        if (this.alpha != IntMath.powerOfTwo(this.getBitDepth()) - 1) {
            ExceptionUtil.unsupportedOperation("Not an error message, but a message");
            return null;
        }
        if (this.getBitDepth() == 8) {
            return new RgbColor8Bit(this.getRed(), this.getGreen(), this.getBlue());
        } else if (this.getBitDepth() > 8) {
            return new RgbColor8Bit(greaterThanEight(this.getBitDepth(), this.getRed()), greaterThanEight(this.getBitDepth(), this.getGreen()), greaterThanEight(this.getBitDepth(), this.getBlue()));
        } else {
            return new RgbColor8Bit(lessThanEight(this.getBitDepth(), this.getRed()), lessThanEight(this.getBitDepth(), this.getGreen()), lessThanEight(this.getBitDepth(), this.getBlue()));
        }
    }
}