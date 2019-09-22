package bezier;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class Bezier {
    
    private static GLWindow window;
    public static int screenWidth = 640;
    public static int screenHeight = 360;
    public static float unitWide = 10;
    
    public static void init(){
       GLProfile.initSingleton();
       GLProfile profile = GLProfile.get(GLProfile.GL2);
       GLCapabilities  caps = new GLCapabilities(profile);
       window = GLWindow.create(caps);
       window.setSize(640, 360);
       window.setTitle("TESTE");
       window.setResizable(false);
       window.addGLEventListener(new EventListener());
       window.addKeyListener(new KeyBoardInput());
       window.addMouseListener(new MouseInput());
       FPSAnimator animator = new FPSAnimator(window,60); // FAZER O LOOP a 60 FPF
       animator.start();
       window.setVisible(true);
    }
    
    public static int getWindowWidth(){
        return window.getWidth();
    }
    
    public static int getWindowHeight(){
        return window.getHeight();
    }

    public static GLWindow getWindow() {
        return window;
    }
    public static void main(String[] args) {         
        init();    
    }
    
    
}
