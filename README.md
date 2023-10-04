# spring-boot-mongodb

## Classes Diagram
```mermaid
graph LR
  User["User<br/>-id: String<br/>-name: String<br/>-email: String"]
  Post["Post<br/>-id: String<br/>-date: String<br/>-title: String<br/>-body: String"]
  Comment["Comment<br/>-id: String<br/>-text: String<br/>-date: Instant"]

  User --> |1..*| Post
  Post -.->|1..*| Comment
  Post -.->|1| User
  Comment -.->|1| User
```
