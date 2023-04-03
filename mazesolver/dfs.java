import java.util.ArrayList;
import java.util.List;

public class dfs {
    public int [][]dir={{0,1},{0,-1},{1,0},{-1,0}};
    public void pathfinder(int [][] maze,int x,int y,List<Integer> path,List<Integer> ans ){
        if(maze[x][y]==1 || maze[x][y]==2) return;
        if(maze[x][y]==9){
            path.add(x);
            path.add(y);
            if(ans.size()==0){
                for(int i=0;i<path.size();i++){
                    ans.add(path.get(i));
                }
            }
            else if(ans.size()>path.size()){
                while(ans.size()!=0) ans.remove(ans.size()-1);
                for(int i=0;i<path.size();i++){
                    ans.add(path.get(i));
                }
            }
            path.remove(path.size()-1);
            path.remove(path.size()-1);
            return;
        }
        if(maze[x][y]==0){
            maze[x][y]=2;
            for(int i=0;i<dir.length;i++){
            int r=dir[i][0];
            int c=dir[i][1];
            path.add(x+r);
            path.add(y+c);
            pathfinder(maze, x+r, y+c, path, ans);
            path.remove(path.size()-1);
            path.remove(path.size()-1);
            }
            maze[x][y]=0;
        }
        return;
    }
}
