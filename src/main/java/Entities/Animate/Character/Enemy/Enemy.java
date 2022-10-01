package Entities.Animate.Character.Enemy;
import Constants.Contants.DIRECTION;
import Entities.Animate.AnimateEntity;
import Entities.Animate.Character.Bomber;
import Entities.Animate.Character.Character;
import Graphics.Sprite;
import Map.Map;

public abstract class Enemy extends Character {
    public Enemy(int x, int y, Sprite sprite) {
        super(x,y,sprite);
    }

    public abstract DIRECTION trace(Bomber bomber,Enemy enemy,Map gameMap);
    @Override
    public void getDirection() {
        direction = trace(gameMap.getPlayer(),this,gameMap);
        currentAnimate = animation.get(direction);
        switch (direction) {
            case UP -> this.setVelocity(-defaultVelocity, 0);
            case DOWN -> this.setVelocity(defaultVelocity, 0);
            case LEFT -> this.setVelocity(0, -defaultVelocity);
            case RIGHT -> this.setVelocity(0, defaultVelocity);
            case DESTROYED -> this.setVelocity(0,0);
        }
    }

    @Override
    public void delete() {
        gameMap.removeCharacter(this);
    }
}
