package Tile;

import org.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNumber;

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[100];
        mapTileNumber = new int[gp.maxWorldColumn][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/worldMap.txt");
    }

    public void getTileImage(){
        try{
            // Grass
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassWaterBorderTop.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassWaterBorderTopRightCorner.png"));
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassWaterBorderRight.png"));
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassWaterBorderBottomRightCorner.png"));
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassWaterBorderBottom.png"));
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassWaterBorderBottomLeftCorner.png"));
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassWaterBorderLeft.png"));
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassWaterBorderTopLeftCorner.png"));

            // Water
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            tile[9].collision = true;
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterLandBorderTop.png"));
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterLandBorderTopRightCorner.png"));
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterLandBorderRight.png"));
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterLandBorderBottomRightCorner.png"));
            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterLandBorderBottom.png"));
            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterLandBorderBottomLeftCorner.png"));
            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterLandBorderLeft.png"));
            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterLandBorderTopLeftCorner.png"));

            // Gravel
            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravel.png"));
            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravelBorderTop.png"));
            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravelBorderTopRightCorner.png"));
            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravelBorderRight.png"));
            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravelBorderBottomRightCorner.png"));
            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravelBorderBottom.png"));
            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravelBorderBottomLeftCorner.png"));
            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravelBorderLeft.png"));
            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravelBorderTopLeftCorner.png"));

            // Sand
            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandWaterBorderTop.png"));
            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandWaterBorderTopRightCorner.png"));
            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandWaterBorderRight.png"));
            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandWaterBorderBottomRightCorner.png"));
            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandWaterBorderBottom.png"));
            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandWaterBorderBottomLeftCorner.png"));
            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandWaterBorderLeft.png"));
            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandWaterBorderTopLeftCorner.png"));

            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandGrassBorderTop.png"));
            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandGrassBorderTopRightCorner.png"));
            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandGrassBorderRight.png"));
            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandGrassBorderBottomRightCorner.png"));
            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandGrassBorderBottom.png"));
            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandGrassBorderBottomLeftCorner.png"));
            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandGrassBorderLeft.png"));
            tile[43] = new Tile();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandGrassBorderTopLeftCorner.png"));

            // Plants
            tile[44] = new Tile();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tallGrass.png"));
            tile[45] = new Tile();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tallTreeBottom.png"));
            tile[45].collision = true;
            tile[46] = new Tile();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tallTreeTop.png"));
            tile[46].collision = true;


            // Walls
            tile[47] = new Tile();
            tile[47].image = ImageIO.read(getClass().getResourceAsStream("/tiles/woodWall.png"));
            tile[47].collision = true;
            tile[48] = new Tile();
            tile[48].image = ImageIO.read(getClass().getResourceAsStream("/tiles/woodWallLeft.png"));
            tile[48].collision = true;
            tile[49] = new Tile();
            tile[49].image = ImageIO.read(getClass().getResourceAsStream("/tiles/woodWallRight.png"));
            tile[49].collision = true;
            tile[50] = new Tile();
            tile[50].image = ImageIO.read(getClass().getResourceAsStream("/tiles/windowHouse.png"));
            tile[50].collision = true;
            tile[51] = new Tile();
            tile[51].image = ImageIO.read(getClass().getResourceAsStream("/tiles/roof1.png"));
            tile[51].collision = true;
            //bigtree
            tile[52] = new Tile();
            tile[52].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/1.png"));
            tile[52].collision = true;
            tile[53] = new Tile();
            tile[53].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/2.png"));
            tile[53].collision = true;
            tile[54] = new Tile();
            tile[54].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/3.png"));
            tile[54].collision = true;
            tile[55] = new Tile();
            tile[55].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/4.png"));
            tile[55].collision = true;
            tile[56] = new Tile();
            tile[56].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/5.png"));
            tile[56].collision = true;
            tile[57] = new Tile();
            tile[57].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/6.png"));
            tile[57].collision = true;
            tile[58] = new Tile();
            tile[58].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/7.png"));
            tile[58].collision = true;
            tile[59] = new Tile();
            tile[59].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/8.png"));
            tile[59].collision = true;
            tile[60] = new Tile();
            tile[60].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/9.png"));
            tile[61] = new Tile();
            tile[61].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/10.png"));
            tile[62] = new Tile();
            tile[62].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/11.png"));
            tile[63] = new Tile();
            tile[63].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/12.png"));
            tile[64] = new Tile();
            tile[64].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/13.png"));
            tile[64].collision = true;
            tile[65] = new Tile();
            tile[65].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/14.png"));
            tile[65].collision = true;
            tile[66] = new Tile();
            tile[66].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/15.png"));
            tile[67] = new Tile();
            tile[67].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/16.png"));
            tile[68] = new Tile();
            tile[68].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/17.png"));
            tile[69] = new Tile();
            tile[69].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/18.png"));
            tile[70] = new Tile();
            tile[70].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/19.png"));
            tile[70].collision = true;
            tile[71] = new Tile();
            tile[71].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/20.png"));
            tile[71].collision = true;
            tile[72] = new Tile();
            tile[72].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/21.png"));
            tile[73] = new Tile();
            tile[73].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/22.png"));
            tile[74] = new Tile();
            tile[74].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/23.png"));
            tile[75] = new Tile();
            tile[75].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/24.png"));
            tile[76] = new Tile();
            tile[76].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/25.png"));
            tile[76].collision = true;
            tile[77] = new Tile();
            tile[77].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/26.png"));
            tile[77].collision = true;
            tile[78] = new Tile();
            tile[78].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/27.png"));
            tile[78].collision = true;
            tile[79] = new Tile();
            tile[79].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/28.png"));
            tile[79].collision = true;
            tile[80] = new Tile();
            tile[80].image = ImageIO.read(getClass().getResourceAsStream("/BigTree/29.png"));
            tile[80].collision = true;


        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String filepath){
        try{
            InputStream is = getClass().getResourceAsStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while(row < gp.maxWorldRow){
                String line = br.readLine();
                if (line == null) break; // Exit the loop if we've reached the end of the file
                String[] numbers = line.split(" ");
                for (col = 0; col < gp.maxWorldColumn && col < numbers.length; col++) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNumber[col][row] = num;
                }
                row++;
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        int worldCol = 0;
        int worldRow = 0;
        while(worldCol < gp.maxWorldColumn && worldRow < gp.maxWorldRow){
            int tileNum = mapTileNumber[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize> gp.player.worldX - gp.player.screenX && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
            worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){

                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            }
            worldCol++;
            if(worldCol == gp.maxWorldColumn){
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
