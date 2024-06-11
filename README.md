Main class is under challenge-crud-application module on com.challenge.crud.application package.

Right now is configured with an H2 DB in Memory.

These are some api calls to test the functionality.

To create users:
http://localhost:8080/api/user/create/axmendez/amendez@gmail.com/passw1/3/1981-09-24/1111
http://localhost:8080/api/user/create/axmendez2/amendez@gmail.com/passw2/3/1981-09-24/1111
http://localhost:8080/api/user/create/axmendez3/amendez@gmail.com/passw3/3/1981-09-24/1111
To update users:
http://localhost:8080/api/user/update/3/amendez3/amendez@gmail.com/passw3/3/1981-09-24/1111
To find users:
http://localhost:8080/api/user/findById/3
To delete users:
http://localhost:8080/api/user/deleteById/2
