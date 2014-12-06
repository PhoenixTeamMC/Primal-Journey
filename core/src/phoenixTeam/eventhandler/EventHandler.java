package phoenixTeam.eventhandler;

import java.util.ArrayList;

import phoenixTeam.util.ReflectionUtil;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * @author Strikingwolf, chbachman
 */
@Deprecated
public class EventHandler
{
    public static ArrayList<Object> leftListeners = new ArrayList<Object>();
    public static ArrayList<Object> damgageListeners = new ArrayList<Object>();
    public static ArrayList<Object> numListeners = new ArrayList<Object>();
    
    @Deprecated
    public static void leftClick() {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            ReflectionUtil.runMethodsFromObjects(leftListeners, "leftClick");
        }
    }
    
    @Deprecated
    public static void onDamage() {
        ReflectionUtil.runMethodsFromObjects(damgageListeners, "onDamage");
    }

    @Deprecated
    public static void numPressed(int num) {
        if (num != -1) {
            ReflectionUtil.runMethodsFromObjects(numListeners, "onNumPressed", num);
        }
    }
}
