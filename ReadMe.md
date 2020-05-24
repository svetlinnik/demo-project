# Getting Started

### How to run
To run the application follow the following steps:
1. Run as Spring Boot application
2. Open a web browser
3. Go to url http://localhost:8080/calculate/BG?totalBudget=totalBudget&countryBudget=countryBudget&currency=currency
where:
* totalBudget(Integer) - total budget for neighbour countries trip.For example: 1200
* countryBudget(Integer) - budget per country.For example: 200
* currency(String)(Length = 3) - what currency are the budgets in.For example: EUR
4. Log in with Google account for the result
### Implementation notes
For this example the application supports only one starting country(BG) and the neighbour countries and exchange rates are mock data.
To make it apply to most countries and exchange rates external APIs had to be used.
