package com.weatherconverter;

public class Converter {

    static public float convertFromCelsius (String convertTo, float convertFromValue){
        switch (convertTo){
            case "Fahrenheit" :
                return (convertFromValue*9/5)+32;
            case "Kelvin" :
                return (float) (convertFromValue + 273.15);
            default:
                return convertFromValue;
        }
    }

    static public float convertFromFahrenheit (String convertTo, float convertFromValue){
        switch (convertTo){
            case "Celsius":
                return (convertFromValue - 32) * 5/9;
            case "Kelvin" :
                return (float) ((convertFromValue + 32) * 5/9 + 273.5);
            default:
                return convertFromValue;
        }
    }

    static public float convertFromKelvin (String convertTo, float convertFromValue){
        switch (convertTo){
            case "Celsius":
                return (float) (convertFromValue - 273.15);
            case "Fahrenheit" :
                return (float) ((convertFromValue - 273.15) * 5/9 + 32);
            default:
                return convertFromValue;
        }
    }
}
