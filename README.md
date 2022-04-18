BenchmarkSQL
============

BenchmarkSQL runs a TPC-C like test against relational databases to compare
performance across versions, settings, and vendors.
This application is supported by different database manager systems:

 * PostgreSQL.
 * IBM Db2 (LUW).

This tool can be easily extended to use another RDBMS.
You can check the documentation to know how to port it.

* Access the [Wiki](https://github.com/ECI-SGBD/BenchmarkSQL-4/wiki).
* Reading the HOW-TO-RUN files under the `docs` directory.

This is a fork of the BenchmarkSQL 4.
BenchmarkSQL has most recent versions;
however, in order to port
[BenchmarkSQL 5](https://github.com/petergeoghegan/benchmarksql) to any RDBMS,
it requires some changes at the Java code to make it work and
[BenchmarkSQL 6](https://github.com/pgsql-io/benchmarksql) is still in
development, which implies the documentation is still limited.
For this reason, these newer versions are not as generic as the 4th one where
you only need to adapt the sql files.

BenchmarkSQL is open source, distributed under the GNU General Public License
version 2.0 (GPLv2) license.

Instructions for running BenchmarkSQL on MySQL
----------------------------------------------

# Requirements

These are the requirements to run this application:

* Use of JDK7.
* Maven to build the sources.
* MySQL database.

## Maven build

This project is configured with Maven, you just need to build the package and
then change to `target` directory:

    mvn clean install

## Create a database and the credentials to access

As the user `root`, create the `benchmarksql` user with correct permissions.

	mysql> CREATE USER 'benchmarksql'@'localhost' IDENTIFIED BY 'password';
	mysql> CREATE DATABASE benchmarksql;
	mysql> GRANT ALL PRIVILEGES ON *.* TO 'benchmarksql'@'%';
	mysql> GRANT ALL ON *.* TO 'benchmarksql'@'%';
	mysql> FLUSH PRIVILEGES;

# Adjust the BenchmarkSQL configuration file

A sample JDBC connection property files is provided for MySQL called
`mysql.properties`.

Go to the `run/mysql` directory, edit the `mysql.properties` file to point to
the database instance you would like to test, go to the root project.

    cd run\mysql
    vi mysql.properties
    
Set the following configuration on `mysql.properties`. 

```
driver=com.mysql.cj.jdbc.Driver
conn=jdbc:mysql://localhost:3306/benchmarksql?useServerPrepStmts=true
user=benchmarksql
password=password

warehouses=1
terminals=1
// To run specified transactions per terminal- runMins must equal zero.
runTxnsPerTerminal=10
// To run for specified minutes- runTxnsPerTerminal must equal zero.
runMins=0
// Number of total transactions per minute.
limitTxnsPerMin=300

// The following five values must add up to 100.
// The default percentages of 45, 43, 4, 4 & 4 match the TPC-C spec.
newOrderWeight=45
paymentWeight=43
orderStatusWeight=4
deliveryWeight=4
stockLevelWeight=4
```

# Build the schema and initial database load

Change to the `run/mysql` directory.

    cd run
    cd mysql

Execute the `sqlTableCreates.sql` to create the base tables.

_Windows:_

    runSQL mysql\mysql.properties mysql\sqlTableCreates.sql

If the last command doesn't work, go back to the root project and use the following command: 

```
java -cp "target/classes/;target/dependency/*;target/lib/*" -Dprop=run/mysql/mysql.properties -DcommandFile=run/mysql/sqlTableCreates.sql com.github.benchmarksql.ExecJDBC
```


_Linux:_

    ./runSQL mysql/mysql.properties mysql/sqlTableCreates.sql

Run the Loader command file to load all of the default data for a benchmark.

 * Approximately half a million rows (per warehouse) will be loaded across 9
 tables.

To run the following command, indicating the quantity of warehouses:

_Windows:_

    runLoader mysql\mysql.properties numWarehouses 1
    
If the last command doesn't work, go back to the root project and use the following command:    
```
java -cp "target/classes/;target/dependency/*;target/lib/*;target/run/mysql/*" -Dprop=run/mysql/mysql.properties com.github.benchmarksql.LoadData \ numWarehouses 1
```
    


_Linux:_

    ./runLoader mysql/mysql.properties numWarehouses 1

NOTE: You should run the `sqlTableTruncates.sql` script if your tables are not
already empty.
      
 * Alternatively, you may choose to generate the load data out to CSV files
 where it can be efficiently bulk loaded into the database as many times as
 required by your testing.

To run the following command, indicating the location of the files.

_Windows:_

    runLoader mysql\mysql.properties numWarehouses 1 fileLocation c:\tmp\csv   

_Linux:_

    ./runLoader mysql/mysql.properties numWarehouses 1 fileLocation /tmp/csv/   

These CSV files can be bulk loaded as follows:

_Windows:_

    runSQL mysql\mysql.properties mysql\sqlTableCopies.sql

_Linux:_

    ./runSQL mysql/mysql.properties mysql/sqlTableCopies.sql

You may truncate the data via:

_Windows:_

    runSQL mysql\mysql.properties mysql\sqlTableTruncates.sql

_Linux:_

    ./runSQL mysql/mysql.properties mysql/sqlTableTruncates.sql

In both cases, run the `runSQL` command file to execute the SQL script
`sqlIndexCreates.sql` to create the primary keys & other indexes on the tables.

_Windows:_

    runSQL mysql\mysql.properties mysql\sqlIndexCreates.sql

_Linux:_

    ./runSQL mysql/mysql.properties mysql/sqlIndexCreates.sql

When you restart the test, and you will reload the data, you could delete the
indexes before this:

_Windows:_

    runSQL mysql\mysql.properties mysql\sqlIndexDrops.sql

_Linux:_

    ./runSQL mysql/mysql.properties mysql/sqlIndexDrops.sql

# Run the configured benchmark

Run the `runBenchmark` command file to test the database.
This command will create terminals and automatically start the transaction
based on the parameters set in `mysql.properties`. 

_Windows:_

    runBenchmark mysql\mysql.properties

_Linux:_

    ./runBenchmark mysql/mysql.properties

# Scale the benchmark configuration

ToDo

# Clean the environment

To clean the database, you can run.

_Windows:_

    runSQL mysql\mysql.properties mysql\sqlTableDrops.sql

_Linux:_

    ./runSQL mysql/mysql.properties mysql/sqlTableDrops.sql


