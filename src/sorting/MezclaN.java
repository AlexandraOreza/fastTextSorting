/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorting;
import java.io.*;

/**
 *
 * @author Alexandra
 */
public class MezclaN {
    private boolean band;
    
    public void MezclaNatural(File F, String F1, String F2, String F3){
        try {
            File f1 = new File("src/resources/"+F1);
            File f2 = new File("src/resources/"+F2);
            File f3 = new File("src/resources/"+F3);
            
            boolean isFile1Created = f1.createNewFile();
            boolean isFile2Created = f2.createNewFile();            
            boolean isFile3Created = f3.createNewFile();
            
            if (isFile1Created && isFile2Created && isFile3Created) {
                System.out.println("Empty text file created successfully.");
            } else {
                System.out.println("Failed to create empty text file.");
            }
            
            PartInicial(F, f2, f3);
            PartFusion(F, f1, f2, f3);
            band = false;

            while (f1.length() == 0 || f3.length() == 0) {
                if(band == true){
                    PartFusion(f2, f3, F, f1);
                    band = false;
                }else{
                    PartFusion(F, f1, f2, f3);
                    band = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public void PartInicial(File F, File F2, File F3){
                
    }
    public void PartFusion(File F, File F1, File F2, File F3){
        
    }
    
    public void isEmpty(){
        
    }
}
