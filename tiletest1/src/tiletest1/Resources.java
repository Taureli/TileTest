package tiletest1;

import java.io.IOException;
import java.awt.Font;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kuba
 */
public class Resources {

    //Textures
    static Texture ImgWall;     //Walls
    static Texture ImgDirt;     //Dirt floor
    static Texture ImgHero;     //Hero (static - no animations)
    //Audio
    static Audio SndStep;       //Walking sound
    //Fonts
    static TrueTypeFont DefFont;        //Default font

    //------------------INITIALISING RESOURCES-------------------------
    public static void init() {
        try {
            //--------------------Loading textures--------------------------
            ImgWall = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/wall.png"));

            System.out.println("Texture loaded: " + ImgWall);
            System.out.println(">> Image width: " + ImgWall.getImageWidth());
            System.out.println(">> Image height: " + ImgWall.getImageHeight());
            System.out.println(">> Texture width: " + ImgWall.getTextureWidth());
            System.out.println(">> Texture height: " + ImgWall.getTextureHeight());
            System.out.println(">> Texture ID: " + ImgWall.getTextureID());

            ImgDirt = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/dirt.png"));

            System.out.println("Texture loaded: " + ImgDirt);
            System.out.println(">> Image width: " + ImgDirt.getImageWidth());
            System.out.println(">> Image height: " + ImgDirt.getImageHeight());
            System.out.println(">> Texture width: " + ImgDirt.getTextureWidth());
            System.out.println(">> Texture height: " + ImgDirt.getTextureHeight());
            System.out.println(">> Texture ID: " + ImgDirt.getTextureID());

            ImgHero = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/hero.png"));

            System.out.println("Texture loaded: " + ImgHero);
            System.out.println(">> Image width: " + ImgHero.getImageWidth());
            System.out.println(">> Image height: " + ImgHero.getImageHeight());
            System.out.println(">> Texture width: " + ImgHero.getTextureWidth());
            System.out.println(">> Texture height: " + ImgHero.getTextureHeight());
            System.out.println(">> Texture ID: " + ImgHero.getTextureID());
            //-------------------------------------------------------
            
            //--------------------Loading sounds---------------------
            SndStep = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/step.wav"));
            //------------------------------------------------------
            
            //------------------Loading fonts-----------------------
            //default java font
            Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
            DefFont = new TrueTypeFont (awtFont, false);
            //------------------------------------------------------
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //-----------------------------------------------------------------
}
