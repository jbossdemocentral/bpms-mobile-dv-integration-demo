JBoss BPM Suite & Mobile Integration Demo
=========================================
This is the BPMS - Mobile integration demo that provides examples of human task integration, form designer
and REST Service Task.

The process is exposed via REST API for Red Hat Mobile Application Platform (MAP) to invoke, and then it invokes Unified Push Server's REST API.

![alt text](https://raw.githubusercontent.com/jbossdemocentral/bpms-mobile-dv-integration-demo/master/docs/architecture1.PNG?token=AA-PN4UWbNoRAYcuThQIapgJV755A4CKks5WMG_LwA%3D%3D "Insurance Architecture")  

Install on your machine
-----------------------
* Prerequisites:
	- If you would like the BPMS instance to be fully integrated with mobile over the Internet, your host or IP needs to be made accessible to Red Hat Mobile Application Platform, as well as connecting to Unified Push Server on OpenShift.
	- Download the products (BPMSuite v6.1.0 and EAP v6.4.0) from [Red Hat Customer Portal](https://access.redhat.com) if you haven't already.

1. [Download and unzip.](https://github.com/jbossdemocentral/bpms-mobile-dv-integration-demo/archive/master.zip)

2. Add products (BPMSuite v6.1.0 and EAP v6.4.0) to {path-to-project}/installs directory.

3. Run 'init.sh' or 'init.bat' file. 'init.bat' must be run with Administrative privileges.

4. Start JBoss BPMS Server by running 'standalone.sh' or 'standalone.bat' in the {path-to-project}/target/jboss-eap-6.4/bin directory.
   Use '-b {YourHostOrIP} -Dorg.uberfire.nio.git.daemon.host={YourHostOrIP} -Dorg.uberfire.nio.git.ssh.host={YourHostOrIP}' as the parameters in the startup.

5. Login to http://{YourHostOrIP}:8080/business-central  (u:bpmsAdmin / p:bpmsuite1!).

6. BPMS-Mobile demo pre-installed as project.

7. Read the documentation found in the docs directory & enjoy JBoss BPM Suite!

Notes
-----
This project is pre-loaded into the JBoss BPM Suite, after starting it you can login,
examine the process, form designer, human task, and REST Service Task.

To view the Push Notification on Android the settings from the UPS must be entered in the push-config.json file.  The Android Project under Projects should be imported in the Android Studio and run the Project to receive the notifications in the emulator.  See the supporting article for more specific detail on Push Notifications.

Supporting Articles
-------------------
- [Red Hat Mobile Application Platform - Connecting to JBoss BPMSuite REST (Special Edition for Red Hat Summit 2015!)](http://maggiechu-jboss.blogspot.com/2015/06/red-hat-mobile-app-connecting-to-bpms-rest.html)
- [Using the Red Hat Mobile Unified Push Server with BPMS](http://www.ossmentor.com/2015/10/using-unified-push-server-with-bpms.html)

Released versions
-----------------
See the tagged releases for the following versions of the product:

- v1.0 - JBoss BPM Suite 6.1.0 installer with BPMS-Mobile demo installed.
