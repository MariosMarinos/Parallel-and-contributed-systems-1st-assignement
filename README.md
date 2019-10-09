# senario4
Marinos Marios Dai17147 

The solutions are extensions to the Imperial code.

Running the Senario 1 all threads start at the same time and seeing the results
we see all the threads passing at the same time so that leads in conflicts,
something we have been waiting for since we have not used mutual exclusion.

Running the Senario 2 we tart all threads at the same time and we observe that they are passing 
one by one so that means we have mutual exclusion, but we lack some kind of justice meaning that 
they can pass 3 blue and 0 red. The mutual exclusion is done with synchronized methods and wait-notify.

Running Scenario 3 we are starting all the threads and seeing the results we see, that they are passing
one at a time and there is some kind of justice as we observe a blue and a red are passing alternatively
, so we have secured some kind of synchronize and mutual exclusion with help of synchronized methods wait-notify, and
boolean variables to determine whose series is to pass.

Scenario 4 which is essentially a variant of Scenario 3 is the same with the difference that we have added some kind of adaptation to see when the cars of one side are more so that they keep their rows and pass over cars(threads) of the same color. it should be noted that if for example we have 3 blue cars and 2 red ones after a time, when new threads are starting to come within some time it will end up not giving time to red cars and only for blue as it will be always blue cars > red cars and the condition will never be true to change the turn. One solution is to change the turn after some specific time no matter how many cars are blue or red in order to give time to the other cars as well.
