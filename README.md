## Please follow below steps to the run this application

1. Import this project to Eclipse or STS editor
2. goto Windows menu>preference>choose Maven>Java EE Integration>uncheck the WAR project Preferences()
3. Build this project (right click on this project and use run as Maven Build with command "clean install")
4. Add tomcat server (window -> show view -> servers) to workspace by right clicking on server view then select new to add new server
5. Right click on server then select "Add and Remove.." to add WordList to the configurred section
6. Right click on server then select publish
7. Right click on server then select Start
8. Once server started visit  http://localhost:8080/WordList to view landing page
