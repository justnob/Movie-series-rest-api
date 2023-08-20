# MOVE & SERIES REST API

This is a simple rest api which helps you to keep record of the movies and series which you have watched.
It's still in progress.

this api currently uses H2 database for development purpose. It has custom-made exception for error handling.

The link to use the api are:-i

1. http://localhost:8080/api/v1/movies to get all the lists of saved movie and series list.
2. http://localhost:8080/api/v1/movies to add a new movie or series to the list.
3. http://localhost:8080/api/v1/movies/{id} to get a movie or series by id.
4. http://localhost:8080/api/v1/movies/{id} to update an existing movie or series by id.
5. http://localhost:8080/api/v1/movies/name?name= name to search a movie or series with name.
6. http://localhost:8080/api/v1/movies/{id} to delete movie or series by its id.
7. http://localhost:8080/api/v1/movies/{movieId}/rating to get a rating of movie or series by id of movie or series and rating id.
8. http://localhost:8080/api/v1/movies/{movieId}/rating/{ratingId} to update the rating to the perticular movie or series.
9. http://localhost:8080/api/v1/movies/{movieId}/rating to add a rating to the perticular movie or series.
10. http://localhost:8080/api/v1/movies/{movieId}/trailer to ADD and UPDATE the trailer details of the movie.
11. http://localhost:8080/api/v1/movies/{movieId}/trailer/{trailerId} to DELETE the trailer with id