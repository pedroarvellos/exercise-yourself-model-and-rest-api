package br.com.exsystem.model.entity;

import br.com.exsystem.model.base.BaseEntity;

public class BodyPart extends BaseEntity {
    private String name;
    private byte[] photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
