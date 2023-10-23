package com.serezka.scene.entities.human;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum Gender {
    MALE("он", "мужчина"),
    FEMALE("она", "женщина");

    String prefix;
    String name;
}
