package projektviewer;

public class FPS {
    boolean initialized;
    int numberOfFrames;
    long firstTime;
    long currentTime;
    
    public FPS(){
        numberOfFrames = 1;
        initialized = false;
    }
    
    public void addTime(long time){

        if(!initialized){
            firstTime = time;
            initialized = true;
        } else{
            currentTime = time;
        }
        numberOfFrames++;
        
    }

    public String getFps(){      
        double fps;
        double dt;
        
        dt = currentTime - firstTime;        
        fps = ((double)numberOfFrames/(dt)) * 1e9;
        
        return "FPS: " + Double.toString(fps);      
    }
}
