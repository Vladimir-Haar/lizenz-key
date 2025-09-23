package com.backend.logic;

import com.backend.model.LoginTestTemplate;

public class LoginTestLogic {

    public static String run(String key) {

        LoginTestTemplate loginInput = new LoginTestTemplate();
        loginInput.setKey(key);
        String value = loginInput.getKey();

        String blockEinz = loginInput.getKey().substring(0, 4);
        String blockZwei = loginInput.getKey().substring(5, 10);
        String blockDrei = loginInput.getKey().substring(11, 14);

        int zahlenAnzahl = blockZwei.length() - blockZwei.replaceAll("\\d", "").length();
        int buchstabenAnzahl = blockZwei.length() - blockZwei.replaceAll("[A-Z]", "").length();


        // 1. Länge: 14 Zeichen
        if (value.trim().length() == 14) {
            System.out.println("Perfekt 1");
        } else {
            System.out.println("Kacke 1");
        }

        // 2. Drei Blöcke(XXXX-XXXXX-XXX)
        if (value.charAt(4) == '-' && value.charAt(10) == '-') {
            System.out.println("Perfekt 2");
        } else {
            System.out.println("Kacke 2");
        }

        // 3. Block 1 nur Großbuchstaben A-Z
        if (blockEinz.matches("[A-Z]+")) {
            System.out.println("Perfekt 3");
        } else {
            System.out.println("Kacke 3");
        }

        // 4. Block 2: 3x Ziffern und 2x Großbuchstaben hat
        if (zahlenAnzahl == 3 && buchstabenAnzahl == 2) {
            System.out.println("Perfekt 4");
        } else {
            System.out.println("Kacke 4");
        }

        // 5. Block 3 endet mit 7
        if (blockDrei.substring(2).equals("7")) {
            System.out.println("Perfekt 5");
        } else {
            System.out.println("Kacke 5");
        }

        return null;
    }
}
