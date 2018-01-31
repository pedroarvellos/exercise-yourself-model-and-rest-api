package br.com.exsystem.model.entity;

import br.com.exsystem.model.base.BaseEntity;
import java.util.ArrayList;
import java.util.List;

public class Exercise extends BaseEntity {

    private String name;
    private String description;
    private String instructions;
    private String photo;
    private List<BodyPart> bodyPartList;

    public Exercise() {
        bodyPartList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<BodyPart> getBodyPartList() {
        return bodyPartList;
    }

    public void setBodyPartList(List<BodyPart> bodyPartList) {
        this.bodyPartList = bodyPartList;
    }
}
