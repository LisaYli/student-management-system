Create student:
POST http://localhost:8080/student-management-system/api/v1/students/new

Json body:

{
"email": "lisa.ylikangas@iths.se",
"firstname": "Lisa",
"lastname": "Ylikangas",
"phoneNumber": "0725052055"
}

-----------------------------------
Get all students:
GET http://localhost:8080/student-management-system/api/v1/students/getall

-------------------------------------
Get student by id:
GET http://localhost:8080/student-management-system/api/v1/students/{id}

------------------------------
Get student by lastname:
GET http://localhost:8080/student-management-system/api/v1/students/{lastname}

--------------------------------------
update firstname:
Patch http://localhost:8080/student-management-system/api/v1/students/firstname/{id}

Json body:
{
"firstname":"lisa"
}


update lastname:
Patch http://localhost:8080/student-management-system/api/v1/students/lastname/{id}

Json body:
{
"lastname":"ylikangas"
}

--------------------------------------
update email:
Patch http://localhost:8080/student-management-system/api/v1/students/email/{id}

Json body:
{
"email:":"lisa@iths.se"
}
