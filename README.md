# Zoo
Tech stack: SpringBoot, H2 DB, Rest Api, Maven, Swagger 

AnimalController:
Method    Url                                   Action
GET       /api/animals                          retrieve all animals
GET       /api/animals/name                     retrieve animal(s) by :name
POST      /api/animals                          create animal and add it to :area

AreaController:
GET       /api/areas                            retrieve all zoo areas
GET       /api/areas/id                         retrieve all animals from specific area by :area_id
GET       /api/areas/leastPopulated             retrieve area with smallest animal population
GET       /api/areas/greatestFoodConsumption    retrieve area with greatest food demands
POST      /api/areas                            create area in the zoo

Just in case: 
SwaggerUi Url:    http://localhost:8080/swagger-ui/index.html
H2Console Url:    http://localhost:8080/h2-ui/
