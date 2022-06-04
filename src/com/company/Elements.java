package com.company;

import java.io.File;
import java.util.Scanner;

public class Elements {
    SimpleQueue<String> queue = new SimpleLinkedListQueue1<>();
    SimpleQueue<String> queue2 = new SimpleLinkedListQueue2<>();
    String str[];
    String str2[];
    String str3[];
    String s = "";
    String a = "";

    public void input() throws Exception {
        File input = new File("\\Users\\admin\\Desktop\\Task_03-19-_Frolova_A-main\\src\\com\\company\\Queue");
        Scanner scan = new Scanner(input);
        String s;
        while (scan.hasNextLine()) {
            s = scan.nextLine();
            str = s.split(" ");
        }
    }

    public String getStr() {
        String s = "";
        for (String i : str) {
            s += i + " ";
        }
        return s;
    }

    public void setStr(String s) {
        str2 = s.split(" ");
        for (String i : str2) {
            queue.add(i);
        }
        while (queue.empty() == false) {
            try {
                dubl(queue.remove());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setStr2(String a) {
        str3 = a.split(" ");
        for (String i : str3) {
            queue2.add(i);
        }
        while (queue2.empty() == false) {
            try {
                dubl2(queue2.remove());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dubl(String str) {
        this.s += str + " " + str + " ";
    }

    public void dubl2(String str) {
        a += str + " " + str + " ";
    }

    public String getStr2() {
        return this.s;
    }

    public String getStr3() {
        return this.a;
    }
}