SELECT m.Title, p.ProjectionDateTime, ch.Name, SUM(r.NumberOfTickets) AS 'Sold tickets'
FROM reservation r
 INNER JOIN projection p ON r.ProjectionID = p.ProjectionID
 INNER JOIN movie m ON p.MovieID = m.MovieID
 INNER JOIN cinemahall ch ON p.CinemaHallID = ch.CinemaHallID
GROUP BY p.ProjectionID
ORDER BY p.ProjectionDateTime