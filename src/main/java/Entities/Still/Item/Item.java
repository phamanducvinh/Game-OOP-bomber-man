package Entities.Still.Item;

import Entities.Animate.Brick;
import Entities.Animate.Character.Bomber;
import Entities.Still.StillEntity;
import Graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

import static Graphics.Sprite.BRICK;

public abstract class Item extends StillEntity {
    private boolean hidden;

    public Item(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        gameMap.setTiles(x,y,new Brick(x,y,BRICK));
        add();
        destroyable = true;
        hidden = true;
    }

    @Override
    public void render(GraphicsContext graphicsContext) {
        if(hidden) {
            graphicsContext.drawImage(img,pixelY,pixelX);
        }
    }

    public void remove() {
        gameMap.removeItem(this);
    }

    public void add() {
        gameMap.addItem(this);
    }


    public boolean isHidden() {
        return hidden;
    }

    public abstract void effect(Bomber bomber);
}
