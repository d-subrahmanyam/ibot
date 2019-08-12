# iBot

This is a slack bot built using Spring Boot and [jslack](https://github.com/seratch/jslack). 


# How to run the application?

- Please do set an environment variable `SLACK_SIGNING_SECRET` 
- Please modify/update the `accessToken`, `botAccessToken` and `signingSecret` values of the `src/main/java/com/subbu/ibot/utils/SlackConfiugration.java` file.
- To run the app - `mvn clean spring-boot:run`

# Thanks 

- The credit should go to [Kazuhiro Sera](https://github.com/seratch). 