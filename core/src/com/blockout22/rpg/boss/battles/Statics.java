package com.blockout22.rpg.boss.battles;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.Array;
import com.blockout22.rpg.boss.battles.screens.GameScreen;
import com.blockout22.rpg.boss.battles.screens.MainMenuScreen;
import com.blockout22.rpg.boss.battles.screens.helper.ScreenStage;
import com.github.czyzby.lml.parser.LmlParser;
import com.github.czyzby.lml.util.Lml;
import com.kotcrab.vis.ui.VisUI;

public class Statics {

    private static Game game;
    private static Preferences prefs;

    //change this to false for paid version
    private static boolean isFree = true;

    private static Array<ScreenStage> screenHistroy;

    public static ScreenStage
            MAIN_MENU,
            GAME_SCREEN;

    public static void init(Game game){
        Statics.game = game;
        prefs = Gdx.app.getPreferences("userdata");
        screenHistroy = new Array<ScreenStage>();

        MAIN_MENU = new MainMenuScreen();
        GAME_SCREEN = new GameScreen();

        setScreen(MAIN_MENU);
    }

    public static void backScreen(){
        if(screenHistroy.size > 1){
            ScreenStage s = screenHistroy.get(screenHistroy.size - 2);
            screenHistroy.removeIndex(screenHistroy.size - 1);
            setScreen(s);
        }
    }

    public static void setScreen(ScreenStage screen){
        game.setScreen(screen);
        screenHistroy.add(screen);
    }

    public static void dispose(){
        MAIN_MENU.dispose();
        GAME_SCREEN.dispose();
        prefs.flush();
    }
}
