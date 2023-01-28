package Colors;

import java.lang.Math;

public class BrutalTester {
    public static void main(String[] args) {
        int testCount = 1000;
        int iteration = 0;
        int correctAnswers = 0;
        int correctProbs = 0;
        boolean compare = false;

        while (iteration < testCount) {
            compare = false;
            try {
                int bitDepth = (int) (Math.random() * (31) + 1);
                int r = (int) (Math.random() * (IntMath.powerOfTwo(bitDepth)));
                int b = (int) (Math.random() * (IntMath.powerOfTwo(bitDepth)));
                int g = (int) (Math.random() * (IntMath.powerOfTwo(bitDepth)));
                int alpha = 0;
                if (Math.random() > 0.5) {
                    alpha = (int) (Math.random() * (IntMath.powerOfTwo(bitDepth)));
                } else {
                    alpha = IntMath.powerOfTwo(bitDepth) - 1;
                    correctProbs++;
                    compare = true;
                }

                RgbColor rgb = new RgbColor(bitDepth, r, g, b);
                RgbaColor rgba = new RgbaColor(bitDepth, r, g, b, alpha);

                System.out.println("RGB: " + rgb.getRed() + " " + rgb.getGreen() + " " + rgb.getBlue());
                System.out.println("RGBA: " + rgba.getRed() + " " + rgba.getGreen() + " " + rgba.getBlue());

                RgbColor8Bit rgb8 = rgb.toRgbColor8Bit();
                RgbColor8Bit rgba8 = rgba.toRgbColor8Bit();

                if (rgb8.getRed() == rgba8.getRed() && rgb8.getGreen() == rgba8.getGreen()
                        && rgb8.getBlue() == rgba8.getBlue()) {
                    System.out.println("Your conversion works damn well");
                    if(compare){
                        correctAnswers++;
                    }
                } else {
                    System.out.println("Fix your conversion 🙂");
                }
            } catch (Exception e) {
                System.out.println(e);

            }

            iteration++;
        }
        System.out.println("Final Result:");
        System.out.println("---------------------------------");
        System.out.println(correctAnswers);
        System.out.println(correctProbs);
        System.out.println("Correctness Accuracy: " + (float) correctAnswers/correctProbs * 100 + "%");

    }
}