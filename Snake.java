import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Snake implements ActionListener , KeyListener{

    public JFrame sframe;
    public Smodel smodel;
    //public Toolkit tool;
    public static Snake snake;
    public Timer timer;  // = new Timer(1000/60, this);

    public int count = 0;
    // snake
    public Point s_head;
    public int dir;
    //array
    public ArrayList<Point> s_array;
    // range for one point
    public int range = 20;
    // direction
    public static final int up = 1;
    public static final int down = 2;
    public static final int left = 3;
    public static final int right = 4;
    // for key code
    public int key;
    // for game
    public int died;
    // apple
    public Point apple;
    Random ran = new Random();
    int fine;
    // score
    public int score;
    public int fps;
    public int speed;
    public int pause;
    // change
    public int change;

    public int reverse;

    public Snake(int f, int s) {
        fps = f;
        speed = s;

        start();

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        sframe = new JFrame("Snake Game");
        sframe.setVisible(true);
        sframe.setSize(800,600);
        sframe.addKeyListener(this);
        sframe.setLocation(d.width / 2 - sframe.getWidth() / 2,
                d.height / 2 - sframe.getHeight() / 2);
        sframe.add(smodel = new Smodel());
        sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer.start();
    }

    void start(){
        dir = right;
        s_array = new ArrayList<Point>();
        s_head = new Point(4, 0);
        s_array.add(new Point(0, 0));
        s_array.add(new Point(1, 0));
        s_array.add(new Point(2, 0));
        s_array.add(new Point(3, 0));
        s_array.add(s_head);
        died = 0;
        pause = 0;
        apple = new Point(ran.nextInt(29), ran.nextInt(28));
        score = 0;
        change = 0;
        timer = new Timer(1000/fps, this);
        reverse = 0;
    }

    public static void main(String[] args) {

        if (args.length == 0){
            snake = new Snake(60, 7);
        }
        else if(args.length == 2){
            int a1 = Integer.parseInt(args[0]);
            int a2 = Integer.parseInt(args[1]);
            if (a1 <= 100 && a1 > 0 && a2 <= 10 && a2 >= 1){
                snake = new Snake(a1, a2);
            }
            else{
                System.out.println("invalid input");
            }
        }
        else {
            System.out.println("invalid input");
        }

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        smodel.repaint();
        count++;
        //System.out.println(count);
        if (pause == 1) return;
        if (died == 1) {
            change = 1;
            return;
        }
        if (count % (fps / speed + 1) == 0){
            if (s_head.x == 0 && dir == left){
                died = 1;
                change = 1;
                return;
            }
            if (s_head.y == 0 && dir == up){
                died = 1;
                change = 1;
                return;
            }
            if (s_head.x == 29 && dir == right){
                died = 1;
                change = 1;
                return;
            }
            if (s_head.y == 28 && dir == down){
                died = 1;
                change = 1;
                return;
            }
            for (int i = 0; i < s_array.size() - 1; i++){
                if (s_head.x == s_array.get(i).x && s_head.y == s_array.get(i).y) {
                    died = 1;
                    change = 1;
                    return;
                }
            }


            // moving process
            if (dir == up){
                s_head = new Point(s_head.x, s_head.y - 1);
                snake.s_array.add(s_head);
            }
            if (dir == down){
                s_head = new Point(s_head.x, s_head.y + 1);
                snake.s_array.add(s_head);
            }
            if (dir == left){
                s_head = new Point(s_head.x - 1, s_head.y);
                snake.s_array.add(s_head);
            }
            if (dir == right){
                s_head = new Point(s_head.x + 1, s_head.y);
                snake.s_array.add(s_head);
            }


            change = 0;
            // check eat
            if (s_head.x == apple.x && s_head.y == apple.y){
                score++;
                while (true){
                    apple = new Point(ran.nextInt(29), ran.nextInt(28));
                    for (Point p : s_array){
                        if (apple.x == p.x && apple.y == p.y) {
                            fine = 0;
                            break;
                        }
                        else fine = 1;
                    }
                    if (fine == 1) break;
                }
                if (reverse == 0 && ran.nextInt(100) > 80){
                    reverse = 1;
                }
                else{
                    reverse = 0;
                }

            }
            else {
                s_array.remove(0);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();

        if (reverse == 0){
            if (key == KeyEvent.VK_LEFT && dir != right && pause == 0 && change == 0){
                dir = left;
                change = 1;
            }
            else if (key == KeyEvent.VK_DOWN && dir != up && pause == 0 && change == 0){
                dir = down;
                change = 1;
            }
            else if (key == KeyEvent.VK_RIGHT && dir != left && pause == 0 && change == 0){
                dir = right;
                change = 1;
            }
            else if (key == KeyEvent.VK_UP && dir != down && pause == 0 && change == 0){
                dir = up;
                change = 1;
            }
        }

        else{

            if (key == KeyEvent.VK_RIGHT && dir != right && pause == 0 && change == 0){
                dir = left;
                change = 1;
            }
            else if (key == KeyEvent.VK_UP && dir != up && pause == 0 && change == 0){
                dir = down;
                change = 1;
            }
            else if (key == KeyEvent.VK_LEFT && dir != left && pause == 0 && change == 0){
                dir = right;
                change = 1;
            }
            else if (key == KeyEvent.VK_DOWN && dir != down && pause == 0 && change == 0){
                dir = up;
                change = 1;
            }

        }


        if (key == KeyEvent.VK_SPACE && pause == 0){
            pause = 1;
            //System.out.println("in P");
            //System.out.println(pause);
        }
        else if (key == KeyEvent.VK_SPACE && pause == 1){
            pause = 0;
        }
        else if (key == KeyEvent.VK_R){
            start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
