package Entities;
import Graphics.Sprite;
import Map.Map;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

import static Graphics.Sprite.SCALED_SIZE;

@Getter
@Setter
public abstract class Entity {
    protected static Map gameMap = Map.getGameMap();
    protected int pixelX, pixelY;
    protected int tileX, tileY;
    protected Sprite sprite;
    protected Image img;
    protected boolean destroyable ;
    protected boolean destroyed;
    protected boolean block;

    public Entity(int x, int y, Sprite sprite) {
        this.tileX = x;
        this.tileY = y;
        this.pixelX = x * SCALED_SIZE;
        this.pixelY = y * SCALED_SIZE;
        this.sprite = sprite;
        this.img = sprite.getFxImage();
        this.block = false;
        this.destroyed = false;
        this.destroyable = false;
    }

    public static void setGameMap(Map gameMap) {
        Entity.gameMap = gameMap;
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(pixelX,pixelY, SCALED_SIZE, SCALED_SIZE);
    }

    public boolean isCollision(Entity entity) {
        return getBoundary().intersects(entity.getBoundary());
    }

    public void render(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(img, pixelY, pixelX);
    }

    public abstract void update();

    public Pair<Integer,Integer> getTile() {
        return new Pair(tileX,tileY);
    }

}
