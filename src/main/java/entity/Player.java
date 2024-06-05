package entity;

import org.main.GamePanel;
import org.main.KeyboardHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyboardHandler keyH;

    public Player(GamePanel gp, KeyboardHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefault();
        getPlayerImage();
    }

    public void setDefault() {
        x = 100;
        y = 100;
        speed = 5;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/PlayerUp1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/PlayerUp2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/PlayerDown1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/PlayerDown2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/PlayerLeft1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/PlayerLeft2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/PlayerRight1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/PlayerRight2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(keyH.up || keyH.down || keyH.left || keyH.right){
            if (keyH.up) {
                direction = "up";
                y -= speed;
            }
            if (keyH.down) {
                direction = "down";
                y += speed;
            }
            if (keyH.left) {
                direction = "left";
                x -= speed;
            }
            if (keyH.right) {
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if(spriteCounter > 14){
                if(spriteNum == 1){
                    spriteNum = 2;
                }else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if(spriteNum ==1){
                    image = up1;
                }
                if(spriteNum ==2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum ==1){
                    image = down1;
                }
                if(spriteNum ==2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum ==1){
                    image = left1;
                }
                if(spriteNum ==2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum ==1){
                    image = right1;
                }
                if(spriteNum ==2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
