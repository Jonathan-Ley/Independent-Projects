README FOR EMPLOYEE-MANAGEMENT-SYSTEM:

I will be sharing the technologies, approaches and the problems / blockers that I encounter as I practice and learn to make an employee management system that will have a frontend, backend, and a MySQL database.

So far I'm making decent progress with the management system. I was able to have a controller, a service, an entity, a model, and a repository to my backend api. It took awhile though to figure out how everything was interconnected with the annotations. In addition, I kept failing the connection to the database, receiving a 500 error status code. I eventually figured it out via creating a new instance of EmployeeEntity in my createEmployee method. I had it originally set to null therefore not able to save the instance with the properties.

In regards to the frontend, I had an axios error, but it was able to be fixed by adding the @CrossOrigins annotation in the api as well as adding the "http://" prefix to the BASE_URL variable within the services file. The solution, however, took me almost an hour to solve it.

Steps to run:

1. cd into ~/Independent-Projects/employee-management/frontend
2. type npm run start in the command prompt
3. cd into ~/Independent-Projects/employee-management/backend in Intellij
4. start the spring boot application
5. open the MySQL workbench and navigate to the employee_records schema
