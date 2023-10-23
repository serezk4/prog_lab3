package com.serezka.scene;

import com.serezka.scene.entities.action.list.*;
import com.serezka.scene.entities.qualifers.list.*;
import com.serezka.scene.entities.family.Family;
import com.serezka.scene.entities.family.FamilyImpl;
import com.serezka.scene.entities.human.Gender;
import com.serezka.scene.entities.human.Human;
import com.serezka.scene.entities.human.HumanImpl;
import com.serezka.scene.entities.human.Organ;
import com.serezka.scene.entities.place.House;
import com.serezka.scene.entities.place.Place;
import com.serezka.scene.entities.place.Roof;

import java.util.Collections;

public class Scene {
    private final TextBuilder history = TextBuilder.getInstance();

    public void play() {
        // places
        Place filleAndRulleHouse = new House();
        Place carlsonHouse = new Roof();

        // humans
        Human kid = new HumanImpl("Малыша", 10, new House(), Gender.MALE);

        Human fille = new HumanImpl("Филле", 9, filleAndRulleHouse, Gender.MALE);
        Human rulle = new HumanImpl("Рулле", 9, filleAndRulleHouse, Gender.MALE);

        Human carlson = new HumanImpl("Карлсон", 30, carlsonHouse, Gender.MALE);
        Human sweep = new HumanImpl("трубочиста", 50, null, Gender.MALE);

        // families
        Family svantesoni = new FamilyImpl("Свантесонов", Collections.emptyList(), new House());

        // build history
        history.add(kid.getName("У"))
                .add(new EyesRounded().executeFrom(Organ.EYES.getName()))
                .add(new Astonishment().getName("от"))
                .add(".");

        history.add("Может,")
                .add(new Mishear().executeFrom(kid.getGender().getPrefix()))
                .add("?");

        history.add("Неужели")
                .add(new Think().executeFromAndUse(new Indeed(), fille, rulle))
                .add(",").add("что")
                .add(new Live().executeFrom(carlson)).add(svantesoni.getName("у"))
                .add("?");

        history.add("Какое счастье")
                .add("!");

        history.add(new Mean().executeFrom("Это"))
                .add(",").add("что")
                .add(new CanHide().executeFromAndUse(new Always(), carlson)).add("у себя дома")
                .add("и")
                .add(new StayThere().execute()).add(new InSafety().use())
                .add(".");

        history.add(new DidntTrackDownOfHim().executeFrom(fille, rulle))
                .add("!");

        history.add(new ItsNotSoEasy().use(), ".");

        history.add("Ведь никто,")
                .add(sweep.getName("кроме"))
                .add(",", new DontClimbOnRoofs().execute(), ".");

        history.add("Итак,")
                .add(new DontUnderstood().executeFrom(fille, rulle))
                .add(carlsonHouse.getName("про"), ",")
                .add("и тем не менее").add(new Awful().getName("все это"))
                .add(".");

        history.add(carlson.getName("Бедняга"))
                .add(",").add(new FeelLike().use()).add(new HaveTo().executeFrom("ему")).add(",")
                .add("если всерьез начнется за ним охота").add("!");

        history.add(new CantHide().executeFromAndUse(new Never(), "Этот дурачок"))
                .add(".");

        System.out.println(history.getResult());
    }
}
