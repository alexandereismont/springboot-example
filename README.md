Adding a new person:
http://localhost:8080/person/add
example input: 
{
	"firstName":"Ole",
	"lastName":"Nordman"
}

Get a list of all people in the database: 

http://localhost:8080/person/all

Update a existing person:

http://localhost:8080/person/update-name

Example input:
{
	"personId": <id>,
	"newFirstName": "Elise",
	"newLastName": "Nordman"
}
	
Add an activity to a person:

http://localhost:8080/activity/add

{
	"activityName": "swimming",
	"personId": <id>
}

Get all activities for a person:

http://localhost:8080/person/get-activities

example input 
{
	"personId": <id>
}
