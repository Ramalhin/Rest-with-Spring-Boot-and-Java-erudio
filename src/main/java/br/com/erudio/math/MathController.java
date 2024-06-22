package br.com.erudio.math;


import org.springframework.web.bind.annotation.RestController;



@RestController
public class MathController{

    public static Double covertToDouble(String strNumber) {
        if (strNumber == null) return 0D; 
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 1.0D;
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false; 
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}
