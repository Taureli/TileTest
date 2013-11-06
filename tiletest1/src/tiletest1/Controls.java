/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiletest1;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import static tiletest1.Main.*;
import static tiletest1.Resources.*;
import tiletest1.Character.*;

/**
 *
 * @author JAKUB KAROLCZAK
 */
public class Controls {

    //------------------------WALKING------------------------
    public static void WalkSound() {
        SndStep.playAsSoundEffect(1.0f, 0.01f, false);
    }

    public static void Walk() {
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            charx -= charSpeed * delta;
            //WalkSound();
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            charx += charSpeed * delta;
           // WalkSound();
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            chary += charSpeed * delta;
          //  WalkSound();
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            chary -= charSpeed * delta;
          //  WalkSound();
        }

        //Preventing char from leaving screen
        if (charx - CHARACTER_SIZE < 0) {
            charx = CHARACTER_SIZE;
        }
        if (charx + CHARACTER_SIZE > DISPLAY_WIDTH) {
            charx = DISPLAY_WIDTH - CHARACTER_SIZE;
        }
        if (chary - CHARACTER_SIZE < 0) {
            chary = CHARACTER_SIZE;
        }
        if (chary + CHARACTER_SIZE > DISPLAY_HEIGHT) {
            chary = DISPLAY_HEIGHT - CHARACTER_SIZE;
        }

        //Removing fast speed glitch while 2 keys pressed (chodzenie pod katem)
        if ((Keyboard.isKeyDown(Keyboard.KEY_W) && Keyboard.isKeyDown(Keyboard.KEY_A)) || (Keyboard.isKeyDown(Keyboard.KEY_W) && Keyboard.isKeyDown(Keyboard.KEY_D))
                || (Keyboard.isKeyDown(Keyboard.KEY_S) && Keyboard.isKeyDown(Keyboard.KEY_A)) || (Keyboard.isKeyDown(Keyboard.KEY_S) && Keyboard.isKeyDown(Keyboard.KEY_D))) {
            charSpeed = 0.10f;
        } else {
            charSpeed = 0.14f;
        }
    }
    //---------------------------------------------------------
}
