/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiletest1;

import java.util.Random;
import static tiletest1.Draw.map;
import static tiletest1.Main.TILE_SIZE;
import static tiletest1.Resources.*;

/**
 *
 * @author Jakub
 */
public class MapGen {

    public static Tile map2[][] = new Tile[18][25];
    
    public static Tile Wall;
    public static Tile MossyWall;
    public static Tile Dirt;

    public static void init() {

        //Creatinng tiles
        Wall = new Tile(TILE_SIZE, ImgWall, false);
        MossyWall = new Tile(TILE_SIZE, ImgWall2, false);
        Dirt = new Tile(TILE_SIZE, ImgDirt, true);

    }

    public static void Generate() {

        Random rand = new Random();
        int randWall, i, j;

        for (i = 0; i <= 17; i++) {
            for (j = 0; j <= 24; j++) {

                randWall = rand.nextInt(2);

                switch(randWall){
                    case 0: 
                        map2[i][j] = Wall;
                        break;
                    case 1:
                        map2[i][j] = MossyWall;
                        break;
                    case 2:
                        map2[i][j] = Dirt;
                        break;
                }

            }
        }

    }

}
