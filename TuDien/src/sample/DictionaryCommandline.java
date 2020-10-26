package sample;

import java.io.IOException;
import java.util.Scanner;

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
     * ham dictionarySearch tim kiem cac tu.
     */
    public void dictionarySearcher(Dictionary dic) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tu vung: ");
        String s = sc.nextLine();
        for (Word i : dic.getDic()) {
            if (i.getWord_target().substring(0, s.length()).equals(s)) {
                //System.out.println("true");
                System.out.println(i.getWord_target());
            }
        }
    }

    /**
     * ham dictionaryAdvanced de goi ham insert, show, look up.
     */
    public void dictionaryAdvanced(Dictionary dic) throws IOException {
        DictionaryManagement dicMan = new DictionaryManagement();
        dic = dicMan.insertFromFile();
        dicMan.dictionaryLookup();
        showAllWords(dic);
        //dicMan.addWord();
        //showAllWords(dic);
        //dicMan.removeWord();
        //showAllWords(dic);
        //dicMan.editWord();
        //showAllWords(dic);
        dicMan.dictionaryExportToFile();
        dictionarySearcher(dic);
    }
}
