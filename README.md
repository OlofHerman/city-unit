# City-Unit
Build the application in each subdirectory, alpha and beta, with the command:

`mvn clean package`

Then run

`docker-compose up`

in the root directory to build and start.

Endpoint to list city units:

* GET http://localhost:8080/alpha/units

Endpoint to update a city unit by id:

* PATCH http://localhost:8080/alpha/units/{id}

To add a number of visitors to all city units:

* PATCH http://localhost:8080/alpha/units/add-visitors/{number}

The Beta service runs a cron job every night at 3:00 that updates each city unit with a random number (1-1000) of visitors.
The default cron expression is: `0 0 3 * * ?`. To change the cron, call the endpoint:
* POST http://localhost:8081/schedule

with a new cron expression in the body. Example

``` 
    {
        "cronExpression": ""0/10 * * * * ?"
    }
```
This will make the job run every 10 minutes.