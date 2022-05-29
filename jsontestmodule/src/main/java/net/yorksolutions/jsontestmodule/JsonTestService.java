package net.yorksolutions.jsontestmodule;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;
@Service
public class JsonTestService {
    private final RestTemplate rest;

    @Autowired
    public JsonTestService() {
        rest = new RestTemplate();
    }

    public JsonTestService(RestTemplate rest) {
        this.rest = rest;
    }
    public void checkAuthorized(UUID token) {
        String url = "http://localhost:8081/isAuthorized?token=" + token;
        final ResponseEntity<Void> response = rest.getForEntity(url, Void.class);

        switch (response.getStatusCode()) {
            case OK:
                return;

            case UNAUTHORIZED:
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

            default:
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public IpAddress ip(@RequestParam String token, HttpServletRequest request) {
        checkAuthorized(UUID.fromString(token));
        return new IpAddress(request.getRemoteAddr());
    }

    public DateTime dateTime(@RequestParam String token) {
        ZonedDateTime dateTimeObj = ZonedDateTime.now(ZoneId.of("GMT"));
        checkAuthorized(UUID.fromString(token));
        return new DateTime(DateTimeFormatter.ofPattern("MM-dd-yyyy").format(dateTimeObj), DateTimeFormatter.ofPattern("hh:mm:ss").format(dateTimeObj));
    }

    HashMap<String, String> headerInfo(@RequestParam String token, @RequestHeader HashMap<String, String> headers) {
        checkAuthorized(UUID.fromString(token));
        return headers;
    }

    public Md5 getMd5(@RequestParam String token, @RequestParam String text) throws NoSuchAlgorithmException {
        checkAuthorized(UUID.fromString(token));
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(text.getBytes());
        BigInteger no = new BigInteger(1, messageDigest);
        String hashText = no.toString(16);
        while (hashText.length() < 32) {
            hashText = "0" + hashText;
        }

        return new Md5(hashText, text);
    }

    public JsonValidateResponse validateJson(@RequestParam String token, @RequestParam String json) {
        checkAuthorized(UUID.fromString(token));
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(json);
        } catch (JacksonException e) {
            return new JsonValidateResponse(false);
        }
        return new JsonValidateResponse(true);
    }


}
