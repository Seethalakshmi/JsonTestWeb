package net.yorksolutions.jsontestmodule;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

@RestController
public class JsonTestController {
    JsonTestService service;

    @Autowired
    public JsonTestController(@NonNull JsonTestService service) {
        this.service = service;
    }

    @GetMapping("/ipAddress")
    @CrossOrigin
    public IpAddress ip(@RequestParam String token, HttpServletRequest request) {
       return service.ip(token, request);
    }

    @GetMapping("/datetime")
    @CrossOrigin
    public DateTime dateTime(@RequestParam String token) {
        return service.dateTime(token);
    }

    @GetMapping("/headers")
    @CrossOrigin
    HashMap<String, String> headerInfo(@RequestParam String token, @RequestHeader HashMap<String, String> headers) {
       return service.headerInfo(token,headers);
    }

    @GetMapping("/md5")
    @CrossOrigin
    public Md5 getMd5(@RequestParam String token, @RequestParam String text) throws NoSuchAlgorithmException {
        return service.getMd5(token, text);
    }

    @GetMapping("/validateJson")
    @CrossOrigin
    public JsonValidateResponse validateJson(@RequestParam String token, @RequestParam String json) {
        return service.validateJson(token, json);
    }
    public void setService(JsonTestService service) {
        this.service = service;
    }
}
