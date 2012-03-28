package projektviewer;

import javax.swing.JFrame;
import projektviewer.FPS;

public final class Viewer implements Runnable{

    JFrame frame;
    GamePanel panel;
    FPS fps;
    
    long previousTime;
    long currentTime;
    long sleepTime;
    long dt;
    long timeGranularity = 2;
    
    public Viewer(){
        setFPSCounter();      
        setWindow();
        setPanel(); 
        startViewerThread();
    }
    
    void setFPSCounter(){
        fps = new FPS();
    }
    
    void setWindow(){
        frame = new JFrame();
        frame.setLocation(150, 100);
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    void setPanel(){
        panel = new GamePanel();
        panel.setDoubleBuffered(true);
        frame.add(panel);
        panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
    }
    
    void startViewerThread(){
        new Thread(this).start();
    }
    
    
    @Override
    public void run() {
        
        previousTime = System.nanoTime();
        
        while(true){
            panel.debugRender(fps.getFps());
            panel.repaint();

            currentTime = System.nanoTime();
                fps.addTime(currentTime);
                
            dt = currentTime - previousTime;
            sleepTime = (50000 - dt)/1000000;
            
            try {
                if(sleepTime > 0){
                    Thread.sleep(sleepTime);
                } else{
                    Thread.sleep(timeGranularity);
                }                
            } catch (InterruptedException ex) {
                
            }
            
            previousTime = System.nanoTime();
        }        
    }   
}
