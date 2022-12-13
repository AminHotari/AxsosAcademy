import React from 'react'
import { Link } from '@reach/router'

const Color = (props) => {

  const write={
    backgroundColor:props.color2,
    color:props.color1,
    width:"20%",
    height:"5rem",
    margin:"0 auto",
    paddingTop: "2rem",
  }

  return (
    <div>
        <Link to="/"><p>Dash</p></Link>
        {isNaN(props.word)?<p style={write}>The word is: {props.word}</p>:<p style={write}>The Number is: {props.word}</p>}
    </div>
  )
}

export default Color
