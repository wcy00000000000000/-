# To-do List Distributed Program compile and run guide
## Database configuration
Run the database.sql script with mysql to create the database of this program and change the value of DBUSER and DBPASSWORD and DBURL in the DatabaseConnection class in package dao based on your own local database configuration.
## Run the ORB server
Use command orbd -ORBInitialPort #{port} -ORBInitialHost #{host} to run your ORB server, the configured port and address should be used when configuring the server and client programs' used ORB server.
## Compile the program
Use command line and change directory to this project's root directory with the pom.xml maven configuration file, and use command mvn compile to compile the program.
## Run the server
Use command line and change directory to this project's root directory with the pom.xml maven configuration file, and use command mvn exec:java -Dexec.mainClass="server.Server" to run the server program.
## Run the client
Use command line and change directory to this project's root directory with the pom.xml maven configuration file, and use command mvn exec:java -Dexec.mainClass="client.Client" to run the client program. Use the client to do the operations required.