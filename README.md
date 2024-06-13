# IMDb Dataset Analysis

This project aims to analyze the IMDb dataset and retrieve the top 10 movies with a minimum of 500 votes, ranked based on a specific formula. The analysis is performed using Spring Batch and Java.

## Problem Statement

The goal of this project is to develop a Spring Batch application that processes the IMDb dataset and achieves the following:

1. Retrieve the top 10 movies with a minimum of 500 votes, where the ranking is determined by the formula: `(numVotes / averageNumberOfVotes) * averageRating`

2. For the top 10 movies, list the persons who are most often credited and list the different titles of the movies.

## Progress

So far, the project has made the following progress:

1. Set up a Spring Batch application using Java and Gradle as the build tool.
2. Implemented a job that reads the `title.ratings.tsv` file and filters movies with at least 500 votes.
3. The filtered movies are printed to the console, displaying the movie ID (tconst), average rating, and number of votes.
4. Attempted to implement the ranking formula and retrieve the top 10 movies based on the calculated ranking score. However, this part is not yet fully functional and needs further debugging and implementation.
5. The second part of the problem statement, retrieving the most often credited persons and different titles for the top 10 movies, has not been addressed yet and remains as a future task.

## Execution Instructions

To run the Spring Batch application and execute the IMDb dataset analysis, follow these steps:

1. Ensure that you have Java Development Kit (JDK) installed on your machine (preferably Java 17 or later).
2. Clone the project repository to your local machine.
3. Open a terminal or command prompt and navigate to the project's root directory.
4. Ensure the `title.ratings.tsv` file is in the `src/main/resources` directory of the project.
5. Build the project using Gradle by running the following command:

./gradlew build

6. Once the build is successful, run the application using the following command:

./gradlew bootRun

7. The application will start executing the IMDb dataset analysis job.
8. After the job completes, you will see the filtered movies printed to the console, displaying the movie ID (tconst), average rating, and number of votes.

Note: The current implementation only filters movies with at least 500 votes and prints them to the console. The ranking and top 10 movie retrieval functionality is not yet fully implemented.

## Future Work

To complete the IMDb dataset analysis project, the following tasks need to be addressed:

1. Debug and fix the issue with calculating the ranking score and retrieving the top 10 movies based on the ranking formula.
2. Implement the functionality to retrieve the most often credited persons and different titles for the top 10 movies.
3. Enhance the test coverage by adding more test cases to verify the expected behavior of the application.
4. Improve the error handling and logging to provide better visibility into the application's execution.
5. Optimize the performance of the application, if necessary, to handle large datasets efficiently.

Contributions and suggestions to improve the project are welcome. If you encounter any issues or have any questions, please feel free to open an issue in the project repository.
