package com.serezka.scene;

import com.serezka.scene.entities.action.Action;
import com.serezka.scene.entities.action.ActionImpl;
import com.serezka.scene.entities.emotion.Emotion;
import com.serezka.scene.entities.emotion.EmotionImpl;
import com.serezka.scene.entities.family.Family;
import com.serezka.scene.entities.family.FamilyImpl;
import com.serezka.scene.entities.human.Gender;
import com.serezka.scene.entities.human.Human;
import com.serezka.scene.entities.human.HumanImpl;
import com.serezka.scene.entities.human.Organ;
import com.serezka.scene.entities.place.House;
import com.serezka.scene.entities.place.Place;
import com.serezka.scene.entities.place.Roof;
import com.serezka.scene.entities.util.HumanUtils;

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

        // actions
        Action eyesRounded = new ActionImpl("округлились");
        Action mishear = new ActionImpl("ослышался");
        Action think = new ActionImpl("думают");
        Action live = new ActionImpl("живет");
        Action mean = new ActionImpl("ведь значит");
        Action canHide = new ActionImpl("может спрятаться");
        Action dontKnowHowToHide = new ActionImpl("не умел прятаться");
        Action stayThere = new ActionImpl("быть там");
        Action didntTrackDownOfHim = new ActionImpl("его не выследили");
        Action notClimbOnRoofs = new ActionImpl("не лазает по крышам");
        Action notUnderstood = new ActionImpl("не пронюхали");
        Action haveTo = new ActionImpl("придется");

        // emotions
        Emotion astonishment = new EmotionImpl("удивления");
        Emotion indeed = new EmotionImpl("в самом деле");
        Emotion always = new EmotionImpl("всегда");
        Emotion inSafety = new EmotionImpl("в полной безопасности");
        Emotion awful = new EmotionImpl("ужасно");
        Emotion feel = new EmotionImpl("каково");
        Emotion never = new EmotionImpl("никогда");

        history.add(kid.getName("У"))
                .add(eyesRounded.executeFrom(Organ.EYES.getName()))
                .add(astonishment.getName("от"))
                .add(".");

        history.add("Может,")
                .add(mishear.executeFrom(kid.getGender().getPrefix()))
                .add("?");

        history.add("Неужели")
                .add(think.executeFromAndUse(indeed, fille, rulle))
                .add(",").add("что")
                .add(live.executeFrom(carlson)).add(svantesoni.getName("у"))
                .add("?");

        history.add("Какое счастье")
                .add("!");

        history.add(mean.executeFrom("Это"))
                .add(",").add("что")
                .add(canHide.executeFromAndUse(always, carlson)).add("у себя дома")
                .add("и")
                .add(stayThere.execute()).add(inSafety.use())
                .add(".");

        history.add(didntTrackDownOfHim.executeFrom(fille, rulle))
                .add("!");

        history.add("Да это и не так легко.");

        history.add("Ведь никто,")
                .add(sweep.getName("кроме"))
                .add(", ").add(notClimbOnRoofs.execute())
                .add(".");

        history.add("Итак,")
                .add(notUnderstood.executeFrom(fille, rulle))
                .add(carlsonHouse.getName("про"), ",")
                .add("и тем не менее").add(awful.getName("все это"))
                .add(".");

        history.add(carlson.getName("Бедняга"))
                .add(",").add(feel.use()).add(haveTo.executeFrom("ему")).add(",")
                .add("если всерьез начнется за ним охота").add("!");

        history.add(never.use()).add(dontKnowHowToHide.executeFrom("Этот дурачок"))
                .add(".");

        System.out.println(history.getResult());
    }
}
