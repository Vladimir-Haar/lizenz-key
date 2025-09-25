package com.backend.logic;

import com.backend.model.Result;

public class LizenzTestLogic {

    public static Result run(String key) {

        String blockEinz = "";
        String blockZwei = "";
        String blockDrei = "";

        if (key == null || key.length() != 14) {
            return new Result(false, "Fehler: Regel 1 - Die Länge von 14 Zeichen ist nicht gegeben.");
        };


        if (key.charAt(4) != '-' || key.charAt(10) != '-') {
            return new Result(false, "Fehler: Regel 2 - Falscher Format von Blöcken.");
        };

        // 3. Block 1 nur Großbuchstaben A-Z
        blockEinz = key.substring(0, 4);
        blockZwei = key.substring(5, 10);
        if (!blockEinz.matches("[A-Z]+")) {
            return new Result(false, "Fehler: Regel 3 - Es sind nicht dazu gehörige Zahlen oder Kleinbuchstaben im Block 1 vorhanden.");
        };

        // 4. Block 2: 3x Ziffern und 2x Großbuchstaben hat
        int zahlenAnzahl = blockZwei.length() - blockZwei.replaceAll("\\d", "").length();
        int buchstabenAnzahl = blockZwei.length() - blockZwei.replaceAll("[A-Z]", "").length();
        if (zahlenAnzahl != 3 && buchstabenAnzahl != 2) {
            return new Result(false, "Fehler: Regel 4 - Falscher Anzahl an Ziffern oder Bchstaben im Block 2.");
        };

        // 5. Block 3 endet mit 7
        blockDrei = key.substring(11, 14);
        if (!blockDrei.substring(2).equals("7")) {
            return new Result(false, "Fehler: Regel 5 - Falscher Endziffer im Block 3.");
        } else {
            return new Result(true, "Lizenzschlüssel ist gültig");
        }

    }
}
