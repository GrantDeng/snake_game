


import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;

@SuppressWarnings("serial")
public class Smodel extends JPanel {



    @Override
    protected void paintComponent(Graphics g) {
        Snake s = Snake.snake;
        super.paintComponent(g);
        g.setColor(Color.white);


        //cur++;

        if (s.reverse == 1){
            g.setColor(Color.orange);
        }

        if (s.died == 1){
            g.setColor(Color.red);
        }
        g.fillRect(0,0,600,600);

        if (s.reverse == 1 && s.died == 0){
            g.setColor(Color.magenta);
            g.setFont(new Font("Arial", Font.PLAIN, 40));
            g.drawString("REVERSE MODE!!!", 180, 290);
        }
        g.setColor(Color.lightGray);
        g.fillRect(600,0,200,600);

        for (Point p : s.s_array){
            //System.out.println(p.x);
            //System.out.println(p.y);
            g.setColor(Color.green);
            g.fillRect(p.x * s.range, p.y * s.range, s.range, s.range);
            g.setColor(Color.black);
            g.fillRect(p.x * s.range, p.y * s.range, s.range, 3);
            g.fillRect(p.x * s.range, p.y * s.range, 3, s.range);
            g.fillRect(p.x * s.range + 17, p.y * s.range, 3, s.range);
            g.fillRect(p.x * s.range, p.y * s.range + 17, s.range, 3);
        }  
        g.setColor(Color.black);
        g.fillRect(s.s_head.x * s.range, s.s_head.y * s.range, s.range, s.range);
        g.setColor(Color.WHITE);
        if (s.dir == s.right) {
            g.fillRect(s.s_head.x * s.range + 13, s.s_head.y * s.range + 3, 4, 4);
            g.fillRect(s.s_head.x * s.range + 13, s.s_head.y * s.range + 13, 4, 4);
        }
        if (s.dir == s.left) {
            g.fillRect(s.s_head.x * s.range + 3, s.s_head.y * s.range + 3, 4, 4);
            g.fillRect(s.s_head.x * s.range + 3, s.s_head.y * s.range + 13, 4, 4);
        }
        if (s.dir == s.up) {
            g.fillRect(s.s_head.x * s.range + 3, s.s_head.y * s.range + 3, 4, 4);
            g.fillRect(s.s_head.x * s.range + 13, s.s_head.y * s.range + 3, 4, 4);
        }
        if (s.dir == s.down) {
            g.fillRect(s.s_head.x * s.range + 3, s.s_head.y * s.range + 13, 4, 4);
            g.fillRect(s.s_head.x * s.range + 13, s.s_head.y * s.range + 13, 4, 4);
        }


        g.setColor(Color.blue);
        g.fillRect(s.apple.x * s.range, s.apple.y * s.range, s.range, s.range);
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString("SNAKE GAME", 620, 40);
        g.drawString("score: ", 620, 150);
        g.drawString(Integer.toString(s.score), 710, 150);
        g.drawString("fps: ", 620, 170);
        g.drawString(Integer.toString(s.fps), 710, 170);
        g.drawString("speed: ", 620, 190);
        g.drawString(Integer.toString(s.speed), 710, 190);

        g.setFont(new Font("Arial", Font.PLAIN, 15));
        g.drawString("MOVE: ARROW KEYS", 630, 450);
        g.drawString("PAUSE: SPACE", 630, 470);
        g.drawString("RESTART: R", 630, 490);
        if (s.pause == 1) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.PLAIN, 40));
            g.drawString("PAUSE", 250, 290);
        }
        if (s.died == 1) {
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 40));
            g.drawString("GAME OVER", 200, 290);
        }


        //System.out.println("print");
        //super.paintComponent(g);
    }


}
