/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import domain.User;
import java.util.HashMap;
import java.util.Map;

public class Session {

    private static Session instance;
    private User currentUser;

    private int currentUseCase;
    private final Map<String, Object> useCaseParams;

    private Session() {
        useCaseParams = new HashMap<>();
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void setCurrentUseCase(int currentUseCase) {
        this.currentUseCase = currentUseCase;
    }

    public int getCurrentUseCase() {
        return currentUseCase;
    }

    public Map<String, Object> getUseCaseParams() {
        return useCaseParams;
    }

}
