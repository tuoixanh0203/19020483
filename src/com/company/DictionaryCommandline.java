package com.company;

import java.io.IOException;

public class DictionaryCommandline {
    /**
     * ham show de the hien danh sach tu dien.
     */
    public void showAllWords(Dictionary dic) {
        System.out.println("No\t" + "| English\t\t" + "| Vietnamese");
        for (int i = 0; i < dic.getDic().size(); i++) {
            System.out.println(i+1 + "\t| " + dic.getDic().get(i).getWord_target()
                    + "\t\t\t| " + dic.getDic().get(i).getWord_explain());
        }
    }

    /**
     * ham nay de goi ham insert va ham show ne.
     */
    public void dictionaryBasic() {
        Dictionary dic = new Dictionary();
        DictionaryManagement dicMan = new DictionaryManagement();
        dic = dicMan.insertFromCommandline();
        showAllWords(dic);
    }

    /**
     * ham dictionaryAdvanced de goi ham insert, show, look up.
     */
    public void dictionaryAdvanced() throws IOException {
        Dictionary dic = new Dictionary();
        DictionaryManagement dicMan = new DictionaryManagement();
        dic = dicMan.insertFromFile();
        showAllWords(dic);
        dicMan.dictionaryLookup();
    }
}
