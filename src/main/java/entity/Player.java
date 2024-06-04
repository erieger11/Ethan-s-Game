package entity;

import org.main.GamePanel;
import org.main.KeyboardHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyboardHandler keyH;

    public Player(GamePanel gp, KeyboardHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefault();
    }

    public void setDefault() {
        x = 100;
        y = 100;
        speed = 5;
    }

    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/PlayerUp1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/PlayerUp2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/PlayerDown1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/PlayerDown2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/PlayerLeft1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/PlayerLeft2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/PlayerRight1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/PlayerRight2.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.up) {
            y -= speed;
        }
        if (keyH.down) {
            y += speed;
        }
        if (keyH.left) {
            x -= speed;
        }
        if (keyH.right) {
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}
