# Installation Instructions

1. Install [Eclipse](https://www.eclipse.org/downloads/packages/installer)
   - In this link, it will help you install the correct version of eclipse for your machine.
   - Make sure it is the Eclipse IDE of Java Developers. 
2. Importing Project
   - File -> import -> Git -> Project from Git(with smart import) -> cloneURI
   - Enter this link --> https://github.com/simransaini1999/students-shyftlabs.git
   - Enter Github your personal Github username
   - For password
        - Need to get Github to generate a personal access token
3. This version of code will need to run via tomcat server which needs to be installed on your machine.

   For Windows, you can use the 32-bit/64-bit Windows Service Installer</br>
   For Unix-based,</br>
      - Download Tomcat 10 Core tar.gz file</br>
      - Open Terminal and unarchive file</br>
      - sudo mkdir -p /usr/local</br>
      - sudo mv ~/Downloads/apache-tomcat-10.1.8 /usr/local</br>
      - Run startup.sh script Tomcat should be running on http://localhost:8080</br>
      - Run shutdown.sh to stop Tomcat</br>

   Configure Eclipse with Tomcat. In Java EE perspective, explore the Servers tab;</br>
      - Create a Web server, select Apache Tomcat 10.0 (point to the directory where you</br>
         unzipped Tomcat)</br>
      - Make sure to stop the Apache service when you first installed it, and run the Tomcat</br>
         v10.1 Server from Eclipse</br>
   

