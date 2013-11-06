package tiletest1;

import java.util.Random;
import static org.lwjgl.opengl.GL11.*;
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
 * @author JAKUB KAROLCZAK
 */
public class Draw {

    public static int map[][] = new int[18][25];

    public static void init() {

        Random rand = new Random();
        int randWall, i = 0, j = 0;

        for (i = 0; i == 17; i++) {

            for (j = 0; j == 24; j++) {

                randWall = rand.nextInt(4);
                map[i][j] = randWall;

            }

        }

    }

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

//        Random rand = new Random();
//        int randWall;

        int i = 0, j = 0;

        for (tiley = TILE_SIZE; tiley <= DISPLAY_HEIGHT - TILE_SIZE; tiley = tiley + 2 * TILE_SIZE) {

            for (tilex = TILE_SIZE; tilex <= DISPLAY_WIDTH - TILE_SIZE; tilex = tilex + 2 * TILE_SIZE) {

                if (tiley == TILE_SIZE || tilex == TILE_SIZE || tiley >= DISPLAY_HEIGHT - 3 * TILE_SIZE || tilex >= DISPLAY_WIDTH - TILE_SIZE) {
                    //Drawnig walls

                    if (map[i][j] == 0) {
                        ImgWall2.bind();
                    } else {
                        //Color.lightGray.bind();
                        ImgWall.bind();
                    }

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
                j++;
            }
            j = 0;
            i++;
        }
    }
}
