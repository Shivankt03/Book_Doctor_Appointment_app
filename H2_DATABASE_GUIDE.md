# H2 Database Setup and Usage Guide

## Overview
This application uses H2 in-memory database for development and testing purposes. The database is automatically configured and ready to use.

## Configuration

### Main Application Properties
The H2 database is configured in `src/main/resources/application.properties`:

```properties
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:learning_spring12
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# H2 Console Configuration
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA and Hibernate Configuration
spring.jpa.hibernate.ddl-auto=create
spring.jpa.generate-ddl=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## How to Access H2 Console

1. **Start the application** by running the main class `DRschedulingApplication`
2. **Open your browser** and go to: `http://localhost:8080/h2-console`
3. **Login with these credentials**:
   - JDBC URL: `jdbc:h2:mem:learning_spring12`
   - Username: `sa`
   - Password: (leave empty)

## API Endpoints

The application provides REST API endpoints for journal entries:

- `GET /journal` - Get all journal entries
- `POST /journal` - Create a new journal entry
- `GET /journal/id/{id}` - Get a specific journal entry by ID
- `PUT /journal/id/{id}` - Update a journal entry
- `DELETE /journal/id/{id}` - Delete a journal entry

## Sample Data

The application automatically loads sample data when it starts. You can see this in the console output:
```
Sample data loaded into H2 database!
```

## Testing

Run the tests to verify H2 database functionality:
```bash
mvn test
```

## Troubleshooting

### Common Issues:

1. **H2 Console not accessible**:
   - Make sure the application is running
   - Check that `spring.h2.console.enabled=true` in application.properties
   - Verify the console path is `/h2-console`

2. **Database connection errors**:
   - Ensure H2 dependency is in pom.xml
   - Check that Spring Data JPA dependency is included
   - Verify entity annotations are correct

3. **Entity not found**:
   - Make sure `@EntityScan` and `@EnableJpaRepositories` are configured in main class
   - Check that entity classes have proper JPA annotations

## Database Schema

The application creates a `journal_entries` table with the following structure:
- `id` (Long, Primary Key, Auto-generated)
- `title` (String, Not Null)
- `content` (TEXT)
- `date` (TIMESTAMP)

## Development Notes

- The database is in-memory, so data is lost when the application stops
- Use `spring.jpa.hibernate.ddl-auto=create` to recreate tables on each startup
- For production, consider switching to a persistent database like PostgreSQL or MySQL
