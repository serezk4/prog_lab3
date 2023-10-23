package com.serezka.scene.entities.emotion;

import com.serezka.scene.entities.Entity;
import com.serezka.scene.entities.human.Human;

public interface Emotion extends Entity {
    String from();
    String use(Human... humans);
    String use();
}
