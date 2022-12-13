import React from 'react'
import { Link } from '@reach/router'

const Write = (props) => {
  return (
    <div>
        <Link to="/"><p>Dash</p></Link>
        <Link to="/hello/blue/red"><p>Color</p></Link>
        <h3>{isNaN(props.write)?<p>The word is: {props.write}</p>:<p>The Number is: {props.write}</p>}</h3>
    </div>
  )
}

export default Write
