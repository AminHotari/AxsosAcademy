import logo from './logo.svg';
import './App.css';
import React,{useState} from 'react';

import Tabs from './components/Tabs';
// import DisplayTabs from './components/DisplayTabs';






function App() {
  // const [text, setText] = useState("");
  
  return (
    <div className="App">
      <Tabs listOfTabs={[{name: "Tab1", content: "Tab1 content is showing here"},
    {name:"Tab2",content:"Tab2 content is showing here"},{name:"Tab3", content:"Tab3 content is showing here"}]}/>

    {/* <DisplayTabs theText={text}/> */}
    </div>
  );
};

export default App;
