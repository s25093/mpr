import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PDDocument document = PDDocument.load(new File("dummy.pdf"));
        PDPage page = new PDPage();
        document.addPage(page);
        PDImageXObject image = PDImageXObject.createFromFile("Capybara02.jpg", document);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.drawImage(image,  20, 300, 500, 400);
        contentStream.close();
        document.save("capybara.pdf");
        document.close();
    }
}
