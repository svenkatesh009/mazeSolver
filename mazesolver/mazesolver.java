import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;


public class mazesolver extends JFrame{
private int [][] maze={ {1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,0,1,0,1,0,1,0,0,0,0,0,1},
                        {1,0,1,0,0,0,1,0,1,1,1,0,1},
                        {1,0,1,1,1,1,1,0,0,0,0,0,1},
                        {1,0,0,1,0,0,0,0,1,1,1,0,1},
                        {1,0,1,0,1,1,1,0,0,0,1,0,1},
                        {1,0,1,0,1,0,0,0,1,1,1,0,1},
                        {1,0,1,0,1,1,1,0,1,0,1,0,1},
                        {1,0,0,0,0,0,0,0,0,0,1,9,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1},
                       };

public List<Integer> path = new ArrayList<>();
public List<Integer> ans = new ArrayList<>();

public mazesolver(){
    setTitle("Maze Solver");
    setSize(640,480);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(rootPaneCheckingEnabled);
    dfs way=new dfs();
    path.add(1);
    path.add(1);
    way.pathfinder(maze, 1, 1, path, ans);
    System.out.println(ans);
}
@Override
public void paint (Graphics g){
    g.translate(75,75);
    // maze construction
    for(int i=0;i<maze.length;i++){
        for(int j=0;j<maze[0].length;j++){
            Color color;
            switch(maze[i][j]){
                case 1 : color=Color.BLACK;break;
                case 9 : color=Color.RED;break;
                default:color=Color.LIGHT_GRAY;
            }
            g.setColor(color);
            g.fillRect(30*j, 30*i, 30, 30);
            g.setColor(Color.RED);
            g.drawRect(30*j, 30*i, 30, 30);
        }

    }
    // maze escape path
    for(int i=0;i<ans.size();i+=2){
        int r=ans.get(i);
        int c=ans.get(i+1);
        g.setColor(Color.YELLOW);
        g.fillRect(30*c, 30*r, 30, 30); 
    }

}
public static void main(String[] args) {  
    mazesolver obj=new mazesolver();
    obj.setVisible(true); 
}  
}