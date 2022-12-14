package Entities.Still.Item;

import Constants.Constants;
import Entities.Animate.Character.Bomber;
import Entities.Animate.Character.Character;
import Entities.Animate.Character.Enemy.Enemy;
import GameController.Bomberman;
import GameController.SoundController;
import Graphics.Sprite;

import static Constants.Constants.SOUND_PATH;

public class Portal extends Item{
    public Portal(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        hidden = true;
    }

    private int countEnemies() {
        int cntEnemies = 0;
        for (Character character: gameMap.getCharacters()) {
            if (character instanceof Enemy) {
                cntEnemies++;
            }
        }
        return cntEnemies;
    }

    @Override
    public void effect(Bomber bomber) {
        if (countEnemies() == 0) {
            //SoundController.playEffectSound(SOUND_PATH[1]);
            destroy();
            gameMap.nextStage();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        destroyable = false;
    }
}
