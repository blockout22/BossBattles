package com.blockout22.rpg.boss.battles.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.blockout22.rpg.boss.battles.Statics;
import com.blockout22.rpg.boss.battles.screens.helper.ScreenStage;
import com.kotcrab.vis.ui.widget.VisTextButton;

public class MainMenuScreen extends ScreenStage {

    private VisTextButton play;
    private VisTextButton options;

    public MainMenuScreen() {
        play = new VisTextButton("Click To Play");
        options = new VisTextButton("Options");

        play.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Statics.setScreen(Statics.GAME_SCREEN);
            }
        });

        rootTable.add(play).fillX();
        rootTable.row();
        rootTable.add(options).fillX();
        rootTable.row();
        rootTable.add().expand();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
//        rootTable.clearChildren();
//        rootTable.add(play).fillX().height(Gdx.graphics.getHeight() * 0.3f);
//        rootTable.row();
//        rootTable.add(options).fillX().height(Gdx.graphics.getHeight() * 0.3f);
//        rootTable.row();
//        rootTable.add().expand();
//        play.getLabel().layout();
    }
}
