package com.serezka.scene;

import com.serezka.scene.entities.action.list.*;
import com.serezka.scene.entities.family.list.Svantesoni;
import com.serezka.scene.entities.human.Organ;
import com.serezka.scene.entities.human.list.*;
import com.serezka.scene.entities.place.list.CarlsonRoof;
import com.serezka.scene.entities.qualifers.list.*;

public class Scene {
    private final TextBuilder history = TextBuilder.getInstance();

    public void build() {
        // build history
        history.add(Kid.getInstance().getName("У"))
                .add(new EyesRounded().executeFrom(Organ.EYES.getName()))
                .add(new Astonishment().getName("от"))
                .add(".");

        history.add("Может,")
                .add(new Mishear().executeFrom(Kid.getInstance().getGender().getPrefix()))
                .add("?");

        history.add("Неужели")
                .add(new Think().executeFromAndUse(new Indeed(), Fille.getInstance(), Rulle.getInstance()))
                .add(",").add("что")
                .add(new Live().executeFrom(Carlson.getInstance())).add(Svantesoni.getInstance().getName("у"))
                .add("?");

        history.add("Какое счастье")
                .add("!");

        history.add(new Mean().executeFrom("Это"))
                .add(",").add("что")
                .add(new CanHide().executeFromAndUse(new Always(), Carlson.getInstance())).add("у себя дома")
                .add("и")
                .add(new StayThere().execute()).add(new InSafety().use())
                .add(".");

        history.add(new DidntTrackDownOfHim().executeFrom(Fille.getInstance(), Rulle.getInstance()))
                .add("!");

        history.add(new ItsNotSoEasy().use(), ".");

        history.add("Ведь никто,")
                .add(Sweep.getInstance().getName("кроме"))
                .add(",", new DontClimbOnRoofs().execute(), ".");

        history.add("Итак,")
                .add(new DontUnderstood().executeFrom(Fille.getInstance(), Rulle.getInstance()))
                .add(CarlsonRoof.getInstance().getName("про"), ",")
                .add("и тем не менее").add(new Awful().getName("все это"))
                .add(".");

        history.add(Carlson.getInstance().getName("Бедняга"))
                .add(",").add(new FeelLike().use()).add(new HaveTo().executeFrom("ему")).add(",")
                .add("если всерьез начнется за ним охота").add("!");

        history.add(new CantHide().executeFromAndUse(new Never(), "Этот дурачок"))
                .add(".");

        System.out.println(history.getResult());
    }
}
