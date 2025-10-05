package com.backend.LicenseKey;

import com.backend.logic.LizenzTestLogic;
import com.backend.model.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/lizenz")
@CrossOrigin(origins = "*")

public class LicenseKeyController {


    @PostMapping(value = "/pruefen", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result pruefen(@RequestBody Map<String, String> body) {
        String key = body.get("lizenzschluessel");

        return LizenzTestLogic.run(key);
    }


    private final LicenseKeyService service;


    public LicenseKeyController(LicenseKeyService service) {
        this.service = service;
    }

    @GetMapping("/keyPruefenUndSpeichern")
    public Result pruefenKeyUndServerKey(@RequestParam String newKey) {
        return service.getAllKeysAndCompareAndSaveWhileTrue(newKey);
    }



}