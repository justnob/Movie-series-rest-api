
INSERT INTO RATE (ID, RATING)
VALUES
    (1001, 8.8),
    (1002, 9.0),
    (1003, 8.6),
    (1004, 7.8),
    (1005, 9.3),
    (1006, 9.2),
    (1007, 8.9),
    (1008, 8.8),
    (1009, 8.8),
    (1010, 8.7);




INSERT INTO Movie (ID, Name, IMAGE_URL, DESCRIPTION, NUMBER_OF_EPISODES, AIR_DATE, END_DATE, RATE_ID)
VALUES
    (1, 'inception', 'https://www.themoviedb.org/t/p/original/8IB2e4r4oVhHnANbnm7O3Tj6tF8.jpg', 'A mind-bending action thriller about dream infiltration.', 1, CURRENT_DATE(), CURRENT_DATE(), 1001),
    (2, 'the dark knight', 'https://www.themoviedb.org/t/p/original/eP5NL7ZlGoW9tE9qnCdHpOLH1Ke.jpg', 'Batman faces the Joker in a battle for Gotham City.', 1, CURRENT_DATE(), CURRENT_DATE(), 1002),
    (3, 'interstellar', 'https://www.themoviedb.org/t/p/original/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg', 'A journey through space and time to find a new habitable planet.', 1, CURRENT_DATE(), CURRENT_DATE(), 1003),
    (4, 'avatar', 'https://www.themoviedb.org/t/p/original/kyeqWdyUXW608qlYkRqosgbbJyK.jpg', 'A marine on an alien planet becomes torn between two worlds.', 1, CURRENT_DATE(), CURRENT_DATE(), 1004),
    (5, 'the shawshank redemption', 'https://www.themoviedb.org/t/p/original/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg', 'A tale of friendship and redemption in a prison.', 1, CURRENT_DATE(), CURRENT_DATE(), 1005),
    (6, 'the godfather', 'https://www.themoviedb.org/t/p/original/hMTncCsOwZZCNOo5SBhE1wQKpid.jpg', 'The aging patriarch of an organized crime dynasty transfers control to his son.', 1, CURRENT_DATE(), CURRENT_DATE(), 1006),
    (7, 'pulp fiction', 'https://www.themoviedb.org/t/p/original/aVbuK7X3uKrAicSP7t7rIIwP0d2.jpg', 'Various interconnected stories of crime and redemption.', 1, CURRENT_DATE(), CURRENT_DATE(), 1007),
    (8, 'the lord of the rings: the fellowship of the ring', 'https://www.themoviedb.org/t/p/original/b4XZizlvqQkZno8cT3VPBYTGudB.jpg', 'A young hobbit embarks on a journey to destroy a powerful ring.', 1, CURRENT_DATE(), CURRENT_DATE(), 1008),
    (9, 'forrest gump', 'https://www.themoviedb.org/t/p/original/kbHlxmkVKDQrBXrKkh0nuIr4rSZ.jpg', 'The life journey of a kind-hearted and naive man through several decades of American history.', 1, CURRENT_DATE(), CURRENT_DATE(), 1009),
    (10, 'the matrix', 'https://www.themoviedb.org/t/p/original/dXNAPwY7VrqMAo51EKhhCJfaGb5.jpg', 'A computer hacker discovers a shocking truth about his reality.', 1, CURRENT_DATE(), CURRENT_DATE(), 1010);


