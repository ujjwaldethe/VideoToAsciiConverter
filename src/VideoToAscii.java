import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import java.io.File;

public class VideoToAscii {
    public static void main(String[] args) throws InterruptedException {
        // Load OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Initialize video capture
        String videoPath = new File("video8.mp4").getAbsolutePath();
        VideoCapture video = new VideoCapture(videoPath);

        if (!video.isOpened()) {
            System.out.println("Error: Cannot open video file.");
            return;
        }

        // Get the video frame rate
        double frameRate = video.get(5); // Index 5 retrieves FPS in OpenCV
        System.out.println("Frame Rate: " + frameRate);

        Mat frame = new Mat();
        int scale = 6; // Adjust for ASCII resolution (higher = lower quality)
        String asciiChars = "@#%*+=-:. "; // ASCII brightness scale

        // Process video frames
        while (true) {
            boolean isFrameRead = video.read(frame); // Read next frame

            if (!isFrameRead) {
                System.out.println("End of video reached.");
                break; // Exit loop when the video ends
            }

            // Resize frame
            Imgproc.resize(frame, frame, new Size(frame.cols() / scale, frame.rows() / scale));
            // Convert to grayscale
            Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);

            // Convert frame to ASCII
            StringBuilder asciiArt = new StringBuilder();
            for (int y = 0; y < frame.rows(); y++) {
                for (int x = 0; x < frame.cols(); x++) {
                    int pixelValue = (int) frame.get(y, x)[0]; // Grayscale pixel value
                    int index = (pixelValue * (asciiChars.length() - 1)) / 255;
                    asciiArt.append(asciiChars.charAt(index)).append(" ");
                }
                asciiArt.append("\n");
            }

            // Clear the console and print ASCII art
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print(asciiArt.toString());

            // Release the frame after processing
            frame.release();

            // Delay for real-time playback
            int delay = Math.max(50, (int) (1000 / frameRate)); // Ensures at least 50ms delay
            Thread.sleep(delay);
        }

        // Release video capture
        video.release();
    }
}
