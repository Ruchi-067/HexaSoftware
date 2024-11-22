
import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a movie
class Movie {
    private String title;
    private String director;
    private int releaseYear;
    private String genre;

    // Constructor
    public Movie(String title, String director, int releaseYear, String genre) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    // Display movie details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Director: " + director);
        System.out.println("Release Year: " + releaseYear);
        System.out.println("Genre: " + genre);
    }
}

// Main class to manage the movie database
public class MovieDatabase {
    private ArrayList<Movie> movies = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Method to add a new movie
    public void addMovie() {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();

        System.out.print("Enter director's name: ");
        String director = scanner.nextLine();

        System.out.print("Enter release year: ");
        int releaseYear = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        Movie movie = new Movie(title, director, releaseYear, genre);
        movies.add(movie);

        System.out.println("Movie added successfully!");
    }

    // Method to search for a movie by title
    public void searchMovie() {
        System.out.print("Enter movie title to search: ");
        String title = scanner.nextLine();

        boolean found = false;
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Movie found:");
                movie.displayDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Movie not found.");
        }
    }

    // Method to display all movies
    public void displayAllMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies in the database.");
            return;
        }

        System.out.println("Movies in the database:");
        for (Movie movie : movies) {
            System.out.println("---------------");
            movie.displayDetails();
        }
    }

    // Main menu
    public void showMenu() {
        int choice;
        do {
            System.out.println("\nMovie Database Menu:");
            System.out.println("1. Add a new movie");
            System.out.println("2. Search for a movie");
            System.out.println("3. Display all movies");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    searchMovie();
                    break;
                case 3:
                    displayAllMovies();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    // Main method
    public static void main(String[] args) {
        MovieDatabase database = new MovieDatabase();
        database.showMenu();
    }
}
