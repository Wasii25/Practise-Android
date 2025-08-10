# 📚 Library App

A Jetpack Compose Android app for searching books using the Google Books API, with navigation between a library list and detailed book pages.

---

## 🚀 Features

* **Search Books** – Search for books via the Google Books API.
* **View Details** – Tap a book to see its detailed info (title, authors, description, cover).
* **Modern UI** – Built with Jetpack Compose and Material 3.
* **Navigation** – Uses `NavHost` for smooth screen transitions.

---

## 🛠 Tech Stack

* **Language:** Kotlin
* **UI:** Jetpack Compose
* **Navigation:** Navigation Compose
* **Networking:** Retrofit
* **Image Loading:** Coil
* **Architecture:** MVVM with StateFlow

---

## 📂 Project Structure

com.example.libraryapp
│
├── model/           # Data models (Book, VolumeInfo, etc.)
├── network/         # Retrofit API service for Google Books
├── ui/
│   ├── components/  # Reusable UI elements (BookItem, SearchBar, etc.)
│   ├── screens/     # Screens (LibraryScreen, BookDetailsScreen)
│   ├── LibraryNavHost.kt
│   └── LibraryViewModel.kt
└── MainActivity.kt  # App entry point

---

## 🔄 App Flow

1. **MainActivity** loads `LibraryNavHost`.
2. **LibraryNavHost** defines navigation routes:

   * `"library"` → shows `LibraryScreen` (book list + search bar)
   * `"details/{bookId}"` → shows `BookDetailsScreen` (detailed info)
3. **LibraryViewModel** handles search logic and API calls.
4. **Google Books API** returns results → displayed in the UI.

![App Flow Diagram](library_app_flow.png)

---

## 📦 Installation

1. Clone this repo:

   ```bash
   git clone https://github.com/yourusername/libraryapp.git
   ```
2. Open in **Android Studio**.
3. Add your **Google Books API base URL** in `LibraryApi`.
4. Run on an emulator or device.

---

## 🖼 Screenshots
<img width="540" height="1136" alt="image" src="https://github.com/user-attachments/assets/d247232d-908f-49e5-8dce-33b110268a12" />
<img width="540" height="1131" alt="image" src="https://github.com/user-attachments/assets/60268126-3621-4ea6-8b69-42b3fe49bf45" />
<img width="540" height="1126" alt="image" src="https://github.com/user-attachments/assets/ad3a107b-2bb5-4ed3-b84f-a1dd50abf49e" />
<img width="1280" height="964" alt="library_app_flow" src="https://github.com/user-attachments/assets/2b26653d-0341-47c8-8b93-2b815b70528e" />

---

## 📜 License

MIT License – You can freely use and modify this code.

---
