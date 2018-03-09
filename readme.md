# Health Application 
Sample dropwizard application to facilitate health requirement.

# IntellijIdea
- mvn clean install
    - mvn idea:idea
    - Run/Debug Configuration -> Application
        - Name: health
        - MainClass: com.india.care.HealthApplication
        - Program Arguments: server src/main/resources/config/config.yml
        - Working Dir: <path to git root>
        - classpath of module: health
        - check the top right box (single instance only), [this will avoid accidental startup on same port]
