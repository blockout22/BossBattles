package com.blockout22.rpg.boss.battles.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.blockout22.rpg.boss.battles.Statics;
import com.blockout22.rpg.boss.battles.mobs.Mob;
import com.blockout22.rpg.boss.battles.mobs.Player;
import com.blockout22.rpg.boss.battles.screens.helper.ScreenStage;
import com.kotcrab.vis.ui.widget.VisDialog;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisProgressBar;
import com.kotcrab.vis.ui.widget.VisTextButton;

public class FightScreen extends ScreenStage {

    private Mob mob;

    private Table bottomBar;
    private VisLabel mobName;
    private VisProgressBar mobHealth, playerHealth;
    private VisTextButton attackButton, backConfirm;
    private VisDialog dialog;

    private String ATTACK_STRING = "Attack";

    private long lastMobHit, lastPlayerHit;

    public FightScreen(final Player player, final Mob mob){
        super(player);
        this.mob = mob;
        bottomBar = new Table();

        mobName = new VisLabel(mob.getName());
        mobHealth = new VisProgressBar(0, mob.getStats().getMaxhealth(), 0.1f, false);
        mobHealth.setValue(mob.getStats().getCurrentHealth());

        playerHealth = new VisProgressBar(0, player.getStats().getMaxhealth(), 0.1f, false);
        playerHealth.setValue(player.getStats().getCurrentHealth());

        attackButton = new VisTextButton("Attack");
        backConfirm = new VisTextButton("Back");

        dialog = new VisDialog("Are you sure you want to go back?");

        attackButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                attackButton.setDisabled(true);
                long dmg = getPlayer().hit(mob);
                lastPlayerHit = System.currentTimeMillis();
            }
        });

        backConfirm.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                dialog.show(getStage());
            }
        });

        rootTable.add(mobName).top().row();
        rootTable.add(mobHealth).top().fillX().expand().row();
        rootTable.add(playerHealth).fillX().row();
        rootTable.add(bottomBar).fillX();
        bottomBar.add(attackButton).center().pad(5);
        bottomBar.add(backConfirm).expand().right();

        VisTextButton back = new VisTextButton("Yes");
        dialog.button(back);
        dialog.button("No");

        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Statics.backScreen();
            }
        });

        lastMobHit = System.currentTimeMillis();
        lastPlayerHit = System.currentTimeMillis();

        player.reset();
        mob.reset();
    }
}
