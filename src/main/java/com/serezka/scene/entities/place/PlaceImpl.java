package com.serezka.scene.entities.place;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PlaceImpl implements Place {
    String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getName(String prefix) {
        return String.join(" ", prefix, " ", this.name);
    }
}
