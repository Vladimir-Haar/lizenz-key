package com.backend.logic;

import com.backend.model.LizenzTestTemplate;
import com.backend.model.Result;

public class LizenzTestLogic {

    public static Result run(String key) {

        LizenzTestTemplate loginInput = new LizenzTestTemplate();
        loginInput.setKey(key);
        String value = loginInput.getKey();

        // 1. Länge: 14 Zeichen
        if (value != null && value.trim().length() == 14) {

            // 2. Drei Blöcke(XXXX-XXXXX-XXX)
            if (value.charAt(4) == '-' && value.charAt(10) == '-') {

                // 3. Block 1 nur Großbuchstaben A-Z
                String blockEinz = loginInput.getKey().substring(0, 4);
                String blockZwei = loginInput.getKey().substring(5, 10);
                if (blockEinz.matches("[A-Z]+")) {

                    // 4. Block 2: 3x Ziffern und 2x Großbuchstaben hat
                    int zahlenAnzahl = blockZwei.length() - blockZwei.replaceAll("\\d", "").length();
                    int buchstabenAnzahl = blockZwei.length() - blockZwei.replaceAll("[A-Z]", "").length();
                    if (zahlenAnzahl == 3 && buchstabenAnzahl == 2) {

                        // 5. Block 3 endet mit 7
                        String blockDrei = loginInput.getKey().substring(11, 14);
                        if (blockDrei.substring(2).equals("7")) {
                            return new Result(true, "Lizenzschlüssel ist gültig");
                        } else {
                            return new Result(false, "Fehler: Regel 5 - Falscher Endziffer im Block 3.");
                        }
                    } else {
                        return new Result(false, "Fehler: Regel 4 - Falscher Anzahl an Ziffern oder Bchstaben im Block 2.");
                    }
                } else {
                    return new Result(false, "Fehler: Regel 3 - Es sind nicht dazu gehörige Zahlen oder Kleinbuchstaben im Block 1 vorhanden.");
                }
            } else {
                return new Result(false, "Fehler: Regel 2 - Falscher Format von Blöcken.");
            }
        } else {
            return new Result(false, "Fehler: Regel 1 - Die Länge von 14 Zeichen ist nicht gegeben.");
        }

    }
}
