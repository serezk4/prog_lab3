package com.serezka.scene.entities.action;

import com.serezka.scene.entities.qualifers.Qualifer;
import com.serezka.scene.entities.human.Human;
import com.serezka.scene.entities.util.HumanUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ActionImpl implements Action {
    String action;

    @Override
    public String getName() {
        return this.action;
    }

    @Override
    public String getName(String prefix) {
        return String.join(" ", prefix, this.action);
    }

    @Override
    public String execute() {
        return this.action;
    }

    @Override
    public String executeFrom(Human... humans) {
        return String.format("%s %s", HumanUtils.toString(humans), this.action);
    }

    @Override
    public String executeFromAndUse(Qualifer qualifer, Human... humans) {
        return String.join(" ", qualifer.use(humans), this.action);
    }

    @Override
    public String executeFrom(String entity) {
        return String.join(" ", entity, this.action);
    }

    @Override
    public String executeFromAndUse(Qualifer qualifer, String entity) {
        return String.join(" ", qualifer.use(entity), this.action);
    }
}
