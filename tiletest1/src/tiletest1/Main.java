package tiletest1;

import java.io.IOException;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.openal.AL;
import org.newdawn.slick.Color;
import org.newdawn.slick.openal.SoundStore;


//AUTHOR: JAKUB KAROLCZAK
public class Main {

    
    //Generating map tiles
    public static float tilex = 0, tiley = 0;
    //Character position
    public static float charx = 400, chary = 300;
    //
    public static final int DISPLAY_WIDTH = 800;
    public static final int DISPLAY_HEIGHT = 600;
    public static final int CHARACTER_SIZE = 16;
    public static final int TILE_SIZE = 16;
    //Character speed
    public static float charSpeed = 0.14f;
    //FPS
    long lastFrame; //time at last frame
    int fps;
    long lastFPS;
    public static int delta;

    //----------------------------START----------------------------
    public void start() {
        try {
            Display.setDisplayMode(new DisplayMode(DISPLAY_WIDTH, DISPLAY_HEIGHT));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        Resources.init();   //Loading resources

        initGL(); // init OpenGL here
        getDelta(); //called before to initialise lastFrame
        lastFPS = getTime();
        
        Draw.init();    //Preparing map etc.
        
        //Constant loop till exit
        while (!Display.isCloseRequested()) {

            //Draw.drawBackground();
            Draw.drawMap();
            Draw.drawHero();  // render OpenGL here

            Display.update();
            
            Display.sync(60); //FPS cap
            delta = getDelta();
            update(delta);
        }

        Display.destroy();
        AL.destroy();
        System.exit(0);
    }
    //------------------------------------------------------------------

    //-----------------------------UPDATING-----------------------------
    public void update(int delta) {

        Controls.Walk();

        // polling is required to allow streaming to get a chance to
        // queue buffers.
        SoundStore.get().poll(0);

        updateFPS();    //FPS counter
    }
    //------------------------------------------------------------------

    //----------------------FRAMES PER SECOND---------------------------
    //Calculating milliseconds since last frame
    public int getDelta() {
        long time = getTime();
        delta = (int) (time - lastFrame);
        lastFrame = time;

        return delta;   //returns milliseconds
    }

    //Getting system time in milliseconds
    public long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    //Calculating FPS
    public void updateFPS() {
        if (getTime() - lastFPS > 1000) {
            Display.setTitle("Tile Test | FPS: " + fps);
            //System.out.println("FPS: " + fps);
            //Resources.DefFont.drawString(100, 50, "FPS: " + fps, Color.white);
            fps = 0;
            lastFPS += 100;
        }
        fps++;
    }
    //-----------------------------------------------------------------

    //-------------------OpenGL initialization-------------------------
    public void initGL() {
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 800, 0, 600, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        Display.setVSyncEnabled(true);
    }
    //-----------------------------------------------------------------

    //------------------------------MAIN-------------------------------
    public static void main(String[] argv) {
        Main TileTest = new Main();
        TileTest.start();
    }
    //-----------------------------------------------------------------
}
