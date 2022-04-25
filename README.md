Tests are not covering all project.

I used https://www.convertcsv.com/csv-to-sql.htm this web page to convert csv to sql

## Postman EndPoints Link <br>
open Postman-import-link-paste <br>
https://www.getpostman.com/collections/a8e5c0a0cfca9dedfc67
## Available end-points
<b> Host: localhost:8080 </b>


#### a) returns all users who have actually borrowed at least one book
```
GET http://localhost:8080/v1/user
```

#### d) returns all books borrowed by a given user in a given date range
```
GET http://localhost:8080/v1/book HTTP/1.1
Content-Type: application/json
{
    "userName": "Chish,Elijah",
    "borrowedFrom": "2021-05-11",
    "borrowedTo": "2021-06-05"
}
```


Kaan Kalan