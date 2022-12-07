import React from 'react';
import logo from './logo.svg';
import './App.css';

import PersonCard from './components/MyComponent'

function App() {
  return (
    <div className="App">
      <PersonCard lastName = {"Hotari"} firstName = {"Amin"} age = {33} hairColor = {"brown"}/>
      <PersonCard lastName = {"Suhad"} firstName = {"Rami"} age = {36} hairColor = {"brown"}/>
      <PersonCard lastName = {"Dawahidi"} firstName = {"Husain"} age = {34} hairColor = {"Black"}/>
      <PersonCard lastName = {"Soboh"} firstName = {"Sami"} age = {35} hairColor = {"Black"}/>
    </div>
  );
}

export default App;
