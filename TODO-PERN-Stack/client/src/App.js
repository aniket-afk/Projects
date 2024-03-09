import React, { Fragment } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import InputTodo from './components/InputTodo';

function App() {
  return (
    <Router>
      <Switch>
        <Route exact path="/">
          <InputTodo />
        </Route>
        {/* Add more routes as needed */}
      </Switch>
    </Router>
  );
}

export default App;
