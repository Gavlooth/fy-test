Implementation details for fy application

The application should consist of the following parts:

#User authentication/authorization
* Simple ring season authentication/authorization, could be implemented
although for a mobile app some token based authentication should also be
considered. buddy is a decent library for that purpose.
* User information including email and (encrypted) password  can be stored in a
table on relational database. Password reset tokens with expiration date information can
also be stored. Any sql dsl on clojure would do that. I favor  either
hugsql/yesql or honeysql if more flexibility is needed.


#Transaction managment

* Another table should hold transaction history for the users.
The product could be stored on a relational database, although non sql  like
mongodb might be more aprropriate. If a nonsql is used, user subscription infor
mation can be stored directly on the product entry, if not a second table should
be queried and updated everytime a transaction or product udpate takes place
* SendGrid Api handlers could be implemented as callbacks to notify user of the
status of their orders.
* Rest api endpoints would curry db updates user authentication etc etc .



