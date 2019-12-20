/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee_AttendanceMng_Package;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Roshli
 */
public class BarcodeDemo2 {
    public static void GenerateBcode(String MBcode) throws Exception, DocumentException{
        
            Document document = new Document(new Rectangle(PageSize.A4));    
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Roshli\\Pictures\\BcodeEMP\\"+MBcode+".pdf"));    
 
    document.open();
     document.add(new Paragraph("MUBS"));
 
     Barcode128 code128 = new Barcode128();
     code128.setGenerateChecksum(true);
     code128.setCode(MBcode);    
 
     document.add(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
    document.close();
 
    System.out.println("Document Generated...!!!!!!");
    JOptionPane.showMessageDialog(null, "Barcode Generated");
            
        
            
    }
    
}
