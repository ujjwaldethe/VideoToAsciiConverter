# 🎨 Video & Image to ASCII Converter  

🚀 A Java-based project that converts videos and images into ASCII art displayed in the console. This project is a tribute to **Chhatrapati Shivaji Maharaj**, blending history with technology using Java and OpenCV.  

## 🔥 Features  

👉 **Video to ASCII Animation** (Real-time conversion of video frames to ASCII).  
👉 **Image to ASCII with Colors** (Displays images with color effects in the terminal).  
👉 **Terminal-Based Rendering** (No external GUI required).  
👉 **Frame Rate Synchronization** (For smooth video playback).  
👉 **Customizable ASCII Resolution** (Modify scale for quality).  

---  

## 🛠️ Tech Stack  

- **Java**  
- **OpenCV** (For video processing)  
- **AWT & BufferedImage** (For image manipulation)  
- **ASCII Art Rendering**  
- **FFmpeg** (For audio playback)  

---  

## 🎦 How It Works  

### 1️⃣ Video to ASCII (VideoToAscii.java)  

Converts a video file into an ASCII animation displayed in the console.  

#### **Steps:**  
1. Load a video file (`video8.mp4`).  
2. Extract frames and resize them.  
3. Convert frames to grayscale.  
4. Map pixel values to ASCII characters.  
5. Render ASCII frames in the console at the original video frame rate.  
6. Play audio using FFmpeg in the background.  

#### **Run Commands:**  
```sh
javac -cp "C:\Users\krish\Downloads\opencv\build\java\opencv-4100.jar;src" -d out VideoToAscii.java
java -cp "out;C:\Users\krish\Downloads\opencv\build\java\opencv-4100.jar" -Djava.library.path="C:\Users\krish\Downloads\opencv\build\java\x64" VideoToAscii
```

---  

### 2️⃣ Image to ASCII (ImageToConsole.java)  

Displays an image (`maharaj1.jpg`) as ASCII art with dynamic color effects.  

#### **Steps:**  
1. Load an image file.  
2. Resize it for the console display.  
3. Convert it to grayscale.  
4. Map brightness to ASCII characters (`*` for bright, space for dark).  
5. Apply dynamic color effects in the terminal.  

#### **Run Commands:**  
```sh
javac ImageToConsole.java  
java ImageToConsole
```

---  

## 📚 File Structure  

```
📂 VideoToAsciiConverter
 ├── 📁 src
 │   ├── VideoToAscii.java
 │   ├── ImageToConsole.java
 │   ├── video8.mp4
 │   └── maharaj1.jpg
 ├── 📁 lib
 │   └── opencv-4100.jar
 └── README.md
```

---  

## 📝 FFmpeg Installation (For Audio Playback)  

FFmpeg is required to play the audio in the background while the video is being displayed as ASCII.

### **Windows**  
1. Download FFmpeg from [https://ffmpeg.org/download.html](https://ffmpeg.org/download.html).  
2. Extract the ZIP file and move it to `C:\ffmpeg`.  
3. Add FFmpeg to the system PATH:  
   - Open `System Properties` > `Advanced` > `Environment Variables`.  
   - Under `System Variables`, find `Path` and click `Edit`.  
   - Click `New` and add `C:\ffmpeg\bin`.  
   - Click `OK` to save.  
4. Verify installation by running:  
   ```sh
   ffmpeg -version
   ```

### **Linux/Mac**  
1. Install FFmpeg via package manager:  
   ```sh
   sudo apt install ffmpeg   # Ubuntu/Debian
   brew install ffmpeg       # macOS
   ```
2. Verify installation:  
   ```sh
   ffmpeg -version
   ```

---  

## 🏆 Tribute to Chhatrapati Shivaji Maharaj  

Chhatrapati Shivaji Maharaj was a visionary leader and a master strategist. His legacy continues to inspire us. This project is a small tribute to his greatness by merging history with technology.  

---  

## 💬 Connect & Contribute  

Would love to hear your thoughts and suggestions! Feel free to contribute or modify the project.  

🚀 **Let's celebrate history with innovation!** 🚀  

---  

🔗 **#ChhatrapatiShivajiMaharajJayanti #Java #OpenCV #ASCIIArt #Coding #TechForHistory**

