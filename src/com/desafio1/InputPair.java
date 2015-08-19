/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio1;

import java.io.Serializable;

/**
 *
 * @author andersonr
 */
class InputPair implements Serializable {
    public int type;
    public String value;

    public InputPair(int type, String value) {
        this.type = type;
        this.value = value;
    }
    
    
    @Override
    public String toString() {
        switch (type) {
            case ConversionCalculator.BIN: return "BIN, " + value;
            case ConversionCalculator.OCT: return "OCT, " + value;
            case ConversionCalculator.DEC: return "DEC, " + value;
            case ConversionCalculator.HEX: return "HEX, " + value;
        }
        return "undefined, " + value;
    }
    
    
}
