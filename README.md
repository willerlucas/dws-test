# Routes

## Bands
GET /api/bands/
Returns all available bands.
The "order" (ordering, A=Alphabetic, P=Popularity) and "bandName" parameters can be added in order to filter the results.

/api/bands?order=A&bandName=Tenacious

GET /api/bands/{id}
Returns a specific band with their album list

## Album
GET /api/albums/
Returns all registered albums
