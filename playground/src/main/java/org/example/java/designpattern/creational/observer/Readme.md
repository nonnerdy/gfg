👉 Intent:
Defines a one-to-many dependency between objects so that when one object (Subject) changes state, all its dependents (Observers) are notified automatically.

👉 Real-world use cases:

Event listeners in GUI frameworks (Swing, JavaFX).

Notification systems (YouTube subscriber model).

Publish/Subscribe in messaging (Kafka, RabbitMQ).

Microservices event-driven communication.

🔹 Key Points:

Subject (Publisher/Channel) → keeps track of observers and notifies them.

Observer (Subscriber/User) → gets updates when subject changes.

Loose coupling → Subject doesn’t know exact implementation of observers.

⚡ Interview Tip:

Mention Observer in Java’s standard libraries:

java.util.Observer and java.util.Observable (deprecated but concept is same).

Event Listeners in Swing/AWT.

Used heavily in Microservices with Pub/Sub.