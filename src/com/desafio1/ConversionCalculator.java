/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio1;

import java.util.List;

/**
 *
 * @author andersonr
 */
public class ConversionCalculator implements Calculator {

    public static final int BIN = 2;
    public static final int OCT = 8;
    public static final int DEC = 10;
    public static final int HEX = 16;
    
    @Override
    public String execute(List<Object> cmds) {
        int inputType = ((Integer) cmds.get(0)).intValue();
        int outputType = ((Integer) cmds.get(1)).intValue();
        String input = (String) cmds.get(2);
        
        return convertFromDecimal(outputType, convertToDecimal(inputType, input));
    }
    
    private String convertToDecimal(int from, String value) {
        int output = 0;
        int i = 0;
        
        value = value.toUpperCase();
        
        while (i < value.length()) {
            if (value.charAt(i) >= '0' && value.charAt(i) <= '9') {
                output = from * output + (int)(value.charAt(i) - '0');
            } else { 
                output = from * output + 10 + (int)(value.charAt(i) - 'A');
            }
            i++;
        }
        
        return (new Integer(output)).toString();
    }
    
    private String convertFromDecimal(int to, String value) {
        int input = (new Integer(value)).intValue();
        String output = new String();
        
        if (input == 0) return "0";
        
        while (input != 0) {
            int v = input % to;
            
            if (v < 10) output = (char)(v + '0') + output;
            else output = (char)(v - 10 + 'A') + output;
            
            input /= to;
        }
        
        
        return output;
    }
    
}
