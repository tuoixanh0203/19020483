package com.company;

import java.io.IOException;

public class Main {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Dictionary dic = new Dictionary();
        DictionaryCommandline dicComL = new DictionaryCommandline();
        dicComL.dictionaryAdvanced(dic);
    }
}


