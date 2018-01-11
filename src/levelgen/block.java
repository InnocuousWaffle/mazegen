/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levelgen;

/**
 *
 * @author Owner
 */
public class block {
    
    private int i;
    
    public block(int s){
        i = s;
    }
    
    
    public int type(){
        return i;
    }
    public boolean isSolid(){
        return (i==1);
    }
}



