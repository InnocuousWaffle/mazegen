package levelgen;
import java.util.Scanner;
import java.util.Random;

public class LevelGen {
    public block [][] level;
    public Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
       LevelGen fish = new LevelGen();
       for(int i=0;i<100;i++){
       fish.fillaray();
       fish.makeBox();
       fish.CallsMazeMake();
       fish.showLevel();
       fish.empty();
       System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
       }
    }
    
    public void empty(){
        level=null;
        System.out.print("One ideration has compleatd");
    }
    public void makeBox(){
        
        for(int x=level.length - 1;x>=0;x--){            
                   
            level[x][0]=new block(1);
            level[x][level[x].length-1]=new block(1);
           
        }
        for(int x=level[0].length - 1;x>=0;x--){            
                   
            level[0][x]=new block(1);
            level[level.length-1][x]=new block(1);           
        }
        
        System.out.println();
        System.out.println("box made");

        
    }
    public void fillaray(){
        
        level = new block [(int)(Math.random()*60+10)][(int)(Math.random()*60+10)];
       //level=new block [60][50];
        
        System.out.println(level.length);
        System.out.println(level[0].length);
        for(int x=level.length - 1;x>=0;x--)
        {             
            for(int y=level[x].length - 1;y>=0;y--)
            {
               
                level[x][y]=new block(0);
            }
        }
        
    }
    public void showLevel(){
        
        System.out.println();
        System.out.println();
        
                
        for(int x=level.length - 1;x>=0;x--)
        {
            for(int y=level[x].length - 1;y>=0;y--)
            {
                if(level[x][y].isSolid())
                    System.out.print("#");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        return;
    }
    public void CallsMazeMake(){
        mazemake(0, 0, level.length, level[0].length);
    }
    
    public void mazemake(int a,int b,int x, int y){
        if((x-a<4)||(y-b<4)){   
        return;
        }           
        System.out.println("maze code activated");
        int wall = (int)(Math.random()*((x-2)-(a+2))+(a+2));
        int floor = (int)(Math.random()*((y-2)-(b+2))+(b+2));
        
        System.out.print(wall);
        System.out.print("<=wall | floor=> ");
        System.out.println(floor);        
        System.out.print(a);
        System.out.print(" <= a | b => ");
        System.out.println(b);
        System.out.print(x);
        System.out.print(" <= x | y=>");
        System.out.println(y);
        showLevel();
        level[wall][floor]=new block(1);
        
        for(int part = a ; part<x ; part++){
            //System.out.println(part);
            level[part][floor]=new block(1);
        }
        for(int part = b ; part<y ; part++){
            level[wall][part]=new block(1);
        }
        mazemake(0,0,wall,floor);
        System.out.println("stage one completed");
        //showLevel();
       mazemake(wall,floor,level.length,level[wall].length);
        return;
    }
}
    



    
    
    

