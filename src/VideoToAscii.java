import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
//U Need To Manually Stop Music Using Cmd : taskkill /IM ffplay.exe /F
//It Will Be Fixed In Next Update
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class VideoToAscii {
    public static void main(String[] args) throws InterruptedException, IOException {
        // Load OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Path : ");
        String videoPath = scanner.nextLine().trim().replaceAll("^\"|\"$", ""); // Remove surrounding quotes
        videoPath = new File(videoPath).getAbsolutePath();

        System.out.println("Enter how many times you want to play the video (0 for infinite): ");
        int loopCount = scanner.nextInt();

        int playCount = 0;

        while (loopCount == 0 || playCount < loopCount) {
            // Start playing audio in a separate process
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "ffplay", "-nodisp", "-autoexit", videoPath);
            processBuilder.redirectErrorStream(true);
            Process audioProcess = processBuilder.start();

            VideoCapture video = new VideoCapture(videoPath);
            if (!video.isOpened()) {
                System.out.println("Error: Cannot open video file.");
                return;
            }

            double frameRate = video.get(5);
            double frameTime = 1000.0 / frameRate; // Time per frame in ms
            long videoStartTime = System.currentTimeMillis();

            System.out.println("Frame Rate: " + frameRate);

            Mat frame = new Mat();
            int scale = 6; // Adjust for ASCII resolution
            String asciiChars = "@#%*+=-:. "; // ASCII brightness scale

            while (true) {
                boolean isFrameRead = video.read(frame);
                if (!isFrameRead) {
                    break;
                }

                Imgproc.resize(frame, frame, new Size(frame.cols() / scale, frame.rows() / scale));
                Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);

                StringBuilder asciiArt = new StringBuilder();
                for (int y = 0; y < frame.rows(); y++) {
                    for (int x = 0; x < frame.cols(); x++) {
                        int pixelValue = (int) frame.get(y, x)[0];
                        int index = (pixelValue * (asciiChars.length() - 1)) / 255;
                        asciiArt.append(asciiChars.charAt(index)).append(" ");
                    }
                    asciiArt.append("\n");
                }

                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print(asciiArt.toString());

                frame.release();

                // Ensure proper frame timing
                long elapsedTime = System.currentTimeMillis() - videoStartTime;
                long expectedTime = (long) ((video.get(1) / frameRate) * 1000);
                long sleepTime = Math.max(0, expectedTime - elapsedTime);
                Thread.sleep(sleepTime);
            }

            video.release();
            playCount++;

            // Ensure the audio process is properly terminated
            if (audioProcess != null && audioProcess.isAlive()) {
                audioProcess.destroy();
            }

            if (loopCount > 0 && playCount >= loopCount) {
                break;
            }
        }
    }
}
