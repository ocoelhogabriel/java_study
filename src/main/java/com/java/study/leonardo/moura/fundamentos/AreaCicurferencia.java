package com.java.study.leonardo.moura.fundamentos;

public class AreaCicurferencia {

    public AreaCicurferencia() {
        // Auto-generated constructor stub
    }

    public static void calculateArea(double raio) {
        final double PI = 3.14;
        double area = PI * raio * raio;
        System.out.println("Área 1 = " + area);

        raio = 10;
        area = PI * raio * raio;
        System.out.println("Área 2 = " + area);

        area = Math.PI * Math.pow(raio, 2);
        System.out.println("Área 3 = " + area);
    }

    public static void convertCelciusToFahrenheit(double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Celsius: " + celsius + " Fahrenheit: " + fahrenheit);
    }

    public static void convertFahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.println("Fahrenheit: " + fahrenheit + " Celsius: " + celsius);
    }

    public static void main(String[] args) {

        calculateArea(5);
        convertCelciusToFahrenheit(37);
        convertFahrenheitToCelsius(98.6);
    }
}
