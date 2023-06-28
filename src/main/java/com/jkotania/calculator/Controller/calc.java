package com.jkotania.calculator.Controller;

public class calc {

    private static double weight;
    private double height;

    public static double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getResult() {
        double bmi = (weight / (height * height)) * 10000;
        return "BMI: " + String.format("%.2f", bmi) + " - " + getBmiCategory(bmi);
    }

    private String getBmiCategory(double bmi) {
        if (bmi < 16) {
            return "Starvation";
        } else if (bmi < 17) {
            return "Emaciation";
        } else if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Correct weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else if (bmi < 35) {
            return "I degree of obesity";
        } else if (bmi < 40) {
            return "II degree of obesity";
        } else {
            return "Extreme obesity";
        }
    }
}
