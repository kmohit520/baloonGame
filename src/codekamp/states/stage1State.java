package codekamp.states;

import codekamp.Game;
import codekamp.GamePanel;
import codekamp.entities.Ballon;
import codekamp.entities.Bomb;
import codekamp.entities.Entity;
import codekamp.utils.RandomGenerator;
import codekamp.utils.Resources;

import java.awt.*;
import java.sql.*;
import java.util.*;

/**
 * Created by mohit on 7/1/2017.
 */
public class stage1State extends State {
    public static final String JDBC_CLASS = "org.sqlite.JDBC";
    public static final String DATABASE_PATH = "jdbc:sqlite:src/codekamp/mydb.sqlite";

    private static final Color SKY_BLUE_COLOR = new Color(161, 204, 255);
    public int SCORE = 0;
    public int PASSED = 0;
    public static final Font MY_FONT = new Font("Areal", Font.BOLD, 15);


    private java.util.List<Ballon> ballon = new ArrayList<>();
    private java.util.List<Bomb> bomb = new ArrayList<>();

    public stage1State() {

        ballon.add(new Ballon(RandomGenerator.randomInt(0, 200), 600));
        ballon.add(new Ballon(RandomGenerator.randomInt(0, 200), 800));
        ballon.add(new Ballon(RandomGenerator.randomInt(0, 200), 1000));
        ballon.add(new Ballon(RandomGenerator.randomInt(0, 200), 1200));
        ballon.add(new Ballon(RandomGenerator.randomInt(0, 200), 1400));

        bomb.add(new Bomb(RandomGenerator.randomInt(0, 200), 500));
        bomb.add(new Bomb(RandomGenerator.randomInt(0, 200), 300));
        bomb.add(new Bomb(RandomGenerator.randomInt(0, 200), 100));


        entities.addAll(ballon);
        entities.addAll(bomb);

    }

    public void update() {
        super.update();

        for (Ballon b : ballon) {
            if (b.y < -128) {
                if (b.visible == true) {
                    PASSED++;
                }

                b.y = 872;

                b.x = RandomGenerator.randomInt(0, 200);

                b.visible = true;
            }
            for (Bomb c : bomb) {
                if (c.y < -128) {
                    c.y = 872;
                    c.x = RandomGenerator.randomInt(0, 200);

                }

            }
        }
        if (PASSED == 10) {
            GamePanel.currentState = new GameoverState();

        }
    }

    public void onClick(int x, int y) {

        for (Ballon b : ballon) {
            if (x >= b.x && x <= (b.x + 128) && y >= b.y && y <= (b.y + 128) && (b.visible == true)) {
                SCORE++;
                Resources.hitAudio.play();
                b.visible = false;
            }
        }
        for (Bomb c : bomb) {
            if (x >= c.x && x <= (c.x + 128) && y >= c.y && y <= (c.y + 128) && (c.visible == true)) {
              this.db();
                GamePanel.currentState = new GameoverState();
                GamePanel.currentState.SCORE = this.SCORE;
            }

        }
    }


    public void render(Graphics a) {

        a.setColor(SKY_BLUE_COLOR);
        a.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        for (Entity e : entities) {
            if (e.visible) {
                a.drawImage(e.getImage(), e.x, e.y, null);
            }
        }
        a.setColor(Color.BLACK);

        a.drawString("Score " + SCORE, 10, 20);
        a.drawString("Ballon passed  " + PASSED, 10, 30);
    }

    public void db() {
        int n = this.SCORE;
        try {
            Class.forName(JDBC_CLASS);
        } catch (ClassNotFoundException e) {
            System.out.println("Please use JDBC");
        }


        try {
            Connection c = DriverManager.getConnection(DATABASE_PATH);
            Statement s = c.createStatement();
          s.execute("INSERT INTO `Score`(`Score`) VALUES (5);");

//            s.execute("INSERT INTO `students`(`name`,`email`,`age`) VALUES ('Ramesh','rameshsingh@gmail.com',55);");
            //s.execute("INSERT INTO `students`(`name`,`email`,`age`) VALUES ('MOhit','kmohit20@gmail.com',20);");
          //  ResultSet r = s.executeQuery("SELECT * FROM `students` ");


        } catch (SQLException e) {
            System.out.println("Catch code running");
            System.out.println(e.getMessage());
        }
    }
}

