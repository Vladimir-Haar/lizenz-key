package com.backend.LicenseKey;

import com.backend.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LicenseKeyService {

    @Autowired
    private LicenseKeyRepository repository;

    public Result getAllKeysAndCompareAndSaveWhileTrue(String newKey) {
        LicenseKey findKey = repository.findByKeyValue(newKey);

        if (findKey != null) {
            return new Result(false, "Fehler: Lizenzschlüssel wurde bereits verwendet.");

        }

        LicenseKey lizenz = new LicenseKey();
        lizenz.setKeyValue(newKey);
        lizenz.setCreatedAt(java.time.LocalDateTime.now());
        repository.save(lizenz);

        return new Result(true, "Lizenzschlüssel ist gültig.");
    }


}
