package com.serezka.scene.entities.emotion;

import com.serezka.scene.entities.human.Human;
import com.serezka.scene.entities.util.HumanUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class EmotionImpl implements Emotion {
    String emotion;

    @Override
    public String from() {
        return String.join(" ", "от", this.emotion);
    }

    @Override
    public String use(Human... humans) {
        return String.format("%s %s", HumanUtils.toString(humans), this.emotion);
    }

    @Override
    public String use() {
        return this.emotion;
    }

    @Override
    public String getName() {
        return this.emotion;
    }

    @Override
    public String getName(String prefix) {
        return String.join(" ", prefix, this.emotion);
    }
}
