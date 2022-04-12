## Topics

1. Normalization (1NF, 2NF, 3NF, BCNF) (ref: GFG)
2. Rdbms Architecture
3. SQL
4. Master, History, Transaction tables, Fact tables - Data modeling
5. All types of keys



## Cloud Technologies - GCP
1. Cloud SQL - RDBMS
2. Cloud Storage - HDFS
3. Big Query - NoSQL


Streaming:
1. Stateful

1 micro batch processed ->
input data -> which state to be updated ???

Spark ->

def mapWithState(lambda function (K,V)): State = {

}
val state: State = ???

state.existKey()

p1 = ProcessedData(India, 10, 0, 2M) = STATE = memory

2 micro batch processed ->
p2 = ProcessedData(India, 0, 5, 3.5M) = STATE = memory

as soon as state is updated -> write it to secondary storage (Rdbms, NoSQL, HDFS)


case class ProcessedData (country: String, profit: Profit, loss: Loss, revenue: Int) - memory

case class Profit (profit: Int)
