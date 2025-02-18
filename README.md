Here's a combined `README.md` file for both your Java programs:  

1. **VideoToAscii**: Converts a video into ASCII animation using OpenCV.  
2. **ImageToConsole**: Displays an image as ASCII art with color effects in the console.  

---

# 🎨 Video & Image to ASCII Converter  

🚀 A Java-based project that converts videos and images into ASCII art displayed in the console. This project is a tribute to **Chhatrapati Shivaji Maharaj**, blending history with technology using Java and OpenCV.  

## 🔥 Features  

✅ **Video to ASCII Animation** (Real-time conversion of video frames to ASCII).  
✅ **Image to ASCII with Colors** (Displays images with color effects in the terminal).  
✅ **Terminal-Based Rendering** (No external GUI required).  
✅ **Frame Rate Synchronization** (For smooth video playback).  
✅ **Customizable ASCII Resolution** (Modify scale for quality).  

---

## 🛠️ Tech Stack  

- **Java**  
- **OpenCV** (For video processing)  
- **AWT & BufferedImage** (For image manipulation)  
- **ASCII Art Rendering**  

---

## 📽️ How It Works  

### 1️⃣ Video to ASCII (VideoToAscii.java)  

Converts a video file into an ASCII animation displayed in the console.  

#### **Steps:**  
1. Load a video file (`video8.mp4`).  
2. Extract frames and resize them.  
3. Convert frames to grayscale.  
4. Map pixel values to ASCII characters.  
5. Render ASCII frames in the console at the original video frame rate.  

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

## 📂 File Structure  

```
📂 VideoToAsciiConverter
 ├── 📁 src
 │   ├── VideoToAscii.java
 │   ├── ImageToConsole.java
 │   ├── video8.mp4
 │   ├── maharaj1.jpg
 ├── 📁 lib
 │   ├── opencv-4100.jar
 ├── README.md
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
