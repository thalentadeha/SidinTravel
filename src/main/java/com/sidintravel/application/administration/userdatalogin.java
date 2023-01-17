package com.sidintravel.application.administration;

public class userdatalogin<T, U, V, W> {
    private final T username;
    private final U password;
    private final V email;
    private W isNew;

    public userdatalogin(T username, U password, V email, W isNew) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isNew = isNew;
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

    public W getIsNew() {
        return this.isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = (W) isNew;
    }

}