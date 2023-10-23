package com.serezka.scene.entities.human;

import com.serezka.scene.entities.place.Place;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class HumanImpl implements Human {
    String name;
    int age;

    Place home;
    Gender gender;

    @Override
    public String describe() {
        return String.format("%s, %s, %d лет, живет в %s",
                this.name, this.gender.getName(), this.age, this.home.getName());
    }

    @Override
    public Place getHome() {
        return this.home;
    }

    @Override
    public Gender getGender() {
        return this.gender;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public Organ[] getOrgans() {
        return Organ.values();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getName(String prefix) {
        return String.join(" ", prefix, this.name);
    }
}
