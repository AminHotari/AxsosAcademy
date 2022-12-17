import React, { useState , useEffect } from 'react';
import axios from 'axios';
import logo from '../erorr/eroor.gif';


const DisplayHome = (props) => {
    const [theStarWar,setTheStarWar] = useState([]);
    const [err,seterr] = useState("");

    useEffect(()=>{
        axios.get('https://swapi.dev/api/'+props.type+"/"+props.id)
        .then(response =>{console.log(response.data); setTheStarWar(response.data)} )
        .catch(err1 => {seterr(err1)})
      },[props.type ,props.id]);

      const show={
        margin: "0 auto",
        width:"35%",
        textAlign: "start",
      }
  return (
    <div style={show}>
      {err ?
      <div>
        <img src={logo} alt="choose" />
        <p>These aren't the droids you're looking for</p>
      </div> 
      :
      (props.type == "films")?
    <div>
        <h2>{theStarWar.title}</h2>
        <p>Episode: {theStarWar.episode_id}</p>
        <p>Director: {theStarWar.director}</p>
        <p>Producer: {theStarWar.producer}</p>
        <p>Release Date: {theStarWar.release_date}</p>
    </div>:
    (props.type =="people")?
    <div>
        <h2>{theStarWar.name}</h2>
        <p>Height: {theStarWar.height}</p>
        <p>Mass: {theStarWar.mass}</p>
        <p>Hair Color: {theStarWar.hair_color}</p>
        <p>Shin Color: {theStarWar.skin_color}</p>
    </div>:
    (props.type =="planets")?
    <div>
        <h2>{theStarWar.name}</h2>
        <p>Climate: {theStarWar.climate}</p>
        <p>Terrain: {theStarWar.terrain}</p>
        <p>Surface Water : {theStarWar.surface_water}</p>
        <p>Population: {theStarWar.population}</p>
    </div>:
    (props.type =="species")?
    <div>
        <h2>{theStarWar.name}</h2>
        <p>Classification: {theStarWar.classification}</p>
        <p>Designation: {theStarWar.designation}</p>
        <p>Language : {theStarWar.language}</p>
        <p>Average Height: {theStarWar.average_height}</p>
    </div>:
    (props.type =="starships")?
    <div>
        <h2>{theStarWar.name}</h2>
        <p>Model: {theStarWar.model}</p>
        <p>Manufacturer: {theStarWar.manufacturer}</p>
        <p>Length : {theStarWar.length}</p>
        <p>Crew: {theStarWar.crew}</p>
    </div>:
    ""
    }
    </div>
  )
}

export default DisplayHome
