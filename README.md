# Process Scheduling Simulator

## Introduction

Process scheduling is an important part of an Operating System and has influence on the achieved CPU utilization, system throughput, waiting time and response time. The task of the scheduler is to decide which process will be run next, based on a list of processes which are ready to run. Multi-level Queue Scheduling Algorithm is used in scenarios where the processes can be classified into groups based on property like process type, CPU time, etc. Each queue is assigned a priority and has its own scheduling algorithm like Round-Robin or FCFS. In order for a process in the ready queue to execute, all the queues of priority higher than it should be empty, meaning
the process in those higher priority queues should have completed its execution.

### Assignment Requirements

You have been asked to simulate a **Multi-Level Queue**  algorithm. The simulation should allow the user the option to specify how many processes should be used at execution time. The simulation should automatically generate the processes and randomly assigned them a Process Type, Priority, Arrival and Burst Time. When the simulation completes a report should be generated to display the intervals that each process ran. This should be presented in a tabular format and also saved to a text file for subsequent retrieval and marking.

The *Process Control Block (PCB)* should include (at minimum) the following elements:

<table>
  <thead>
    <tr>
        <th colspan="3">PROCESS CONTROL BLOCK</th>
  	</tr>
    <tr>
    	<th>ITEM</th>
        <th>DESCRIPTION</th>
    	<th>GENERATED</th>
    </tr>
  </thead>
  <tbody>
   <tr>
    <td>Process Id</td>
    <td>Unique identifier for process</td>
    <td>a <i>unique</i> randomized integer between 0 and 20</td>
  </tr>
   <tr>
    <td>Process Type</td>
    <td>Type of process:
    	<ul>
        	<li>1 System</li>
            <li>2 Interactive</li>
            <li>3 Batch</li>
        </ul>
    </td>
    <td>a randomized selection from options</td>
  </tr>
   <tr>
    <td>Priority</td>
    <td>Importance of process:
    	<ul>
        	<li>1 High</li>
            <li>2 Medium</li>
            <li>3 Low</li>
        </ul>
    </td>
    <td>a randomized selection from options</td>
  </tr>
  <tr>
    <td>Burst Time</td>
    <td>CPU time needed to complete task</td>
    <td>a randomized integer between 1 and 10</td>
  </tr>
  <tr>
    <td>Arrival Time</td>
    <td>Time the process was created</td>
    <td>a randomized integer between 0 and 29</td>
  </tr>
  <tr>
    <td>Start Time</td>
    <td>Time the process first gets the CPU</td>
    <td></td>
  </tr>
   <tr>
    <td>End Time</td>
    <td>Time the process ends</td>
    <td></td>
  </tr>
  </tbody>
</table>

### Combination 

The lab tutor gave out 5 combinations of which each group should pick only ONE. 
For this project Combination 3 was choosen.

<table>
  <thead>
    <tr>
    	<th></th>
        <th>PROCESS TYPE</th>
    	<th>PRIORITY</th>
        <th>ALGORITHM</th>
    </tr>
  </thead>
  <tbody>
   <tr>
    <td rowspan="3"><b>Combination 3</b></td>
    <td>System</td>
    <td><center>1</center></td>
    <td>SRTF</td>
  </tr>
  <tr>
    <td>Interactive</td>
    <td><center>2</center></td>
    <td>RR - Q:2</td>
  </tr>
   <tr>
    <td>Batch</td>
    <td><center>3</center></td>
    <td>FCFS</td>
  </tr>
  </tbody>
</table>
