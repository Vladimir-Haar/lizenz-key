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


        // 1. Länge: 14 Zeichen
        if (value.trim().length() == 14) {
            // 2. Drei Blöcke(XXXX-XXXXX-XXX)
            if (value.charAt(4) == '-' && value.charAt(10) == '-') {
                // 3. Block 1 nur Großbuchstaben A-Z
                if (blockEinz.matches("[A-Z]+")) {
                    // 4. Block 2: 3x Ziffern und 2x Großbuchstaben hat
                    int zahlenAnzahl = blockZwei.length() - blockZwei.replaceAll("\\d", "").length();
                    int buchstabenAnzahl = blockZwei.length() - blockZwei.replaceAll("[A-Z]", "").length();
                    if (zahlenAnzahl == 3 && buchstabenAnzahl == 2) {
                        // 5. Block 3 endet mit 7
                        if (blockDrei.substring(2).equals("7")) {
                            System.out.println("Lizenzschlüssel ist gültig.");
                        } else {
                            System.out.println("Fehler: Regel 5 - Falscher Endziffer im Block 3.");
                        }
                    } else {
                        System.out.println("Fehler: Regel 4 - Falscher Anzahl an Ziffern oder Bchstaben im Block 2.");
                    }
                } else {
                    System.out.println("Fehler: Regel 3 - Es sind nicht dazu gehörige Zahlen oder Kleinbuchstaben im Block 1 vorhanden.");
                }
            } else {
                System.out.println("Fehler: Regel 2 - Falscher Format von Blöcken.");
            }
        } else {
            System.out.println("Fehler: Regel 1 - Die Länge von 14 Zeichen ist nicht gegeben.");
        }

        return null;
    }
}
