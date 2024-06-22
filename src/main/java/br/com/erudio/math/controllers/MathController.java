package br.com.erudio.math.controllers;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.Calculations;
import br.com.erudio.math.NumberConvertor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController{

    public Calculations calc = new Calculations();

    @RequestMapping(value="/soma/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double soma(@PathVariable("numberOne") String numberOne,
                       @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConvertor.isNumeric(numberOne) || !NumberConvertor.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("please set a numeric value");
        }
        return calc.soma(NumberConvertor.covertToDouble(numberOne), NumberConvertor.covertToDouble(numberTwo));
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConvertor.isNumeric(numberOne) || !NumberConvertor.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("please set a numeric value");
        }
        return calc.sub(NumberConvertor.covertToDouble(numberOne), NumberConvertor.covertToDouble(numberTwo)) ;
    }

    @RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConvertor.isNumeric(numberOne) || !NumberConvertor.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("please set a numeric value");
        }
        return calc.div(NumberConvertor.covertToDouble(numberOne), NumberConvertor.covertToDouble(numberTwo));
    }

    @RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mult(@PathVariable("numberOne") String numberOne,
                       @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConvertor.isNumeric(numberOne) || !NumberConvertor.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("please set a numeric value");
        }
        return calc.mult(NumberConvertor.covertToDouble(numberOne), NumberConvertor.covertToDouble(numberTwo));
    }

    @RequestMapping(value="/med/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double med(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConvertor.isNumeric(numberOne) || !NumberConvertor.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("please set a numeric value");
        }
        return calc.med(NumberConvertor.covertToDouble(numberOne), NumberConvertor.covertToDouble(numberTwo));
    }

    @RequestMapping(value="/raiz/{numberOne}", method=RequestMethod.GET)
    public Double raiz(@PathVariable("numberOne") String numberOne
    ) throws Exception {
        if (!NumberConvertor.isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("please set a numeric value");
        }
        return calc.raiz(NumberConvertor.covertToDouble(numberOne));
    }

}

