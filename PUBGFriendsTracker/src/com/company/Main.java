package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List trackedUserId = new ArrayList();

    public static void main(String[] args) {

        loadSettings();

    }

    private static void loadSettings() {
        trackedUserId.clear();
        trackedUserId.add("");

    }

}
