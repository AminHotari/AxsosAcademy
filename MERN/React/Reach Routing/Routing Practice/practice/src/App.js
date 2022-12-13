import logo from './logo.svg';
import './App.css';
import { Router } from '@reach/router';

import Home from './components/Home';
import Color from './components/Color';
import Dash from './components/Dash';
import Write from './components/Write';

function App() {
  return (
    <div className="App">
      <Router>
        <Dash path="/"/>
        <Home path="/home"/>
        <Write path="/:write"/>
        <Color path="/:word/:color1/:color2"/>
      </Router>
    </div>
  );
}

export default App;
