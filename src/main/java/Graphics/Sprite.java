package Graphics;

import Graphics.SpriteSheet;
import javafx.scene.image.*;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.Arrays;

/**
 * Lưu trữ thông tin các pixel của 1 sprite (hình ảnh game)
 */
public class Sprite {

    public static final int DEFAULT_SIZE = 16;
    public static final int SCALED_SIZE = DEFAULT_SIZE * 2;
    private static final int TRANSPARENT_COLOR = 0xFFFD40FF;
    public final int SIZE;
    private int _x, _y;
    public int[] _pixels;
    protected int _realWidth;
    protected int _realHeight;
    private SpriteSheet _sheet;

    /*
    |--------------------------------------------------------------------------
    | Board sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite grass = new Sprite(DEFAULT_SIZE, 6, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite brick = new Sprite(DEFAULT_SIZE, 7, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite wall = new Sprite(DEFAULT_SIZE, 5, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite PORTAL = new Sprite(DEFAULT_SIZE, 4, 0, SpriteSheet.tiles, 14, 14);

    /*
    |--------------------------------------------------------------------------
    | Bomber Sprites
    |--------------------------------------------------------------------------
     */

    public static Sprite[] PLAYER_RIGHT = {
            new Sprite(DEFAULT_SIZE, 1, 0, SpriteSheet.tiles, 16, 10),
            new Sprite(DEFAULT_SIZE, 1, 1, SpriteSheet.tiles, 16, 10),
            new Sprite(DEFAULT_SIZE, 1, 2, SpriteSheet.tiles, 16, 10),
    };

    public static Sprite[] PLAYER_LEFT = {
            new Sprite(DEFAULT_SIZE, 3, 0, SpriteSheet.tiles, 16, 10),
            new Sprite(DEFAULT_SIZE, 3, 1, SpriteSheet.tiles, 16, 10),
            new Sprite(DEFAULT_SIZE, 3, 2, SpriteSheet.tiles, 16 ,10)
    };


    public static Sprite[] PLAYER_UP = {
            new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.tiles, 16, 10),
            new Sprite(DEFAULT_SIZE, 0, 1, SpriteSheet.tiles, 16, 10),
            new Sprite(DEFAULT_SIZE, 0, 2, SpriteSheet.tiles, 16, 10),
    };

    public static Sprite[] PLAYER_DOWN = {
            new Sprite(DEFAULT_SIZE, 2, 0, SpriteSheet.tiles, 16, 10),
            new Sprite(DEFAULT_SIZE, 2, 1, SpriteSheet.tiles, 16, 10),
            new Sprite(DEFAULT_SIZE, 2, 2, SpriteSheet.tiles, 16, 10)
    };

    public static Sprite[] PLAYER_DEAD = {
            new Sprite(DEFAULT_SIZE, 4, 2, SpriteSheet.tiles, 16, 13),
            new Sprite(DEFAULT_SIZE, 5, 2, SpriteSheet.tiles, 16, 13),
            new Sprite(DEFAULT_SIZE, 6, 2, SpriteSheet.tiles, 16, 13)
    };


    /*
    |--------------------------------------------------------------------------
    | Character
    |--------------------------------------------------------------------------
     */
    //BALLOON
    public static final Sprite[] BALLOON_LEFT = {
            new Sprite(DEFAULT_SIZE, 9, 0, SpriteSheet.tiles, 16, 13),
            new Sprite(DEFAULT_SIZE, 9, 1, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 9, 2, SpriteSheet.tiles, 16, 13)
    };

    public static final Sprite[] BALLOON_RIGHT = {
            new Sprite(DEFAULT_SIZE, 10, 0, SpriteSheet.tiles, 16, 13),
            new Sprite(DEFAULT_SIZE, 10, 1, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 10, 2, SpriteSheet.tiles, 16, 13)
    };

    public static final Sprite[] BALLOON_DEAD = {
            new Sprite(DEFAULT_SIZE, 9, 3, SpriteSheet.tiles, 16, 13),
            new Sprite(DEFAULT_SIZE, 9, 3, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 9, 3, SpriteSheet.tiles, 16, 13)
    };

    //ONEAL

    public static Sprite[] ONEAL_LEFT = {
            new Sprite(DEFAULT_SIZE, 11, 0, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 11, 1, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 11, 2, SpriteSheet.tiles, 16, 16)
    };

    public static Sprite[] ONEAL_RIGHT = {
            new Sprite(DEFAULT_SIZE, 12, 0, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 12, 1, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 12, 2, SpriteSheet.tiles, 16, 16),
    };

    public static Sprite[] ONEAL_DEAD = {
            new Sprite(DEFAULT_SIZE, 11, 3, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 11, 3, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 11, 3, SpriteSheet.tiles, 16, 16)
    };

    //DOLL
    public static Sprite[] DOLL_LEFT = {
            new Sprite(DEFAULT_SIZE,13,0,SpriteSheet.tiles,16,16),
            new Sprite(DEFAULT_SIZE,13,1,SpriteSheet.tiles,16,16),
            new Sprite(DEFAULT_SIZE,13,2,SpriteSheet.tiles,16,16),
    };

    public static Sprite[] DOLL_RIGHT = {
            new Sprite(DEFAULT_SIZE,14,0,SpriteSheet.tiles,16,16),
            new Sprite(DEFAULT_SIZE,14,1,SpriteSheet.tiles,16,16),
            new Sprite(DEFAULT_SIZE,14,2,SpriteSheet.tiles,16,16),
    };

    public static Sprite[] DOLL_DEAD = {
            new Sprite(DEFAULT_SIZE,13,3,SpriteSheet.tiles,16,16),
            new Sprite(DEFAULT_SIZE,13,3,SpriteSheet.tiles,16,16),
            new Sprite(DEFAULT_SIZE,13,3,SpriteSheet.tiles,16,16),
    };

    // GHOST

    public static Sprite[] GHOST_RIGHT = {
            new Sprite(DEFAULT_SIZE,6,5,SpriteSheet.tiles,16,16),
            new Sprite(DEFAULT_SIZE,6,6,SpriteSheet.tiles,16,16),
            new Sprite(DEFAULT_SIZE,6,7,SpriteSheet.tiles,16,16),
    };

    public static Sprite[] GHOST_LEFT = {
            new Sprite(DEFAULT_SIZE,7,5,SpriteSheet.tiles,16,16),
            new Sprite(DEFAULT_SIZE,7,6,SpriteSheet.tiles,16,16),
            new Sprite(DEFAULT_SIZE,7,7,SpriteSheet.tiles,16,16)
    };

    public static Sprite[] GHOST_DEAD = {
            new Sprite(DEFAULT_SIZE,6,8,SpriteSheet.tiles,16,16),
            new Sprite(DEFAULT_SIZE,6,8,SpriteSheet.tiles,16,16),
            new Sprite(DEFAULT_SIZE,6,8,SpriteSheet.tiles,16,16)
    };

    // MINVO
    public static Sprite[] MINVO_LEFT = {
            new Sprite(DEFAULT_SIZE, 8, 5, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 8, 6, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 8, 7, SpriteSheet.tiles, 16, 16)
    };

    public static Sprite[] MINVO_RIGHT = {
            new Sprite(DEFAULT_SIZE, 9, 5, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 9, 6, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 9, 7, SpriteSheet.tiles, 16, 16)
    };

    public static Sprite[] MINVO_DEAD = {
            new Sprite(DEFAULT_SIZE, 8, 8, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 8, 8, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 8, 8, SpriteSheet.tiles, 16, 16)
    };

    //KONDORIA

    public static Sprite[] KONDORIA_LEFT = {
            new Sprite(DEFAULT_SIZE, 10, 5, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 10, 6, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 10, 7, SpriteSheet.tiles, 16, 16)
    };

    public static Sprite[] KONDORIA_RIGHT = {
            new Sprite(DEFAULT_SIZE, 11, 5, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 11, 6, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 11, 7, SpriteSheet.tiles, 16, 16)
    };

    public static Sprite[] KONDORIA_DEAD = {
            new Sprite(DEFAULT_SIZE, 10, 8, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 10, 8, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 10, 8, SpriteSheet.tiles, 16, 16)
    };

    //ALL
    public static Sprite mob_dead1 = new Sprite(DEFAULT_SIZE, 15, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite mob_dead2 = new Sprite(DEFAULT_SIZE, 15, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite mob_dead3 = new Sprite(DEFAULT_SIZE, 15, 2, SpriteSheet.tiles, 16, 16);

    /*
    |--------------------------------------------------------------------------
    | Bomb Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite[] BOMB = {
            new Sprite(DEFAULT_SIZE, 0, 3, SpriteSheet.tiles, 15, 15),
            new Sprite(DEFAULT_SIZE, 1, 3, SpriteSheet.tiles, 13, 15),
            new Sprite(DEFAULT_SIZE, 2, 3, SpriteSheet.tiles, 12, 14)
    };

    /*
    |--------------------------------------------------------------------------
    | FlameSegment Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite[] EXPLODED = {
            new Sprite(DEFAULT_SIZE, 0, 4, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 0, 5, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 0, 6, SpriteSheet.tiles, 16, 16)
    };

    public static Sprite[] VERTICAL = {
            new Sprite(DEFAULT_SIZE, 1, 5, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 2, 5, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 3, 5, SpriteSheet.tiles, 16, 16)
    };

    public static Sprite[] HORIZONTAL = {
            new Sprite(DEFAULT_SIZE, 1, 7, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 1, 8, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 1, 9, SpriteSheet.tiles, 16, 16)
    };

    public static Sprite[] LEFT_LAST = {
            new Sprite(DEFAULT_SIZE, 0, 7, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 0, 8, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 0, 9, SpriteSheet.tiles, 16, 16)
    };

    public static Sprite[] RIGHT_LAST = {
            new Sprite(DEFAULT_SIZE, 2, 7, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 2, 8, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 2, 9, SpriteSheet.tiles, 16, 16)
    };

    public static Sprite[] TOP_LAST = {
            new Sprite(DEFAULT_SIZE, 1, 4, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 2, 4, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 3, 4, SpriteSheet.tiles, 16, 16)
    };

    public static Sprite[] DOWN_LAST = {
            new Sprite(DEFAULT_SIZE, 1, 6, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 2, 6, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 3, 6, SpriteSheet.tiles, 16, 16)
    };

    /*
    |--------------------------------------------------------------------------
    | Brick FlameSegment
    |--------------------------------------------------------------------------
     */
    public static Sprite[] BRICK_EXPLODED = {
            new Sprite(DEFAULT_SIZE, 7, 1, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 7, 2, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 7, 3, SpriteSheet.tiles, 16, 16)
    };

    /**
     * FIRE
     * */
    public static Sprite[] fire_down = {
            new Sprite(DEFAULT_SIZE, 6, 12, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 6, 12, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 6, 12, SpriteSheet.tiles, 16, 16)
    };

    public static Sprite[] fire_right = {
            new Sprite(DEFAULT_SIZE, 7, 12, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 7, 12, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 7, 12, SpriteSheet.tiles, 16, 16)

    };
    public static Sprite[] fire_up = {
            new Sprite(DEFAULT_SIZE, 8, 12, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 8, 12, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 8, 12, SpriteSheet.tiles, 16, 16)
    };
    public static Sprite[] fire_left = {
            new Sprite(DEFAULT_SIZE, 9, 12, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 9, 12, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 9, 12, SpriteSheet.tiles, 16, 16)
    };


    /*
    |--------------------------------------------------------------------------
    | PowerUps
    |--------------------------------------------------------------------------
     */
    public static Sprite BOMB_ITEM = new Sprite(DEFAULT_SIZE, 0, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite FLAME_ITEM = new Sprite(DEFAULT_SIZE, 1, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite SPEED_ITEM = new Sprite(DEFAULT_SIZE, 2, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite WALL_PASS_ITEM = new Sprite(DEFAULT_SIZE, 3, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite DETONATOR_ITEM = new Sprite(DEFAULT_SIZE,4,10,SpriteSheet.tiles,16,16);
    public static Sprite BOMB_PASS_ITEM = new Sprite(DEFAULT_SIZE, 5, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite FLAME_PASS_ITEM = new Sprite(DEFAULT_SIZE, 6, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite RANDOM_ITEM = new Sprite(DEFAULT_SIZE,7,10,SpriteSheet.tiles,16,16);
    public Sprite(int size, int x, int y, SpriteSheet sheet, int rw, int rh) {
        SIZE = size;
        _pixels = new int[SIZE * SIZE];
        _x = x * SIZE;
        _y = y * SIZE;
        _sheet = sheet;
        _realWidth = rw * 2;
        _realHeight = rh * 2;
        load();
    }

    public Sprite(int size, int color) {
        SIZE = size;
        _pixels = new int[SIZE * SIZE];
        setColor(color);
    }

    private void setColor(int color) {
        Arrays.fill(_pixels, color);
    }

    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                _pixels[x + y * SIZE] = _sheet._pixels[(x + _x) + (y + _y) * _sheet.SIZE];
            }
        }
    }

    public static Sprite movingSprite(Sprite[] sprites, int animate, long time) {
        return sprites[(int) ((time + 3) / 3 % animate)];
    }

    public Image getFxImage() {
        WritableImage wr = new WritableImage(SIZE, SIZE);
        PixelWriter pw = wr.getPixelWriter();
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if ( _pixels[x + y * SIZE] == TRANSPARENT_COLOR) {
                    pw.setArgb(x, y, 0);
                }
                else {
                    pw.setArgb(x, y, _pixels[x + y * SIZE]);
                }
            }
        }
        Image input = new ImageView(wr).getImage();
        return resample(input);
    }

    private Image resample(Image input) {
        final int W = (int) input.getWidth();
        final int H = (int) input.getHeight();
        final int S = 2;

        WritableImage output = new WritableImage(
                W * S,
                H * S
        );

        PixelReader reader = input.getPixelReader();
        PixelWriter writer = output.getPixelWriter();

        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                final int argb = reader.getArgb(x, y);
                for (int dy = 0; dy < S; dy++) {
                    for (int dx = 0; dx < S; dx++) {
                        writer.setArgb(x * S + dx, y * S + dy, argb);
                    }
                }
            }
        }

        return output;
    }
}
