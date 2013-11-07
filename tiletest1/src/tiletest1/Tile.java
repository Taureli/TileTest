/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiletest1;

import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Jakub
 */
public class Tile {
    
    int size, x, y;
    Texture texture;
    boolean canWalk;
    
    public Tile(int size, Texture texture, boolean canWalk){
        this.size = size;
//        this.x = x;
//        this.y = y;
        this.texture = texture;
        this.canWalk = canWalk;
    } 
    
    public Texture getTexture(){
        return this.texture;
    }
    
    public int getSize(){
        return this.size;
    }
    
}
