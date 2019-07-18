SELECT m.Title, p.ProjectionDateTime, ch.Name, (ch.NumberOfSeats - SUM(r.NumberOfTickets)) AS 'Number of available tickets'
FROM reservation r
 INNER JOIN projection p ON r.ProjectionID = p.ProjectionID
 INNER JOIN movie m ON p.MovieID = m.MovieID
 INNER JOIN cinemahall ch ON p.CinemaHallID = ch.CinemaHallID
GROUP BY p.ProjectionID 