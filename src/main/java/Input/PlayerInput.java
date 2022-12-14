package Input;

import Constants.Constants;

import java.util.Set;

import static Constants.Constants.DIRECTION.*;

public class PlayerInput implements KeyInput {

    public void initialization() {
        keyInput.put("A", false);
        keyInput.put("D", false);
        keyInput.put("W", false);
        keyInput.put("S", false);
        keyInput.put("SPACE", false);
    }

    @Override
    public Constants.DIRECTION handleKeyInput() {
        Set<String> keySet = keyInput.keySet();
        for (String code : keySet) {
            if (keyInput.get(code)) {
                switch (code) {
                    case ("SPACE"):
                        keyInput.put("SPACE",false);
                        return PLACE_BOMB;
                    case ("W"):
                        return UP;
                    case ("D"):
                        return RIGHT;
                    case ("S"):
                        return DOWN;
                    case ("A"):
                        return LEFT;
                }
            }
        }
        return NONE;
    }
}
