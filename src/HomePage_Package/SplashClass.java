/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomePage_Package;



/**
 *
 * @author Manju_PC
 */
public class SplashClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SplashScreen sp = new SplashScreen();
        MainHome home = new MainHome();
        sp.setVisible(true);
        try {
            for(int i=0;i<=100;i++){
                Thread.sleep(30);
                sp.ReadingValue_Splash.setText(Integer.toString(i)+"%");
                sp.ProgressBar_Splash.setValue(i);
                if(i==100){
                    sp.setVisible(false);
                    home.setVisible(true);
                }
            }
        } catch (Exception e) {
        }
        
    }
    
}
