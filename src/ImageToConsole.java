import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class ImageToConsole {
    public static void main(String[] args) throws Exception {
        int c = 1, count = 1;
        final int CONSOLE_WIDTH = 80; // Adjust based on your console size

        while (true) {
            // Clear console
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J"); // Works on Unix-based systems
                System.out.flush();
            }
            if (count > 8) {
                c = 1;
                count = 1;
            }

            String colorChanging = "\u001B[3" + c + "m";

            try {
                // Load the image
                File file = new File("C:\\Users\\krish\\IdeaProjects\\VideoToAsciiConverter\\src\\maharaj1.jpg");
                if (!file.exists()) {
                    System.out.println("Image file not found!");
                    return;
                }
                BufferedImage image = ImageIO.read(file);

                // Resize scaling
                int scale = 4;
                int width = image.getWidth() / scale;
                int height = image.getHeight() / scale;
                for (int y = 0; y < height; y++) {
                    // Add a white line effect at the start of each row
                    System.out.print("                                                                                                    "+"                                                                                                                                                                "); // Vertical white separator

                    for (int x = 0; x < width; x++) {
                        int pixel = image.getRGB(x * scale, y * scale);
                        Color color = new Color(pixel, true);

                        // Convert to grayscale
                        int gray = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

                        // Choose ASCII character based on brightness
                        String ch = gray < 128 ? " " : "*"; // Darker pixels are empty, lighter are '*'

                        // Apply color and print
                        System.out.print(colorChanging + ch);
                    }
                    System.out.print("\u001B[0m\n"); // Reset color and move to a new line
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            count++;
            c++;
            Thread.sleep(5000);
        }
    }
}
