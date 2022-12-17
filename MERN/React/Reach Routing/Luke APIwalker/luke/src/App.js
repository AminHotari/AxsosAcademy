import logo from './logo.svg';
import './App.css';
import { Router } from '@reach/router';

import Home from './components/Home';
import DisplayHome from './components/DisplayHome';

function App() {
  return (
    <div className="App">
      <Home/>
      <Router>      
        <DisplayHome path="/:type/:id" />
      </Router>
    </div>
  );
}

export default App;
