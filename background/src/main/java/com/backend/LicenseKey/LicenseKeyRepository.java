package com.backend.LicenseKey;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseKeyRepository extends JpaRepository<LicenseKey, Long> {

    LicenseKey findByKeyValue(String keyValue);

}
