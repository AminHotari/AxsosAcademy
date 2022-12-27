import logo from './logo.svg';
import './App.css';
import Main from './views/Main';
import Head from './components/Head';
import { Router } from '@reach/router';
import Create from './components/Create';
import Update from './components/Update';

function App() {
  return (
    <div className="App">
      <Head/>
      <Router>
        <Main path="/"/>
        <Create path="/new/"/>
        <Update path="/edit/:id/"/>
      </Router> 
    </div>
  );
}

export default App;
