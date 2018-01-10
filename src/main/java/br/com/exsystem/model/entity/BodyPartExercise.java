package br.com.exsystem.model.entity;

import br.com.exsystem.model.base.BaseEntity;

public class BodyPartExercise extends BaseEntity {
    private BodyPart bodyPart;
    private Exercise exercise;

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
