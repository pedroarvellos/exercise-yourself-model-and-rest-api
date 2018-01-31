package br.com.exsystem.model.entity;

import br.com.exsystem.model.base.BaseEntity;

public class BodyPart extends BaseEntity {
    private String name;
    private String photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
