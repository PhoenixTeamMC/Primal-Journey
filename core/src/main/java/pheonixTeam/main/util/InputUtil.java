package pheonixTeam.main.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * @author Strikingwolf, chbachman
 */
public class InputUtil
{
    public static int getNumPressed() {
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_0)) {
            return 0;
        } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)) {
            return 1;
        } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_2)) {
            return 2;
        } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_3)) {
            return 3;
        } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_4)) {
            return 4;
        } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_5)) {
            return 5;
        } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_6)) {
            return 6;
        } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_7)) {
            return 7;
        } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_8)) {
            return 8;
        } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_9)) {
            return 9;
        } else {
            return -1;
        }
    }
}
