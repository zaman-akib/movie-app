# Movie Listing Application

## Overview
The Movie Listing Application is a console-based application that allows users to register, log in, search for movies, and manage their favorite movies. Inspired by movie databases like IMDb, this application provides functionalities for browsing and managing movies without requiring a database.

## Features
- **User Registration**: Users can register with their email addresses.
- **User Login**: Users can log in to access the main features of the application.
- **Movie Search**: Users can search for movies by title, cast, or category.
- **Movie Details**: Users can view detailed information about a selected movie.
- **Favorites Management**: Users can add movies to their favorites and remove them as needed.
- **View Personal Details**: Users can view their personal details and favorite movies.
- **Search Favorites**: Users can search for movies within their favorites.

## Technologies Used
- Java
- Collections Framework
- LocalDate for date management
- JUnit and Mockito for unit testing

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 17 or higher installed.
- A text editor or an Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse.

### Installation
Clone the repository:
```
git clone https://github.com/yourusername/movie-app.git
```

### Run App
1. Navigate to the Project Directory
```
cd movie-app
```
2. Compile the Java Files 
```
javac -d bin src/main/java/org/movie/*.java src/main/java/org/movie/model/*.java src/main/java/org/movie/service/*.java
```
3. Run the Application
```
java -cp bin org.movie.MovieApp
```
