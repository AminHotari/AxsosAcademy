import React,{useState} from 'react'

const BoxGenerator = (props) => {
    const [color, setColor] = useState("");
    // const [box, setBox] = useState([]);

    const addColor = (e) =>{
        e.preventDefault();
        // props.newColor(color);
        props.newBox(color)
    }

  return (
    <form onSubmit={addColor}>
        <h3>Color</h3>
        <input type="text" onChange={(e) => setColor(e.target.value) }/>
        <input type="submit" value="Add" />
        <hr></hr>
    </form>
  )
}

export default BoxGenerator
