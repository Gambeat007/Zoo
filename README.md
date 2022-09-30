# Zoo
Tech stack: 
SpringBoot, H2 DB, Rest Api, Maven, Swagger 

Method    Url                                   Action

GET       /zoo/animals                          retrieve all animals in the zoo
GET       /zoo/animals/{name}                   retrieve animal(s) by :name
POST      /zoo/animals                          create animal and add it to :area
GET       /zoo/areas                            retrieve all areas in the zoo
GET       /zoo/areas/{areaId}                   retrieve all animals from specific area by :area_id
GET       /zoo/areas/least-populated            retrieve area with smallest population
GET       /zoo/areas/greatest-food-consumption  retrieve specific area with greatest food consumption, along with the animals
POST      /zoo/areas                            create area in the zoo

Just in case: 
SwaggerUi Url:    http://localhost:8080/swagger-ui/index.html
H2Console Url:    http://localhost:8080/h2-ui/
