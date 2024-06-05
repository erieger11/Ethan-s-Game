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
    Tile[] tile;
    int[][] mapTileNumber;

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[30];
        mapTileNumber = new int[gp.maxScreenColumn][gp.maxScreenRow];
        getTileImage();
        loadMap();
    }

    public void getTileImage(){
        try{
            //grass
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassWaterBorderTop.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassWaterBorderRight.png"));
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassWaterBorderLeft.png"));
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassWaterBorderBottom.png"));
            //water
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterLandBorderTop.png"));
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterLandBorderRight.png"));
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterLandBorderLeft.png"));
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterLandBorderBottom.png"));
            //gravel
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravel.png"));
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravelBorderTop.png"));
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravelBorderRight.png"));
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravelBorderLeft.png"));
            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravelBorderBottom.png"));
            //sand
            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandWaterBorderTop.png"));
            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandWaterBorderRight.png"));
            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandWaterBorderLeft.png"));
            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandWaterBorderBottom.png"));
            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandGrassBorderTop.png"));
            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandGrassBorderRight.png"));
            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandGrassBorderLeft.png"));
            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sandGrassBorderBottom.png"));
            //plants
            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tallGrass.png"));
            //walls
            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/woodWall.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(){
        try{
            InputStream is = getClass().getResourceAsStream("/maps/firstMap.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while(row < gp.maxScreenRow){
                String line = br.readLine();
                if (line == null) break; // Exit the loop if we've reached the end of the file
                String[] numbers = line.split(" ");
                for (col = 0; col < gp.maxScreenColumn && col < numbers.length; col++) {
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
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gp.maxScreenColumn && row < gp.maxScreenRow){

            int tileNum = mapTileNumber[col][row];
            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;
            if(col == gp.maxScreenColumn){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}
