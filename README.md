# JavaFX Chat App Assignment

Create a JavaFX chat application using MQTT and GSON.

You can reuse most of your code from the `Cards Against Teachers` assignment.

## Login Screen

Create a login screen that allows the user to enter his/her nickname. Create a `User` class that stores the nickname and pass an instance of this class to the next scene.

## Chat Screen

The chat screen should allow the user to chat within a channel.

## MQTT and JSON

The actual communication should happen using MQTT. You can make use of the `SimpleMQTTClient` library (see gitbook) for this.

The transmitted data should be formatted using JSON. You can make use of the GSON library for this (see gitbook).

## Extra's

The chat channel can also be used for other information besides chat messages. User could also publish join en leave messages for example. Feel free to implement this as an extra.

You can also create a user profile that is published when joining a channel.

You could also introduce special commands that start with slash `/` to for example whisper a message to someone in the channel.

Just make sure to document your application so the user knows how it works.