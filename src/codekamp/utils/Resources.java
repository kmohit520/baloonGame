package codekamp.utils;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.IOException;

/**
 * Created by cerebro on 28/06/17.
 */
public class Resources {
    public static Image ballonImage;
    public static Image bombImage;
    public static Image boomImage;


    public static AudioClip hitAudio;


    public static void load() {
        try {
            Resources.ballonImage = ImageIO.read(Resources.class.getResource("../resources/ballon.png"));
            Resources.bombImage = ImageIO.read(Resources.class.getResource("../resources/bomb.png"));
            Resources.boomImage = ImageIO.read(Resources.class.getResource("../resources/boom.png"));

            Resources.hitAudio = Applet.newAudioClip(Resources.class.getResource("../resources/hit.wav"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
