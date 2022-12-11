import logo from './logo.svg';
import './App.css';
import React,{useState} from 'react';

import BoxGenerator from './components/BoxGenerator';
import ColorDisplay from './components/ColorDisplay';




function App() {
  // const [color1, setColor1] = useState("");

  const [box, setBox] = useState([]);

  const fun = (x)=> {
    setBox([...box,x]);
    // setBox(box.concat(x));

  }




  // const displayColor1 = (color2) => {
  //   setColor1(color2);
  // }
  
  return (
    <div className="App">
      <BoxGenerator  newBox={fun}/>
      <ColorDisplay  theBox={box}/>
    </div>
  );
};

export default App;
