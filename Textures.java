package projektviewer;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Textures {

    public static BufferedImage bufferedTextures;
    public static BufferedImage grass;

    static Graphics graphics;
    
    public static void init(){
        
        initBufferedTextures();
        initGrass();        
    }
    
    static void initBufferedTextures(){
        
        try{
            File imageFile = new File("building_sprites.png");
            bufferedTextures = ImageIO.read(imageFile);
            
            System.out.println("AllTextures width:  " + Textures.bufferedTextures.getWidth(null) +
                             "\n            heigth: " + Textures.bufferedTextures.getHeight(null));
            
        } catch(Exception e){
            
        }
        /*
        bufferedTextures = new BufferedImage(allTextures.getWidth(null),
                                             allTextures.getHeight(null),
                                             BufferedImage.TYPE_INT_ARGB);
         * 
         */
         
        //System.out.println("AllTextures width:  " + allTextures.getWidth(null) +
        //                 "\n            heigth: " + allTextures.getHeight(null));
    }
    
    static void initGrass(){
        grass = bufferedTextures.getSubimage(6, 1805, 48, 24);
        
        /*
        System.out.println("Grass: " + grass);
        
        graphics = grass.getGraphics();
        graphics.drawImage(allTextures, 0, 0, 48, 25, 0, 0, 40, 20, null);
        
        System.out.println(grass.getRGB(20, 20)); */
        
        //grass = bufferedTextures.getSubimage(6, 1805, 48, 25);
        
        //graphics = grass.getGraphics();
        //graphics.drawImage(bufferedTextures, 0, 0, null);       
    }
}
