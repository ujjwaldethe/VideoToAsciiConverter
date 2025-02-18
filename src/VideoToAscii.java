import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import java.io.File;

public class VideoToAscii {

    public static void main(String[] args) throws InterruptedException {
        // Load the OpenCV native library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Initialize video capture
        String videoPath = new File("video8.mp4").getAbsolutePath();

        // Update with your video path
        VideoCapture video = new VideoCapture(videoPath);
        if (!video.isOpened()) {
            System.out.println("Error: Cannot open video file.");
            return;
        }

        // Get the video frame rate (frames per second)
        double frameRate = video.get(5); // 5 is the index for FPS in OpenCV
        System.out.println("Frame Rate: " + frameRate);

        Mat frame = new Mat();
        int scale = 6; // Adjust for ASCII resolution (higher = lower quality)
        String asciiChars = "@#%*+=-:. "; // ASCII brightness scale

        // Continuous loop to process video frames
        while (true) {
            boolean isFrameRead = video.read(frame);  // Read the next frame from video

            if (!isFrameRead) {
                System.out.println("End of video reached.");
                break; // Exit the loop when the video reaches the end
            }

            // Resize frame for ASCII resolution
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

            // Print the ASCII art (overwrite the previous line in the console)
            System.out.print(asciiArt.toString());

            // Release the memory for the current frame after processing
            frame.release();

            // Calculate delay time for real-time playback (in milliseconds)
            int delay = (int) (1000 / frameRate); // Delay in ms to match frame rate
            Thread.sleep(delay); // Wait for the next frame
        }

        // Release video capture
        video.release();
    }
}