package net.yorksolutions.usermodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.UUID;
@Service
public class UserService {
    private UserAccountRepository repository;
    private HashMap<UUID, Long> tokenMap;


    @Autowired
    public UserService(@NonNull UserAccountRepository repository) {
        this.repository = repository;
        tokenMap = new HashMap<>();
    }

    public UserService(@NonNull UserAccountRepository repository,
                       @NonNull HashMap<UUID, Long> tokenMap) {
        this.repository = repository;
        this.tokenMap = tokenMap;
    }

    UUID login(@RequestParam String username, @RequestParam String password) {

        var result = repository.findByUsernameAndPassword(username, password);
        if (result.isEmpty())
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        final var token = UUID.randomUUID();
        tokenMap.put(token, result.get().id);
        return token;
    }

    public void register(@RequestParam String username, @RequestParam String password) {
        if (repository.findByUsername(username).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT);

        repository.save(new UserAccount());
    }


    boolean logout(@RequestParam String uuid) {
        if(tokenMap.containsKey(UUID.fromString(uuid))){
            tokenMap.remove(UUID.fromString(uuid));
            return true;
        }
        return false;
    }
    public void isAuthorized( UUID token) {
        if(tokenMap.containsKey(token))
            return;
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }

    public void setRepository(UserAccountRepository repository) {
        this.repository = repository;
    }

    public void setTokenMap(HashMap<UUID, Long> tokenMap) {
        this.tokenMap = tokenMap;
    }
}
