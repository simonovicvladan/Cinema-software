SELECT *
FROM reservation r
	INNER JOIN member me ON r.MemberID = me.MemberID
	INNER JOIN projection p ON r.ProjectionID = p.ProjectionID
	INNER JOIN movie m ON p.MovieID = m.MovieID
	INNER JOIN cinemahall ch ON p.CinemaHallID = ch.CinemaHallID
	INNER JOIN cinema.user u ON r.UserID = u.UserID
	

