JBoss BPM Suite & Mobile Integration Demo
============================
This is the BPMS - Mobile integration demo that provides exammples of human task integration, form designer
and REST Service Task.

There is options available to you for using this demo; .


Option 1 - Install on your machine
----------------------------------
1. [Download and unzip.](https://github.com/jbossdemocentral/bpms-rewards-demo/archive/master.zip)

2. Add products to installs directory.

3. Run 'init.sh' or 'init.bat' file. 'init.bat' must be run with Administrative privileges.

4. Start JBoss BPMS Server by running 'standalone.sh' or 'standalone.bat' in the <path-to-project>/target/jboss-eap-6.4/bin directory.

5. Login to http://<host>:8080/business-central  (u:bpmsAdmin / p:bpmsuite1!).

6. BPMS-Mobile demo pre-installed as project.

7. Read the documentation found in the docs directory & enjoy JBoss BPM Suite!

Notes
-----
This project is pre-loaded into the JBoss BPM Suite, after starting it you can login,
examine the rule, process, and data model from within the various product components.

After claiming the user task as a manager (to approve or deny the award), if task completion takes longer
than 1 minutes it will te reassigned back into the group so other managers can claim it. The short time frame
of 1 minutes is for demo purposes, should talk about days to complete instead as if a manager that claimed a
task got sick and failed to complete the claimed task.

Optional: A task notification has also been setup to alert the members of the group responsible if a task sits longer than 2 minutes
without being started (claimed). This is an email notification which you can view using the provided simple java SMTP server 
'fakeSMTP.jar' (from https://nilhcem.github.io/FakeSMTP), just start as root/admin user to catch sent notifications in the
mailbox window provided:

   ```
   $ sudo java -jar support/fakeSMTP.jar 
   ```

   In fakeSMTP GUI click 'START SERVER' button or you will get 'Could not connect to SMTP host' errors. This does not prevent 
   the process from working, it just fails to send an email notification.

There is a workshop [available online](http://bpmworkshop-onthe.rhcloud.com) that will show you how to build this demo from scratch. 


Supporting Articles
-------------------
- [Red Hat Mobile Application Platform - Connecting to JBoss BPMSuite REST (Special Edition for Red Hat Summit 2015!))](http://maggiechu-jboss.blogspot.com/2015/06/red-hat-mobile-app-connecting-to-bpms-rest.html)

Released versions
-----------------
See the tagged releases for the following versions of the product:

- v1.0 - JBoss BPM Suite 6.1.0 installer with BPMS-Mobile demo installed.