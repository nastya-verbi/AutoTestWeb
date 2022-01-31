package lesson4.HomeWork.HomeWork;

import java.text.DecimalFormat;

public class Triangle {
    private static double a;
    private static double b;
    private static double c;
    private static DecimalFormat df = new DecimalFormat("#.#");

    public static Double areaOfATriangle(double a, double b, double c) {
        if (a > 0 && b > 0 && c > 0) {
            double p = (a + b + c) / 2;
            if (p > a && p > b && p > c) {
                String area = df.format(Math.sqrt(p * (p - a) * (p - b) * (p - c))).replace(',', '.');
                return Double.parseDouble(area);
            }
        }
        return 0.0D;
    }
}
