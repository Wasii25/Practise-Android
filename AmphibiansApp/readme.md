# 🐸 Amphibians App

A simple Jetpack Compose Android app that fetches and displays amphibians using a public REST API. Built with modern Android development tools: Kotlin, Coroutines, ViewModel, Retrofit, Coil, and Material 3.

---

## ✨ Features

- 📡 Fetches amphibian data from a remote API
- 🧪 MVVM architecture using `ViewModel` and `StateFlow`
- 🖼️ Displays images using `Coil` with smooth loading and error states
- 💀 Graceful error handling
- 🧩 Clean UI built with `Jetpack Compose`
- 📱 Adaptive layout with proper padding and spacing

---

## 🧱 Tech Stack

| Layer         | Tech                                                         |
|---------------|--------------------------------------------------------------|
| Language      | [Kotlin](https://kotlinlang.org/)                            |
| UI            | [Jetpack Compose](https://developer.android.com/jetpack/compose) |
| Architecture  | MVVM, `ViewModel`, `StateFlow`                               |
| Networking    | [Retrofit](https://square.github.io/retrofit/) + Kotlinx Serialization |
| Image Loading | [Coil](https://github.com/coil-kt/coil)                      |
| JSON Parsing  | [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization) |
| DI            | Manual (AppContainer pattern)                                |

---

## 📸 Screenshots

> _App preview screenshots from different UI states._

### 🔄 Loading State  
<img width="270" src="https://github.com/user-attachments/assets/231bed1d-fdd5-4b91-b6c1-78c42abde2c2" alt="Loading state" />

### ✅ Success State  
<img width="270" src="https://github.com/user-attachments/assets/d4f7b750-8b0c-4bf1-bc59-9d2535f4aa09" alt="Success state" />

### ❌ Error State  
<img width="270" src="https://github.com/user-attachments/assets/5f14c938-0c09-487f-8a56-a72e5ed0effb" alt="Error state" />


## 🚀 Getting Started

### 1. Clone the repo

git clone https://github.com/yourusername/AmphibiansApp.git
cd AmphibiansApp


### 2. Open in Android Studio

Make sure you have:

* Android Studio Giraffe or later
* Kotlin 2.2.0+
* Gradle 8.1+
* Compile SDK: 34+

### 3. Run the app

Ensure you have an emulator or physical device with internet, then click ▶️ in Android Studio.

---

## 📄 License

MIT License — feel free to fork, modify, and use for learning or portfolio purposes.

---

## 🙌 Acknowledgments

* Inspired by [Android Basics with Compose](https://developer.android.com/courses/android-basics-compose/course) by Google.
* API provided by [Google Dev Training Mars Server](https://android-kotlin-fun-mars-server.appspot.com/amphibians).
