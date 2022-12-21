import { Link , navigate } from '@reach/router';
import axios from 'axios';
import React, { useEffect, useState } from 'react'

const Detail = (props) => {
    const [theProduct,setTheProduct] = useState({})

    useEffect(()=>{
        axios.get('http://localhost:8000/api/product/' +props.id)
            .then(res=> {setTheProduct(res.data)})
            .catch(err=> console.error(err))
    },[]);

    const deleteThis =(e)=>{
      e.preventDefault();
      axios.delete('http://localhost:8000/api/product/' +props.id)
        .then(res=> navigate("/"))
        .catch(err=>console.log(err))
    }
  return (
    <div>
      <h3>{theProduct.title}</h3>
      <p>Price: ${theProduct.price}</p>
      <p>Description: {theProduct.description}</p>
      <Link to={"/"+props.id+ "/edit"}>Edit</Link><br></br>
      <Link to={"/"}>Back To Main</Link><br></br>
      <button onClick={deleteThis}>Delete</button>
    </div>
  )
}

export default Detail
