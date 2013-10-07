package tiletest1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import org.newdawn.slick.opengl.Texture;
import static tiletest1.Main.*;
import static tiletest1.Resources.*;
/**
 *
 * @author JAKUB KAROLCZAK
 */
public class Character {

    String name;
    float x, y;
    float size;
    Texture texture;

    public Character(String name, float x, float y, float size, Texture texture) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.size = size;
        this.texture = texture;
    }

    public void init() {
        //Creating Hero
        Character Hero = new Character("Hero", charx, chary, CHARACTER_SIZE, ImgHero);
    }
}
