## Command line to execute benchmark first step

```
java -cp "target/classes/;target/dependency/*;target/lib/*" -Dprop=run/mysql/mysql.properties -DcommandFile=run/mysql/sqlTableCreates.sql com.github.benchmarksql.ExecJDBC
```

/**
Run the Loader command file to load all of the default data for a benchmark.
Approximately half a million rows (per warehouse) will be loaded across 9 tables.
To run the following command, indicating the quantity of warehouses:
*/

```
java -cp "target/classes/;target/dependency/*;target/lib/*;target/run/mysql/*" -Dprop=run/mysql/mysql.properties com.github.benchmarksql.LoadData \ numWarehouses 1
```