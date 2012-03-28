package projektviewer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import projektviewer.Textures;

public class GamePanel extends JPanel {
   
    int blockSize;
    
        double num = 0;
        double velocity = 0.5;
        enum Mode{ left, right }
        Mode mode = Mode.right;
        
        Graphics canvas;
        Image buffer;
    
        
    public GamePanel(){
        createBuffer();
        Textures.init();
    }
    
    public GamePanel(int blockSize){        
        this.blockSize = blockSize;
        createBuffer();
    }
    
    
    private void createBuffer(){
        buffer = new BufferedImage(700, 500, BufferedImage.TYPE_INT_RGB);
        
        canvas = buffer.getGraphics();
    }
    
    public void render(){        
        if(buffer == null)
            System.out.println("buffer is null");
        
        
        
        if(canvas == null)
            System.out.println("canvas is null");
        
        canvas.setColor(Color.black);
        canvas.fillRect(0, 0, 700, 500);
        canvas.setColor(Color.white);
        canvas.fillOval((int)num, 150, 40, 40);
        
            switch(mode){
                case left: num-= velocity;
                            break;
                case right: num+= velocity;              
                            break;
            }

            if(num > 656) mode = Mode.left;
            else if(num < 0) mode = Mode.right;           
    }
    
    public void render(String string){
        //render();
        //canvas.drawString(string, 50, 50);
        
        // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        // ##################  Drawing  ##########################
        // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        // very ugly place
        try{
            //canvas.drawImage(Textures.grass, 0, 0, null);
            for(int i = 0; i<=700; i += 48){
                for(int j = 0; j<= 500; j += 24){
                    canvas.drawImage(Textures.grass, i, j, null);
                   
                }
            }
            
            canvas.drawString(string, 50, 50);
            
            ////////////////////// just chekin'
           /* System.out.println("AllTextures width:  " + Textures.allTextures.getWidth(null) +
                             "\n            heigth: " + Textures.allTextures.getHeight(null));
            */
        } catch(Exception e){
            
        }
        
    }
    
    /*
    @Override
    public void paintComponent(Graphics g){
        //super.paintComponent(g);
        g.drawImage(buffer, 0, 0, null);
    }*/
    
    
    
    @Override
    public void paint(Graphics g){
        g.drawImage(buffer, 0, 0, null);
    }
    
    
    
    void debugRender(String string){
        
        
        try{
            //canvas.drawImage(Textures.grass, 0, 0, null);
            for(int i = 0; i<=700; i += 48){
                for(int j = 0; j<= 500; j += 24){
                    canvas.drawImage(Textures.grass, i, j, null);
                   
                }
            }
            
            canvas.drawString(string, 50, 50);
            
            ////////////////////// just chekin'
           /* System.out.println("AllTextures width:  " + Textures.allTextures.getWidth(null) +
                             "\n            heigth: " + Textures.allTextures.getHeight(null));
            */
        } catch(Exception e){
            
        }
        
        
        
         if(buffer == null)
            System.out.println("buffer is null");
        
        
        
        if(canvas == null)
            System.out.println("canvas is null");
        
        canvas.setColor(Color.white);
        canvas.fillOval((int)num, 150, 40, 40);
        
            switch(mode){
                case left: num-= velocity;
                            break;
                case right: num+= velocity;              
                            break;
            }

            if(num > 656) mode = Mode.left;
            else if(num < 0) mode = Mode.right; 
    }
    
}
