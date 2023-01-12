package com.example.sidin.service;

public class userdatalogin<T, U, V> {
    private final T username;
    private final U password;
    private final V email;

    public userdatalogin(T username, U password, V email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public T getUsername() {
        return this.username;
    }

    public U getPassword() {
        return this.password;
    }

    public V getEmail() {
        return this.email;
    }
}