 import java.util.Scanner;
 import java.util.Random;
 public class App{
    
    public static class Board{
       private char[][] board= new char[3][3];


       public Board(){
        board[0][0]=' ';
        board[0][1]=' ';
        board[0][2]=' ';
        board[1][2]=' ';
        board[1][1]=' ';
        board[1][0]=' ';
        board[2][0]=' ';
        board[2][1]=' ';
        board[2][2]=' ';
       }

       public void player1turn(int a,int b)
       {
        if(a<=2&&b<=2&&board[a][b]!='O'&&board[a][b]!='X')
        {
            board[a][b]='X';
        }
        else
        {
            System.out.println("Invalid move");
        System.out.println("Player1:");
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextInt();
        player1turn(a, b);
        }
       }


       public void player2turn(int a,int b)
       {
        if(a<=2&&b<=2&&board[a][b]!='O'&&board[a][b]!='X')
        {
            board[a][b]='O';
        }
        else
        {
            System.out.println("Invalid move");
            int y,z;
        System.out.println("Player2:");
        Scanner sc3=new Scanner(System.in);
        y=sc3.nextInt();
        z=sc3.nextInt();
        player2turn(y, z);
        }
       }


       public void computerturn()
       {
        Random cm=new Random();
        int x= cm.nextInt(3);
        int y =cm.nextInt(3);
        while(board[x][y]!=' ')
        {
            x= cm.nextInt(3);
            y =cm.nextInt(3);
        }
        board[x][y]='O';
        /*
        int flag=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]!='X'&&board[i][j]!='O')
                {
                    board[i][j]='O';
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            break;
        }*/

       }
       public boolean checkwinner()
       {
        for(int i=0;i<3;i++)
        {
            if(board[i][0]==board[i][1]&&board[i][0]==board[i][2])
            {
                if(board[i][0]=='X')
                {
                    System.out.println("X wins");
                    return true;
                }
                else if(board[i][0]=='O')
                {
                    System.out.println("O wins");
                    return true;
                }
                
            }
        }
        for(int i=0;i<3;i++)
        {
            if(board[0][i]==board[1][i]&&board[0][i]==board[2][i])
            {
                if(board[0][i]=='X')
                {
                    System.out.println("X wins");
                    return true;
                }
                else if(board[0][i]=='O')
                {
                    System.out.println("O wins");
                    return true;
                }
               
            }
        }
        if(board[0][0]==board[1][1]&&board[0][0]==board[2][2])
        {
            if(board[0][0]=='X')
                {
                    System.out.println("X wins");
                    return true;
                }
                else if(board[0][0]=='O')
                {
                    System.out.println("O wins");
                    return true;
                }
                
        }
        if(board[0][2]==board[1][1]&&board[1][1]==board[2][0])
        {
            if(board[1][1]=='X')
                {
                    System.out.println("X wins");
                    return true;
                }
                else if(board[1][1]=='O')
                {
                    System.out.println("O wins");
                    return true;
                }
                
        }
        int flag=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]=='X'||board[i][j]=='O')
                {
                    flag=1;
                }
                else
                {
                    flag=0;
                    break;
                }
            }
            if(flag==0)
            break;
        }
        if(flag==1)
        {
            System.out.println("Draw");
        }
        return false;
       }
       public void printboard()
       {
        System.out.println(board[0][0]+"|"+board[0][1]+"|"+board[0][2]+"|");
        System.out.println("-------");
        System.out.println(board[1][0]+"|"+board[1][1]+"|"+board[1][2]+"|");
        System.out.println("-------");
        System.out.println(board[2][0]+"|"+board[2][1]+"|"+board[2][2]+"|");
        System.out.println("-------");
       }
    }
  

    public static void main(String args[])
    {
        Board b1 = new Board();
        b1.printboard();
        System.out.println("Enter 1 for player vs player and 2 for player vs computer");
        Scanner sc2 = new Scanner(System.in);
        int c=sc2.nextInt();
        int count=0;
        if(c==2)
        {
            while(b1.checkwinner()==false&&count<9)
        {
            int a,b;
        System.out.println("Enter your move");
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextInt();
        b1.player1turn(a, b);
        count++;
        if(count<9)
        {
            b1.computerturn();
        count++;
        }
        
        b1.printboard();
        
        }
        }
        else if(c==1)
        {
            while(b1.checkwinner()==false&&count<9)
        {
            int a,b;
        System.out.println("Player 1:");
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextInt();
        b1.player1turn(a, b);
        count++;
        b1.printboard();
        if(count<9)
        {
            int y,z;
        System.out.println("Player2:");
        Scanner sc3=new Scanner(System.in);
        y=sc3.nextInt();
        z=sc3.nextInt();
        b1.player2turn(y, z);
        count++;
        b1.printboard();
        }      
        }
        }
        else
        {
            System.out.println("Invalid");
        }
    }    
}