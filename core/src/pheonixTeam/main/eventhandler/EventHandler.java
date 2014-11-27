package pheonixTeam.main.eventhandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import pheonixTeam.main.util.ReflectionUtil;

import java.util.ArrayList;

/**
 * @author Strikingwolf, chbachman
 */
public class EventHandler
{
    public static ArrayList<Object> leftListeners = new ArrayList<Object>();
    public static ArrayList<Object> damgageListeners = new ArrayList<Object>();
    public static ArrayList<Object> numListeners = new ArrayList<Object>();

    public static void leftClick() {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            ReflectionUtil.runMethodsFromObjects(leftListeners, "leftClick");
        }
    }

    public static void onDamage() {
        ReflectionUtil.runMethodsFromObjects(damgageListeners, "onDamage");
    }

    public static void numPressed(int num) {
        if (num != -1) {
            ReflectionUtil.runMethodsFromObjects(numListeners, "onNumPressed", num);
        }
    }
}
