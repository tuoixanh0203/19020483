package com.company;

import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> Dic = new ArrayList<Word>();

    public ArrayList<Word> getDic() {
        return Dic;
    }

    public void setDic(ArrayList<Word> dic) {
        Dic = dic;
    }
}

