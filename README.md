# GitHub User Explorer

This is a simple native Android application built using Jetpack Compose and MVVM architecture that allows users to search for GitHub profiles, view their details, and navigate to their followers, following, and repositories.

## Project Structure

The project is divided into the following packages:

- `data`: Contains data models, repository, and data sources.
- `domain`: Contains business logic, use cases, and entities.
- `presentation`: Contains UI-related code, including Compose views and view models.
- `navigation`: Contains the navigation graph and destination definitions.

## Features

1. **Search for a user**
2. **Display user profile** (name, bio, followers, following, repos)
3. **Navigate to followers and following lists**
4. **Navigate to repositories list**
5. **Unit testing** (bonus)

## GitHub API Endpoints

1. Search users: `GET /search/users`
2. Get user profile: `GET /users/{username}`
3. Get user followers: `GET /users/{username}/followers`
4. Get user following: `GET /users/{username}/following`
5. Get user repos: `GET /users/{username}/repos`

## Dependencies

- Jetpack Compose
- Retrofit
- Hilt
- Kotlin

## How to Run

1. Clone the repository.
2. Open the project in Android Studio.
3. Sync the project with Gradle.
4. Run the application on an emulator or physical device.

## Notable Design Decisions

- **MVVM Architecture:** Ensures separation of concerns and makes the codebase more maintainable.
- **Jetpack Compose:** For building the UI declaratively.
- **Hilt:** For dependency injection, making the code easier to test and manage.

## Unit Testing

Unit tests are included for the ViewModels and use cases. To run the tests, use the following command:

```bash
./gradlew test
