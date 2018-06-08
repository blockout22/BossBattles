package com.blockout22.rpg.boss.battles.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.blockout22.rpg.boss.battles.Statics;
import com.blockout22.rpg.boss.battles.mobs.Player;
import com.blockout22.rpg.boss.battles.screens.helper.ScreenStage;
import com.kotcrab.vis.ui.widget.VisTextButton;

public class MainMenuScreen extends ScreenStage {

    private VisTextButton play;
    private VisTextButton options;

    public MainMenuScreen(Player player) {
        super(player);
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
    }
}
