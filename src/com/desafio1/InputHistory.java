/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andersonr
 */
public class InputHistory {
    static ArrayList<InputPair> cmds = new ArrayList<InputPair>();
    public static final String FILE_NAME = "history.txt";
    
    public List<InputPair> loadHistory() throws FileNotFoundException, IOException, ClassNotFoundException {
        InputStream input = new FileInputStream(FILE_NAME);
        ObjectInputStream objInput = new ObjectInputStream(input);
        ArrayList<InputPair> output = new ArrayList<InputPair>();
        
        cmds = (ArrayList<InputPair>) objInput.readObject();
        
        input.close();
        return cmds;
    }
    
    public void addHistory(InputPair cmd) throws FileNotFoundException, IOException {
        OutputStream output = new FileOutputStream(FILE_NAME);
        ObjectOutputStream objOutput = new ObjectOutputStream(output);
        cmds.add(cmd);
        objOutput.writeObject(cmds);
        output.close();
    }
}

