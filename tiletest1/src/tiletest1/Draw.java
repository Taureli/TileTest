package tiletest1;

import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTexParameteri;
import static org.lwjgl.opengl.GL11.glVertex2f;
//import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.Color;
import static tiletest1.Main.*;
import static tiletest1.Resources.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kuba
 */
public class Draw {

    //Generating map tiles
    public static float tilex = 0, tiley = 0;
    //Character position
    public static float charx = 400, chary = 300;

    public static void drawBackground() {
        //Color.black.bind();

        glBegin(GL_QUADS);
        glVertex2f(0 - DISPLAY_WIDTH, 0 - DISPLAY_HEIGHT);
        glVertex2f(0 + DISPLAY_WIDTH, 0 - DISPLAY_HEIGHT);
        glVertex2f(0 + DISPLAY_WIDTH, 0 + DISPLAY_HEIGHT);
        glVertex2f(0 - DISPLAY_WIDTH, 0 + DISPLAY_HEIGHT);
        glEnd();
    }

    //Rendering OpenGL
    public static void drawHero() {
        // Clear the screen and depth buffer
        //glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        ImgHero.bind();
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);

        glBegin(GL_QUADS);
        glTexCoord2f(0, 1);
        glVertex2f(charx - CHARACTER_SIZE, chary - CHARACTER_SIZE);
        glTexCoord2f(1, 1);
        glVertex2f(charx + CHARACTER_SIZE, chary - CHARACTER_SIZE);
        glTexCoord2f(1, 0);
        glVertex2f(charx + CHARACTER_SIZE, chary + CHARACTER_SIZE);
        glTexCoord2f(0, 0);
        glVertex2f(charx - CHARACTER_SIZE, chary + CHARACTER_SIZE);
        glEnd();
    }

    public static void drawMap() {

        for (tiley = TILE_SIZE; tiley <= DISPLAY_HEIGHT - TILE_SIZE; tiley = tiley + 2 * TILE_SIZE) {

            for (tilex = TILE_SIZE; tilex <= DISPLAY_WIDTH - TILE_SIZE; tilex = tilex + 2 * TILE_SIZE) {

                if (tiley == TILE_SIZE || tilex == TILE_SIZE || tiley >= DISPLAY_HEIGHT - 3 * TILE_SIZE || tilex >= DISPLAY_WIDTH - TILE_SIZE) {
                    //Drawnig walls

                    //Color.lightGray.bind();
                    ImgWall.bind();
                    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
                    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);

                    glBegin(GL_QUADS);
                    glTexCoord2f(0, 1);
                    glVertex2f(tilex - TILE_SIZE, tiley - TILE_SIZE);
                    glTexCoord2f(1, 1);
                    glVertex2f(tilex + TILE_SIZE, tiley - TILE_SIZE);
                    glTexCoord2f(1, 0);
                    glVertex2f(tilex + TILE_SIZE, tiley + TILE_SIZE);
                    glTexCoord2f(0, 0);
                    glVertex2f(tilex - TILE_SIZE, tiley + TILE_SIZE);
                    glEnd();
                } else {

                    ImgDirt.bind();
                    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
                    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);

                    glBegin(GL_QUADS);
                    glTexCoord2f(0, 1);
                    glVertex2f(tilex - TILE_SIZE, tiley - TILE_SIZE);
                    glTexCoord2f(1, 1);
                    glVertex2f(tilex + TILE_SIZE, tiley - TILE_SIZE);
                    glTexCoord2f(1, 0);
                    glVertex2f(tilex + TILE_SIZE, tiley + TILE_SIZE);
                    glTexCoord2f(0, 0);
                    glVertex2f(tilex - TILE_SIZE, tiley + TILE_SIZE);
                    glEnd();
                }
            }
        }
    }
}
