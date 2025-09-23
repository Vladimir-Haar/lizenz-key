package com.backend.controller;

import com.backend.logic.LizenzTestLogic;
import com.backend.model.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/lizenz")
@CrossOrigin(origins = "http://localhost:3000")

public class LizenzController {

    @PostMapping(value = "/pruefen", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result pruefen(@RequestBody Map<String, String> body) {
        String key = body.get("lizenzschluessel");

        return LizenzTestLogic.run(key);

    }
}