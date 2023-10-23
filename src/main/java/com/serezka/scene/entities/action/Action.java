package com.serezka.scene.entities.action;

import com.serezka.scene.entities.Entity;
import com.serezka.scene.entities.emotion.Emotion;
import com.serezka.scene.entities.human.Human;

public interface Action extends Entity {
    String execute();
    String executeFrom(Human... humans);
    String executeFromAndUse(Emotion emotion, Human... humans);
    String executeFrom(String entity);
}
