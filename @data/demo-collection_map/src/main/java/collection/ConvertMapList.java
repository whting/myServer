package collection;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuxiang on 2017/8/29.
 */
public class ConvertMapList {


    static void convert_list_to_map_with_java () {

        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(1, "The Shawshank Redemption"));
        movies.add(new Movie(2, "The Godfather"));

        Map<Integer, Movie> mappedMovies = new HashMap<Integer, Movie>();
        for (Movie movie : movies) {
            mappedMovies.put(movie.getRank(), movie);
        }

        System.out.println(mappedMovies);

//        logger.info(mappedMovies);
//        assertTrue(mappedMovies.size() == 2);
//        assertEquals("The Shawshank Redemption", mappedMovies.get(1).getDescription());
    }

    static void convert_list_to_map_with_java8_lambda () {

        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(1, "The Shawshank Redemption"));
        movies.add(new Movie(2, "The Godfather"));

        Map<Integer, Movie> mappedMovies = movies.stream().collect(
                Collectors.toMap(Movie::getRank, (p) -> p));

        System.out.println(mappedMovies);

//        logger.info(mappedMovies);
//        assertTrue(mappedMovies.size() == 2);
//        assertEquals("The Shawshank Redemption", mappedMovies.get(1).getDescription());
    }

    static void convert_list_to_map_with_guava() {

        List<Movie> movies = Lists.newArrayList();
        movies.add(new Movie(1, "The Shawshank Redemption"));
        movies.add(new Movie(2, "The Godfather"));


        Map<Integer, Movie> mappedMovies = Maps.uniqueIndex(movies, new Function<Movie, Integer>() {
            public Integer apply(Movie from) {
                return from.getRank();
            }
        });

//        logger.info(mappedMovies);
        System.out.println(mappedMovies);

//        assertTrue(mappedMovies.size() == 2);
//        assertEquals("The Shawshank Redemption", mappedMovies.get(1).getDescription());
    }

    public static void main(String[] args) {
        convert_list_to_map_with_java();
        convert_list_to_map_with_java8_lambda();
        convert_list_to_map_with_guava();
    }
}

class Movie {

    private Integer rank;
    private String description;

    public Movie(Integer rank, String description) {
        super();
        this.rank = rank;
        this.description = description;
    }

    public Integer getRank() {
        return rank;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return rank + ":" + description;
//        return Objects.toStringHelper(this)
//                .add("rank", rank)
//                .add("description", description)
//                .toString();
    }
}

/**
 * 三种将list转换为map的方法 - jackyrong - ITeye博客
 * http://jackyrong.iteye.com/blog/2158009
 */