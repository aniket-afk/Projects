# TODO PERN Stack Project

This is a simple TODO application built using the PERN stack (PostgreSQL, Express.js, React.js, Node.js).

## Features

- **User Authentication:** Users can sign up, log in, and log out securely.
- **Create, Read, Update, Delete (CRUD) Operations:** Users can add, view, edit, and delete tasks.
- **Task Filtering and Sorting:** Users can filter tasks based on categories or tags, and sort tasks by priority or due date.
- **Responsive Design:** The application is responsive and can be accessed from various devices.

## Technologies Used

- **Frontend:**
  - React.js
  - HTML/CSS
  - JavaScript
  
- **Backend:**
  - Node.js
  - Express.js
  
- **Database:**
  - PostgreSQL
  
## Installation

To run this project locally, follow these steps:

1. Clone the repository:

```
git clone https://github.com/your-username/todo-pern-stack.git
```

2. Navigate to the project directory:

```
cd todo-pern-stack
```

3. Install dependencies:

```
npm install
```

4. Set up the PostgreSQL database:
   - Create a database named `todo_database`.
   - Import the database schema from the provided SQL file (`todo_database.sql`).
   
5. Start the server:

```
npm start
```

6. Start the client:

```
cd client
npm start
```

7. Open your web browser and visit [http://localhost:3000](http://localhost:3000) to view the application.

## Usage

- Sign up or log in to your account.
- Add new tasks with titles, descriptions, priorities, due dates, and categories.
- View, edit, or delete existing tasks.
- Filter tasks by categories or tags, and sort tasks by priority or due date.
