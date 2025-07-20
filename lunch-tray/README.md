# 🍽️ Lunch Tray App

A sample Android app for placing a lunch order, built using **Jetpack Compose** and **ViewModel architecture**.  
This project is part of the Android Basics with Compose course by Google.

---

## ✨ Features

- 🔹 **Jetpack Compose UI** — modern declarative UI building.
- 🔹 **Navigation with NavHost** — multi-screen app flow.
- 🔹 **ViewModel + State Management** — selection and price updates persist across screens.
- 🔹 **Material3 TopAppBar** — dynamic app bar with screen-specific titles and back button.
- 🔹 **Scrollable Menu Screens** — vertical scrolling for long option lists.
- 🔹 **Cancel + Reset Flow** — clears state and resets to start.

---

## 📱 Screenshots

| Start Order | Entree Menu | Side Dish Menu |
|-------------|-------------|----------------|
| <img width="300" alt="Start Screen" src="https://github.com/user-attachments/assets/5844a453-d9e4-4dd9-a91f-e7103da9f87f" /> | <img width="300" alt="Entree Screen" src="https://github.com/user-attachments/assets/b5fa0a5f-8c5f-4163-ae38-f0dd92b5a7fd" /> | <img width="300" alt="Side Dish Screen" src="https://github.com/user-attachments/assets/0f6426da-14a0-47fc-8f87-c04805355a4f" /> |

| Accompaniment Menu | Checkout |
|--------------------|----------|
| <img width="300" alt="Accompaniment Screen" src="https://github.com/user-attachments/assets/0ec48624-5b69-48c9-a4fe-025dd4ae4c36" /> | <img width="300" alt="Checkout Screen" src="https://github.com/user-attachments/assets/09902e35-94cf-4663-a7da-7260c108ce2b" /> |

---

## 🧠 What I Learned

- Setting up multi-screen navigation with `NavHostController`
- Managing UI state using `ViewModel` and `StateFlow`
- Handling user selections and state resets across screens
- Updating UI dynamically with screen-specific data
- Structuring a Compose project with good architecture

---

## 🚀 How to Run

1. Clone this repository:
   bash
   git clone https://github.com/wasii25/lunch-tray-app.git


2. Open the project in **Android Studio**
3. Run on an emulator or device (minimum SDK 24)

---

## 📂 Project Structure

lunch-tray-app/
│
├── ui/                 # Composable screens
├── datasource/         # Menu item data
├── OrderViewModel.kt   # Shared ViewModel
├── LunchTrayApp.kt     # NavHost + AppBar setup
├── MainActivity.kt     # Entry point
└── README.md

## 🙋‍♂️ About

This app was built as part of my learning journey in Android Development using **Jetpack Compose**.
Feel free to explore, fork, or share feedback!
---

