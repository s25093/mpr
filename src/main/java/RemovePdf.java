import java.io.File;

public class RemovePdf {
    public static void main(String[] args) {
        try {
            File f = new File("capybara.pdf");
            if (!f.delete()) {
                System.err.println("Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
