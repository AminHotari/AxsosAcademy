import React from 'react'
import {Link} from '@reach/router'

const Home = (props) => {
  return (
    <div>
        <Link to="/"><p>Dash</p></Link>
        <Link to="/7"><p>Write</p></Link>
        <h2>Welcome</h2>
    </div>
  )
}

export default Home
