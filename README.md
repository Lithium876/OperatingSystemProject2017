# Process Scheduling Simulator

## Introduction

Process scheduling is an important part of an Operating System and has influence on the achieved CPU utilization, system throughput, waiting time and response time. The task of the scheduler is to decide which process will be run next, based on a list of processes which are ready to run. Multi-level Queue Scheduling Algorithm is used in scenarios where the processes can be classified into groups based on property like process type, CPU time, etc. Each queue is assigned a priority and has its own scheduling algorithm like Round-Robin or FCFS. In order for a process in the ready queue to execute, all the queues of priority higher than it should be empty, meaning
the process in those higher priority queues should have completed its execution.

### Assignment Requirements

You have been asked to simulate a Multi-Level Queue algorithm. The simulation should allow the user the option to specify how many processes should be used at execution time. The simulation should automatically generate the processes and randomly assigned them a Process Type, Priority, Arrival and Burst Time. When the simulation completes a report should be generated to display the intervals that each process ran. This should be presented in a tabular format and also saved to a text file for subsequent retrieval and marking.

The <i>Process Control Block (PCB)</i> should include (at minimum) the following elements:

|PROCESS CONTROL BLOCK                                                                             |
|:------------------------------------------------------------------------------------------------:|
| ITEM     | DESCRIPTION                      | GENERATED                                          |
|----------|:--------------------------------:|:--------------------------------------------------:|
|Process Id| Unique identifier for process    | a <i>unique</i> randomized integer between 0 and 20|
|Process Type| Type of Porcess:* 1 System     |  a randomized selection from options     |
