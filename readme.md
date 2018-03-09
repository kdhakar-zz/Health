# Health Application 

This will be my part time work for betterment of health in India. This project contains 2 major components.
# Components
1. **Frontend**: Website (mobile application later).
2. **Backend**: Rest based application.

# Entities/Features.
1. **Hospital**: This component will include various feature to manage hospital infrastructure and drug inventories. 
2. **Patient**: This component will have features for patients so that they can have a smooth experience than ever.
3. **Doctor**: This component will have features for doctors so that they can manage their time and serve patients better.
4. **Drugs**: This component will have feature to manage drugs inventory.
5. **Infrastructure**: This component will have feature to manage hospital infrastructure.


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
