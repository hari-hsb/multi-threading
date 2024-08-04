Thread Termination: why and when
-----------------------------------
**why??**
Thread consume memory and CPU

**when??**
1. if a thread finishes its works, But the application is Still running then:
    need to release the thread resources
2. if a thread is misbehaving need to terminate the thread
    eg: Runs a calculation for very long time exceeding the allowed time
3. By default, Application runs if any thread is running even if the **Main** thread is not running

**How??**

Thread.interrupt();

when can we interrupt:
1. if a thread is executing a method that throws an _InterruptedException_
2. if the Threads code is handling the Interrupt signal Explicitly

**Deamon Thread :**
Background Thread that dont prevent the application from exiting if the main thread terminates
eg: some background task that should not block our app from termination (file saving thread in Text editor) 