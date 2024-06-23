package br.com.erudio.firstSteps.mathAndGreeting;

public class Calculations extends NumberConvertor {


    public Double soma(double numberOne, double numberTwo){
        return numberOne + numberTwo;
    }


    public Double sub(double numberOne, double numberTwo){
        return numberOne - numberTwo;
    }


    public Double div(double numberOne, double numberTwo){
        return numberOne / numberTwo;
    }


    public Double mult(double numberOne, double numberTwo){
        return numberOne * numberTwo;
    }


    public Double med(double numberOne, double numberTwo){
        return (numberOne + numberTwo)/2;
    }


    public Double raiz(double numberOne){
        return Math.sqrt(numberOne);
    }

}
