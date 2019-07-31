package _05_netflix;

public class Runner {
	public static void main(String[] args) {
		Movie a = new Movie("d", 5);
		Movie b = new Movie("c", 2);
		Movie c = new Movie("b", 3);
		Movie d = new Movie("a", 7);
		Movie e = new Movie("null 2", 12);
		NetflixQueue a1 = new NetflixQueue();
		
		a1.addMovie(a);
		a1.addMovie(b);
		a1.addMovie(c);
		a1.addMovie(d);
		a1.addMovie(e);
		a1.printMovies();
		a1.sortMoviesByRating();
		System.out.println("the best movie is...."+a1.getBestMovie());
		System.out.println("the second best movie is...."+a1.movies.get(1));
	}
}
