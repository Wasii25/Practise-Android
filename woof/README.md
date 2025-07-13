# 🐾 Woof

A simple Android app built with Jetpack Compose to showcase a list of adorable dogs, with their ages and descriptions.

<img width="540" height="1135" alt="image" src="https://github.com/user-attachments/assets/a685dc8d-b9a7-42ac-9ba1-b8ac99c0c303" />


## ✨ Features

- Display a list of dogs with:
  - Name
  - Age
  - Photo
  - Additional details when expanded
- Clean, modern Material 3 design
- Light and dark themes
- Custom typography with Montserrat and Abril Fatface fonts
- Edge-to-edge layout with transparent system bars

## 📱 Screenshots

<img src="YOUR_SCREENSHOT_URL_HERE" width="250" />

## 🛠️ Built With

- [Kotlin](https://kotlinlang.org/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Material 3](https://developer.android.com/jetpack/compose/material3)
- Android Studio

## 🚀 Getting Started

Follow these steps to build and run the project:

1. **Clone the repository**

   bash
   git clone https://github.com/yourusername/woof.git
   cd woof


2. **Open in Android Studio**

   * Choose **File > Open** and select this project folder.

3. **Sync Gradle**

   * Android Studio will automatically download dependencies.

4. **Run the App**

   * Connect your device or use the emulator.
   * Click **Run > Run 'app'**.

## 🧩 Project Structure


app/
├── src/
│   ├── main/
│   │   ├── java/com/example/woof/
│   │   │   ├── MainActivity.kt
│   │   │   └── ui/theme/          # Theming (colors, typography, shapes)
│   │   └── res/
│   │       ├── font/              # Custom fonts
│   │       └── drawable/          # Images for dogs
└── build.gradle


## 🎨 Customization

You can change:

* Dog data (names, ages, photos) in `MainActivity` or your data source.
* Typography in `ui/theme/Theme.kt`
* Colors in `ui/theme/Color.kt`

## 🙏 Acknowledgements

* Fonts:

  * [Abril Fatface](https://fonts.google.com/specimen/Abril+Fatface)
  * [Montserrat](https://fonts.google.com/specimen/Montserrat)
    
---

Made with ❤️ using Jetpack Compose.


