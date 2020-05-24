# Getting Started

### How to run
To run the application follow the following steps:
1. Run as Spring Boot application
2. Open a web browser
3. Go to url http://localhost:8080/calculate/BG?totalBudget=<totalBudget>&countryBudget=<budget>&currency=<currency>
3.1 Input following data:
* totalBudget(Integer) - total budget for neighbour countries trip
* countryBudget(Integer) - budget per country
* currency(String) - what currency are the budgets in
4. Log in with Google account for the result
### Implementation notes
For this example the application supports only one starting country(BG) and the neighbour countries and exchange rates are mock data.
To make it apply to most countries and exchange rates external APIs had to be used.
