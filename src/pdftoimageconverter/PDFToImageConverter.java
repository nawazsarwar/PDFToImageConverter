package pdftoimageconverter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.ImageIOUtil;

/**
 * @author nawazsarwar
 */
public class PDFToImageConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        String pdfFileName = "pdf.pdf";
        PDDocument document = PDDocument.loadNonSeq(new File(pdfFileName), null);
        
        List<PDPage> pdPages = document.getDocumentCatalog().getAllPages();
        
        int page = 0;
        
        for(PDPage pdPage : pdPages){
            ++page;
            BufferedImage bim = pdPage.convertToImage(BufferedImage.TYPE_INT_RGB, 300);
            ImageIOUtil.writeImage(bim, pdfFileName+"-"+page+".png", 300);
        }
        
    }
    
}
