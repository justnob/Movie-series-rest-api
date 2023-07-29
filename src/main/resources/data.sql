
INSERT INTO RATE (ID, RATING)
VALUES
    (1, 8.8),
    (2, 9.0),
    (3, 8.6),
    (4, 7.8),
    (5, 9.3),
    (6, 9.2),
    (7, 8.9),
    (8, 8.8),
    (9, 8.8),
    (10, 8.7);


INSERT INTO AIRED (ID, AIR_DATE, END_DATE)
VALUES
    (1, CURRENT_DATE(), CURRENT_DATE()),
    (2, CURRENT_DATE(), CURRENT_DATE()),
    (3, CURRENT_DATE(), CURRENT_DATE()),
    (4, CURRENT_DATE(), CURRENT_DATE()),
    (5, CURRENT_DATE(), CURRENT_DATE()),
    (6, CURRENT_DATE(), CURRENT_DATE()),
    (7, CURRENT_DATE(), CURRENT_DATE()),
    (8, CURRENT_DATE(), CURRENT_DATE()),
    (9, CURRENT_DATE(), CURRENT_DATE()),
    (10, CURRENT_DATE(), CURRENT_DATE());



INSERT INTO Movie (ID, Name, IMAGE_URL, DESCRIPTION, NUMBER_OF_EPISODES, AIRED_ID, RATE_ID)
VALUES
    (1, 'inception', 'https://www.themoviedb.org/t/p/original/8IB2e4r4oVhHnANbnm7O3Tj6tF8.jpg', 'A mind-bending action thriller about dream infiltration.', 1, 1, 1),
    (2, 'the dark knight', 'https://www.themoviedb.org/t/p/original/eP5NL7ZlGoW9tE9qnCdHpOLH1Ke.jpg', 'Batman faces the Joker in a battle for Gotham City.', 1, 2, 2),
    (3, 'interstellar', 'https://www.themoviedb.org/t/p/original/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg', 'A journey through space and time to find a new habitable planet.', 1, 3, 3),
    (4, 'avatar', 'https://www.themoviedb.org/t/p/original/kyeqWdyUXW608qlYkRqosgbbJyK.jpg', 'A marine on an alien planet becomes torn between two worlds.', 1, 4, 4),
    (5, 'the shawshank redemption', 'https://www.themoviedb.org/t/p/original/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg', 'A tale of friendship and redemption in a prison.', 1, 5, 5),
    (6, 'the godfather', 'https://www.themoviedb.org/t/p/original/hMTncCsOwZZCNOo5SBhE1wQKpid.jpg', 'The aging patriarch of an organized crime dynasty transfers control to his son.', 1, 6, 6),
    (7, 'pulp fiction', 'https://www.themoviedb.org/t/p/original/aVbuK7X3uKrAicSP7t7rIIwP0d2.jpg', 'Various interconnected stories of crime and redemption.', 1, 7, 7),
    (8, 'the lord of the rings: the fellowship of the ring', 'https://www.themoviedb.org/t/p/original/b4XZizlvqQkZno8cT3VPBYTGudB.jpg', 'A young hobbit embarks on a journey to destroy a powerful ring.', 1, 8, 8),
    (9, 'forrest gump', 'https://www.themoviedb.org/t/p/original/kbHlxmkVKDQrBXrKkh0nuIr4rSZ.jpg', 'The life journey of a kind-hearted and naive man through several decades of American history.', 1, 9, 9),
    (10, 'the matrix', 'https://www.themoviedb.org/t/p/original/dXNAPwY7VrqMAo51EKhhCJfaGb5.jpg', 'A computer hacker discovers a shocking truth about his reality.', 1, 10, 10);

Insert INTO TRAILER (ID, MOVIE_ID, VIDEO_LINK)
VALUES
    (1, 1, 'https://www.youtube.com/watch?v=YoHD9XEInc0'),
    (2, 2, 'https://www.youtube.com/watch?v=_PZpmTj1Q8Q'),
    (3, 3, 'https://www.youtube.com/watch?v=zSWdZVtXT7E'),
    (4, 4, 'https://www.youtube.com/watch?v=5PSNL1qE6VY'),
    (5, 5, 'https://www.youtube.com/watch?v=PLl99DlL6b4'),
    (6, 6, 'https://www.youtube.com/watch?v=UaVTIH8mujA'),
    (7, 7, 'https://www.youtube.com/watch?v=s7EdQ4FqbhY'),
    (8, 8, 'https://www.youtube.com/watch?v=V75dMMIW2B4'),
    (9, 9, 'https://www.youtube.com/watch?v=bLvqoHBptjg'),
    (10, 10, 'https://www.youtube.com/watch?v=vKQi3bBA1y8');

INSERT INTO GENRE (ID, MOVIE_ID, GENRE_NAME)
VALUES
    (1, 1, 'action'),
    (2, 2, 'action'),
    (3, 3, 'space'),
    (4, 4, 'friction'),
    (5, 5, 'thrill'),
    (6, 6, 'mafia'),
    (7, 7, 'friction'),
    (8, 8, 'friction'),
    (9, 9, 'story'),
    (10, 10, 'science');
