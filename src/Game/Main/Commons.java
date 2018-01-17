package Game.Main;

public interface Commons {

    public static int GameAreaWidth = 800;
    public static int GameAreaHeight = 500;
    public static int LooseBallEdge = 490;  /*10 above the bottom*/
    public static int PaddleInitialX = 375; /*paddle width 50*/
    public static int PaddleInitialY = 470; /*paddle height 10*/
    public static int BallInitialX = 395;   /*ball radius 5*/
    public static int BallInitialY = 465;   /*ball radius 5 -> stick to paddle*/
    public static int BlockAmount = 120;    /*block is 20 width and 10 height -> number of blocks = 3 rows of 40 blocks or 4 rows of 30 blocks*/
    public static int Delay = 1000;         /*for timer [ms]*/
    public static int Period = 10;          /*for timer [ms]*/
}
