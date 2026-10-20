import java.util.Set;
import java.util.HashSet;

class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        
        int forBox1 =0, forBox2=0, forBox3=0;
        char[] first9 = new char[9];
        char[] second9 = new char[9];
        char[] third9 = new char[9];
        for (int i=0; i<9; i++){
            //check for row
            if(!checkBox(board[i]))     return false;

            //check for boxes
            if (forBox1==9) {
                forBox1=0;
                if(!checkBox(first9))   return false;
            }
            if (forBox2==9) {
                forBox2=0;
                if(!checkBox(second9))   return false;
            }
            if (forBox3==9) {
                forBox3=0;
                if(!checkBox(third9))   return false;
            }           
            char[] temp = new char[9];
            for(int j=0;j<9;j++){
                temp[j]=board[j][i];
                if(i<3){
                    if(j<3){
                        first9[forBox1]=board[i][j];
                        forBox1++;
                    }
                    if(j>2 && j<6) {
                        second9[forBox2]=board[i][j];
                        forBox2++;
                    }  
                    if(j>5 && j<9){
                        third9[forBox3]=board[i][j];
                        forBox3++;
                    }
                }
                if(i>2 && i<6){
                    if(j<3){
                        first9[forBox1]=board[i][j];
                        forBox1++;
                    }  
                    if(j>2 && j<6){
                        second9[forBox2]=board[i][j];
                        forBox2++;
                    }  
                    if(j>5 && j<9){
                        third9[forBox3]=board[i][j];
                        forBox3++;
                    }
                }               
                if(i>5 && i<9){
                    if(j<3) {
                        first9[forBox1]=board[i][j];
                        forBox1++;
                    } 
                    if(j>2 && j<6){
                        second9[forBox2]=board[i][j];
                        forBox2++;
                    }  
                    if(j>5 && j<9) {
                        third9[forBox3]=board[i][j];
                        forBox3++;
                    }     
                }
            }

            //check for col
            if(!checkBox(temp))     return false;
        }
        //check the 3 last boxes
        if(!checkBox(first9))   return false;
        if(!checkBox(second9))   return false;
        if(!checkBox(third9))   return false;
        return true;
    }

    private boolean checkBox(char[] box){
        int count=0;
        char dot = '.';
        Set<Character> set = new HashSet<>();
        for(int i=0; i<box.length;i++){
            if(box[i]!= dot){
                count++;
                set.add(box[i]);
            }
        }
        return (count==set.size());
    }    
}
