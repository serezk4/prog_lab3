package com.serezka.scene.entities.family;

import com.serezka.scene.entities.human.Human;
import com.serezka.scene.entities.place.Place;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
 @RequiredArgsConstructor
public class FamilyImpl implements Family {
    String name;
    List<Human> peoples;
    Place house;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Human> getPeoples() {
        return this.peoples;
    }

    @Override
    public Place getHouse() {
        return this.house;
    }
}
