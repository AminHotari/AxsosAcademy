import React,{ useState ,useEffect } from 'react';
import axios from 'axios';


const Pokemon = () => {
    const [poke,setPoke] = useState([]);
    const [show, setShow] = useState(false);

    // const [poke,setPoke] = useState(null); //if null
    // const [loaded, setLoaded] = useState(false); // for null

    


    const pok={
        marginTop: "2rem",
        marginLift: "1rem",
        backgroundColor: "gray",
        color: "white",
        width: "10%",
        borderRadius: "0.3rem",
    }

    const list={
      margin: "0 auto",
      width: "5%",
    }

    useEffect(() =>{
        axios.get('https://pokeapi.co/api/v2/pokemon?limit=807&offset=0')
        // .then(response => {console.log(response)})
        .then(response=> {console.log(response);setPoke(response.data.results)} )
        // .then(response=> {console.log(response);setPoke(response.data.results);setLoaded(true)} ) // for null
        // .catch(err=>console.log(err))
    }, []);

    

    const clicker=(e)=> {
      e.preventDefault();
      // show?setShow(false):setShow(true)

      setShow(!show);
    }


  return (
    <div>
      <button style={pok} onClick={clicker} >Fetch Pokemon</button>

      <div style={list}>
      {show ? poke.map((item,index) => {
        return (<ul >
          <li  key={index}>{item.name}</li>
        </ul>
        )
      }) : ""}

      {/* (show ? loaded && poke.map((item,index)) //for null */}
      </div>
      
    </div>
  )
}

export default Pokemon
