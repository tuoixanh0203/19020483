package com.company;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class DictionaryManagement {
    Dictionary dic = new Dictionary();

    /**
     * day la ham insert co chuc nang nhap lieu nhe.
     */
    public Dictionary insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tu can tra: ");
        String s = sc.nextLine();
        for (int i = 0; i < dic.getDic().size(); i++) {
            if (dic.getDic().get(i).getWord_target().equals(s)) {
                System.out.println(dic.getDic().get(i).getWord_explain());
            }
        }
    }

}
