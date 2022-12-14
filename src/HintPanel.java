import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HintPanel extends JPanel {

    private final BufferedImage backgroundImage;

    // Some code to initialize the background image.
    // Here, we use the constructor to load the image. This
    // can vary depending on the use case of the panel.
    public HintPanel(String fileName) throws IOException {
        backgroundImage = ImageIO.read(new File(fileName));
    }

    public BufferedImage getBackgroundImage(){
        return backgroundImage;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(backgroundImage, 0, 0, this);
    }
}
