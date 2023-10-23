package com.serezka.scene.entities.place;

import com.serezka.scene.entities.Entity;

public interface Place extends Entity {
    String getName();
    String in(String prefix);
    String in();
}
