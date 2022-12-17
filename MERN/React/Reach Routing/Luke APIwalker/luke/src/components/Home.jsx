import React, { useState } from 'react';

import { Link, navigate } from '@reach/router';

const Home = (props) => {
  const forTable={
    margin: "0 auto",
    marginTop: "2rem",
  }
  const forButton={
    backgroundColor:"blue",
    color:"white",
    width:"8rem",
    height:"3rem",
    borderRadius: "0.4rem 0.4rem",
    border: "none",
  }

  const forInput={
    width:"4rem",
    height:"3rem",
    marginLeft:"0.5rem",
    marginRight:"1rem",
    border: "none",
    backgroundColor:"#efefef",
    borderRadius: "0.4rem 0.4rem",
    textAlign: "center",
  }

  const forSelect={
    width:"10rem",
    height:"3rem",
    border: "none",
    backgroundColor:"#efefef",
    borderRadius: "0.4rem 0.4rem",
    marginLeft:"0.5rem",
    marginRight:"2rem",
  }

  const [starWar,setStarWar] = useState("");
  const [theId,setTheId] = useState(0);


  const choosen = (e) =>{
    e.preventDefault();
    navigate(`/${starWar}/${theId}`)
  }

  return (
    <div>
      <form onSubmit={choosen}>
        <table style={forTable}>
          <tr>
            <td><p>Search for:</p></td>
            <td>
              <select style={forSelect} onChange={(e)=>{setStarWar(e.target.value)}}>
                <option value="">Select One</option>
                  <option value="films">Films</option>
                  <option value="people">People</option>
                  <option value="planets">Planets</option>
                  <option value="species">Species</option>
                  <option value="starships">Starships</option>                 
              </select>
            </td>
            <td><p>ID:</p></td>
            <td><input type="text" style={forInput} onChange={(e) =>{setTheId(e.target.value)}} /></td>
            <td><button style={forButton}>Search</button></td>
          </tr>
        </table>                       
      </form>  

      <Link to="/">Another Search</Link>  
        
    </div>
  )
}

export default Home
