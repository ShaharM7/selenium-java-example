# GE-HealthCare

You need to complete the below home assignment and be ready to present results. The project should be completed within 3
days.

Please carefully read the guidelines for the exercises and be sure that all is clear.

Feel free to ask questions if something is unclear.

General guidelines:

Create a maven project
Use Java8
Push the project into GitLab.
Share the link to the project and make sure it has an access right.

Exercises:


1. Web - Create TestNG test and run it:

a. Open browser (any browser that you want)

b. Go to https://opensource-demo.orangehrmlive.com/

c. Login with credentials appears on site

d. Go to "Time" in left options bar

e. Under section of "Timesheets Pending Action" section, click view for “Timesheet period” of 2022-08-15 - 2022-08-21

f. Click on the green comment button in the first row (see pic below * )

g. Print the text in comment and compare to text – “Leadership Development”

h. Think about negative test and implement it



2. Create RESTful API test for ‘restful-booker’
a. Use the following API documentation - https://restful-booker.herokuapp.com/apidoc/index.html

b. Do 3 actions with help of this API (use JSON format for requests/response):

1.       Create new booking entry with your name – verify booking created with provided details in request and print the response

2.       Get newly created booking entry – verify it’s possible to retrieve the booking and print the response

3.       Update your booking with any information you would like to - verify booking was updated with provided data and print the response

4.       Delete your booking - verify booking was deleted and print the response

Bonus question:

3. Create Gitlab public project
a. Acquire shared docker runner (i.e., use one of the default publics GitLab allows)

b. Create .gitlab-ci.yml file in project

c. Make sure CI/CD pipeline works

d. Show tests run in a pipeline in CI/CD of the Gitlab project.



![](../../Users/shaha/Downloads/image001.png)