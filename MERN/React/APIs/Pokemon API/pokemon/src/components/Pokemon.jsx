import React,{ useState ,useEffect } from 'react'


const Pokemon = () => {
    const [poke,setPoke] = useState([]);
    const [show, setShow] = useState(false);


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
        fetch('https://pokeapi.co/api/v2/pokemon?limit=807&offset=0')
        .then(response => response.json())
        .then(response => setPoke(response.results))
    }, []);

    const clicker=()=> {
        show?setShow(false):setShow(true)
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
      </div>
      
    </div>
  )
}

export default Pokemon
