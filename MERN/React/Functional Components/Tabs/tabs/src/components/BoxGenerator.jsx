import React,{useState} from 'react'

const BoxGenerator = (props) => {
    const [color, setColor] = useState("");

    const addColor = (e) =>{
        e.ppreventDefault();
        props.newColor(color);
    }

  return (
    <form onSubmit={addColor}>
        <h3>Color</h3>
        <input type="text" onChange={(e) => setColor(e.target.value) }/>
        <input type="submit" value="Add" />
    </form>
  )
}

export default BoxGenerator
