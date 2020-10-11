package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.Scanner;

public class DictionaryManagement {
    Dictionary dic = new Dictionary();
    Scanner sc = new Scanner(System.in);

    /**
     * day la ham insert co chuc nang nhap lieu nhe.
     */
    public Dictionary insertFromCommandline() {
        //Scanner sc = new Scanner(System.in);
        String english, vietnamese;
        System.out.println("Nhap so luong tu moi: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap tu tieng Anh: ");
            english = sc.nextLine();
            System.out.println("Nhap tieng Viet: ");
            vietnamese = sc.nextLine();
            Word newWord = new Word(english, vietnamese);
            dic.getDic().add(newWord);
        }
        return dic;
    }

    /**
     * ham insertFromFile cai tien lan 1.
     */
    public Dictionary insertFromFile() throws IOException {
        Scanner sc = new Scanner(Paths.get("dictionaries.txt"),
                "UTF-8");
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] words = s.split("\t");
            Word newWord = new Word(words[0], words[1]);
            dic.getDic().add(newWord);
        }
        sc.close();
        return dic;
    }

    /**
     * ham tra cuu.
     */
    public void dictionaryLookup() {
        //Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tu can tra: ");
        String s = sc.nextLine();
        for (int i = 0; i < dic.getDic().size(); i++) {
            if (dic.getDic().get(i).getWord_target().equals(s)) {
                System.out.println(dic.getDic().get(i).getWord_explain());
            }
        }
    }

    public void addWord() {
        System.out.println("Nhap tu can them: \nTieng Anh: ");
        String english = sc.nextLine();
        System.out.println("Tieng Viet: ");
        String vietnamese = sc.nextLine();
        Word newWord = new Word(english, vietnamese);
        dic.getDic().add(newWord);
    }

    public void editWord() {
        System.out.println("Nhap tu Tieng Anh muon sua: ");
        String english = sc.nextLine();
        System.out.println("Ban muon sua thanh: ");
        System.out.println("Tieng Anh: ");
        String e = sc.nextLine();
        System.out.println("Tieng Viet: ");
        String v = sc. nextLine();
        Word w = new Word(e, v);
        int cnt = 0, index = 0;
        for (Word i : dic.getDic()) {
            cnt ++;
            if (i.getWord_target().equals(english)) {
                index = cnt - 1;
            }
        }
        dic.getDic().set(index, w);
    }

    public void removeWord() {
        System.out.println("Nhap tu muon xoa: ");
        String english = sc.nextLine();
        Word word = null;
        for (Word i : dic.getDic()) {
            if (i.getWord_target().equals(english)) {
                word = i;
            }
        }
        dic.getDic().remove(word);
    }

    public void dictionaryExportToFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter printWriter = new PrintWriter("dictionaries.txt", "UTF-8");
        for (Word i : dic.getDic()) {
            printWriter.println(i.getWord_target() + "\t" + i.getWord_explain());
        }
        printWriter.close();
    }
}
